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
import xyz.antsgroup.course.dao.impl.ConsumablesDao;
import xyz.antsgroup.course.dao.impl.ConsumablesDetailDao;
import xyz.antsgroup.course.dao.impl.ConsumablesUsageDao;
import xyz.antsgroup.course.entity.Consumables;
import xyz.antsgroup.course.entity.ConsumablesDetail;
import xyz.antsgroup.course.entity.ConsumablesUsage;
import xyz.antsgroup.course.util.EquipConsumCategoryDetail;

/**
 * 实验室管理员对实验室耗材管理
 * GET 请求现有耗材
 * POST 请求处理原有耗材的增加、新耗材的添加、耗材使用的出库
 */
public class ConsumablesManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "{\"success\":\"true\"}";
    private static final String FAILURE = "{\"success\":\"false\"}";
    
    // 客户端请求参数，不一定都会用到
    private String action = null;   // 操作参数
    private String id = null;       // 耗材id，目前后台id和name一致
    private String name = null;     // 
    private String category = null; // 耗材所属分类
    private String total = null;    // 总量
    private String unit = null;     // 耗材单位
    private String number = null;   // 可能代表请求使用的数量等
    private String note = null;     // 使用耗材是添加的描述
       
    private static Map<String, String> actionMap = null;
       
    /**
     */
    public ConsumablesManageServlet() {
        super();
        // 建立客户端请求操作与数据库存储操作的映射
        actionMap = new HashMap();
        actionMap.put("add", "A");
        actionMap.put("new", "N");
        actionMap.put("export", "E");
    }

	/**
	 * 获取数据库中所有材料情况
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String sql = " SELECT c.consumablesId, ca.categoryId, ca.categoryName, ca.parentId, ca.parentName, c.total, c.unit "
	            + " FROM consumables AS c "
	            + " LEFT JOIN "
	            + " ( "
	            + "     SELECT a.categoryId, a.name AS categoryName, b.categoryId AS parentId, b.name AS parentName "
	            + "     FROM category AS a  "
	            + "     INNER JOIN "
	            + "     (SELECT * FROM category) AS b "
	            + "     ON a.parent = b.categoryId "
	            + " ) AS ca "
	            + " ON c.categoryId = ca.categoryId";
        
        BaseDao<ConsumablesDetail, String> dao = new ConsumablesDetailDao();
        List<ConsumablesDetail> Consumables = null;
        try {
            Consumables = dao.queryByCondition(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String category = null;
        try {
            category = EquipConsumCategoryDetail.getCategoryInJosn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("consum", Consumables);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/equipment/consumables.jsp").forward(request, response);
	}

	/**
	 * 请求处理原有耗材的增加、新耗材的添加、耗材使用的出库
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
        unit = map.get("unit");
        number = map.get("number");
        note = map.get("note");
    
        if("export".equals(action)) {
            result = consumablesExport(request);
        } else if("add".equals(action)) {
            result = consumablesAdd(request);
        } else if("new".equals(action)) {
            result = consumablesNew(request);
        } else {
            result = FAILURE;
        }
        out.write(result);
        out.close();
	
	}
	
	/**
	 * 对现存耗材的增加操作
	 * @param request
	 * @return 处理结果信息 json
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String consumablesAdd(HttpServletRequest request) throws ServletException, IOException {
	    String result = SUCCESS;
        Consumables consum = null;
        BaseDao<Consumables, String> cdao = new ConsumablesDao();
        ConsumablesUsage cu = new ConsumablesUsage();
        BaseDao<ConsumablesUsage, String> cudao = new ConsumablesUsageDao();
        try {
            consum = cdao.get(id);
            consum.setTotal(consum.getTotal() + Integer.valueOf(number));
            cdao.update(consum);
            
            // 把增加操作写入usage表 这个目前不是必须同步
            cu.setConsumablesId(consum.getConsumablesId());
            cu.setAction("A");
            cu.setAmount(Integer.valueOf(number));
            cu.setManagerId((String) request.getSession().getAttribute("id"));
            cu.setTime((System.currentTimeMillis())/1000 + "");
            cu.setDescription(note);
            cudao.save(cu);
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
	    return result;
	}
	
	/**
	 * 新增材料（仓库中没有的）
	 * @param request
	 * @return 处理结果信息 json
	 * @throws ServletException
	 * @throws IOException
	 */
    protected String consumablesNew(HttpServletRequest request) throws ServletException, IOException {
        Consumables consum = new Consumables();
        BaseDao<Consumables, String> cdao = new ConsumablesDao();
        ConsumablesUsage cu = new ConsumablesUsage();
        BaseDao<ConsumablesUsage, String> cudao = new ConsumablesUsageDao();
        try {
            consum.setConsumablesId(name);
            consum.setCategoryId(category);
            consum.setTotal(Integer.valueOf(total));
            consum.setUnit(unit);
            cdao.save(consum);
            
            
            // 把新建操作写入usage表 这个目前不是必须同步
            cu.setConsumablesId(consum.getConsumablesId());
            cu.setAction("N");
            cu.setAmount(Integer.valueOf(number));
            cu.setManagerId((String) request.getSession().getAttribute("id"));
            cu.setTime((System.currentTimeMillis())/1000 + "");
            cu.setDescription(note);
            cudao.save(cu);
            
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
        return "{\"success\":\"true\",\"id\":\""+name+"\"}";
    }

    /**
     * 材料出库使用操作
     * @param request
     * @return 处理结果信息 json
     * @throws ServletException
     * @throws IOException
     */
    protected String consumablesExport(HttpServletRequest request) throws ServletException, IOException {
        String result = SUCCESS;
        Consumables consum = null;
        BaseDao<Consumables, String> cdao = new ConsumablesDao();
        ConsumablesUsage cu = new ConsumablesUsage();
        BaseDao<ConsumablesUsage, String> cudao = new ConsumablesUsageDao();
        try {
            consum = cdao.get(id);
            if (consum.getTotal() < Integer.valueOf(number)) {
                // 如果仓库余量小于请求量则拒绝
                return FAILURE;
            }
            consum.setTotal(consum.getTotal() - Integer.valueOf(number));
            cdao.update(consum);
            
            // 把出库操作写入usage表 这个目前不是必须同步
            cu.setConsumablesId(consum.getConsumablesId());
            cu.setAction("E");
            cu.setAmount(Integer.valueOf(number));
            cu.setManagerId((String) request.getSession().getAttribute("id"));
            cu.setTime((System.currentTimeMillis())/1000 + "");
            cu.setDescription(note);
            cudao.save(cu);
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
        return result;
    }


}
