/**
 * 数据库中存储的实验耗材表
 */
package xyz.antsgroup.course.entity;

/**
 * @author ANTS_YPC
 *
 */
public class Consumables {
    
    private String consumablesId;
    private String categoryId;
    private int    total;
    private String unit;
    
    /**
    consumablesId VARCHAR(255) NOT NULL PRIMARY KEY,            # 耗材唯一编号
    categoryId INT NOT NULL,                                    # 分类编号
    total INT DEFAULT 0,                                        # 耗材数量
    unit VARCHAR(20) NOT NULL
     */
    

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
