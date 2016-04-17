package xyz.antsgroup.course.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import xyz.antsgroup.course.entity.StudentScoreReport;
import xyz.antsgroup.course.util.DBTool;

public class StudentScoreReportDao extends BaseDaoImpl<StudentScoreReport, String> {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	List<StudentScoreReport> list = new LinkedList<StudentScoreReport>();
	public List<StudentScoreReport>  getStudentScoreReport(String course, String teacherId, String _class, int courseId) throws SQLException{
		
		try {
			conn = DBTool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "select student.studentId,department,name,gender,major,student._class,stuScore,score.courseId "
				+ "from student join score "
				+ "on student.studentId = score.studentId "
				+ "and score.courseId = ? and student._class = ?";
		
		ps = conn.prepareStatement(sql);
		ps.setInt(1, courseId);
		ps.setString(2, _class);
		rs = ps.executeQuery();
		while(rs.next()){
			StudentScoreReport ssr = new StudentScoreReport();
			ssr.setStudentId(rs.getString("studentId"));
			ssr.setName(rs.getString("name"));
			ssr.setGender(rs.getString("gender"));
			ssr.setDepartment(rs.getString("department"));
			ssr.setMajor(rs.getString("major"));
			ssr.setStuClass(_class);
			ssr.setCourseId(courseId);
			ssr.setCourseName(course);
			ssr.setScore(rs.getString("stuScore"));
			list.add(ssr);
		}
		return list;
		
	}
}
