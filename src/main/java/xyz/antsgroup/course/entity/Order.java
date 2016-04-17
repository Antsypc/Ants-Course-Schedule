package xyz.antsgroup.course.entity;

public class Order {
	private String labRoomId;
	private String campus;
	private String building;
	private String roomName;
	private String roomType;
	private int capacity;
	private String freePeriod;
	
	public Order(){
		
	}
	
	public Order(String labRoomId, String campus, String building,
			String roomName, String roomType, int capacity, String freePeriod) {
		super();
		this.labRoomId = labRoomId;
		this.campus = campus;
		this.building = building;
		this.roomName = roomName;
		this.roomType = roomType;
		this.capacity = capacity;
		this.freePeriod = freePeriod;
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

	public String getFreePeriod() {
		return freePeriod;
	}

	public void setFreePeriod(String freePeriod) {
		this.freePeriod = freePeriod;
	}
	
	
}
