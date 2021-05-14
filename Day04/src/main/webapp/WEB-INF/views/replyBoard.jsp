<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>답변 글 등록</title>
</head>
<body>
	<center>
		<h1>답변 글 등록</h1>
		<hr>
		<form action="replyBoard.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="seq" value="${board.seq}">
			<input type="hidden" name="re_ref" value="${board.re_ref }">
			<input type="hidden" name="re_lev" value="${board.re_lev }">
			<input type="hidden" name="re_seq" value="${board.re_seq }">
			<input type="hidden" name="pageNum" value="${board.pageNum }">
			<input type="hidden" name="searchCondition" value="${board.searchCondition }">
			<input type="hidden" name="searchKeyword" value="${board.searchKeyword }"><!-- "" -->
		
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title"  value="[답변]"/></td>
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