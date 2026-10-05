package com.techmahindra.jdbc.prepared.statement.crud.operation.controller;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.ProductDao;

public class DisplayProductDetails {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		System.out.println(dao.getAllProductDao());
	}
}
