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

<c:forEach var="id" items="${ids}">
   id:${id }<br>
</c:forEach>

<br>
<button onclick="loc2ex02Bean()">이동</button>
<br>

<script>
function loc2ex02Bean(){
	location.href="/sample/ex02Bean?list[0].name=aaa&list[1].name=bbb&list[2].name=ccc";
}

</script>
</body>
</html>
