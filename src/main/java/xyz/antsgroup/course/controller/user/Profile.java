/**
 * 用户获取和修改个人信息
 */
package xyz.antsgroup.course.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.antsgroup.course.entity.Manager;
import xyz.antsgroup.course.entity.Student;
import xyz.antsgroup.course.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Servlet implementation class UpdateTeacher
 */
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
    private static final SqlSessionFactory sessionFactory;

    //public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    //public static final String REGEX_PHONE = "^((13[0-9])|(15[0-9])|177|(18[0,5-9]))\\d{8}$";
    //public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = Profile.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
    }

	/**
	 * 判断用户类型，执行相应获取个人信息操作
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // 注意开始时是通过返回json给客户端，现在是把用户信息写入页面返回给客户端
	    
        response.setCharacterEncoding("UTF-8");
        // 返回json格式或页面跳转
        HttpSession session = request.getSession();
        String identity = (String) session.getAttribute("identity");
        
        //PrintWriter out = response.getWriter();
        String result = "";
        if("student".equals(identity)) {
        // 将用户对象写入request同时返回用户对象信息的json
            result = getStudentInfo(request);       
            request.getRequestDispatcher("/WEB-INF/page/profile/student.jsp").forward(request, response);
        } else if("teacher".equals(identity)) {
        // 将用户对象写入request同时返回用户对象信息的json
            result = getTeacherInfo(request); 
            request.getRequestDispatcher("/WEB-INF/page/profile/teacher.jsp").forward(request, response);
        } else if("manager".equals(identity)) {
         // 将用户对象写入request同时返回用户对象信息的json
            result = getLabManagerInfo(request); 
            request.getRequestDispatcher("/WEB-INF/page/profile/manager.jsp").forward(request, response);
        } else {
            System.out.println("no user");
            //out.write(FAILURE);
            return;
        }

        //out.write(result);
        //out.close();
	}

	/**
	 * 判断用户身份，执行相应修改个人信息操作。
	 * 返回"{\"success\":\"true\"}" 或 "{\"success\":\"false\"}";
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    response.setCharacterEncoding("UTF-8");
	    
	    HttpSession session = request.getSession();
	    System.out.println("update user info:");
	    System.out.println(session.getAttribute("identity"));
	    System.out.println(session.getAttribute("id"));
	    String user = (String) session.getAttribute("identity");
	    String result = "";
	    PrintWriter out = response.getWriter();
	    if("student".equals(user)) {
	        result = updateStudentInfo(request);
	    } else if("teacher".equals(user)) {
	        result = updateTeacherInfo(request);
	    } else if("manager".equals(user)) {
	        result = updateManagerInfo(request);
	    } else {
	        System.out.println("no user");
	        out.write(FAILURE);
	        return;
	    }
	    out.write(result);
	    out.close();
	        
	}

	/**
	 * 获取某学生个人信息,将学生对象写入request，并返回对象的json
	 * @param request
	 * @return json格式
	 * @throws ServletException
	 * @throws IOException
	 */
    protected String getStudentInfo(HttpServletRequest request) throws ServletException, IOException{
        String studentId = (String) request.getSession().getAttribute("id");
        String info = "";
        if(studentId == null)
            return FAILURE;

        try (SqlSession sqlSession = sessionFactory.openSession()) {
            Student student = sqlSession.selectOne("Student.getStudentById", studentId);
            ObjectMapper mapper = new ObjectMapper();
            info = mapper.writeValueAsString(student);  // 转换为json
            System.out.println("getstudentinfo:" + info);
            request.setAttribute("user", student);      // 将该对象加入request
            System.out.println("student email" + student.getEmail());
        }
        return info;
    }
    
    /**
     * 获取某位老师个人信息，将教师对象写入request，并返回对象的json
     * @param request
     * @return json格式
     * @throws ServletException
     * @throws IOException
     */
    protected String getTeacherInfo(HttpServletRequest request) throws ServletException, IOException{
        String teacherId = (String) request.getSession().getAttribute("id");
        String info = "";
        if(teacherId == null)
            return FAILURE;

        try (SqlSession sqlSession = sessionFactory.openSession()) {
            Teacher teacher = sqlSession.selectOne("Teacher.getTeacherById", teacherId);
            ObjectMapper mapper = new ObjectMapper();
            info = mapper.writeValueAsString(teacher);  // 转换为json
            System.out.println("getteacherinfo:" + info);
            request.setAttribute("user", teacher);      // 将该对象加入request
        }

        return info;

    }
    
    /**
     * 获取某管理员个人信息，将实验室管理员对象写入request，并返回对象的json
     * @param request
     * @return json格式
     * @throws ServletException
     * @throws IOException
     */
    protected String getLabManagerInfo(HttpServletRequest request) throws ServletException, IOException{
        String managerId = (String) request.getSession().getAttribute("id");
        String info = "";
        if(managerId == null)
            return FAILURE;

        try (SqlSession sqlSession = sessionFactory.openSession()) {
            Manager manager = sqlSession.selectOne("Manager.getManagerById", managerId);
            ObjectMapper mapper = new ObjectMapper();
            info = mapper.writeValueAsString(manager);  // 转换为json
            System.out.println("getmanagerinfo:" + info);
            request.setAttribute("user", manager);      // 将该对象加入request
        }

        return info;
    }
    
    /**
     * 更新某学生个人信息
     * @param request
     * @return json格式返回成功与否
     * @throws ServletException
     * @throws IOException
     */
    protected String updateStudentInfo(HttpServletRequest request) throws ServletException, IOException{

        String id = (String) request.getSession().getAttribute("id");
        if(id == null)
            return FAILURE;

        Student student = null;
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            student = sqlSession.selectOne("Student.getStudentById", id);
        }
        // 获取学生需要修改的信息
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, String> map = mapper.readValue(in, Map.class);
        in.close();
        
        // 验证密码,修改信息
        String pw = map.get("oldpassword");
        if(pw == null || !student.getPassword().equals(pw)) {
            return FAILURE;
        } else {
            String newpassword = map.get("newpassword");
            if(!newpassword.isEmpty()) {
                System.out.println("学生新密码是：" + newpassword);
                student.setPassword(newpassword);                
            }
            student.setEmail(map.get("email"));
            System.out.println("getemail"+ student.getEmail());
            student.setPhone(map.get("phone"));
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                sqlSession.update("Student.updateStudent", student);
                sqlSession.commit();
            }
            return SUCCESS;
        }
    }
    
    /**
     * 更新某老师个人信息
     * @param request
     * @return json格式，返回成功与否
     * @throws ServletException
     * @throws IOException
     */
    protected String updateTeacherInfo(HttpServletRequest request) throws ServletException, IOException{
        String id = (String) request.getSession().getAttribute("id");
        if(id == null)
            return FAILURE;

        Teacher teacher = null;
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            teacher = sqlSession.selectOne("Teacher.getTeacherById", id);
        }
        // 获取需要修改的信息
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, String> map = mapper.readValue(in, Map.class);
        in.close();
        
        // 验证密码,修改信息
        String pw = map.get("oldpassword");
        if(pw == null || !teacher.getPassword().equals(pw)) {
            return FAILURE;
        } else {
            String newpassword = map.get("newpassword");
            if(!newpassword.isEmpty()) {
                teacher.setPassword(newpassword);
            }
            teacher.setEmail(map.get("email"));
            teacher.setPhone(map.get("phone"));
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                sqlSession.update("Teacher.updateTeacher", teacher);
                sqlSession.commit();
            }
            return SUCCESS;
        }
    }
    
    /**
     * 更新某管理员个人信息
     * @param request
     * @return json格式，返回成功与否
     * @throws ServletException
     * @throws IOException
     */
    protected String updateManagerInfo(HttpServletRequest request) throws ServletException, IOException{
        String id = (String) request.getSession().getAttribute("id");
        if(id == null)
            return FAILURE;

        Manager manager = null;
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            manager = sqlSession.selectOne("Manager.getManagerById", id);
        }
        // 获取需要修改的信息
        BufferedReader in = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, String> map = mapper.readValue(in, Map.class);
        in.close();
        
        // 验证密码,修改信息
        String pw = map.get("oldpassword");
        if(pw == null || !manager.getPassword().equals(pw)) {
            return FAILURE;
        } else {
            String newpassword = map.get("newpassword");
            if(!newpassword.isEmpty()) {
                manager.setPassword(newpassword);
            }
            manager.setEmail(map.get("email"));
            manager.setPhone(map.get("phone"));
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                sqlSession.update("Manager.updateManager", manager);
                sqlSession.commit();
            }
            return SUCCESS;
        }
    }
}



