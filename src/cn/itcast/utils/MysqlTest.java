package cn.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlTest {
	/**
	 * �����������ݿ��Ƿ�ɹ�
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
			System.out.println("���ݿ����ӳɹ�!");
			connection.close();
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��");
		}

	}
}
