package xyz.antsgroup.course.controller.teacher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.antsgroup.course.dao.OrderDao;
import xyz.antsgroup.course.dao.impl.OrderDaoImpl;
import xyz.antsgroup.course.entity.Order;

/**
 * Servlet implementation class OrderServlet
 */
@SuppressWarnings("serial")
public class SearchLabRoomServlet extends HttpServlet {
	
    
    OrderDao orderDao = new OrderDaoImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/laboratory/list.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String campus = request.getParameter("campus");
        String date = request.getParameter("datetime");
        
        
        Map<String,Order> room = new HashMap<String,Order>();
        if(!"所有".equals(campus)){
            room=orderDao.queryOrderInfo(campus,date);
        }else{
            String defaultCampus = "东院 西院 鉴湖 南湖 余区";
            StringTokenizer st = new StringTokenizer(defaultCampus);
            while(st.hasMoreTokens()){
                String tempCampus = st.nextToken();
                room.putAll(orderDao.queryOrderInfo(tempCampus, date));
            }
        }
        request.setAttribute("room", room);
        
        //response.sendRedirect("/course/list.jsp");
        request.getRequestDispatcher("/laboratory/list.jsp").forward(request, response);
    }

}
