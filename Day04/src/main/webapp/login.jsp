<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α���</title>
</head>
<body>
Login Page-----
	<center>
		<h1>�α���</h1>
		
		
		<hr>
		<form action="login.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">id</td>
				<%-- 	<td><input type="text" name="id"  value="${userVO.id}"/></td> --%>
					<td><input type="text" name="id"  value="${user.id}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange">�н�����</td>
					<%-- <td><input type="password" name="password"  value="${userVO.password}"/></td> --%>
					<td><input type="password" name="password"  value="${user.password}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="�α���" />
					<input type="button" onclick="javascript:location.href='membership.do'" value="ȸ������" />
					<input type="button" onclick="javascript:location.href='changePass.do'" value="��й�ȣ����" />		
						</td>
				</tr>
			</table>
		</form>
		<hr>
	</center>
</body>
</html>