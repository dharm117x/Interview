<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<h3>Home Page</h3>
	
	Message: ${username} <%= request.getAttribute("username") %>
	
	<a href="singlieUploadFileView.html" >single Upload file</a>
	<br/
	><a href="uploadFileView.html" >Upload file</a>
	
</body>
</html>