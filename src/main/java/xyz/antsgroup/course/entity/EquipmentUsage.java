/**
 * 数据库中存储的设备使用情况记录表（主要是补充和新增设备）
 */
package xyz.antsgroup.course.entity;


public class EquipmentUsage {

    private int    equipmentUsageId;
    private String equipmentId;
    private String action;
    private int    amount;
    private String time;
    
    /**
    equipmentUsageId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,   # 主键
    equipmentId VARCHAR(256) NOT NULL,                          # 设备唯一编号，与equipment表保持一致
    action CHAR(1) NOT NULL,                                    # 'A'补充，'N'新增
    amount INT NOT NULL,                                        # 操作数量
    time INT NOT NULL                                           # 操作时间
     */
    
    
    public int getEquipmentUsageId() {
        return equipmentUsageId;
    }
    public void setEquipmentUsageId(int equipmentUsageId) {
        this.equipmentUsageId = equipmentUsageId;
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
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    
    
}