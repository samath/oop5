<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
<h1>Shopping Cart</h1>
<form action="UpdateCart" method="POST">
<ul>
<% 
	ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
	for(String id : cart.getAllIDs()) {
		CartItem item = cart.getCartItem(id);
		%>
		<li>
		<input type="text" value="<%= item.getQuantity() %>" name="<%= id %>">
		<a href="show-product.jsp?id=<%= item.getID() %>"><%= item.getName() %></a>
		, $<%= String.format("%.2f", item.getPrice()) %> </li>	
		<%
	}
%>
</ul>
Total: $ <%= String.format("%.2f", cart.totalCost()) %>
<input type="submit" value="Update Cart">
</form><br>
<a href="store.jsp">Return to catalog</a>

</body>
</html>