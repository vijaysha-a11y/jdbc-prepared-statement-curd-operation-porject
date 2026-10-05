package com.techmahindra.jdbc.prepared.statement.crud.operation.dao;

import java.sql.Date;

public class ProductDao {
	private int id;
	private String name;
	private String price;
	private Date mfd;
	private String color;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getMfd() {
		return mfd;
	}
	public void setMfd(Date mfd) {
		this.mfd = mfd;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "ProductDao [id=" + id + ", name=" + name + ", price=" + price + ", mfd=" + mfd + ", color=" + color
				+ "]";
	}
	
}
