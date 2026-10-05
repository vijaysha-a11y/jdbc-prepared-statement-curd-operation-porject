package com.techmahindra.jdbc.prepared.statement.crud.operation.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.ProductProceduerDao;
import com.techmahindra.jdbc.prepared.statement.crud.operation.dto.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/productRegister")
public class InsertProductControllerServletController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name =  req.getParameter("name");
		double  price  = Double.parseDouble(req.getParameter("price"));
		Date mfd = Date.valueOf(req.getParameter("mfd"));
		String color =  req.getParameter("color");
		
		ProductProceduerDao proceduredao = new ProductProceduerDao();
		Product product = new Product(id, name, price, mfd, color);
		int a=proceduredao.saveProdutctDao(product);
		
		PrintWriter printwriter = resp.getWriter();
		
		if(a!=0) {
			printwriter.write("Registrtion-successfully");
			RequestDispatcher dispatcher = req.getRequestDispatcher("product-user-login");
			dispatcher.include(req, resp);
		}else {
			printwriter.write("Registration-failed....");
			RequestDispatcher dispatcher=req.getRequestDispatcher("product-registration");
			dispatcher.include(req, resp);
		}
	
		resp.getWriter().println("Product Registered...");
	}
}
