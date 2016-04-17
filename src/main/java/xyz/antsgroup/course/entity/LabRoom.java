/**
 * 数据库中存储的实验室信息表
 */
package xyz.antsgroup.course.entity;


public class LabRoom {

	private String labRoomId;
	private String campus;
	private String building;
	private String roomName;
	private String roomType;
	private int capacity;
	private String managerId;
	private String managerName;
	
	/*
    labRoomId CHAR(7) NOT NULL PRIMARY KEY,
    campus VARCHAR(15) NOT NULL,               # 园区
    building VARCHAR(30) NOT NULL,             # 楼栋
    roomName VARCHAR(30) NOT NULL,             # 实验室名字
    roomType VARCHAR(30),                      # 实验室类型
    capacity SMALLINT NOT NULL,                # 实验室最大容纳人数
    managerId CHAR(8),
    managerName VARCHAR(20)
     */
    

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
    public String getLabRoomId() {
        return labRoomId;
    }
    public void setLabRoomId(String labRoomId) {
        this.labRoomId = labRoomId;
    }
	

}
