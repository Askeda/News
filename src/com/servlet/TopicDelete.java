package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Topic;
import com.serivce.TopicService;
import com.serivce.TopicServiceImpl;

public class TopicDelete extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int tid=Integer.parseInt(request.getParameter("tid"));
			TopicService ts=new TopicServiceImpl();
			Topic t=new Topic(tid);
			boolean flag=ts.Td(t);
			if(flag){
				request.getRequestDispatcher("zhuti.jsp").forward(request, response);
			}else{
				
			}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
