package com.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter{

		private String encode=null;
	public void destroy() {
		// TODO Auto-generated method stub
		encode=null;
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(null==request.getCharacterEncoding()){
			request.setCharacterEncoding(encode);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig FilterCon) throws ServletException {
		String en = FilterCon.getInitParameter("encode");
		if(encode==null){
			encode=en;
		}
	}

}
