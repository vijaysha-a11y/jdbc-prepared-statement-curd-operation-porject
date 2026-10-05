package com.techmahindra.jdbc.prepared.statement.crud.operation.client.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.UserDao;
import com.techmahindra.jdbc.prepared.statement.crud.operation.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/registerUser")
public class UserRegisterController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDao userDao = new UserDao();
		User user = new User(email, password);
		
		int a = userDao.registerUserDao(user);
		PrintWriter printWriter = resp.getWriter();
		
		if(a!=0) {
			req.getRequestDispatcher("login-user.jsp").forward(req, resp);
		}else {
		printWriter.write("<html><body><h2 style='color:red'>something went wrong</h2></body></html>");	
		RequestDispatcher dispatcher = req.getRequestDispatcher("register-user.jsp");
		dispatcher.include(req, resp);
		}
	}
}
