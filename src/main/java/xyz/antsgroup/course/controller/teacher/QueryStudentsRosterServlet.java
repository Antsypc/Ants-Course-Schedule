package xyz.antsgroup.course.controller.teacher;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.dao.impl.CourseDao;
import xyz.antsgroup.course.dao.impl.StudentDao;
import xyz.antsgroup.course.entity.Course;
import xyz.antsgroup.course.entity.Student;

/*
 * 功能：根据课程名称、班级查看学生花名册
 */
public class QueryStudentsRosterServlet extends HttpServlet {
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
//		//K=courseName,V=courseClasses
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
//			//将map转换为json数组，key为课程名称，value为班级
//			ObjectMapper mapper = new ObjectMapper();
//			String json = mapper.writeValueAsString(map);
//			request.setAttribute("json", json);
//			request.getRequestDispatcher("/student-management/students.jsp").forward(request, response);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//
//		//根据班级导出学生花名册
//		String _class = request.getParameter("courseClass");
//		String sql = "select * from student where _class= '" + _class + "' order by studentId asc";
//		try {
//			List<Student> students = studentDao.queryByCondition(sql);
//			request.setAttribute("students", students);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		doGet(request,response);
//	}

}
