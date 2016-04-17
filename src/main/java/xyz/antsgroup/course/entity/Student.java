/**
 * 数据库中存储的学生信息表
 */
package xyz.antsgroup.course.entity;


public class Student {

	private String id;
	private String password;
	private String name;
	private String department;
	private String major;
	private String studentClass;
	private String gender;
    private int inYear;
	private String nativePlace;
	private String email;
	private String phone;

    /*
  id            CHAR(13)    NOT NULL PRIMARY KEY, # 学号
  password      VARCHAR(26) NOT NULL,             # 密码
  name          VARCHAR(20) NOT NULL,             # 姓名
  department    VARCHAR(20) NOT NULL,             # 学院
  major         VARCHAR(20) NOT NULL,             # 专业
  student_class VARCHAR(20) NOT NULL,             # 班级
  gender        VARCHAR(3)  NOT NULL,             # 性别
  in_year       SMALLINT    NOT NULL,             # 入学年份
  native_place  VARCHAR(50) NOT NULL,             # 籍贯
  phone         CHAR(13),                         # 电话
  email         VARCHAR(30)                       # 邮箱
     */

    public Student() {
    }

    public Student(String id, String password, String name, String department, String major, String studentClass,
                   String gender, int inYear, String nativePlace, String email, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.department = department;
        this.major = major;
        this.studentClass = studentClass;
        this.gender = gender;
        this.inYear = inYear;
        this.nativePlace = nativePlace;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getInYear() {
        return inYear;
    }

    public void setInYear(int inYear) {
        this.inYear = inYear;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
