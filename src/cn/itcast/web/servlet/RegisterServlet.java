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
 * ע��servlet
 */
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ���������������
		request.setCharacterEncoding("utf-8");

		// 1.��ȡ�����������
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println(user);

		// 2.�������������У��

		// 2.1 ��֤��У��
		String imageCode = request.getParameter("imageCode");
		String _imageCode = (String) request.getSession().getAttribute(
				"imageCode");

		// ��������֤���session��ɾ��
		request.getSession().removeAttribute("imageCode");

//		if (!(imageCode != null && imageCode.equals(_imageCode))) {
		if (imageCode == null || !(imageCode.equals(_imageCode))) {
			// ��֤��û����������벻��ȷ
			request.setAttribute("imageCode.msg", "��֤�벻��ȷ");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}

		// 2.2���������У�飨�������˵�У�飩
		Map<String, String> map = user.validate();
		if (map.size() > 0) {
			// �д�����Ϣ
			request.setAttribute("map", map);
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}

		// 3.����UserService�е�regist�������ע�����
		UserService service = new UserService();
		try {
			service.regist(user);

			// ��ӳɹ�
			response.sendRedirect(request.getContextPath()
					+ "/registersuccess.jsp");
			return;

		} catch (UserException e) {
			e.printStackTrace();
			// ���ʧ��
			request.setAttribute("regist.msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}

		// 4.���ݷ������ж��Ƿ�ע��ɹ���ʧ��Ӧ�÷��ص�register.jspҳ����ʾ������Ϣ���ɹ���������ת��registersuccess.jspҳ��

	}
}
