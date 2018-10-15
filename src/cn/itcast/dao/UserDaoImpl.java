package cn.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.itcast.domain.User;
import cn.itcast.exception.UserException;
import cn.itcast.utils.JdbcUtils;

/**
 * UserDaoImpl实现了UserDao
 */
public class UserDaoImpl implements UserDao {
	// 添加用户
	public void addUser(User user) throws UserException, ClassNotFoundException, SQLException {
		// 使用jdbc对数据进行操作insert操作。
		// 1.sql语句
		String sql = "insert into user values(null,?,?,?,?,?,?)";
		// 2.得到Connection
		Connection con = null;
		PreparedStatement pst = null;

		con = JdbcUtils.getConnection();
		// 3.得到PreparedStatement
		pst = con.prepareStatement(sql);
		// 4.赋值
		pst.setString(1, user.getEmail());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getPassword());
		pst.setString(4, user.getSex());
		pst.setString(5, user.getTelephone());
		pst.setString(6, user.getIntroduce());
		// 5.执行sql
		int row = pst.executeUpdate();
		if (row == 0) {
			// 失敗
			throw new UserException("添加用戶失敗");
		}

		// 关闭资源
		JdbcUtils.close(con, pst);

	}
}
