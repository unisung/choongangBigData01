<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ��Ż��</title>
</head>
<body>

	<center>
		<h1>ȸ��Ż��</h1>
		<hr>
		<form action="deleteUser.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">id</td>
					<td><input  name="id" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">�н�����</td>
					<td><input type="password" name="password" "/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="Ż��"  onclick="return check()"/>
					</td>
				</tr>
			</table>
		</form>
		<hr>
	</center>
	
	
<script>
function check(){
	if(!confirm("���� Ż���Ͻðڽ��ϱ�?")) return false
	else true;
}

</script>	
</body>
</html>