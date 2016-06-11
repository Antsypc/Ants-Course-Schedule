package xyz.antsgroup.course.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.antsgroup.course.entity.Course;
import xyz.antsgroup.course.entity.Teacher;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author ants_ypc
 * @version 1.0 6/11/16
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
    private static final SqlSessionFactory sessionFactory;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = TeacherController.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
    }

    @RequestMapping("")
    public String teacher() {
        return "teacher";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(HttpServletRequest request) throws Exception{
        String teacherId = (String) request.getSession().getAttribute("id");
        String info = "";
        if(teacherId == null)
            return FAILURE;

        try (SqlSession sqlSession = sessionFactory.openSession()) {
            Teacher teacher = sqlSession.selectOne("Teacher.getTeacherById", teacherId);
            ObjectMapper mapper = new ObjectMapper();
            info = mapper.writeValueAsString(teacher);  // 转换为json
            System.out.println("getteacherinfo:" + info);
            request.setAttribute("user", teacher);      // 将该对象加入request
        }
        return "/profile/teacher";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @ResponseBody
    public String updateProfile(HttpServletRequest request) throws Exception {
        String id = (String) request.getSession().getAttribute("id");
        if(id == null)
            return FAILURE;

        Teacher teacher = null;
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            teacher = sqlSession.selectOne("Teacher.getTeacherById", id);
        }
        // 获取需要修改的信息
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, String> map = mapper.readValue(in, Map.class);
        in.close();

        // 验证密码,修改信息
        String pw = map.get("oldpassword");
        if(pw == null || !teacher.getPassword().equals(pw)) {
            return FAILURE;
        } else {
            String newpassword = map.get("newpassword");
            if(!newpassword.isEmpty()) {
                teacher.setPassword(newpassword);
            }
            teacher.setEmail(map.get("email"));
            teacher.setPhone(map.get("phone"));
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                sqlSession.update("Teacher.updateTeacher", teacher);
                sqlSession.commit();
            }
            return SUCCESS;
        }
    }

    @RequestMapping(value = "/course/schedule", method = RequestMethod.GET)
    public String schedule(HttpServletRequest request) {
        String teacherId = (String) request.getSession().getAttribute("id");
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            List<Course> courses = sqlSession.selectList("Course.getCourseByTeacherId", teacherId);
            request.setAttribute("courses", courses);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/teacher/course-schedule";
    }

    @RequestMapping(path = "/course/schedule", method = RequestMethod.POST)
    @ResponseBody
    public String doSchedule(HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();

        String result = "";

        try {
            result = addTeacherSchedule(request);
            String json = mapper.writeValueAsString(result);
            request.setAttribute("result", json);
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
        return result;
    }


    /*
     * 教师添加课程计划
     */
    private String addTeacherSchedule(HttpServletRequest request) throws Exception{

        //从session中拿到teacherID
        String teacherId = (String) request.getSession().getAttribute("id");
        //如果teacherID为空，失败
        if(teacherId == null){
            return FAILURE;
        }

        //从前端获取要添加的课程信息
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String,String> map = mapper.readValue(in,Map.class);
        in.close();

        String courseName = map.get("courseName");
        String courseClass = map.get("courseClass");
        String description = map.get("description");
        //判断是否取到
        if(courseName == null || courseClass == null || description == null){
            return FAILURE;
        }

        int insertNum;

        try (SqlSession sqlSession = sessionFactory.openSession()) {
            //根据teacherID从teacher表中查到teacherName
            Teacher teacher = sqlSession.selectOne("Teacher.getTeacherById", teacherId);
            String teacherName = teacher.getName();
            if (teacherName == null) {
                return FAILURE;
            }

            Course course = new Course();
            course.setName(courseName);
            course.setClasses(courseClass);
            course.setDescription(description);
            course.setTeacherId(teacherId);
            course.setTeacherName(teacherName);

            insertNum = sqlSession.insert("Course.insertCourse", course);
            sqlSession.commit();
        }
        return 1 == insertNum ? SUCCESS : FAILURE;
    }
}
