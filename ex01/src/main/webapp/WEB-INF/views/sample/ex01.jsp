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

이름:${sampleDTO.name }<br>
나이:${sampleDTO.age }<br>
<a href="/sample/ex02List?ids=hong&ids=kim&ids=wang">ids</a>
<br>

<form action="/sample/ex02List" method="get">
  <input type="checkbox" name="ids" value="hong">홍
  <input type="checkbox" name="ids" value="kim">김
  <input type="checkbox" name="ids" value="wang">왕
<input type="submit"  value="전송">
</form>

</body>
</html>
