package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.serivce.UserService;
import com.serivce.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session=request.getSession(true);
			String name=request.getParameter("uname");
			session.setAttribute("name", name);
			String pwd=request.getParameter("pwd");
			UserService us=new UserServiceImpl();
			User u=new User(name,pwd);
			if(us.login(u)){
				request.getRequestDispatcher("content.jsp").forward(request, response);
			}else{
				response.sendRedirect("index.jsp");
			}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
