/**
 * 
 */
package xyz.antsgroup.course.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.entity.Equipment;
import xyz.antsgroup.course.entity.EquipmentMaintenance;
import xyz.antsgroup.course.util.DBTool;

/**
 * @author ANTS_YPC
 *
 */
public class EquipmentMaintenanceDao extends BaseDaoImpl<EquipmentMaintenance, String> {

    @Override
    public int save(EquipmentMaintenance entity) throws Exception {
        
        // 如果该设备正常的数量小于请求维修的数量，则拒绝
        int saveNum = 0;
        String eid = entity.getEquipmentId();
        BaseDao<Equipment, String> edao = new EquipmentDao();
        Equipment e = null;
        try {
            e = edao.get(eid);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if(e.getFree() < entity.getAmount()) {
            return saveNum;
        }
        
        //return super.save(entity);
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBTool.getConnection();
            conn.setAutoCommit(false);

            String sql1 = "INSERT INTO equipmentMaintenance VALUE (?,?,?,?,?,?,?,?,?)";
            st = conn.prepareStatement(sql1);
            st.setNull(1, Types.INTEGER);
            st.setString(2, entity.getEquipmentId());
            st.setString(3, entity.getAction());
            st.setInt(4, entity.getAmount());
            st.setInt(5, Integer.valueOf(entity.getCheckInTime()));
            st.setNull(6, Types.INTEGER);
            st.setString(7, entity.getManagerId());
            st.setString(8, entity.getCheckInDescription());
            st.setString(9, entity.getReturnDescription());
            saveNum = st.executeUpdate();
            
            String sql2 = "";
            if("R".equals(entity.getAction())) {
                sql2 = "UPDATE equipment SET free = free - ? WHERE equipmentId = ?";
                st = conn.prepareStatement(sql2);
                st.setInt(1, entity.getAmount());
                st.setString(2, entity.getEquipmentId());
            } else if("S".equals(entity.getAction())) {
                sql2 = "UPDATE equipment SET free = free - ?,total = total - ? WHERE equipmentId = ?";
                st = conn.prepareStatement(sql2);
                st.setInt(1, entity.getAmount());
                st.setInt(2, entity.getAmount());
                st.setString(3, entity.getEquipmentId());
            }
            saveNum = st.executeUpdate();
            conn.commit();
        } catch (RuntimeException e1) {
            e1.printStackTrace();
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    
        return saveNum;
    }

    @Override
    public void update(EquipmentMaintenance entity) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        int updateNum1 = 0;
        int updateNum2 = 0;
        try {
            conn = DBTool.getConnection();
            conn.setAutoCommit(false);
            Equipment eq = null;
            EquipmentDao eqdao = new EquipmentDao();
            eq = eqdao.get(entity.getEquipmentId());
            
            // 存储修改记录为归还
            String sql1 = "UPDATE equipmentMaintenance SET returnTime = ?, returnDescription = ? WHERE equipmentMaintenanceId = ?";   
            st = conn.prepareStatement(sql1);
            st.setInt(1, Integer.valueOf(entity.getReturnTime()));
            st.setString(2, entity.getReturnDescription());
            st.setInt(3, Integer.valueOf(entity.getEquipmentMaintenanceId()));
            updateNum1 = st.executeUpdate();
            
            
            // 修改Equipment表的free数量
            String sql2 = "UPDATE equipment SET free = ? WHERE equipmentId = ?";
            st = conn.prepareStatement(sql2);
            st.setInt(1, eq.getFree()+Integer.valueOf(entity.getAmount()));
            st.setString(2, entity.getEquipmentId());
            updateNum2 = st.executeUpdate();
            
            
            conn.commit();
        } catch (RuntimeException e1) {
            e1.printStackTrace();
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
        
        if(updateNum1 == 0 || updateNum2 == 0) {
            // 如果更新失败抛出异常
            throw new Exception();
        }
    }
    
    
    

}
