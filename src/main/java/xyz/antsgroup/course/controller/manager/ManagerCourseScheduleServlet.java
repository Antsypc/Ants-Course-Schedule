package xyz.antsgroup.course.controller.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.antsgroup.course.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ants_ypc
 * @version 1.0 4/17/16
 */
@WebServlet(name = "ManagerCourseScheduleServlet")
public class ManagerCourseScheduleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final SqlSessionFactory sessionFactory;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
//    private static final HashMap<String, String> majorMap;
//    private static final HashMap<String, String> isScheduleMap;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = ClassroomServlet.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
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

        out.write(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String major = request.getParameter("major");
        String isSchedule = request.getParameter("isSchedule");


        List<Course> courseList = null;
        try (SqlSession sqlSession = sessionFactory.openSession()){
            courseList = sqlSession.selectList("Course.getCoursesByCondition", new HashMap<String,String>(){
                {put("major", major); put("isSchedule", isSchedule);}
            });
        }
        request.setAttribute("courseList", courseList);
        request.setAttribute("major", major);
        request.setAttribute("isSchedule", isSchedule);
        request.getRequestDispatcher("/manager/course-schedule.jsp").forward(request, response);
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
        course.setTeacherId((String) request.getSession().getAttribute("id"));
        course.setTeacherName((String) request.getSession().getAttribute("name"));
        course.setDescription(map.get("note"));


        try (SqlSession sqlSession = sessionFactory.openSession()){
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
