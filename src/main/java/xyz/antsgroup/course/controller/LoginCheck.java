/**
 * 登录验证，验证成功跳转到相应身份首页
 */

package xyz.antsgroup.course.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.antsgroup.course.entity.Manager;
import xyz.antsgroup.course.entity.Student;
import xyz.antsgroup.course.entity.Teacher;

/**
 * Servlet implementation class LoginCheck
 */
public class LoginCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
    private static final SqlSessionFactory sessionFactory;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = LoginCheck.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String identity = (String) request.getSession().getAttribute("identity");
        String contextPath = request.getContextPath();
        if("student".equals(identity)) {
            response.sendRedirect(contextPath + "/student.jsp");
        } else if("teacher".equals(identity)) {
            response.sendRedirect(contextPath + "/teacher.jsp");
        } else if("manager".equals(identity)) {
            response.sendRedirect(contextPath + "/manager.jsp");
        } else {
            request.getRequestDispatcher("/logging/login.jsp").forward(request, response);
        }
    }

    /**
     * POST提交用户名，密码和用户身份，验证是否正确
     * 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String identity = request.getParameter("identity");

        // 身份验证，从相应表读相应身份用户的密码
        if ("student".equals(identity)) {
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                Student student = sqlSession.selectOne("Student.getStudentById", username);
                if (student != null && password.equals(student.getPassword())) {
                    session.setAttribute("identity", identity); // 设置该session代表用户的身份
                    session.setAttribute("id", username); // 设置该session代表用户的id
                    session.setAttribute("name", student.getName());
                    // out.write(SUCCESS);
                    // 登录成功执行页面跳转到学生主页
                    response.sendRedirect(request.getContextPath()+"/student.jsp");
                } else {
                    System.out.println("登录失败...");
                    response.sendRedirect(request.getContextPath()+"/login");
                }
            }
        } else if ("teacher".equals(identity)) {
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                Teacher teacher = sqlSession.selectOne("Teacher.getTeacherById", username);

                if (teacher != null && password.equals(teacher.getPassword())) {
                    session.setAttribute("identity", identity); // 设置该session代表用户的身份
                    session.setAttribute("id", username); // 设置该session代表用户的id
                    session.setAttribute("name", teacher.getName());
                    // out.write(SUCCESS);
                    // 登录成功执行页面跳转到教师主页
                    response.sendRedirect(request.getContextPath()+"/teacher.jsp");
                } else {
                    response.sendRedirect(request.getContextPath()+"/login");
                }
            }
        } else if ("manager".equals(identity)) {
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                Manager manager = sqlSession.selectOne("Manager.getManagerById", username);

                if (manager != null && password.equals(manager.getPassword())) {
                    session.setAttribute("identity", identity); // 设置该session代表用户的身份
                    session.setAttribute("id", username); // 设置该session代表用户的id
                    session.setAttribute("name", manager.getName());
                    // out.write(SUCCESS);
                    // 登录成功执行页面跳转到管理员
                    response.sendRedirect(request.getContextPath()+"/manager.jsp");
                } else {
                    response.sendRedirect(request.getContextPath()+"/login");
                }
            }
        } else {
            // 不存在该身份
            out.write(FAILURE);
            out.close();
            return;
        }

    }

}
