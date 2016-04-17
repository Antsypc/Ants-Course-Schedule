package xyz.antsgroup.course.controller.teacher;

/**
 * 功能：教师取约实验室预约
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.dao.impl.CourseDao;
import xyz.antsgroup.course.dao.impl.LabRoomUsageDao;
import xyz.antsgroup.course.entity.Course;
import xyz.antsgroup.course.entity.LabRoomUsage;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@SuppressWarnings("serial")
public class TeacherReserveLabRoomServlet extends HttpServlet {
//
//	private static final String SUCCESS = "{\"success\":\"true\"}";
//    private static final String FAILURE = "{\"success\":\"false\"}";
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		// 注意开始时是通过返回json给客户端，现在是把用户信息写入页面返回给客户端
//        response.setCharacterEncoding("UTF-8");
//
//        @SuppressWarnings("unused")
//		String result = "";
//        try {
//			result = reserve(request);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//        return;
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		String result = "";
//
//		try {
//			result = reserve(request);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		 PrintWriter out = response.getWriter();
//		 out.write(result);
//		 out.close();
//	}
//
//	private String reserve(HttpServletRequest request) throws Exception {
//		//从session中获取teacherId
//		String teacherId = (String) request.getSession().getAttribute("id");
//		if(teacherId == null){
//			return FAILURE;
//		}
//
//		//通过ajax获取前台传送的课程名、预约时间、实验室ID
//		BufferedReader in = request.getReader();
//		ObjectMapper mapper = new ObjectMapper();
//		@SuppressWarnings("unchecked")
//		Map<String,String> map = mapper.readValue(in, Map.class);
//		in.close();
//
//		String courseName = map.get("courseName");
//		String datetime = map.get("reserveTime");
//		String labRoomId = map.get("labRoomId");
//
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//        Date date = null;
//        try {
//            date = df.parse(datetime);
//            System.out.println((int)(date.getTime()/1000));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//		System.out.println(courseName);
//		if(courseName == null || datetime == null || labRoomId == null){
//			return FAILURE;
//		}
//
//		//通过teacherId和courseName得到course对象
//		String sql = "select * from course where teacherId =" +teacherId+ " and courseName =" +" '"+ courseName+"'";
//
//		BaseDao<Course,String> baseDao = new CourseDao();
//		List<Course> courses = baseDao.queryByCondition(sql);
//
//		if(courses == null){
//			return FAILURE;
//		}
//
//		//取得对应的courseId
//		for(Course course : courses){
//			int courseId = course.getCourseId();
//			//将预约信息插入数据库中
//			LabRoomUsage lru = new LabRoomUsage();
//			lru.setTeacherId(teacherId);
//			lru.setCourseId(courseId);
//			lru.setMaxNum(80);
//			lru.setTimeFrom((int)(date.getTime()/1000));
//			lru.setLabRoomId(labRoomId);
//			lru.setIsOk("0");
//
//			BaseDao<LabRoomUsage,String> labRoomUsageDao = new LabRoomUsageDao();
//			labRoomUsageDao.save(lru);
//		}
//
//		return SUCCESS;
//	}
//
}