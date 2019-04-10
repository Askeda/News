package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.entity.User;
import com.serivce.UserService;
import com.serivce.UserServiceImpl;

public class RegServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			UserService us=new UserServiceImpl();
			String name=request.getParameter("name");

			String pwd=request.getParameter("pwd");
			User u=new User(name,pwd);
			boolean flag=us.reg(u);
			if(flag){
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				response.sendRedirect("reg.jsp");
			}
			
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
