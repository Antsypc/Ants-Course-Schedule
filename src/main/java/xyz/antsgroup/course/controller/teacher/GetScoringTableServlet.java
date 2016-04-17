package xyz.antsgroup.course.controller.teacher;
/**
 * 功能：教师评分前获取学生评分名单
 */
import java.io.IOException;
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
import xyz.antsgroup.course.dao.impl.StudentDao;
import xyz.antsgroup.course.entity.Course;
import xyz.antsgroup.course.entity.Student;
import xyz.antsgroup.course.entity.StudentScoreReport;


public class GetScoringTableServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	BaseDao<Student,String> studentDao = new StudentDao();
//	BaseDao<Course,String> courseDao = new CourseDao();
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//
//		//得到老师ID
//		String teacherId = (String) request.getSession().getAttribute("id");
//
//		//用于存储菜单项信息，key为课程名称，value为班级
//		Map<String,List<String>> map = new HashMap<String,List<String>>();
//
//		String sql = "select * from course where teacherId =" +teacherId;
//
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
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//
//		//根据teacherId和courseName得到courseId
//		int courseId=0 ;
//		String teacherId = (String) request.getSession().getAttribute("id");
//		String course = request.getParameter("marking-course");
//		String sql = "select * from course where courseName ='"+course +"' and teacherId ="+teacherId;
//		try {
//			List<Course> courses = courseDao.queryByCondition(sql);
//			for(Course c : courses){
//				courseId = c.getCourseId();
//			}
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//
//		List<StudentScoreReport> studentReport = new LinkedList<StudentScoreReport>();
//		//根据班级导出学生花名册
//		String _class = request.getParameter("marking-class");
//		String sql1 = "select * from student where _class= '" + _class + "' order by studentId asc";
//		System.out.println("course:"+course+" _class:"+_class+" sql:"+sql1);
//		try {
//			List<Student> students = studentDao.queryByCondition(sql1);
//			for(Student student : students){
//				StudentScoreReport stuSco = new StudentScoreReport();
//				stuSco.setStudentId(student.getId());
//				stuSco.setName(student.getName());
//				stuSco.setDepartment(student.getDepartment());
//				stuSco.setMajor(student.getMajor());
//				stuSco.setGender(student.getGender());
//				stuSco.setStuClass(student.getStudentClass());
//				stuSco.setCourseId(courseId);
//				stuSco.setCourseName(course);
//				studentReport.add(stuSco);
//			}
//			request.setAttribute("studentReport", studentReport);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		doGet(request,response);
//	}

}
