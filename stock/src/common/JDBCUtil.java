package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConnection() {
		// Connection ���� ���� ����
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String username = "system";
//		String password = "qkek12";
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String username = "catchmi";
		String password = "qkek12";
		
		// 1. Driver Class �ε�
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 2. Connection ��ü ����
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Statement stmt, Connection conn) {
		// 5. Connection ���� ����
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, Statement stmt, 
			                 Connection conn) {
		// 6. Connection ���� ����
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}








