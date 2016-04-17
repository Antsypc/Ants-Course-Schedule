/**
 * 
 */
package xyz.antsgroup.course.entity;

/**
 * @author ANTS_YPC
 * Equipment 类的具体信息
 */
public class EquipmentDetail {

    private String equipmentId;
    private String categoryId;
    private String categoryName;
    private String parentId;
    private String parentName;
    private int    total;
    private String unit;
    private int    free;
    private String isOk;
    
    public String getEquipmentId() {
        return equipmentId;
    }
    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
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
    public int getFree() {
        return free;
    }
    public void setFree(int free) {
        this.free = free;
    }
    public String getIsOk() {
        return isOk;
    }
    public void setIsOk(String isOk) {
        this.isOk = isOk;
    }
    
    
}
