/**
 * 
 */
package xyz.antsgroup.course.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.entity.CourseChooseLog;
import xyz.antsgroup.course.util.DBTool;

/**
 * @author ANTS_YPC
 *
 */
public class CourseChooseLogDao extends BaseDaoImpl<CourseChooseLog, String>{

    
    @Override
    /**
     * return 0执行错误，1成功选课，2课程已满，3课程已选
     */
    public int save(CourseChooseLog entity) throws Exception {
        
        // 如果该该时间该地点的实验课已被选择则拒绝
        BaseDao<CourseChooseLog, String> ccldao = new CourseChooseLogDao();
        List<CourseChooseLog> list = null;
//        String sql = "SELECT * FROM courseChooseLog WHERE labRoomUsageId = "
//                  + entity.getLabRoomUsageId() + " AND studentId = \'"+entity.getStudentId()+"\'";
        try {
//            list = ccldao.queryByCondition(sql);
            if(list.size() > 0) {
                System.out.println("选课数"+list.size());
                return -1;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            return 0;
        } 
        
        Connection conn = null;
        PreparedStatement st = null;
        int updateNum = 0;
        int insertNum = 0;
        try {
            conn = DBTool.getConnection();
            conn.setAutoCommit(false);
            // 实验室使用记录人数+1
            String sqlupdate = "UPDATE labRoomUsage SET nowNum = nowNum + 1 WHERE labRoomUsageId = ? AND nowNum < maxNum";
            // 插入选课记录
            String sqlinsert = "INSERT INTO courseChooseLog VALUE(?,?,?,?)";
            
            st = conn.prepareStatement(sqlupdate);
//            st.setInt(1, Integer.valueOf(entity.getLabRoomUsageId()));
            updateNum = st.executeUpdate();

            st = conn.prepareStatement(sqlinsert);
//            st.setNull(1, Types.INTEGER);
//            st.setString(2, entity.getStudentId());
//            st.setInt(3, Integer.valueOf(entity.getLabRoomUsageId()));
//            st.setInt(4, Integer.valueOf(entity.getTime()));
            insertNum = st.executeUpdate();
            
            conn.commit();
        } catch (RuntimeException e1) {
            e1.printStackTrace();
            conn.rollback();
        } finally {
            if(updateNum != 1) {
                conn.rollback();
                return 2;
            }
            if(insertNum != 1) {
                conn.rollback();
                return 0;
            }
            conn.setAutoCommit(true);
            conn.close();
        }
        return insertNum;
    }
    

    /**
     * 删除表记录
     * @param sql
     * @return
     * @throws Exception
     */
    public int deleteByCondition(String sql) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        
        conn = DBTool.getConnection();
        ps = conn.prepareStatement(sql);
        rs = ps.executeUpdate();
        return rs;
    }
}
