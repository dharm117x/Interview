<%@taglib prefix="mytag" uri="/WEB-INF/tld/mytags.tld" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<h1>Home Page</h1>
	<mytag:meta item="Hello World" dynamicAttr1 = "valu1" dynamicAttr2 = "valu2"/>
	<div>
	Username :: ${user.username}
	</div>
</body>
</html>