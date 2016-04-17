package xyz.antsgroup.course.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import xyz.antsgroup.course.dao.OrderDao;
import xyz.antsgroup.course.entity.Order;
import xyz.antsgroup.course.util.DBTool;

public class OrderDaoImpl extends BaseDaoImpl<Order,String> implements OrderDao {

	public Map<String,Order> queryOrderInfo(String campus, String date) {
		String sql = "CALL free_lab_by_campus_day(?,?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Map<String,Order> orders = new HashMap<String, Order>();
		
		try {
			conn = DBTool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, campus);
			ps.setString(2, date);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Order order = new Order();
				
				String freePeriod = rs.getString("freePeriod");
				
				order.setLabRoomId(rs.getString("labRoomId"));
				order.setCampus(rs.getString("campus"));
				order.setBuilding(rs.getString("building"));
				order.setRoomName(rs.getString("roomName"));
				order.setRoomType(rs.getString("roomType"));
				order.setCapacity(rs.getInt("capacity"));
				order.setFreePeriod(freePeriod.substring(0, freePeriod.lastIndexOf(":")));
				
				if(orders.containsKey(order.getLabRoomId())){
					order.setFreePeriod(orders.get(order.getLabRoomId()).getFreePeriod() + order.getFreePeriod().substring(10));
					orders.put(order.getLabRoomId(), order);
				}
				else{
					orders.put(order.getLabRoomId(), order);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
