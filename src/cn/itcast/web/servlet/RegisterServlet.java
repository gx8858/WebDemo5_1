package cn.itcast.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.User;
import cn.itcast.exception.UserException;
import cn.itcast.service.UserService;

/**
 * 注册servlet
 */
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 处理请求参数乱码
		request.setCharacterEncoding("utf-8");

		// 1.获取所有请求参数
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println(user);

		// 2.对请求参数进行校验

		// 2.1 验证码校验
		String imageCode = request.getParameter("imageCode");
		String _imageCode = (String) request.getSession().getAttribute(
				"imageCode");

		// 立即将验证码从session中删除
		request.getSession().removeAttribute("imageCode");

//		if (!(imageCode != null && imageCode.equals(_imageCode))) {
		if (imageCode == null || !(imageCode.equals(_imageCode))) {
			// 验证码没有输入或输入不正确
			request.setAttribute("imageCode.msg", "验证码不正确");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}

		// 2.2对请求参数校验（服务器端的校验）
		Map<String, String> map = user.validate();
		if (map.size() > 0) {
			// 有错误信息
			request.setAttribute("map", map);
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}

		// 3.调用UserService中的regist方法完成注册操作
		UserService service = new UserService();
		try {
			service.regist(user);

			// 添加成功
			response.sendRedirect(request.getContextPath()
					+ "/registersuccess.jsp");
			return;

		} catch (UserException e) {
			e.printStackTrace();
			// 添加失败
			request.setAttribute("regist.msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}

		// 4.根据返回来判断是否注册成功，失败应该返回到register.jsp页面显示错误信息，成功，我们跳转到registersuccess.jsp页面

	}
}
