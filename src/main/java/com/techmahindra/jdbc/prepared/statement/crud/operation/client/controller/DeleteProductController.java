package com.techmahindra.jdbc.prepared.statement.crud.operation.client.controller;

import java.io.IOException;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.ProductDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/delete")
public class DeleteProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("Delete controller "+id);
	
		boolean b = new ProductDao().deleteProductById(id);
		if(b) {
			req.getRequestDispatcher("product-display.jsp").forward(req, resp);
		}
	}
}
