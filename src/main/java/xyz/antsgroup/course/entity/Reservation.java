package xyz.antsgroup.course.entity;

public class Reservation {
	private String labRoomUsageId;
	private String campus;
	private String building;
	private String roomName;
	private int capacity;
	private String courseName;
	private int courseCapacity;
	private String reservedPeriod;
	private String status;
	
	public Reservation() {
		super();
	}

	public Reservation(String labRoomUsageId, String campus, String building,
			String roomName, int capacity, String courseName,
			int courseCapacity, String reservedPeriod, String status) {
		super();
		this.labRoomUsageId = labRoomUsageId;
		this.campus = campus;
		this.building = building;
		this.roomName = roomName;
		this.capacity = capacity;
		this.courseName = courseName;
		this.courseCapacity = courseCapacity;
		this.reservedPeriod = reservedPeriod;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLabRoomUsageId() {
		return labRoomUsageId;
	}

	public void setLabRoomUsageId(String labRoomUsageId) {
		this.labRoomUsageId = labRoomUsageId;
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


	public String getCourseName() {
		return courseName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCourseCapacity() {
		return courseCapacity;
	}

	public void setCourseCapacity(int courseCapacity) {
		this.courseCapacity = courseCapacity;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	

	public String getReservedPeriod() {
		return reservedPeriod;
	}

	public void setReservedPeriod(String reservedPeriod) {
		this.reservedPeriod = reservedPeriod;
	}
}
