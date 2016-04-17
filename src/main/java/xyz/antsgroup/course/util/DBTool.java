/**
 * 数据库连接池
 */
package xyz.antsgroup.course.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ANTS_YPC
 *
 */
public class DBTool {
	
	private static ComboPooledDataSource cpds = null;
	
	private DBTool() {
	}
	
	static {
		cpds = new ComboPooledDataSource();
        if(cpds != null) {
            System.out.println("c3p0 initialized.");
        }
	}
	
	/**
	 * 获取一个Connection对象
	 * @return Connection con
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}
	
	

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			Connection con = cpds.getConnection();
            if(con != null) {
                System.out.println("Got connection by c3p0.");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("c3p0 is ok.");
	}

}
