package xyz.antsgroup.course.controller.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.dao.impl.StudentScoreDetailDao;
import xyz.antsgroup.course.entity.StudentScoreDetail;

/**
 * Servlet implementation class ScoreServlet
 */
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String studentId = (String) request.getSession().getAttribute("id");
	    String sql = "SELECT s.stuScore, c.courseName, c.teacherName "
	          + " FROM course AS c "
	          + " INNER JOIN "
	          + " (SELECT * FROM score WHERE studentId = '"+ studentId +"') "
	          + " AS s "
	          + " ON c.courseId = s.courseId";    
	    List<StudentScoreDetail> scoreList = null;
	    BaseDao<StudentScoreDetail, String> sdao = new StudentScoreDetailDao();
	
	    try {
	        scoreList = sdao.queryByCondition(sql);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("").forward(request, response);
        }
	    request.setAttribute("scoreList", scoreList);
	    request.getRequestDispatcher("/course/studentscores.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
