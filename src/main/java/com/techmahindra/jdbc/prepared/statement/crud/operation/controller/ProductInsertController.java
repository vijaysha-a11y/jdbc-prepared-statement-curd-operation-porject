package com.techmahindra.jdbc.prepared.statement.crud.operation.controller;

import java.sql.Date;
import java.util.Scanner;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.ProductProceduerDao;
import com.techmahindra.jdbc.prepared.statement.crud.operation.dto.Product;

public class ProductInsertController {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Produuct Details :");
			System.out.println("Enter Product id :");
			int id = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter Product name :");
			String name = sc.nextLine();
			
			System.out.println("Enter Product Price :");
			double price = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter Product mfd :");
			Date mfd = Date.valueOf(sc.next());
			sc.nextLine();
			System.out.println("Enter Product Color :");
			String color = sc.nextLine();
			
			ProductProceduerDao dao = new ProductProceduerDao();
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setPrice(price);
			product.setMfd(mfd);
			product.setColor(color);
			
			int a = dao.saveProdutctDao(product);
			String msg = a!=0?"Saved Sucsessfully":"Somethink went wrong";
			System.out.println(msg);
		}
		
	}
}
