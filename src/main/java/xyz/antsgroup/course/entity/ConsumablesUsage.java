/**
 * 数据库中存储的耗材使用情况记录表（主要是补充和新增耗材）
 */
package xyz.antsgroup.course.entity;

/**
 * @author ANTS_YPC
 *
 */
public class ConsumablesUsage {

    private int consumablesUsageId;
    private String consumablesId;
    private String action;
    private int    amount;
    private String managerId;
    private String time;
    private String description;
    
    
    /**
    consumablesUsageId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, # 主键
    consumablesId VARCHAR(256) NOT NULL,                        # 耗材唯一编号，与consumables表保持一致
    action CHAR(1) NOT NULL,                                    # 'A'add补充，'N'new新增，'E'export出库使用
    amount INT NOT NULL,                                        # 操作数量
    managerId CHAR(8) NOT NULL,                                 # 操作人ID
    time INT NOT NULL,                                          # 操作时间
    description TEXT                                            # 描述
     */
    
    
    public int getConsumablesUsageId() {
        return consumablesUsageId;
    }
    public void setConsumablesUsageId(int consumablesUsageId) {
        this.consumablesUsageId = consumablesUsageId;
    }
    public String getConsumablesId() {
        return consumablesId;
    }
    public void setConsumablesId(String consumablesId) {
        this.consumablesId = consumablesId;
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
    public String getManagerId() {
        return managerId;
    }
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
    

    
}
