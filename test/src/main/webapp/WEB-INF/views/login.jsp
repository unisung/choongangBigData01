<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form action="/login" method="post">
 <label>id</label><input name="id"><br>
 <label>pwd</label><input type="password" name="pwd"><br>
 <input type="submit" value="로긴">
</form>
</body>
</html>
