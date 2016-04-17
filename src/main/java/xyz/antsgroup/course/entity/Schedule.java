package xyz.antsgroup.course.entity;
/**
 * 功能：暂存老师查询教学计划时的信息
 * @author 李进锋
 *
 */
public class Schedule {

	private int courseId;
	private String courseName;
	private String courseClass;
	private String timeFrom;
	private String timeTo;
	private String teacherId;
	private String teacherName;
	private String coursewareURL;
	private String description;
	
	public Schedule() {
		super();
	}

	public Schedule(int courseId, String courseName, String courseClass,
			String timeFrom, String timeTo, String teacherId,
			String teacherName, String coursewareURL, String description) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseClass = courseClass;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.coursewareURL = coursewareURL;
		this.description = description;
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

	public String getCourseClass() {
		return courseClass;
	}

	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCoursewareURL() {
		return coursewareURL;
	}

	public void setCoursewareURL(String coursewareURL) {
		this.coursewareURL = coursewareURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
