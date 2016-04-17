USE course;

DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS teacher;
DROP TABLE IF EXISTS manager;
DROP TABLE IF EXISTS classroom;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS course_choose_log;


############################################
# 创建用户表
############################################
# 学生表
CREATE TABLE student (
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
) DEFAULT CHARSET = utf8;


# 教师表
CREATE TABLE teacher (
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
) CHARSET = utf8;

# 管理员表
CREATE TABLE manager (
  id       CHAR(8)     NOT NULL PRIMARY KEY,      # 员工编号
  password VARCHAR(26) NOT NULL,                  # 密码
  name     VARCHAR(20) NOT NULL,                  # 姓名
  position VARCHAR(10) NOT NULL,                  # 职位
  gender   VARCHAR(3)  NOT NULL,                  # 性别
  phone    CHAR(14),                              # 电话
  email    VARCHAR(30)                            # 邮箱
) CHARSET = utf8;

# 教室表
CREATE TABLE classroom (
  id       CHAR(8)     NOT NULL PRIMARY KEY,
  capacity SMALLINT    NOT NULL,
  campus   VARCHAR(15) NOT NULL,                  # 园区
  building VARCHAR(30) NOT NULL,                  # 楼栋
  roomName VARCHAR(30) NOT NULL,                  # 教室名,如:0310
  roomType VARCHAR(30)                            #
) CHARSET = utf8;

# 课程表
CREATE TABLE course (
  id             INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name           VARCHAR(255) NOT NULL,           # 课程名称
  classes        VARCHAR(255) NOT NULL,           # 学该课程的班级,多个班级用分号隔开
  week_from      TINYINT,
  week_to        TINYINT,
  weekday        TINYINT,                         # 星期几
  time_from      INT,                             # 该课程从哪一天开始
  time_to        INT,                             # 该课程到哪一天截止
  classroom_id   CHAR(8),
  capacity       INT,
  now            INT,
  teacher_id     CHAR(8)      NOT NULL,           # 授课教师ID
  teacher_name   VARCHAR(20),                     # 授课教师姓名
  courseware_url VARCHAR(255),                    # 课程资料存放地址
  description    TEXT                             # 该课程的描述
) CHARSET = utf8;

# 学生选课信息表，供学生查看当前已选课程
CREATE TABLE course_choose_log (
  id         INT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  student_id CHAR(13) NOT NULL,
  course_id  INT      NOT NULL,
  time       INT
) CHARSET = utf8;
