<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% 
	String id = request.getParameter("id");
	if(id == null) { out.println(StoreJSPUtils.formatErrorPage("Invalid url.")); }
	else {
		Product p = StoreSQLUtils.getProductByID(id); 
		if(p == null) { out.println(StoreJSPUtils.formatErrorPage(
				"No product with id " + id + " found.")); }
		else {
			%>
			
<title><%= p.getName() %></title>
<head><body>
<h1><%= p.getName() %></h1>
<img src="store-images/<%= p.getFile() %>"><br>
<form action="AddItem" method="POST">
<input type="hidden" name="name" value="<%= p.getName() %>">
<input type="hidden" name="id" value="<%= p.getID() %>">
<input type="hidden" name="file" value="<%= p.getFile() %>">
<input type="hidden" name="price" value="<%= p.getPrice() %>">
$<%= String.format("%.2f", p.getPrice()) %>
<input type="submit" value="Add to Cart">
</form><br>
<a href="store.jsp">Return to catalog</a>
</body></head>	
		
<%	
		}
	}
%>
</html>