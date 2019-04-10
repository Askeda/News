package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Content;
import com.serivce.ContentService;
import com.serivce.ContentServiceImpl;

public class ContentReg extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		String ntitle=request.getParameter("ntitle");
		String nauthor=request.getParameter("nauthor");
		String ncontent=request.getParameter("ncontent");
		String nsummary=request.getParameter("nsummary");
		ContentService cs=new ContentServiceImpl();
		Content c=new Content(ntitle,nauthor,ncontent,nsummary);
		boolean flag=cs.Cr(c);
		if(flag){
			request.getRequestDispatcher("content.jsp").forward(request, response);
		}else{
			System.out.println("dsa");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
