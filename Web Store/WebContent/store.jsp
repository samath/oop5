<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Store</title>
</head>
<body>
<h1>Student Store</h1>
Items available: <br><br>
<ul>
<% 
	List<Product> products = StoreSQLUtils.getProducts();
	for(Product p : products) {
		%>
		<li><a href="show-product.jsp?id=<%= p.getID() %>">
		<%= p.getName() %></a></li>	
		<%
	}
%>
</ul>

</body>
</html>