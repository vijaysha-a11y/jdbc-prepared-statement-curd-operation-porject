<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
int a = 10;
<%
int sum = 0;
for(int i=0; i<10; i++){
	if(i%2==0){
%>
<h4 style='color:red'><%=i%>is a even number</h4>
<%} else{%>
<h4 style='color:green'><%=i%>is a odd number</h4>
<%}} %>

<%!
public String getRandomNumber(){
	UUID uuid = UUID.randomUUID();
	return uuid.toString();
}
%>
</body>
</html>