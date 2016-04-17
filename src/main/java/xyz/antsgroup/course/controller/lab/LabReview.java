/**
 * 实验室管理员查看目前实验室使用申请状况，审核实验室使用
 */
package xyz.antsgroup.course.controller.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.dao.impl.LabWithReservationDao;
import xyz.antsgroup.course.entity.LabWithReservation;
import xyz.antsgroup.course.util.DBTool;

/**
 * Servlet implementation class LabApply
 */
public class LabReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LabReview() {
        super();
    }

	/**
	 * 根据参数获取待审核实验室申请，
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String campus = request.getParameter("campus");
	    String date = request.getParameter("date");
	    String status = request.getParameter("status");
	    System.out.println(campus);
	    System.out.println(date);
	    System.out.println(status);
	    if(date == null) {
	        // 还应该判断date的格式是否正确，防止sql注入！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
	        // 如果没有指定日期，则不进行任何查询，返回实验室预约审核页面
	        request.getRequestDispatcher("/laboratory/review.jsp").forward(request, response);
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
	    statusMap.put("pending", "pending");
	    statusMap.put("passed", "passed");
	    statusMap.put("refused", "refused");
	    statusMap.put("all", "all");
	    
	    
	    String sql = "CALL lab_by_campus_day_status(\'"+ campusMap.get(campus) 
	            + "\',\'" + date + "\',\'" + statusMap.get(status) + "\')";
	    
	    System.out.println(sql);
	    BaseDao<LabWithReservation, String> dao = new LabWithReservationDao();
	    List<LabWithReservation> list = null;
	    try {
            list = dao.queryByCondition(sql);
        } catch (Exception e) {
            e.printStackTrace();
            // 
        }
	    request.setAttribute("labinfo", list);
	    request.setAttribute("date", date);
	    request.setAttribute("campus", campus);
	    request.setAttribute("status", status);
	    request.getRequestDispatcher("/laboratory/review.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	    PrintWriter out = response.getWriter();
        // 获取客户端传来的信息
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, String> map = mapper.readValue(in, Map.class);
        in.close();
	
        String labRoomUsageId = map.get("labRoomUsageId");
        String action = map.get("action");
        
        // 判断该教室该时间段是否已经被预约，如果是则拒绝
        String sql1 = "SELECT * "
                + " FROM labRoomUsage b "
                + " INNER JOIN "
                + " (SELECT labRoomId, timeFrom FROM labRoomUsage WHERE labRoomUsageId = ?) AS a "
                + " ON a.labRoomId = b.labRoomId AND a.timeFrom = b.timeFrom "
                + " WHERE isOk = '1'";
        // 实验室管理员审核操作
        String sql = "UPDATE labRoomUsage SET isOk = ? WHERE labRoomUsageId = ?";
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet resultset = null;
        int result = 0;
        try {
            con = DBTool.getConnection();
            
            // 如果这个实验室的这个时间段被占用了，拒绝审核
            pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1, Integer.valueOf(labRoomUsageId));
            resultset = pstmt.executeQuery();
            while (resultset.next()) {
                out.write(FAILURE);
                out.close();
                return;
            }
            
            // 开始审核该条申请
            result = 0;
            pstmt = con.prepareStatement(sql);
            if("pass".equals(action)) {
                pstmt.setString(1, "1");
            } else if("refuse".equals(action)) {
                pstmt.setString(1, "2");
            } else {
                out.write(FAILURE);
                return;
            }
            pstmt.setInt(2, Integer.valueOf(labRoomUsageId));
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            out.write(FAILURE);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                out.write(FAILURE);
            }
        }
        if(1 == result) {
            out.write(SUCCESS);
        } else {
            out.write(FAILURE);
        }
        out.close();

        
	}

}
