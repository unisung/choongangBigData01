<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>글 등록</title>
</head>
<body>
	<center>
		<h1>글 등록</h1>
		<hr>
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><input type="text" name="writer" size="10"  value="${user.name}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">파일</td>
					<td align="left"><input type="file" name="uploadFile"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="등록" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="getBoardList.do">글등록</a>
	</center>
</body>
</html>