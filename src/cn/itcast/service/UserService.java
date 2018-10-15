package cn.itcast.service;

import java.sql.SQLException;

import cn.itcast.dao.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.exception.UserException;

/**
 * UserService
 */
public class UserService {

	// ע�����
	public void regist(User user) throws UserException  {
		// ����UserDao�е�����û�����addUser
		UserDaoImpl dao = new UserDaoImpl();
		try {
			dao.addUser(user);
		} catch (UserException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("�������ݿ��������");
		}
	}
}
