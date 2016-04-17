package xyz.antsgroup.course.entity;
/**
 * 功能：用于映射学生成绩报表信息
 * @author 李进锋
 *
 */
public class StudentScoreReport {
	String studentId;
	String name;
	String gender;
	String department;
	String major;
	int courseId;
	String stuClass;
	String courseName;
	String score;

	public StudentScoreReport() {
		super();
	}
	
	public StudentScoreReport(String studentId, String name, String gender,
			String department, String major, int courseId, String stuClass,
			String courseName, String score) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.major = major;
		this.courseId = courseId;
		this.stuClass = stuClass;
		this.courseName = courseName;
		this.score = score;
	}

	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
}
