<%@taglib prefix="cf" tagdir="/WEB-INF/tags/forms" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<h1>Login</h1>
	<div>
	<cf:customForm labelKey="a" idKey="name" name="firstname"></cf:customForm>
	<form action="home" method="post">
		UserName::
		<input type="text" name="username"><br/>
		Password::
		<input type="text" name="password"><br/>
		<input type="submit">
	</form>	
	</div>
</body>
</html>