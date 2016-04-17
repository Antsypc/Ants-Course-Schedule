package xyz.antsgroup.course.controller.teacher;
/**
 * 功能：1、老师查询学生成绩
 *     2、老师修改学生成绩
 * @author 李进锋
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.dao.impl.CourseDao;
import xyz.antsgroup.course.dao.impl.ScoreDao;
import xyz.antsgroup.course.dao.impl.StudentScoreReportDao;
import xyz.antsgroup.course.entity.Course;
import xyz.antsgroup.course.entity.StudentScoreReport;

public class QueryStudentScoreServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static final String SUCCESS = "{\"success\":\"true\"}";
//	private static final String FAILURE = "{\"success\":\"false\"}";
//
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//
//		//得到老师ID
//		String teacherId = (String) request.getSession().getAttribute("id");
//
//		Map<String,List<String>> map = new HashMap<String,List<String>>();
//
//		String sql = "select * from course where teacherId =" +teacherId;
//		BaseDao<Course,String> courseDao = new CourseDao();
//		try {
//			//根据老师ID得到课程
//			List<Course> courses = courseDao.queryByCondition(sql);
//			for(Course course : courses){
//				List<String> courseClasses = new LinkedList<String>();
//				//分隔班级
//				StringTokenizer token = new StringTokenizer(course.getCourseClass(),";");
//				while(token.hasMoreTokens()){
//					String courseClass = token.nextToken();
//					courseClasses.add(courseClass);
//				}
//				map.put(course.getCourseName(), courseClasses);
//			}
//
//			//将map转换为json数组，key为课程名称，value为班级
//			ObjectMapper mapper = new ObjectMapper();
//			String json = mapper.writeValueAsString(map);
//			request.setAttribute("json", json);
//
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		request.getRequestDispatcher("/student-management/results.jsp").forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//
//		BaseDao<Course, String> courseDao = new CourseDao();
//		StudentScoreReportDao studentScoreReportDao = new StudentScoreReportDao();
//
//		// 根据teacherId和courseName得到courseId
//		int courseId = 0;
//		String teacherId = (String) request.getSession().getAttribute("id");
//		String course = request.getParameter("course");
//		String _class = request.getParameter("class");
//
//		if((course != null && !"".equals(course)) || ( _class != null && !"".equals(_class))) {
//			String sql = "select * from course where courseName ='" + course
//					+ "' and teacherId = '" +teacherId+"'";
//			try {
//				List<Course> courses = courseDao.queryByCondition(sql);
//				for (Course c : courses) {
//					courseId = c.getCourseId();
//				}
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//
//			List<StudentScoreReport> stuScoreReport =new LinkedList<StudentScoreReport>();
//			try {
//				stuScoreReport = studentScoreReportDao.getStudentScoreReport(course, teacherId, _class, courseId);
//				request.setAttribute("stuScoreReport", stuScoreReport);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			doGet(request, response);
//
//		} else {
//			String result = null;
//			PrintWriter out = response.getWriter();
//			ObjectMapper mapper = new ObjectMapper();
//			try {
//				result = resetStudentScore(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			String json = mapper.writeValueAsString(result);
//			out.write(json);
//		}
//
//	}
//
//	/**
//	 * 功能：教师根据studentId，courseId,score修改学生成绩
//	 * @param request
//	 * @param response
//	 * @return result（json格式，操作成功或失败）
//	 * @throws Exception
//	 */
//	protected String resetStudentScore (HttpServletRequest request,HttpServletResponse response) throws Exception{
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//
//		String result = SUCCESS;
//
//		ScoreDao scoreDao = new ScoreDao();
//		ObjectMapper mapper = new ObjectMapper();
//		BufferedReader in = request.getReader();
//		@SuppressWarnings("unchecked")
//		Map<String, String> map = mapper.readValue(in, Map.class);
//		in.close();
//
//		String courseId = map.get("courseId");
//		System.out.println(courseId);
//		String studentId = map.get("studentId");
//		System.out.println(studentId);
//		String score =map.get("studentScore");
//		System.out.println("score = " + score);
//
//		if (courseId == null || "".equals(courseId.trim())) {
//			result = FAILURE;
//		}
//		if (studentId == null || "".endsWith(studentId.trim())) {
//			result = FAILURE;
//		}
//
//		result = scoreDao.update(Integer.parseInt(courseId), studentId, score);
//		return result;
//	}

}
