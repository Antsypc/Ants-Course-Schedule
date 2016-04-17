/**
 * 
 */
package xyz.antsgroup.course.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ANTS_YPC
 *
 */
public class EquipConsumCategoryDetail {
    
    public static String getCategoryInJosn() throws SQLException, JsonProcessingException {
        
        String sql = " SELECT a.categoryId, a.name AS categoryName, b.categoryId AS parentId, b.name AS parentName "
                + " FROM category AS a  "
                + " INNER JOIN "
                + " (SELECT * FROM category) AS b "
                + " ON a.parent = b.categoryId ";
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        
        Map<String, ArrayList<MyPair> > map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        

            con = DBTool.getConnection();
            pstmt = con.prepareStatement(sql);
            result = pstmt.executeQuery();
            while (result.next()) {
                // 如果 map 没有改键，则新添加。有该键则往对应值代表的list加Pair
                ArrayList<MyPair> list = map.get(result.getString("parentName"));
                if(list == null) {
                    list = new ArrayList<MyPair>();
                    map.put(result.getString("parentName"), list);
                }
                list.add(new MyPair(result.getString("categoryId"), result.getString("categoryName")));
            }
        

        String val = null;
        val = mapper.writeValueAsString(map);
        
        return val;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println(EquipConsumCategoryDetail.getCategoryInJosn());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}

/**
 * 设备和耗材的一二级分类信息
 */
class Categorydetail {
    private String categoryId;
    private String categoryName;
    private String parentId;
    private String parentName;
    
    
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getParentName() {
        return parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
    
}

class MyPair {
    private String id;
    private String name;
    public MyPair(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    

}

