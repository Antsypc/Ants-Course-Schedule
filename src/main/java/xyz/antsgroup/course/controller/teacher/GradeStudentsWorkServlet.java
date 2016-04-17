package xyz.antsgroup.course.controller.teacher;

/**
 * 功能：教师给学生评分（根据课程和班级）
 * @author 李进锋
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.dao.impl.ScoreDao;
import xyz.antsgroup.course.entity.Score;

public class GradeStudentsWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String result = SUCCESS;
		
		BaseDao<Score,String> scoreDao = new ScoreDao();
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader in = request.getReader();
		@SuppressWarnings("unchecked")
		List<Map<String,String>> scores = mapper.readValue(in, List.class);
		in.close();
		
		for(Map<String, String> map : scores){
			String courseId = String.valueOf(map.get("courseId"));
			String studentId =map.get("studentId");
			String studentScore = map.get("score");
			Score score =new Score();
			score.setStuScore(studentScore);
			score.setCourseId(Integer.parseInt(courseId));
			score.setStudentId(studentId);
			try {
				scoreDao.save(score);
			} catch (Exception e) {
				result = FAILURE;
				e.printStackTrace();
			}
		}
		String json = mapper.writeValueAsString(result);
		out.write(json);
		
	}

}
