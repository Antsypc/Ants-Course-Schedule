/**
 * 
 */
package xyz.antsgroup.course.entity;

/**
 * @author ANTS_YPC
 *
 */
public class ConsumablesDetail {
    private String consumablesId;
    private String categoryId;
    private String categoryName;
    private String parentId;
    private String parentName;
    private int    total;
    private String unit;
    
    public String getConsumablesId() {
        return consumablesId;
    }
    public void setConsumablesId(String consumablesId) {
        this.consumablesId = consumablesId;
    }
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
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    

}
