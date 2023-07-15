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
	<form method="POST" action="uploadMultiFile?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
     
		<table>
			<tr>
				<td>Select a file to upload</td>
				<td><input type="file" name="files" /></td>
			</tr>
			<tr>
				<td>Select a file to upload</td>
				<td><input type="file" name="files" /></td>
			</tr>
			<tr>
				<td>Select a file to upload</td>
				<td><input type="file" name="files" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>

	<h2>Submitted Files</h2>
	<table>
		<c:forEach items="${files}" var="file">
			<tr>
				<td>OriginalFileName:</td>
				<td>${file.originalFilename}</td>
			</tr>
			<tr>
				<td>Type:</td>
				<td>${file.contentType}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>	