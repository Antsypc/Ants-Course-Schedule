package xyz.antsgroup.course.controller.teacher;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.antsgroup.course.entity.Course;
import xyz.antsgroup.course.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/CourseScheduleServlet")
public class CourseScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
    private static final SqlSessionFactory sessionFactory;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = CourseScheduleServlet.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String teacherId = (String) request.getSession().getAttribute("id");
		try (SqlSession sqlSession = sessionFactory.openSession()) {
            List<Course> courses = sqlSession.selectList("Course.getCourseByTeacherId", teacherId);
            request.setAttribute("courses", courses);
        } catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/teacher/course-schedule.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		String result = "";
		
		try {
			result = addTeacherSchedule(request);
			String json = mapper.writeValueAsString(result);
			request.setAttribute("result", json);
		} catch (Exception e) {
			e.printStackTrace();
			out.write(FAILURE);
			return;
		}
		out.write(result);
		//doGet(request,response);
	}
	
	/*
	 * 教师添加课程计划
	 */
	private String addTeacherSchedule(HttpServletRequest request) throws Exception{
		
		//从session中拿到teacherID
		String teacherId = (String) request.getSession().getAttribute("id");
		//如果teacherID为空，失败
		if(teacherId == null){
			return FAILURE;
		}

        //从前端获取要添加的课程信息
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String,String> map = mapper.readValue(in,Map.class);
        in.close();

        String courseName = map.get("courseName");
        String courseClass = map.get("courseClass");
        String description = map.get("description");
        //判断是否取到
        if(courseName == null || courseClass == null || description == null){
            return FAILURE;
        }

        int insertNum;

        try (SqlSession sqlSession = sessionFactory.openSession()) {
            //根据teacherID从teacher表中查到teacherName
            Teacher teacher = sqlSession.selectOne("Teacher.getTeacherById", teacherId);
            String teacherName = teacher.getName();
            if (teacherName == null) {
                return FAILURE;
            }

            Course course = new Course();
            course.setName(courseName);
            course.setClasses(courseClass);
            course.setDescription(description);
            course.setTeacherId(teacherId);
            course.setTeacherName(teacherName);

            insertNum = sqlSession.insert("Course.insertCourse", course);
            sqlSession.commit();
        }
        return 1 == insertNum ? SUCCESS : FAILURE;
	}

}
