package xyz.antsgroup.course.controller.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.dao.impl.EquipmentDao;
import xyz.antsgroup.course.dao.impl.EquipmentDetailDao;
import xyz.antsgroup.course.dao.impl.EquipmentMaintenanceDao;
import xyz.antsgroup.course.dao.impl.EquipmentUsageDao;
import xyz.antsgroup.course.entity.Equipment;
import xyz.antsgroup.course.entity.EquipmentDetail;
import xyz.antsgroup.course.entity.EquipmentMaintenance;
import xyz.antsgroup.course.entity.EquipmentUsage;
import xyz.antsgroup.course.util.EquipConsumCategoryDetail;

/**
 * 实验室设备管理
 * GET 获取实验室设备情况
 * POST 请求处理原有设备数量的增加、新设备的添加、设备维修登记、设备报废
 * Servlet implementation class EquipmentMaintenance
 */
public class EquipmentManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
	
    // 客户端请求参数，不一定都会用到
    private String action = null;       // 操作参数
    private String id = null;           // 耗材id，目前后台id和name一致
    private String name = null;
    private String category = null;     // 耗材所属分类
    private String total = null;        // 总量
    private String free = null;         // 处于可用状态的数量
    private String unit = null;         // 耗材单位
    private String number = null;       // 可能代表请求使用的数量等
    private String note = null;         // 使用耗材是添加的描述
       
    private static Map<String, String> actionMap = null;
    
    
    /**
     */
    public EquipmentManageServlet() {
        super();
     // 建立客户端请求操作与数据库存储操作的映射
        actionMap = new HashMap();
        actionMap.put("repair", "R");
        actionMap.put("abandon", "A");
        actionMap.put("add", "A");
        actionMap.put("new", "N");
        actionMap.put("scrap", "S");
    }

	/**
	 * 获取实验室设备情况
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        String sql = "SELECT e.equipmentId, c.categoryId, c.categoryName, c.parentId, c.parentName, e.total, e.unit, e.free, e.isOk "
                + " FROM equipment AS e "
                + " LEFT JOIN "
                + " ( "
                + "     SELECT a.categoryId, a.name AS categoryName, b.categoryId AS parentId, b.name AS parentName "
                + "     FROM category AS a  "
                + "     INNER JOIN "
                + "     (SELECT * FROM category) AS b "
                + "     ON a.parent = b.categoryId "
                + " ) AS c "
                + " ON e.categoryId = c.categoryId";
        
        BaseDao<EquipmentDetail, String> dao = new EquipmentDetailDao();
        List<EquipmentDetail> equipments = null;
        try {
            equipments = dao.queryByCondition(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String category = null;
        try {
            category = EquipConsumCategoryDetail.getCategoryInJosn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("equip", equipments);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/equipment/equipment.jsp").forward(request, response);
	}

	/**
	 * 请求处理原有设备数量的增加、新设备的添加、设备维修登记、设备报废
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    String result = FAILURE;
        BufferedReader in = request.getReader();
	    ObjectMapper mapper = new ObjectMapper();
	    Map<String, String> map = mapper.readValue(in, Map.class);
	    
        action = map.get("action");
        id = map.get("id");
        name = map.get("name");
        category = map.get("category");
        total = map.get("total");
        free = map.get("free");
        unit = map.get("unit");
        number = map.get("number");
        note = map.get("note");
	
	    if("repair".equals(action)) {
	        result = equipmentRepair(request);
	    } else if("scrap".equals(action)) {
	        result = equipmentScrap(request);
	    } else if("return".equals(action)) {
	        result = equipmentReturn(request);
	    } else if("add".equals(action)) {
	        result = equipmentAdd(request);
	    } else if("new".equals(action)) {
	        result = equipmenntNew(request);
	    } else {
	        result = FAILURE;
	    }
	    out.write(result);
	    out.close();
	}

	/**
	 * 对现有设备的增加操作
	 * @param request
	 * @return 处理结果信息 json
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String equipmentAdd(HttpServletRequest request) throws ServletException, IOException {
	    Equipment equip;
	    BaseDao<Equipment, String> edao = new EquipmentDao();
	    EquipmentUsage eu = new EquipmentUsage();
	    BaseDao<EquipmentUsage, String> eudao = new EquipmentUsageDao();
	    try {
            equip = edao.get(id);
            equip.setTotal(equip.getTotal() + Integer.valueOf(number));
            equip.setFree(equip.getFree() + Integer.valueOf(number));
            edao.update(equip);
            
            // 把操作记录写入usage表，这个记录目前不是必须同步的
            eu.setEquipmentId(equip.getEquipmentId());
            eu.setAction("A");
            eu.setAmount(Integer.valueOf(number));
            eu.setTime((System.currentTimeMillis())/1000 + "");
            eudao.save(eu);
            
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
	    return SUCCESS;
	}
	
	/**
	 * 设备新增操作
	 * @param request
	 * @return 处理结果信息 json
	 * @throws ServletException
	 * @throws IOException
	 */
    protected String equipmenntNew(HttpServletRequest request) throws ServletException, IOException {
        Equipment equip = new Equipment();
        BaseDao<Equipment, String> edao = new EquipmentDao();
        EquipmentUsage eu = new EquipmentUsage();
        BaseDao<EquipmentUsage, String> eudao = new EquipmentUsageDao();
        try {
            equip.setEquipmentId(name);
            equip.setCategoryId(category);
            equip.setTotal(Integer.valueOf(total));
            equip.setUnit(unit);
            equip.setFree(Integer.valueOf(total));
            equip.setIsOk("1");
            edao.save(equip);
            
            
            // 把操作记录写入usage表，这个记录目前不是必须同步的
            eu.setEquipmentId(equip.getEquipmentId());
            eu.setAction("N");
            eu.setAmount(Integer.valueOf(number));
            eu.setTime((System.currentTimeMillis())/1000 + "");
            eudao.save(eu);
            
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
        return "{\"success\":\"true\",\"id\":\""+name+"\"}";
    }
	
    /**
     * 设备维修登记
     * @param request
     * @return 处理结果信息 json
     * @throws ServletException
     * @throws IOException
     */
	protected String equipmentRepair(HttpServletRequest request) throws ServletException, IOException {
	    EquipmentMaintenance em = new EquipmentMaintenance();
	    em.setAction(actionMap.get(action));
	    em.setAmount(Integer.valueOf(number));
	    em.setCheckInDescription(note);
	    em.setCheckInTime((System.currentTimeMillis())/1000 + "");
	    em.setEquipmentId(id);
	    em.setManagerId((String) request.getSession().getAttribute("id"));
	    
	    BaseDao<EquipmentMaintenance, String> emdao = new EquipmentMaintenanceDao();
	    int resultCount = 0;
	    try {
	        resultCount = emdao.save(em);
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
	    if(resultCount != 1) {
	        return FAILURE;
	    }
        return SUCCESS;
	}
	
	/**
	 * 设备报废登记
	 * @param request
	 * @return 处理结果信息 json
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String equipmentScrap(HttpServletRequest request) throws ServletException, IOException {
        EquipmentMaintenance em = new EquipmentMaintenance();
        em.setAction(actionMap.get(action));
        em.setAmount(Integer.valueOf(number));
        em.setCheckInDescription(note);
        em.setCheckInTime((System.currentTimeMillis())/1000 + "");
        em.setEquipmentId(id);
        em.setManagerId((String) request.getSession().getAttribute("id"));
        
        BaseDao<EquipmentMaintenance, String> emdao = new EquipmentMaintenanceDao();
        int resultCount = 0;
        try {
            resultCount = emdao.save(em);
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
        if(resultCount != 1) {
            return FAILURE;
        }
        return SUCCESS;
    }
	

	/**
	 * 设备维修后，回库登记
	 * @param request
	 * @return 处理结果信息 json
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String equipmentReturn(HttpServletRequest request) throws ServletException, IOException {
	    
	    String result = null;
	    BaseDao<EquipmentMaintenance, String> emdao = new EquipmentMaintenanceDao();
	    EquipmentMaintenance em = null;
	    try {
            em = emdao.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
	    em.setReturnDescription(note);
	    em.setReturnTime((System.currentTimeMillis())/1000 + "");
	    try {
            emdao.update(em);
        } catch (Exception e) {
            e.printStackTrace();
            result = FAILURE;
        }
	    result = SUCCESS;
        return result;
    }
}
