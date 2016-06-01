/**
 * 数据库中存储的实验室管理员表
 */
package xyz.antsgroup.course.entity;


public class Manager {

	private String id;
	private String password;
	private String name;
	private String position;
	private String gender;
	private String phone;
	private String email;
	
	/*
    id CHAR(8) NOT NULL PRIMARY KEY,        # 员工编号
    password VARCHAR(26) NOT NULL,          # 密码
    name VARCHAR(20) NOT NULL,              # 姓名
    position VARCHAR(10) NOT NULL,          # 职位
    gender VARCHAR(3) NOT NULL,             # 性别
    phone CHAR(14),                         # 电话
    email VARCHAR(30)                       # 邮箱
     */
    
	
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
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
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
	

	
	
}
