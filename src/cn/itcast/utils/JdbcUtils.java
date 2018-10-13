package cn.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class JdbcUtils {

	private static final String DRIVERCLASS;
	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;

	static {
		DRIVERCLASS = ResourceBundle.getBundle("jdbc").getString("driverClass");
		URL = ResourceBundle.getBundle("jdbc").getString("url");
		USER = ResourceBundle.getBundle("jdbc").getString("user");
		PASSWORD = ResourceBundle.getBundle("jdbc").getString("password");
	}

	static {
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		return con;
	}

	public static void close(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void close(Statement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void close(Connection con, Statement st) {
		close(st);
		close(con);
	}

	public static void close(Connection con, Statement st, ResultSet rs) {
		close(rs);
		close(con, st);
	}
}
