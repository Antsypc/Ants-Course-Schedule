/**
 * 
 */
package xyz.antsgroup.course.entity;

/**
 * 某学生实验课的所有课程及选择信息，如果未选则 courseChooseLogId 为null
 * @author ANTS_YPC
 *
 */
public class StudentChooseLabDetail {

    private int    courseId;
    private String courseName;
    private String coursewareURL;
    private String teacherName;
    private int    labRoomUsageId;
    private String labRoomId;
    private String timeFrom;
    private int    nowNum;
    private int    maxNum;
    private int    courseChooseLogId;
    private String campus;
    private String building;
    private String roomName;
    private String roomType;
    

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
    public String getCoursewareURL() {
        return coursewareURL;
    }
    public void setCoursewareURL(String coursewareURL) {
        this.coursewareURL = coursewareURL;
    }
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public int getLabRoomUsageId() {
        return labRoomUsageId;
    }
    public void setLabRoomUsageId(int labRoomUsageId) {
        this.labRoomUsageId = labRoomUsageId;
    }
    public String getLabRoomId() {
        return labRoomId;
    }
    public void setLabRoomId(String labRoomId) {
        this.labRoomId = labRoomId;
    }
    public String getTimeFrom() {
        return timeFrom;
    }
    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }
    public int getNowNum() {
        return nowNum;
    }
    public void setNowNum(int nowNum) {
        this.nowNum = nowNum;
    }
    public int getMaxNum() {
        return maxNum;
    }
    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }
    public int getCourseChooseLogId() {
        return courseChooseLogId;
    }
    public void setCourseChooseLogId(int courseChooseLogId) {
        this.courseChooseLogId = courseChooseLogId;
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

    
    
}
