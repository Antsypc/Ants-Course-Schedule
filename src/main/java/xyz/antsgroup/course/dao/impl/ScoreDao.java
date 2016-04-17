package xyz.antsgroup.course.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import xyz.antsgroup.course.entity.Score;
import xyz.antsgroup.course.util.DBTool;

public class ScoreDao extends BaseDaoImpl<Score,String> {
	Connection conn = null;
	PreparedStatement ps = null;
	private static final String SUCCESS = "{\"success\":\"true\"}";
	private static final String FAILURE = "{\"success\":\"false\"}";
	String result =SUCCESS;
	/**
	 * 功能：根据以下三个字段修改学生成绩
	 * @param courseId
	 * @param studentId
	 * @param stuScore
	 * @return
	 * @throws SQLException
	 */
	public String update(int courseId, String studentId, String stuScore) throws SQLException{
		try {
			conn = DBTool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = FAILURE;
		}
		
		String sql = "update score set stuScore = ? where studentId = ? and courseId = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, stuScore);
		ps.setString(2, studentId);
		ps.setInt(3, courseId);
		ps.executeUpdate();
		return result;
	}

}
