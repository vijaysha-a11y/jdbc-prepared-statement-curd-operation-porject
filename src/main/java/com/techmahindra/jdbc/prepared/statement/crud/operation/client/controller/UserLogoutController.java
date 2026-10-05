package com.techmahindra.jdbc.prepared.statement.crud.operation.client.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value="/logout")
public class UserLogoutController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		if(httpSession!=null && httpSession.getAttribute("userSession")!=null);
		httpSession.invalidate();
		resp.sendRedirect("login-user.jsp");
	}
}
