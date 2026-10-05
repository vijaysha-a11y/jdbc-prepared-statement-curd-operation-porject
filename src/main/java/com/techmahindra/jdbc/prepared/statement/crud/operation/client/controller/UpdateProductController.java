package com.techmahindra.jdbc.prepared.statement.crud.operation.client.controller;

import java.io.IOException;
import java.sql.Date;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.ProductDao;
import com.techmahindra.jdbc.prepared.statement.crud.operation.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/productUpdate")
public class UpdateProductController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		Date mfd = Date.valueOf(req.getParameter("mfd"));
		String color = req.getParameter("color");
		
		Product product = new Product(id, name, price, mfd, color);
		
		ProductDao productDao = new ProductDao();
		int a = productDao.updateProductDetails(product);
		System.out.println("a ="+a);
		if(a!=0) {
			System.out.println("data updated");
			req.getRequestDispatcher("product-dashboard.jsp").forward(req, resp);
		}else {
			System.out.println("somethink went wrong");
		}
	}
}
