package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.serivce.UserService;
import com.serivce.UserServiceImpl;

public class UserYanServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			String name=request.getParameter("name");
			String pwd =request.getParameter("pwd");
			User u=new User(name,pwd);
			UserService us=new UserServiceImpl();
			boolean flag=us.useryan(u);
			PrintWriter out=response.getWriter();
			if(flag){
				out.write("true");
			}else{
			out.write("false");
			}
			out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
