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

<P>  The time on the server is ${serverTime}. </P>

<form action="/sample/ex03" >
	<input type="text" name="title"><br>
	<input type="text" name="dueDate"><br>
	<input type="submit" value="등록">
</form> 
</body>
</html>
