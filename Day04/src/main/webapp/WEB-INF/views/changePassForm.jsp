<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��й�ȣ����</title>
</head>
<body>
	<center>
		<h1>��й�ȣ����</h1>
		<hr>
		<form action="updatePassword.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">id</td><td><input name="id"  id="id" required /></td>
				</tr>
				<tr>
<td bgcolor="orange">�н�����</td><td><input type="password" id="password" name="password"  required /></td>
				</tr>
				<tr>
<td bgcolor="orange">�н����� Ȯ��</td><td><input type="password" id="password2" name="password2"  required /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
			<input type="submit" value="�����ϱ�"  onclick="return check()"/>	<input type="reset" value="�ٽ��Է�" />	
					</td>
				</tr>
			</table>
		</form>
		<hr>
	</center>
<script>
function check(){
	var id=document.getElementById("id").value;
	var password=document.getElementById("password").value;
	var password2=document.getElementById("password2").value;
	
	if(password!=password2){
		alert("�Է°��� ���� �ٸ��ϴ�.");
		document.getElementById("password").value="";
		document.getElementById("password2").value="";
		document.getElementById("password").focus();
		return false;
	}else
		return true;
}

</script>
	
</body>
</html>