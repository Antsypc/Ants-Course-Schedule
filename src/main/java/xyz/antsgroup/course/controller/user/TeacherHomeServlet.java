package xyz.antsgroup.course.controller.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ants_ypc
 * @version 1.0 4/30/16
 */
@WebServlet(name = "TeacherHomeServlet")
public class TeacherHomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("teacher".equals(request.getSession().getAttribute("identity"))) {
            request.getRequestDispatcher("/WEB-INF/page/teacher.jsp").forward(request,response);
        } else {
            response.sendError(404);
        }

    }
}
