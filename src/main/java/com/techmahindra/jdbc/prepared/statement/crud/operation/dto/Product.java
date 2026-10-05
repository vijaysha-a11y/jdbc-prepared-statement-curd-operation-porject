package com.techmahindra.jdbc.prepared.statement.crud.operation.dto;

import java.sql.Date;
import java.util.Objects;
//Java-POJO-Class
public class Product {
	private int id;
	private String name;
	private double price;
	private Date mfd;
	private String color;
	
	public Product() {
		super();
	}
	
	
	public Product(int id, String name, double price, Date mfd, String color) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.mfd = mfd;
		this.color = color;
	}


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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
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
	public int hashCode() {
		return Objects.hash(color, Integer.valueOf(id), mfd, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(color, other.color) && id == other.id && Objects.equals(mfd, other.mfd)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", mfd=" + mfd + ", color=" + color + "]";
	}
	
}
