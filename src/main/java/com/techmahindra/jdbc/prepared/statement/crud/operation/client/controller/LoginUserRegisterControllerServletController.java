package com.techmahindra.jdbc.prepared.statement.crud.operation.client.controller;

import java.io.IOException;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginUser")
public class LoginUserRegisterControllerServletController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println("email=[" + email + "] password=[" + password + "]");   // DEBUG

		boolean valid = new UserDao().loginUserDao(email, password);
		System.out.println("valid=" + valid);                                      // DEBUG

		if (valid) {
			HttpSession session = req.getSession();
			req.changeSessionId();
			session.setAttribute("userSession", email);
			session.setMaxInactiveInterval(600);   // 10 minute (seconds mein)
			resp.sendRedirect(req.getContextPath() + "/product-dashboard.jsp");   // apne display page ka naam likho
			return;
		}

		req.setAttribute("error", "Check your credentials");
		req.getRequestDispatcher("login-user.jsp").forward(req, resp);
	}
}