package xyz.antsgroup.course.controller.lab;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.dao.impl.EquipmentRepairDetailDao;
import xyz.antsgroup.course.entity.EquipmentRepairDetail;

/**
 * 设备维修处理操作，目前只有获取正在维修设备状态操作
 */
public class EquipmentRepairInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipmentRepairInfoServlet() {
        super();
    }

	/**
	 * 获取正在维修设备状态操作
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String sql = " SELECT em.equipmentMaintenanceId, em.equipmentId, em.action, em.amount, em.checkInTime, em.returnTime, em.managerId, "
	            + "         em.checkInDescription, em.returnDescription, em.categoryId, em.unit, c.categoryId, c.categoryName, c.parentId, c.parentName"
	            + " FROM "
	            + " ("
	            + "     SELECT a.categoryId, a.name AS categoryName, b.categoryId AS parentId, b.name AS parentName"
	            + "     FROM category AS a "
	            + "     INNER JOIN"
	            + "     (SELECT * FROM category) AS b"
	            + "     ON a.parent = b.categoryId"
	            + " ) AS c"
	            + " INNER JOIN"
	            + " ("
	            + "     SELECT m.equipmentMaintenanceId, m.equipmentId, m.action, m.amount, m.checkInTime, m.returnTime, m.managerId, m.checkInDescription, m.returnDescription, e.categoryId, e.unit"
	            + "     FROM equipment AS e"
	            + "     INNER JOIN "
	            + "     (SELECT equipmentMaintenanceId, equipmentId, action, amount, FROM_UNIXTIME(checkInTime) AS checkInTime, FROM_UNIXTIME(returnTime) AS returnTime, managerId, checkInDescription, returnDescription"
	            + "     FROM equipmentMaintenance WHERE returnTime is NULL AND action = 'R' "
	            + "     ) AS m"
	            + "     ON e.equipmentId = m.equipmentId"
	            + " ) AS em"
	            + " ON c.categoryId = em.categoryId";
	    BaseDao<EquipmentRepairDetail, String> emdao = new EquipmentRepairDetailDao();
	    List<EquipmentRepairDetail> emlist = null;
	    try {
            emlist = emdao.queryByCondition(sql);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher(request.getContextPath() +"/equipment/repair.jsp").forward(request, response);
            return;
        }
	    
	    // 删除时间后的.0 如果不这样操作得到的时间是2016-01-01 23:00:27。0
	    for(int i = 0; i < emlist.size(); i++) {
	        EquipmentRepairDetail erd = emlist.get(i);
	        String time = erd.getCheckInTime();
	        erd.setCheckInTime(time.substring(0, time.lastIndexOf(".")));
	    }
	    
	    request.setAttribute("repairlist", emlist);
	    
	    request.getRequestDispatcher(request.getContextPath() +"/equipment/repair.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

}
