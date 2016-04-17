package xyz.antsgroup.course.entity;

/**
 * 数据库中存储的固定资产表
 */
public class Equipment {

    private String equipmentId;
    private String categoryId;
    private int    total;
    private String unit;
    private int    free;
    private String isOk;
    
    /**
    equipmentId VARCHAR(255) NOT NULL PRIMARY KEY,              # 设备唯一编号
    categoryId INT NOT NULL,                                    # 分类编号
    total INT DEFAULT 1,                                        # 设备数量
    unit VARCHAR(20) NOT NULL,                                  # 设备单位
    free INT,                                                   # 设备闲置数量
    isOk TINYINT(1) DEFAULT '1'                                 # 设备是否已经报废，如果报废了置'0'      
     */
    

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
