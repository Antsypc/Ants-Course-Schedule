/**
 * 
 */
package xyz.antsgroup.course.entity;

/**
 * 该类存储一门课程对应 的实验室的具体信息，主要用于学生选实验室
 * @author ANTS_YPC
 *
 */
public class CourseLabRoom {

    private String courseId;
    private String courseName;
    private String teacherName;
    private String labRoomId;
    private String campus;
    private String building;
    private String roomName;
    private String roomType;
    private int capacity;
    private int nowNum;
    private String labRoomUsageId;
    private String timeFrom;
    
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getLabRoomId() {
        return labRoomId;
    }
    public void setLabRoomId(String labRoomId) {
        this.labRoomId = labRoomId;
    }
    public String getCampus() {
        return campus;
    }
    public void setCampus(String campus) {
        this.campus = campus;
    }
    public String getBuilding() {
        return building;
    }
    public void setBuilding(String building) {
        this.building = building;
    }
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getNowNum() {
        return nowNum;
    }
    public void setNowNum(int nowNum) {
        this.nowNum = nowNum;
    }
    public String getLabRoomUsageId() {
        return labRoomUsageId;
    }
    public void setLabRoomUsageId(String labRoomUsageId) {
        this.labRoomUsageId = labRoomUsageId;
    }
    public String getTimeFrom() {
        return timeFrom;
    }
    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }
    

}
