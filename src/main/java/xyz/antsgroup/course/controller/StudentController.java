package xyz.antsgroup.course.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.antsgroup.course.controller.manager.ClassroomServlet;
import xyz.antsgroup.course.entity.Course;
import xyz.antsgroup.course.entity.CourseChooseLog;
import xyz.antsgroup.course.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/student")
public class StudentController {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\", \"message\":\"error\"}";
    private static final String FAILURE_CHOSEN = "{\"success\":\"false\", \"message\":\"chosen\"}";
    private static final String FAILURE_FULL = "{\"success\":\"false\", \"message\":\"full\"}";
    private static final SqlSessionFactory sessionFactory;

    private String action = null;
    private String courseId = null;
    private String studentId = null;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = StudentController.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");

    }

    @RequestMapping("")
    public String student() {
        return "student";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(HttpSession session, Model model) throws Exception{
        String studentId = (String) session.getAttribute("id");
        String info = "";
        if(studentId == null)
            return FAILURE;

        try (SqlSession sqlSession = sessionFactory.openSession()) {
            Student student = sqlSession.selectOne("Student.getStudentById", studentId);
            ObjectMapper mapper = new ObjectMapper();
            info = mapper.writeValueAsString(student);  // 转换为json
            System.out.println("getstudentinfo:" + info);
            model.addAttribute("user", student);      // 将该对象加入request
            System.out.println("student email" + student.getEmail());
        }
        return "/profile/student";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @ResponseBody
    public String updateProfile(HttpServletRequest request) throws Exception{
        String id = (String) request.getSession().getAttribute("id");
        if(id == null)
            return FAILURE;

        Student student = null;
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            student = sqlSession.selectOne("Student.getStudentById", id);
        }
        // 获取学生需要修改的信息
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, String> map = mapper.readValue(in, Map.class);
        in.close();

        // 验证密码,修改信息
        String pw = map.get("oldpassword");
        if(pw == null || !student.getPassword().equals(pw)) {
            return FAILURE;
        } else {
            String newpassword = map.get("newpassword");
            if(!newpassword.isEmpty()) {
                System.out.println("学生新密码是：" + newpassword);
                student.setPassword(newpassword);
            }
            student.setEmail(map.get("email"));
            System.out.println("getemail"+ student.getEmail());
            student.setPhone(map.get("phone"));
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                sqlSession.update("Student.updateStudent", student);
                sqlSession.commit();
            }
            return SUCCESS;
        }
    }

    @RequestMapping("/course")
    public String course(HttpSession session, Model model) {
        List<Course> courseList = null;
        String studentId = (String) session.getAttribute("id");
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            courseList = sqlSession.selectList("Course.getChosenCourseByStudentId", studentId);
        }
        model.addAttribute("courseList", courseList);
        return "/student/student-course";
    }

    @RequestMapping(path = "/course/choose", method = RequestMethod.GET)
    public String getChooseCourse(HttpServletRequest request) {

        String studentId = (String)request.getSession().getAttribute("id");
        if (studentId == null)
            return "/student/student-choose-course";

        List<Course> courses = null;
        List<CourseChooseLog> courseChooseLogs = null;
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            Student student = sqlSession.selectOne("Student.getStudentById", studentId);
            courses = sqlSession.selectList("Course.getCoursesByCondition", new HashMap<String, String>() {
                {put("major", student.getStudentClass()); put("isSchedule", "true");}
            });
            courseChooseLogs = sqlSession.selectList("CourseChooseLog.getCourseChooseLogByStudentId", studentId);

            // 标识所有课程中已选的课
            for (CourseChooseLog logs : courseChooseLogs) {
                for (Course c : courses) {
                    if (c.getId() == logs.getCourseId()) {
                        c.setTeacherId("chosen");
                        c.setClasses(String.valueOf(logs.getId()));
                        break;
                    }
                }
            }
            for (Course c : courses) {
                if (!c.getTeacherId().equals("chosen")) {
                    c.setTeacherId("<button data-priority=\"1\" class=\"btn btn-xs btn-primary\">"
                            + "<i class=\"fa fa-plus\"></i> 选课</button>");
                } else {
                    c.setTeacherId("<button data-priority=\"2\" class=\"btn btn-xs btn-danger\">"
                            + "<i class=\"fa fa-remove\"></i> 退选</button>");
                }
            }
        }

        request.setAttribute("sclist", courses);
        return "/student/student-choose-course";

    }

    @RequestMapping(value = "/course/choose", method = RequestMethod.POST)
    @ResponseBody
    public String chooseCourse(HttpServletRequest request) throws Exception{
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(in, Map.class);
        action = map.get("action");
        courseId = String.valueOf(map.get("id"));

        studentId = (String) request.getSession().getAttribute("id");

        String result = null;
        if("choose".equals(action)) {
            result = doChoose(request);
        } else if("drop".equals(action)) {
            result = dropCourse(request);
        } else {
            result = FAILURE;
        }
        return result;
    }

    /**
     * 学生选课
     *
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    protected String doChoose(HttpServletRequest request) throws ServletException, IOException {

        // 执行选课操作
        // 在CourseChooseLogDao的save方法中判断了课程是否已被选，课程是否已满员
        int result = 0;
        try (SqlSession sqlSession = sessionFactory.openSession()){
            // 判断是否已选
            CourseChooseLog log = sqlSession.selectOne("CourseChooseLog.getLogByStudentIdCourseId", new HashMap<String, String>() {
                {
                    put("studentId", studentId);
                    put("courseId", courseId);
                }
            });
            if (log != null) return FAILURE_CHOSEN;

            // 安全插入
            result = sqlSession.update("Course.updateSafeForStudentChoose", courseId);
            if (result != 1) return FAILURE_FULL;


            log = new CourseChooseLog();
            log.setCourseId(Integer.valueOf(courseId));
            log.setStudentId(studentId);
            log.setTime((int) System.currentTimeMillis() / 1000);
            result = sqlSession.insert("CourseChooseLog.insertLog", log);
            sqlSession.commit();
            return result == 1 ? SUCCESS : FAILURE;
        }

    }

    /**
     * 学生退课.
     *
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    protected String dropCourse(HttpServletRequest request) throws ServletException, IOException {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            int delete = sqlSession.delete("CourseChooseLog.deleteLogByCourseIdStudentId", new HashMap<String, String>() {
                {
                    put("studentId", studentId);
                    put("courseId", courseId);
                }
            });
            int update = sqlSession.update("Course.updateForStudentDrop", courseId);
            sqlSession.commit();
            if (delete == 1 && update == 1) return SUCCESS;
            else return FAILURE;
        }
    }
}
