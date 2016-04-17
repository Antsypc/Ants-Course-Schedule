package xyz.antsgroup.course.controller.teacher;

/*
 * 功能：教师取消实验室预约
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.dao.impl.LabRoomUsageDao;
import xyz.antsgroup.course.entity.LabRoomUsage;

public class TeacherCancelReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String result = SUCCESS;
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		BaseDao<LabRoomUsage,String> labRoomUsageDao = new LabRoomUsageDao();
		
		//得到前段传来的labRoomUsageId
		
		BufferedReader in = request.getReader();
		@SuppressWarnings("unchecked")
		Map<String,String> map = mapper.readValue(in, Map.class);
		in.close();
		
		String labRoomUsageId = map.get("labRoomUsageId");
		if(labRoomUsageId == null){
			result = FAILURE;
		}
		
		try {
			labRoomUsageDao.delete(labRoomUsageId);
			System.out.println("删除成功");
		} catch (Exception e) {
			result = FAILURE;
			e.printStackTrace();
		}
		String json = mapper.writeValueAsString(result);
		out.write(json);
	}

}
