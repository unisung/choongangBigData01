<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>글 목록</h1>
		<h3>
			<c:if test="${not empty user}">
			${user.name}님 환영합니다...
			</c:if>
			<c:if test="${empty user}">
			 guest님 환영합니다...
			</c:if>
			
			<c:if test="${not empty user}">
			<a href="logout.do">Log-out</a>
			</c:if>
			<c:if test="${empty user}">
			<a href="login.do">Log-In</a>
			</c:if>
		</h3>
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
					<!-- <select name="searchCondition">
							<option value="TITLE">제목
							<option value="CONTENT">내용
					</select>  -->
					<select name="searchCondition">
						<c:forEach var="option" items="${conditionMap }">
							<option value="${option.value }">${option.key}
						</c:forEach>
					</select> 
					<input name="searchKeyword" type="text" /> 
					<input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.seq }</td>
					<td align="left">
					<a href="javascript:go2('${board.seq }','${pageNum}','${searchCondition}','${searchKeyword}')">
<%-- <a href="getBoard.do?seq=${board.seq }&pageNum=${pageNum}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}"> --%>
							${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.regdate }</td>
					<td>${board.cnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		  전체페이지:${total}<br>

		  <c:forEach var="i" begin="1" end="${lastPage}">
		      <a href="javascript:go('${i}','${searchCondition}','${searchKeyword}')">${i}</a>
		    <%--   <a href="getBoardList.do?pageNum=${i}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}">${i}</a>  --%>
		  </c:forEach>
		 
		  
		<br> <!-- <a href="insertBoard.jsp">새글 등록</a> -->
		<a href="/insertBoard.do">새글 등록</a>
	</center>
</body>
<script>
  function go(pageNum, searchCondition, searchKeyword){
	  location.href='getBoardList.do?pageNum='+pageNum+'&searchCondition='+searchCondition
			            +'&searchKeyword='+encodeURIComponent(searchKeyword);
  }
  function go2(seq, pageNum, searchCondition, searchKeyword){
	 location.href='getBoard.do?seq='+seq+'&pageNum='+pageNum
			           +'&searchCondition='+searchCondition+'&searchKeyword='+encodeURIComponent(searchKeyword);
  }
</script>
</html>