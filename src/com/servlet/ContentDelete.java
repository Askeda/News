package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Content;
import com.serivce.ContentService;
import com.serivce.ContentServiceImpl;

public class ContentDelete extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int nid=Integer.parseInt(request.getParameter("nid"));
			ContentService cs=new ContentServiceImpl();
			Content c=new Content(nid);
			boolean flag=cs.Cd(c);
			if(flag){
				request.getRequestDispatcher("CB.jsp").forward(request, response);
			}else{
				response.sendRedirect("CB.jsp");		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
