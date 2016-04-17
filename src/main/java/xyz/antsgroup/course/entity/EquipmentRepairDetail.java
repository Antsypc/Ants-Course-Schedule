/**
 * 
 */
package xyz.antsgroup.course.entity;

/**
 * @author ANTS_YPC
 *
 */
public class EquipmentRepairDetail {
    private String equipmentMaintenanceId;
    private String equipmentId;
    private String action;
    private String unit;
    private int    amount;
    private String categoryId;
    private String categoryName;
    private String parentId;
    private String parentName;
    private String checkInTime;
    private String returnTime;
    private String managerId;
    private String checkInDescription;
    private String returnDescription;
    
    public String getEquipmentMaintenanceId() {
        return equipmentMaintenanceId;
    }
    public void setEquipmentMaintenanceId(String equipmentMaintenanceId) {
        this.equipmentMaintenanceId = equipmentMaintenanceId;
    }
    public String getEquipmentId() {
        return equipmentId;
    }
    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
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
    public String getCheckInTime() {
        return checkInTime;
    }
    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }
    public String getReturnTime() {
        return returnTime;
    }
    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
    public String getManagerId() {
        return managerId;
    }
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    public String getCheckInDescription() {
        return checkInDescription;
    }
    public void setCheckInDescription(String checkInDescription) {
        this.checkInDescription = checkInDescription;
    }
    public String getReturnDescription() {
        return returnDescription;
    }
    public void setReturnDescription(String returnDescription) {
        this.returnDescription = returnDescription;
    }
    
    
}
