package com.techmahindra.jdbc.prepared.statement.crud.operation.client.filter;

import java.io.IOException;
import java.net.http.HttpRequest;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MyApplicationFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse respose, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)respose;
		
		HttpSession httpSession = httpRequest.getSession(false);
		if(httpSession!=null && httpSession.getAttribute("userSession")!=null) {
			chain.doFilter(httpRequest, httpResponse);
		}else {
			httpResponse.sendRedirect("login-user.jsp");
		}
		
	}
}
