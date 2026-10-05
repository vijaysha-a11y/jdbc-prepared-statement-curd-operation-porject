package com.techmahindra.jdbc.prepared.statement.crud.operation.controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.ProductDao;
import com.techmahindra.jdbc.prepared.statement.crud.operation.dto.Product;

public class InsertMultipleProductsController {
	public static void main(String[] args) {
		
		Product product1 = new Product(8973,"Mouse",8383,Date.valueOf("2025-10-10"),"white");
		
		Product product2 = new Product(8971,"Keyboard",25833,Date.valueOf("2024-06-05"),"Red");
		
		Product product3 = new Product(8990,"CPU",8358443,Date.valueOf("2023-05-10"),"Black");
		
		List<Product> products = new ArrayList<Product>(Arrays.asList(product1, product2, product3));
		
		int a = new ProductDao().saveMultipleProductDao(products);
		if(a==0) {
			System.out.println("no of row affected "+a);
		}else {
			System.out.println("no of rows "+a+" affected");
		}
	}
}
