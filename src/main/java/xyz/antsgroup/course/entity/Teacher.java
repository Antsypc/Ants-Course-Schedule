/**
 * 数据库中存储的教师信息表
 */
package xyz.antsgroup.course.entity;

public class Teacher {

	private String id;
	private String password;
	private String name;
	private String department;
	private String title;
	private String gender;
	private String phone;
	private String email;
	private int    inYear; 
	private String nativePlace;
	
/*
  id           CHAR(8)     NOT NULL PRIMARY KEY,  # 教师号
  password     VARCHAR(26) NOT NULL,              # 密码
  name         VARCHAR(20) NOT NULL,              # 姓名
  department   VARCHAR(20) NOT NULL,              # 学院
  title        VARCHAR(10) NOT NULL,              # 职称
  gender       VARCHAR(3)  NOT NULL,              # 性别
  phone        CHAR(14),                          # 电话
  email        VARCHAR(30),                       # 邮箱
  in_year      SMALLINT    NOT NULL,              # 入职年份
  native_place VARCHAR(50) NOT NULL               # 籍贯
 */

    public Teacher() {
    }

    public Teacher(String id, String password, String name, String department, String title,
                   String gender, String phone, String email, int inYear, String nativePlace) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.department = department;
        this.title = title;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.inYear = inYear;
        this.nativePlace = nativePlace;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
