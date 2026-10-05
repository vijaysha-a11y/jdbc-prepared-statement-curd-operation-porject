package com.techmahindra.jdbc.prepared.statement.crud.operation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.techmahindra.jdbc.prepared.statement.crud.operation.dao.ProductDao;

public class DeleteMultipleProductInBatchById {
	public static void main(String[] args) {
		
		List<Integer> integers = new ArrayList<Integer>(Arrays.asList(8973,8976));
		
		int a = new ProductDao().deleteMultipleProductInBatchByIdDao(integers);
		
		System.out.println("number of rows is deleted "+a);
	}
}
