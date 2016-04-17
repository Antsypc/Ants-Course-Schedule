/**
 * 数据库中存储的需要上实验课的课程表
 */
package xyz.antsgroup.course.entity;


public class Course {

    private int id;
    private String name;
    private String classes;
    private int weekFrom;
    private int weekTo;
    private int weekday;
    private String timeFrom;
    private String timeTo;
    private String classroomId;
    private int capacity;
    private int now;
    private String teacherId;
    private String teacherName;
    private String coursewareUrl;
    private String description;

    /*
  id             INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name           VARCHAR(255) NOT NULL,           # 课程名称
  classes        VARCHAR(255) NOT NULL,           # 学该课程的班级,多个班级用分号隔开
  week_from      TINYINT,
  week_to        TINYINT,
  weekday        TINYINT,                         # 星期几
  time_from      INT,                             # 该课程从哪一天开始
  time_to        INT,                             # 该课程到哪一天截止
  classroom_id   CHAR(8),
  capacity INT,
  now INT,
  teacher_id     CHAR(8)      NOT NULL,           # 授课教师ID
  teacher_name   VARCHAR(20),                     # 授课教师姓名
  courseware_url VARCHAR(255),                    # 课程资料存放地址
  description    TEXT                             # 该课程的描述
     */

    public Course() {
    }

    public Course(int id, String name, String classes, int weekFrom, int weekTo, int weekday, String timeFrom,
                  String timeTo, String classroomId, int capacity, int now, String teacherId, String teacherName, String coursewareUrl, String description) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.weekFrom = weekFrom;
        this.weekTo = weekTo;
        this.weekday = weekday;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.classroomId = classroomId;
        this.capacity = capacity;
        this.now = now;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.coursewareUrl = coursewareUrl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getWeekFrom() {
        return weekFrom;
    }

    public void setWeekFrom(int weekFrom) {
        this.weekFrom = weekFrom;
    }

    public int getWeekTo() {
        return weekTo;
    }

    public void setWeekTo(int weekTo) {
        this.weekTo = weekTo;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
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

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
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

    public String getCoursewareUrl() {
        return coursewareUrl;
    }

    public void setCoursewareUrl(String coursewareUrl) {
        this.coursewareUrl = coursewareUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", weekFrom=" + weekFrom +
                ", weekTo=" + weekTo +
                ", weekday=" + weekday +
                ", timeFrom='" + timeFrom + '\'' +
                ", timeTo='" + timeTo + '\'' +
                ", classroomId='" + classroomId + '\'' +
                ", capacity=" + capacity +
                ", now=" + now +
                ", teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", coursewareUrl='" + coursewareUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}