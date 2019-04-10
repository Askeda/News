package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.entity.Topic;
import com.serivce.TopicService;
import com.serivce.TopicServiceImpl;

public class TopicServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				HttpSession session=request.getSession();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				TopicService ts=new TopicServiceImpl();
				List<Topic>list=ts.getall();
				session.setAttribute("list", list);
				String jsonString=JSON.toJSONString(list);
				out.print(jsonString);
				out.flush();
				out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
