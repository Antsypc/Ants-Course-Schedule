/**
 * 数据库中存储的学生选课日志表
 */
package xyz.antsgroup.course.entity;

public class CourseChooseLog {

	private int id;
	private String 	studentId;
	private int     courseId;
	private int     time;
	
	   
    /*
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,  # 主键
    studentId CHAR(13) NOT NULL,                                # 学生ID
    labRoomUsageId INT NOT NULL,                                
    time INT                                                    # 选课时间，CURRENT_TIME
     */

    public CourseChooseLog() {
    }

    public CourseChooseLog(int id, String studentId, int courseId, int time) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CourseChooseLog{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", courseId=" + courseId +
                ", time=" + time +
                '}';
    }
}
