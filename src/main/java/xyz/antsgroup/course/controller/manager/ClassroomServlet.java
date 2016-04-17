package xyz.antsgroup.course.controller.manager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.antsgroup.course.entity.Classroom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class LabManage
 */
public class ClassroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
    private static final SqlSessionFactory sessionFactory;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = ClassroomServlet.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassroomServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // 该类目前采用SearchLabRoomServlet类的相同实现方式
        String campus = request.getParameter("campus");
        String type = request.getParameter("type");
        if(campus == null || type == null) {
            request.getRequestDispatcher("/manager/classroom.jsp").forward(request, response);
            return;
        }
        
        // 建立前端字段和数据库的对应关系，防止sql注入
        Map<String, String> campusMap = new HashMap<>();
        Map<String, String> typeMap = new HashMap<>();
        campusMap.put("all", null);
        campusMap.put("nanhu", "南湖");
        campusMap.put("jianhu", "鉴湖");
        campusMap.put("dongyuan", "东院");
        campusMap.put("xiyuan", "西院");
        campusMap.put("yuqu", "余区");
        typeMap.put("classroom", "教室");
        typeMap.put("laboratory", "实验室");
        typeMap.put("all", null);

        try (SqlSession sqlSession = sessionFactory.openSession()){
            List<Classroom> room = sqlSession.selectList("Classroom.getRoomByConditions", new HashMap<String,String>(){
                {put("campus", campusMap.get(campus)); put("roomType", typeMap.get(type));}
            });

            request.setAttribute("room", room);
            request.setAttribute("campus", campus);
            request.setAttribute("type", type);
        }
        request.getRequestDispatcher("/manager/classroom.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request,response);
	}

}
