import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.antsgroup.course.entity.Classroom;
import xyz.antsgroup.course.entity.Course;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author ants_ypc
 * @version 1.0 4/16/16
 */
public class Test {
    private static final SqlSessionFactory sessionFactory;

    static {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
    }

    public static void main(String[] args) {
        List<Course> courseList = null;
        try (SqlSession sqlSession = sessionFactory.openSession()){
            courseList = sqlSession.selectList("Course.getCoursesByCondition", new HashMap<String,String>(){
                {put("major", null); put("isSchedule", "true");}
            });
        }
        for (Course c : courseList) {
            System.out.println(c);
        }
    }
}
