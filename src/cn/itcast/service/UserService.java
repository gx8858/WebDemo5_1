package cn.itcast.service;

import java.sql.SQLException;

import cn.itcast.dao.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.exception.UserException;

/**
 * UserService
 */
public class UserService {

	// 注册操作
	public void regist(User user) throws UserException  {
		// 调用UserDao中的添加用户方法addUser
		UserDaoImpl dao = new UserDaoImpl();
		try {
			dao.addUser(user);
		} catch (UserException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("操作数据库出现问题");
		}
	}
}
