package xyz.antsgroup.course.controller.manager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.antsgroup.course.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ants_ypc
 * @version 1.0 4/16/16
 */
@WebServlet(name = "CourseServlet")
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final SqlSessionFactory sessionFactory;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = ClassroomServlet.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = null;
        try (SqlSession sqlSession = sessionFactory.openSession()){
            courses = sqlSession.selectList("Course.getAllCourses");
        }
        request.setAttribute("courseList", courses);
        request.getRequestDispatcher("/WEB-INF/page/manager/course.jsp").forward(request, response);
    }
}
