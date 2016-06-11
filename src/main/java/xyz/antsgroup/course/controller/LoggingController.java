package xyz.antsgroup.course.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.antsgroup.course.entity.Manager;
import xyz.antsgroup.course.entity.Student;
import xyz.antsgroup.course.entity.Teacher;

import javax.servlet.http.HttpSession;
import java.io.InputStream;

/**
 * @author ants_ypc
 * @version 1.0 6/11/16
 */
@Controller
public class LoggingController {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
    private static final SqlSessionFactory sessionFactory;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = LoggingController.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
    }


    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        String identity = (String) session.getAttribute("identity");
        if("student".equals(identity)) {
            return "redirect:/student";
        } else if("teacher".equals(identity)) {
            return "redirect:/teacher";
        } else if("manager".equals(identity)) {
            return "redirect:/manager";
        } else {
            return "login";
        }
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String loginCheck(@RequestParam String username, @RequestParam String password,
                             @RequestParam String identity, HttpSession session) {
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
                    return "redirect:/student";
                } else {
                    System.out.println("登录失败...");
                    return "redirect:/login";
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
                    return "redirect:/teacher";
                } else {
                    return "redirect:/login";
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
                    return "redirect:/manager";
                } else {
                    return "redirect:/login";
                }
            }
        } else {
            // 不存在该身份
//            out.write(FAILURE);
//            out.close();
            return "/login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("id");
        session.removeAttribute("name");
        session.removeAttribute("identity");
        return "redirect:/logout";
    }
}
