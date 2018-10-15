package cn.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlTest {
	/**
	 * 测试连接数据库是否成功
	 */
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/webdemo?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
			System.out.println("数据库连接成功!");
			connection.close();
		} catch (Exception e) {
			System.out.println("数据库连接失败");
		}

	}
}
