<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>
<h1>
The Name <%= request.getParameter("name") %> Is Already In Use<br>
</h1>
Please enter proposed name and password. <br>
<form action="CreateServlet" method="POST">
User name: <input type="text" name="name"><br>
Password: <input type="password" name="password">
<input type="submit" value="Submit"><br>
</form>
<a href="index.html">Return to login screen.</a>

</body>
</html>