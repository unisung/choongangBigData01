<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호 변경</title>
</head>
<body>

	<center>
		<h1>비밀번호 변경 인증</h1>
		
		
		<hr>
		<form action="idPassCheck.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">id</td>
					<td><input  name="id" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">패스워드</td>
					<td><input type="password" name="password" "/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="비밀번호변경" />	
						</td>
				</tr>
			</table>
		</form>
		<hr>
	</center>
</body>
</html>