package com.techmahindra.jdbc.prepared.statement.crud.operation.controller;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.ProductDao;

public class DeleteProductById {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		System.out.println(dao.deleteProductById(103));
	}
}
