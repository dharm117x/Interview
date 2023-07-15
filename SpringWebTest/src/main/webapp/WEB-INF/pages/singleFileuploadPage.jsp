<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="uploadFile?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" name="singlefile" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>
	<h2>Submitted Files</h2>
	<table>
	    <tr>
	        <td>OriginalFileName:</td>
	        <td>${file.originalFilename}</td>
	    </tr>
	    <tr>
	        <td>Type:</td>
	        <td>${file.contentType}</td>
	    </tr>
	</table>
	
</body>
</html>	