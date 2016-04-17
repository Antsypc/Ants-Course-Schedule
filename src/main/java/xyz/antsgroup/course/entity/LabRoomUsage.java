/**
 * 数据库中存储的实验室使用记录表
 */
package xyz.antsgroup.course.entity;

public class LabRoomUsage {
	
	private String labRoomUsageId;
	private String labRoomId;
	private int timeFrom;
	private int courseId;
	private String teacherId;
	private int nowNum;
	private int maxNum;
	private String isOk;
	private String description;
	
	/**
	labRoomUsageId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, # 主键
    labRoomId INT NOT NULL,                     # 房间号，与labRoom保持一致
    timeFrom INT NOT NULL,                      # 使用起始时间
    courseId INT,                               # 使用该实验室的课程编号，当临时事件使用时可以没有编号
    teacherId CHAR(8),                          # 预约该实验室的老师ID
    nowNum SMALLINT DEFAULT 0,                  # 该课程已有人数
    maxNum SMALLINT DEFAULT 0,                  # 实验室最大容量
    isOk CHAR(1) DEFAULT '0',                   # 实验室管理员是否通过该项实验室申请，默认为‘0’，通过为‘1’
    description VARCHAR(30)                     # 建议只用临时事件使用时填写该字段
	 */
	
    public String getLabRoomUsageId() {
        return labRoomUsageId;
    }
    public void setLabRoomUsageId(String labRoomUsageId) {
        this.labRoomUsageId = labRoomUsageId;
    }
    public String getLabRoomId() {
        return labRoomId;
    }
    public void setLabRoomId(String labRoomId) {
        this.labRoomId = labRoomId;
    }
    public int getTimeFrom() {
        return timeFrom;
    }
    public void setTimeFrom(int timeFrom) {
        this.timeFrom = timeFrom;
    }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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
    public String getIsOk() {
        return isOk;
    }
    public void setIsOk(String isOk) {
        this.isOk = isOk;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}