<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
</head>
<body>
Login Page-----
	<center>
		<h1>로그인</h1>
		
		
		<hr>
		<form action="login.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">id</td>
				<%-- 	<td><input type="text" name="id"  value="${userVO.id}"/></td> --%>
					<td><input type="text" name="id"  value="${user.id}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange">패스워드</td>
					<%-- <td><input type="password" name="password"  value="${userVO.password}"/></td> --%>
					<td><input type="password" name="password"  value="${user.password}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="로그인" />
					<input type="button" onclick="javascript:location.href='membership.do'" value="회원가입" />
					<input type="button" onclick="javascript:location.href='changePass.do'" value="비밀번호변경" />		
						</td>
				</tr>
			</table>
		</form>
		<hr>
	</center>
</body>
</html>