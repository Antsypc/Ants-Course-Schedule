package xyz.antsgroup.course.controller.lab;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.antsgroup.course.dao.OrderDao;
import xyz.antsgroup.course.dao.impl.OrderDaoImpl;
import xyz.antsgroup.course.entity.Order;

/**
 * Servlet implementation class LabManage
 */
public class LabManageSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LabManageSearch() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // 该类目前采用SearchLabRoomServlet类的相同实现方式
        String campus = request.getParameter("campus");
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        System.out.println(campus);
        System.out.println(date);
        System.out.println(status);
        if(date == null) {
            // 还应该判断date的格式是否正确，防止sql注入！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
            // 如果没有指定日期，则不进行任何查询，返回实验室预约审核页面
            request.getRequestDispatcher("/laboratory/course-schedule.jsp").forward(request, response);
            return;
        }
        
        // 建立前端字段和数据库的对应关系，防止sql注入
        Map<String, String> campusMap = new HashMap<String, String>();
        Map<String, String> statusMap = new HashMap<String, String>();
        campusMap.put("all", "all");
        campusMap.put("nanhu", "南湖");
        campusMap.put("jianhu", "鉴湖");
        campusMap.put("dongyuan", "东院");
        campusMap.put("xiyuan", "西院");
        campusMap.put("yuqu", "余区");
        statusMap.put("ready", "free");
        statusMap.put("reserved", "passed");
        statusMap.put("all", "all");
        
        
//        String sql = "CALL lab_by_campus_day_status(\'"+ campusMap.get(campus) 
//                + "\',\'" + date + "\',\'" + statusMap.get(status) + "\')";
//        
//        System.out.println(sql);
//        BaseDao<LabWithReservation, String> dao = new LabWithReservationDao();
//        List<LabWithReservation> list = null;
//        try {
//            list = dao.queryByCondition(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // 
//        }
        OrderDao orderDao = new OrderDaoImpl();
        Map<String,Order> room = orderDao.queryOrderInfo(campusMap.get(campus), date);
    
        request.setAttribute("room", room);
        request.setAttribute("campus", campus);
        request.setAttribute("date", date);
        request.setAttribute("status", status);
        
        request.getRequestDispatcher("/laboratory/course-schedule.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request,response);
	}

}
