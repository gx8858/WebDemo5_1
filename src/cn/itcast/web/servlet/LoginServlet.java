package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��¼��������¼�ɹ�
		
		//�ж��Ƿ�ѡ�˼�ס�û���
		String rememberUsername = request.getParameter("rememberUsername");
		if("ok".equals(rememberUsername)){
			//��ѡ�˼�ס�û���
			Cookie cookie=new Cookie("ru","tom");
			cookie.setMaxAge(7*24*60*60);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}

}
