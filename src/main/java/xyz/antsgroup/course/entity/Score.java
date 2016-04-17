package xyz.antsgroup.course.entity;
/**
 * 功能：学生成绩实体类
 * @author 李进锋
 *
 */
public class Score {
	
	private String studentId;
	private int courseId;
	private String stuScore;
	
	public Score() {
		super();
	}

	public Score(String studentId, int courseId, String score) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.stuScore = score;
	}


	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getStuScore() {
		return stuScore;
	}

	public void setStuScore(String stuScore) {
		this.stuScore = stuScore;
	}

	
	
}
