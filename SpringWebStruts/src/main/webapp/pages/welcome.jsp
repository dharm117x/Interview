<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h4 align="center">Welcome page | Spring security with Struts 1.3
	</h4>
	<%
       String message = (String)request.getAttribute("message");
    %>
	<br>
	<div align="center">
		Welcome: <%= message %>
	</div>

	<br>
	<br>
	<div align="center">
		<a href="<c:url value="/logout"/>">Logout</a>
	</div>
</body>
</html>