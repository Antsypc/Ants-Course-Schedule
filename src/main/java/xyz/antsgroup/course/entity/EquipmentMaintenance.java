/**
 * 数据库中存储的设备维修记录表
 */
package xyz.antsgroup.course.entity;

/**
 * @author ANTS_YPC
 *
 */
public class EquipmentMaintenance {
    private String equipmentMaintenanceId;
    private String equipmentId;
    private String action;
    private int    amount;
    private String checkInTime;
    private String returnTime;
    private String managerId;
    private String checkInDescription;
    private String returnDescription;
    
    /**
    equipmentMaintenanceId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,      # 主键
    equipmentId VARCHAR(255) NOT NULL,                          # 设备ID
    action CHAR(1) NOT NULL,                                    # 'R'维修, 'A'废弃abandon
    amount INT NOT NULL,                                        # 维修数量
    checkInTime INT NOT NULL DEFAULT 0,                         # 登记时间
    returnTime INT NOT NULL DEFAULT 0,                          # 如果维修好了归还时间
    managerId CHAR(8) NOT NULL,                                 # 记录人
    checkInDescription TEXT,                                    # 维修登记的描述   
    returnDescription TEXT                                      # 修好归还的描述
     */
    
    
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
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
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
