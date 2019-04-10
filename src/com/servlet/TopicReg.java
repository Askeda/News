package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.TopicDao;
import com.Dao.TopicDaoImpl;
import com.entity.Topic;


public class TopicReg extends HttpServlet {

	/**
	 * 
	 */
    public TopicReg() {
        super();
        // TODO Auto-generated constructor stub
    }
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("utf-8");
			String tname=request.getParameter("name");
			TopicDao td=new TopicDaoImpl();
			Topic t=new Topic();
			t.setTname(tname);
			td.Tr(t);
			request.getRequestDispatcher("zhuti.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
