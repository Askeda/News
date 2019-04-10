package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.entity.Topic;
import com.serivce.TopicService;
import com.serivce.TopicServiceImpl;

public class TopicModify extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			int tid=Integer.parseInt(request.getParameter("tid"));
			String tname=request.getParameter("tname");
			TopicService ts=new TopicServiceImpl();
			Topic t=new Topic(tid,tname);
			boolean flag=ts.Tm(t);
			if(flag){
				request.getRequestDispatcher("zhuti.jsp").forward(request, response);
			}else{
				response.sendRedirect("zhuti.jsp");
			}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
