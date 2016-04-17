package xyz.antsgroup.course.entity;

/**
 * @author ants_ypc
 * @version 1.0 4/16/16
 */
public class Classroom {
    private int id;
    private int capacity;
    private String campus;
    private String building;
    private String roomName;
    private String roomType;

    public Classroom() {
    }

    public Classroom(int id, int capacity, String campus, String building, String roomName, String roomType) {
        this.id = id;
        this.capacity = capacity;
        this.campus = campus;
        this.building = building;
        this.roomName = roomName;
        this.roomType = roomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", campus='" + campus + '\'' +
                ", building='" + building + '\'' +
                ", roomName='" + roomName + '\'' +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}
