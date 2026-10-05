<%@page import="com.techmahindra.jdbc.prepared.statement.crud.operation.dao.ProductDao"%>
<%@page import="java.util.List"%>
<%@page import="com.techmahindra.jdbc.prepared.statement.crud.operation.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product-Display-Page</title>
</head>
<body>
    <%
    List<Product>products=new ProductDao().getAllProductDao();
    %>
    
	<h4>Product-Details</h4>
	<table border="2">
		<tr>
			<th>ID:</th>
			<th>NAME:</th>
			<th>PRICE:</th>
			<th>MFD:</th>
			<th>COLOR:</th>
			<th colspan="2">ACTIONS:</th>
		<tr>
		
		<%for(Product product:products){%>
		
		<tr>
			<td><%=product.getId()%></td>
			<td><%=product.getName()%></td>
			<td><%=product.getPrice()%></td>
			<td><%=product.getMfd()%></td>
			<td><%=product.getColor()%></td>
			<td><a href="product-edit.jsp?id=<%=product.getId()%>">EDIT</a></td>
			<td><a href="delete?id=<%=product.getId()%>">DELETE</a></td>
		</tr>
		<%}%>
		
	</table>
</body>
</html>