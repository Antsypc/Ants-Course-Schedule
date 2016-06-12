package xyz.antsgroup.course.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.antsgroup.course.entity.Classroom;
import xyz.antsgroup.course.entity.Course;
import xyz.antsgroup.course.entity.Manager;
import xyz.antsgroup.course.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ants_ypc
 * @version 1.0 6/11/16
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
    private static final SqlSessionFactory sessionFactory;
    // 建立前端字段和数据库的对应关系，防止sql注入
    private static Map<String, String> campusMap;
    private static Map<String, String> typeMap;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = ManagerController.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");

        campusMap = new HashMap<>();
        typeMap = new HashMap<>();
        campusMap.put("all", null);
        campusMap.put("nanhu", "南湖");
        campusMap.put("jianhu", "鉴湖");
        campusMap.put("dongyuan", "东院");
        campusMap.put("xiyuan", "西院");
        campusMap.put("yuqu", "余区");
        typeMap.put("classroom", "教室");
        typeMap.put("laboratory", "实验室");
        typeMap.put("all", null);
    }

    @RequestMapping("")
    public String manager() {
        return "manager";
    }

    /**
     * 获取某管理员个人信息，将实验室管理员对象写入request，对象的 json 在 info
     * @param request
     * @throws Exception
     */
    @RequestMapping(path = "profile", method = RequestMethod.GET)
    public void getProfile(HttpServletRequest request) throws Exception{
        String managerId = (String) request.getSession().getAttribute("id");
        String info = "";
        if(managerId == null)
            return ;

        try (SqlSession sqlSession = sessionFactory.openSession()) {
            Manager manager = sqlSession.selectOne("Manager.getManagerById", managerId);
            ObjectMapper mapper = new ObjectMapper();
            info = mapper.writeValueAsString(manager);  // 转换为json
            System.out.println("getmanagerinfo:" + info);
            request.setAttribute("user", manager);      // 将该对象加入request
        }
    }

    @RequestMapping(path = "profile",method = RequestMethod.POST)
    @ResponseBody
    public String updateProfile(HttpServletRequest request) throws Exception{
        String id = (String) request.getSession().getAttribute("id");
        if(id == null)
            return FAILURE;

        Manager manager = null;
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            manager = sqlSession.selectOne("Manager.getManagerById", id);
        }
        // 获取需要修改的信息
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, String> map = mapper.readValue(in, Map.class);
        in.close();

        // 验证密码,修改信息
        String pw = map.get("oldpassword");
        if(pw == null || !manager.getPassword().equals(pw)) {
            return FAILURE;
        } else {
            String newpassword = map.get("newpassword");
            if(!newpassword.isEmpty()) {
                manager.setPassword(newpassword);
            }
            manager.setEmail(map.get("email"));
            manager.setPhone(map.get("phone"));
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                sqlSession.update("Manager.updateManager", manager);
                sqlSession.commit();
            }
            return SUCCESS;
        }
    }

    @RequestMapping(path = "/classroom", method = RequestMethod.GET)
    public String classroom(@RequestParam(value = "campus",required = false) String campus,
                            @RequestParam(value = "type",required = false) String type,
                            Model model) {
        if (campus == null || type == null) {
            return "/manager/classroom";
        }
        try (SqlSession sqlSession = sessionFactory.openSession()){
            List<Classroom> room = sqlSession.selectList("Classroom.getRoomByConditions", new HashMap<String,String>(){
                {put("campus", campusMap.get(campus)); put("roomType", typeMap.get(type));}
            });

            model.addAttribute("room", room);
            model.addAttribute("campus", campus);
            model.addAttribute("type", type);
        }
        return "/manager/classroom";
    }

    @RequestMapping("/course")
    public String course(Model model) {
        List<Course> courses = null;
        try (SqlSession sqlSession = sessionFactory.openSession()){
            courses = sqlSession.selectList("Course.getAllCourses");
        }
        model.addAttribute("courseList", courses);
        return "/manager/course";
    }

    @RequestMapping(path = "/course/schedule", method = RequestMethod.GET)
    public String getSchedule(@RequestParam(required = false) String major,
                              @RequestParam(required = false) String isSchedule,
                              Model model) {
        System.out.println("get schedule");
        List<Course> courseList = null;
        try (SqlSession sqlSession = sessionFactory.openSession()){
            courseList = sqlSession.selectList("Course.getCoursesByCondition", new HashMap<String,String>(){
                {put("major", major); put("isSchedule", isSchedule);}
            });
        }
        model.addAttribute("courseList", courseList);
        model.addAttribute("major", major);
        model.addAttribute("isSchedule", isSchedule);
        System.out.println("return ");
        return "/manager/course-schedule";
    }

    @RequestMapping(path = "/course/schedule", method = RequestMethod.POST)
    @ResponseBody
    public String doSchedule(HttpServletRequest request) throws Exception{
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> map = mapper.readValue(in, Map.class);
        String action = map.get("action");
        String result = null;
        if (action.equals("new")) {
            result = addCourse(request, map);
        } else if (action.equals("edit")) {
            result = editCourse(request, map);
        } else if (action.equals("scrap")) {
            result = scrapCourse(request, map);
        } else {
            result = FAILURE;
        }
        return result;
    }


    private String addCourse(HttpServletRequest request, Map<String, String> map) throws ServletException,IOException {
        Course course = new Course();
        course.setName(map.get("name"));
        course.setClasses(map.get("classes"));
        course.setWeekFrom(Integer.valueOf(map.get("weekFrom")));
        course.setWeekTo(Integer.valueOf(map.get("weekTo")));
        course.setWeekday(Integer.valueOf(map.get("weekday")));
        course.setTimeFrom(map.get("timeFrom"));
        course.setTimeTo(map.get("timeTo"));
        course.setCapacity(Integer.valueOf(map.get("capacity")));
        course.setClassroomId(map.get("classroom"));
        course.setTeacherId((String) request.getSession().getAttribute("id"));
        course.setTeacherName((String) request.getSession().getAttribute("name"));
        course.setDescription(map.get("note"));


        try (SqlSession sqlSession = sessionFactory.openSession()){
            int num = sqlSession.insert("Course.insertCourse", course);
            sqlSession.commit();
            return num == 1 ? SUCCESS : FAILURE;
        }
    }
    private String editCourse(HttpServletRequest request, Map<String, String> map) throws ServletException,IOException {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            Course course = new Course();
            course.setId(Integer.valueOf(map.get("id")));
            course.setName(map.get("name"));
            course.setClasses(map.get("classes"));
            course.setWeekFrom(Integer.valueOf(map.get("weekFrom")));
            course.setWeekTo(Integer.valueOf(map.get("weekTo")));
            course.setWeekday(Integer.valueOf(map.get("weekday")));
            course.setTimeFrom(map.get("timeFrom"));
            course.setTimeTo(map.get("timeTo"));
            course.setClassroomId(map.get("classroom"));
            course.setCapacity(Integer.valueOf(map.get("capacity")));
            Teacher teacher = sqlSession.selectOne("Teacher.getTeacherById", map.get("teacherId"));
            course.setTeacherId(teacher.getId());
            course.setTeacherName(teacher.getName());
            course.setDescription(map.get("note"));


            int num = sqlSession.update("Course.updateCourse", course);
            sqlSession.commit();
            return num == 1 ? SUCCESS : FAILURE;
        }
    }
    private String scrapCourse(HttpServletRequest request, Map<String, String> map) throws ServletException,IOException {
        try(SqlSession sqlSession = sessionFactory.openSession()) {
            int num = sqlSession.delete("Course.deleteCourse", Integer.valueOf(map.get("id")));
            sqlSession.delete("CourseChooseLog.deleteLogByCourseId", Integer.valueOf(map.get("id")));
            sqlSession.commit();
            return num == 1 ? SUCCESS : FAILURE;
        }
    }
}
