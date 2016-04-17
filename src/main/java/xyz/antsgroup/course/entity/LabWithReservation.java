package xyz.antsgroup.course.entity;

/**
 * 实验室及其在某一天某一时段的预约情况
 * 对应数据库procedure lab_by_campus_day_status 的返回值
 * @author ANTS_YPC
 *
 */
public class LabWithReservation {
    
    private String labRoomId;
    private String campus;
    private String building;
    private String roomName;
    private String roomType;
    private String capacity;    // 实验室容纳的人数
    private String managerId;
    private String managerName;

    private String labRoomUsageId;
    private String timeFrom;
    private String courseId;
    private String courseName;
    private String teacherId;
    private String teacherName;
    private String nowNum;     // 预约该实验室对应课程当前人数
    private String maxNum;     // 预约该实验室对应课程的最大容量
    private String isOk;
    
    /**
     * SELECT f.labRoomId, f.campus, f.building, f.roomName, f.roomType, f.capacity, f.managerId, f.managerName, 
     * f.timeFrom, t.labRoomUsageId, t.courseId, t.courseName, t.teacherId, t.name AS teacherName, t.nowNum, t.maxNum, t.isOk
     */
    
    
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
    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public String getManagerId() {
        return managerId;
    }
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
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
    public String getNowNum() {
        return nowNum;
    }
    public void setNowNum(String nowNum) {
        this.nowNum = nowNum;
    }
    public String getMaxNum() {
        return maxNum;
    }
    public void setMaxNum(String maxNum) {
        this.maxNum = maxNum;
    }
    public String getIsOk() {
        return isOk;
    }
    public void setIsOk(String isOk) {
        this.isOk = isOk;
    }
    

}
