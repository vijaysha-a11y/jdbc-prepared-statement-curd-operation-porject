package com.techmahindra.jdbc.prepared.statement.crud.operation.controller;

import java.util.List;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.ProductDao;
import com.techmahindra.jdbc.prepared.statement.crud.operation.dto.Product;

public class SortAllProductInDESCByPrice {
	public static void main(String[] args) {
		List<Product> products = new ProductDao().sortAllProductInDESCByPrice();
		
		products.forEach(a->System.out.println(a));
	}
}
