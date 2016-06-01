package xyz.antsgroup.course.controller.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.antsgroup.course.controller.manager.ClassroomServlet;
import xyz.antsgroup.course.entity.Course;
import xyz.antsgroup.course.entity.CourseChooseLog;
import xyz.antsgroup.course.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生选课情况
 * GET 请求所有可选课程信息以及自己选择状态
 * POST 请求提交某一实验课的选择
 */
public class ChooseCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\", \"message\":\"error\"}";
    private static final String FAILURE_CHOSEN = "{\"success\":\"false\", \"message\":\"chosen\"}";
    private static final String FAILURE_FULL = "{\"success\":\"false\", \"message\":\"full\"}";
    private static final SqlSessionFactory sessionFactory;

    private String action = null;
    private String courseId = null;
    private String studentId = null;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = ClassroomServlet.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");

    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseCourseServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String studentId = (String)request.getSession().getAttribute("id");
        if (studentId == null) request.getRequestDispatcher("/WEB-INF/page/student/student-choose-course.jsp").forward(request, response);

        List<Course> courses = null;
        List<CourseChooseLog> courseChooseLogs = null;
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            Student student = sqlSession.selectOne("Student.getStudentById", studentId);
            courses = sqlSession.selectList("Course.getCoursesByCondition", new HashMap<String, String>() {
                {put("major", student.getStudentClass()); put("isSchedule", "true");}
            });
            courseChooseLogs = sqlSession.selectList("CourseChooseLog.getCourseChooseLogByStudentId", studentId);

            // 标识所有课程中已选的课
            for (CourseChooseLog logs : courseChooseLogs) {
                for (Course c : courses) {
                    if (c.getId() == logs.getCourseId()) {
                        c.setTeacherId("chosen");
                        c.setClasses(String.valueOf(logs.getId()));
                        break;
                    }
                }
            }
            for (Course c : courses) {
                if (!c.getTeacherId().equals("chosen")) {
                    c.setTeacherId("<button data-priority=\"1\" class=\"btn btn-xs btn-primary\">"
                            + "<i class=\"fa fa-plus\"></i> 选课</button>");
                } else {
                    c.setTeacherId("<button data-priority=\"2\" class=\"btn btn-xs btn-danger\">"
                            + "<i class=\"fa fa-remove\"></i> 退选</button>");
                }
            }
        }

        request.setAttribute("sclist", courses);
        request.getRequestDispatcher("/WEB-INF/page/student/student-choose-course.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    PrintWriter out = response.getWriter();
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(in, Map.class);
        action = map.get("action");
	    courseId = String.valueOf(map.get("id"));
	    
	    studentId = (String) request.getSession().getAttribute("id");
	    
	    String result = null;
	    if("choose".equals(action)) {
	        result = chooseCourse(request);
	    } else if("drop".equals(action)) {
            result = dropCourse(request);
	    } else {
	        result = FAILURE;
	    }

	    out.write(result);
	    out.close();
	}

    /**
     * 学生选课
     *
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
	protected String chooseCourse(HttpServletRequest request) throws ServletException, IOException {
	
        // 执行选课操作 
        // 在CourseChooseLogDao的save方法中判断了课程是否已被选，课程是否已满员
        int result = 0;
        try (SqlSession sqlSession = sessionFactory.openSession()){
            // 判断是否已选
            CourseChooseLog log = sqlSession.selectOne("CourseChooseLog.getLogByStudentIdCourseId", new HashMap<String, String>() {
                {
                    put("studentId", studentId);
                    put("courseId", courseId);
                }
            });
            if (log != null) return FAILURE_CHOSEN;

            // 安全插入
            result = sqlSession.update("Course.updateSafeForStudentChoose", courseId);
            if (result != 1) return FAILURE_FULL;


            log = new CourseChooseLog();
            log.setCourseId(Integer.valueOf(courseId));
            log.setStudentId(studentId);
            log.setTime((int) System.currentTimeMillis() / 1000);
            result = sqlSession.insert("CourseChooseLog.insertLog", log);
            sqlSession.commit();
            return result == 1 ? SUCCESS : FAILURE;
        }

	}

    /**
     * 学生退课.
     *
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
	protected String dropCourse(HttpServletRequest request) throws ServletException, IOException {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            int delete = sqlSession.delete("CourseChooseLog.deleteLogByCourseIdStudentId", new HashMap<String, String>() {
                {
                    put("studentId", studentId);
                    put("courseId", courseId);
                }
            });
            int update = sqlSession.update("Course.updateForStudentDrop", courseId);
            sqlSession.commit();
            if (delete == 1 && update == 1) return SUCCESS;
            else return FAILURE;
        }
	}
}
