package cn.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.itcast.domain.User;
import cn.itcast.exception.UserException;
import cn.itcast.utils.JdbcUtils;

/**
 * UserDaoImplʵ����UserDao
 */
public class UserDaoImpl implements UserDao {
	// ����û�
	public void addUser(User user) throws UserException, ClassNotFoundException, SQLException {
		// ʹ��jdbc�����ݽ��в���insert������
		// 1.sql���
		String sql = "insert into user values(null,?,?,?,?,?,?)";
		// 2.�õ�Connection
		Connection con = null;
		PreparedStatement pst = null;

		con = JdbcUtils.getConnection();
		// 3.�õ�PreparedStatement
		pst = con.prepareStatement(sql);
		// 4.��ֵ
		pst.setString(1, user.getEmail());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getPassword());
		pst.setString(4, user.getSex());
		pst.setString(5, user.getTelephone());
		pst.setString(6, user.getIntroduce());
		// 5.ִ��sql
		int row = pst.executeUpdate();
		if (row == 0) {
			// ʧ��
			throw new UserException("����Ñ�ʧ��");
		}

		// �ر���Դ
		JdbcUtils.close(con, pst);

	}
}
