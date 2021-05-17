<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="message.board.list.mainTitle"/></title>
</head>
<body>
	<center>
		<h1><spring:message code="message.board.list.mainTitle"/></h1>
		<h3>
			<c:if test="${not empty user}">
			${user.name}<spring:message code="message.board.list.welcomeMsg"/>...
			</c:if>
			<c:if test="${empty user}">
			 guest<spring:message code="message.board.list.welcomeMsg"/>...
			</c:if>
			
			<c:if test="${not empty user}">
			<a href="logout.do">Log-out</a>
			</c:if>
			<c:if test="${empty user}">
			<a href="login.do">Log-In</a>
			</c:if>
		</h3>
		<a href="?lang=ko&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}"><spring:message code="message.user.login.language.ko"/></a> 
		| 
		<a href="?lang=en&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}"><spring:message code='message.user.login.language.en'/></a>
		<hr>
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
					<select name="searchCondition">
						<c:forEach var="option" items="${conditionMap }">
							<option value="${option.value }">${option.key}
						</c:forEach>
					</select> 
					<input name="searchKeyword" type="text" /> 
					<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>" /></td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq"/></th>
				<th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title"/></th>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer"/></th>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate"/></th>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt"/></th>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.goodbad"/></th>
			</tr>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.seq }</td>
					<td align="left">
					<c:if test="${board.re_lev>0}">
						   <c:forEach begin="1" end="${board.re_lev}">
						        &nbsp;&nbsp;
						   </c:forEach>	
						   <span class="glyphicon glyphicon-share-alt"></span>
					</c:if>
					<a href="javascript:go2('${board.seq }','${pageNum}','${searchCondition}','${searchKeyword}')">
<%-- <a href="getBoard.do?seq=${board.seq }&pageNum=${pageNum}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}"> --%>
						
							${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.regdate }</td>
					<td>${board.cnt }</td>
					<td>${board.good } / ${board.bad }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		  전체페이지:${total}<br>
		
        <c:if test="${startPage != 1 }">
			<a href="/getBoardList.do?pageNum=${startPage - 1 }&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}">&lt;</a>
		</c:if>
		  <c:forEach var="i" begin="${startPage}" end="${endPage}">
		      <a href="javascript:go('${i}','${searchCondition}','${searchKeyword}')">${i}</a>
		    <%--   <a href="getBoardList.do?pageNum=${i}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}">${i}</a>  --%>
		  </c:forEach>
		 <c:if test="${endPage != lastPage}">
			<a href="/getBoardList.do?pageNum=${endPage+1 }&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}">&gt;</a>
		</c:if>
		  
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