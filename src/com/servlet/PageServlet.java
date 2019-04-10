package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.serivce.ContentService;
import com.serivce.ContentServiceImpl;

public class PageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str =(String)request.getParameter("index");
		String str1 =(String)request.getParameter("pageSize");
		if(str==null){
	    	  str="1";
	      }
		if(str1==null){
	    	  str1="8";
	      }
		Integer index=Integer.parseInt(str);
		Integer pageSize=Integer.parseInt(str1);
		//System.out.println(index);
		//System.out.println(pageSize);
		ContentService um=new ContentServiceImpl();
		com.entity.Page p=um.getUserList(index, pageSize);
		
		String jsonString=JSON.toJSONString(p);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
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
