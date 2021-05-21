<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<a href="logout.do">Log-out</a>
		<hr>
		<form action="updateBoard.do" method="post" enctype="multipart/form-data">
			<input name="seq" type="hidden" value="${board.seq}" />
			<input name="pageNum" type="hidden" value="${board.pageNum}">
			<input name="searchCondition" type="hidden" value="${board.searchCondition}">
			<input name="searchKeyword" type="hidden" value="${board.searchKeyword}">
			
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input name="title" type="text"
						value="${board.title }" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left">${board.writer }</td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10">
						${board.content }</textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left">${board.regdate }</td><!-- EL - 속성명의 값 BoardVO의 getRegdate()-->
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left">${board.cnt } 
					                       <button type="button" onclick="upGood('${board.seq}','${board.pageNum}','${board.searchCondition }','${board.searchKeyword}','${board.re_ref }','${board.re_lev }','${board.re_seq}')">좋아요${board.good }</button>
					                       <button type="button" onclick="upBad('${board.seq}','${board.pageNum}','${board.searchCondition }','${board.searchKeyword}','${board.re_ref }','${board.re_lev }','${board.re_seq}')">싫어요${board.bad }</button>
					                       </td>
				</tr>
				<tr>
				 <td bgcolor="orange">이미지</td>
				 <td>
				 	<img alt="" src="/img/${board.img}"  width="20%" height="200px">
				 	<%-- <input type="hidden" name="img" value="${board.img}"> --%>
				 	<input type="file" name="uploadFile">
				 </td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<c:if test="${not empty replies }">
		<table border=1>
		<tr><td>글번호</td><td>제목</td><td>작성자</td> </tr>
		  <c:forEach var="reply" items="${replies}">
		  <tr>
		        <td> ${reply.seq }</td>
		        <td>
		         <a href="getBoard.do?seq=${reply.seq }&pageNum=${board.pageNum}&searchCondition=${board.searchCondition}&searchKeyword=${board.searchKeyword}">
		          ${reply.title }
		         </a>
		         </td>
		         <td> ${reply.writer }</td>
		  </tr>
		  </c:forEach>
		  </table>
		  </c:if>
		<hr>
		<a href="javascript:go3('${board.seq}','${board.pageNum}','${board.searchCondition }','${board.searchKeyword}','${board.re_ref }','${board.re_lev }','${board.re_seq}')">답글</a>
		<a href="insertBoard.do">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="javascript:go2('${board.seq}','${board.pageNum}','${board.searchCondition }','${board.searchKeyword}')">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="javascript:go('${board.pageNum}','${board.searchCondition}','${board.searchKeyword}')">글목록</a>
	</center>
</body>
<script>
  function go(pageNum, searchCondition, searchKeyword){
	  location.href='getBoardList.do?pageNum='+pageNum+'&searchCondition='+searchCondition
			            +'&searchKeyword='+encodeURIComponent(searchKeyword);
  }
  function go2(seq, pageNum, searchCondition, searchKeyword){
	 if(confirm("정말삭제할까요?")){
	  location.href='deleteBoard.do?seq='+seq+'&pageNum='+pageNum
			           +'&searchCondition='+searchCondition+'&searchKeyword='+encodeURIComponent(searchKeyword);
	  }
  }
	 
  function go3(seq, pageNum, searchCondition, searchKeyword,re_ref,re_lev,re_seq){
		 location.href='replyBoard.do?seq='+seq+'&pageNum='+pageNum
				           +'&searchCondition='+searchCondition+'&searchKeyword='+encodeURIComponent(searchKeyword)+'&re_ref='+re_ref+'&re_lev='+re_lev+"&re_seq="+re_seq;
	  }
  
 function upGood(seq, pageNum, searchCondition, searchKeyword, re_ref, re_lev, re_seq){
	 location.href='updateGoodBad.do?seq='+seq+"&flag=good"+'&pageNum='+pageNum
     +'&searchCondition='+searchCondition+'&searchKeyword='+encodeURIComponent(searchKeyword)
     +'&re_ref='+re_ref+'&re_lev='+re_lev+"&re_seq="+re_seq;
 }
 function upBad(seq, pageNum, searchCondition, searchKeyword, re_ref, re_lev, re_seq){
	 location.href='updateGoodBad.do?seq='+seq+"&flag=bad"+'&pageNum='+pageNum
     +'&searchCondition='+searchCondition+'&searchKeyword='+encodeURIComponent(searchKeyword)
     +'&re_ref='+re_ref+'&re_lev='+re_lev+"&re_seq="+re_seq;
 }
</script>
</html>
