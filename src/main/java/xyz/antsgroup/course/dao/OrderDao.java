package xyz.antsgroup.course.dao;

import java.util.Map;

import xyz.antsgroup.course.entity.Order;

public interface OrderDao extends BaseDao<Order, String> {
	public Map<String,Order> queryOrderInfo(String campus, String date);
}
