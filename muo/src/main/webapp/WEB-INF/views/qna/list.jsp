<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<style>
	#search select[name="type"]{
	height:35px;
	border-radius: 4px;
	border:1px solid lightgray;
	position: relative;
	top: -1px;
}
</style>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>1:1 QNA</h3></div>
		<div class="qna_list">
			<form method="get" action="/qna/list" id="search">
				<select name="type" >
  		           <option value=""  <c:out  value="${pageMaker.cri.type==null?'selected':''}"/>>----</option>
  		           <option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목
  		           <option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
  		           <option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>분류</option>
  		           <option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목+내용</option>
  		           <option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목+분류</option>
  		           <option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW'?'selected':''}"/> >제목+내용+분류</option>
				</select>
				   <input name='keyword' type="text" value='<c:out value="${pageMaker.cri.keyword}"/>'>
  		           <input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
  		           <input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
				   <input type="submit" value="검색"> 
			</form>
			<table cellspacing="0" cellpadding="0" class="table">
				<tr class="table_th">
					<th width="80px">번호</th>
					<th width="900px">제목</th>
					<th width="150px">답변여부</th>
					<th width="150px">등록일</th>
				</tr>
			
			<c:forEach items="${list }" var="lists">
				<tr>
					<td>${lists.qna_bno }</td>
					<td><a href="/qna/view?qna_bno=${lists.qna_bno }">${lists.qna_type } - ${lists.qna_title }</a></td>
					<td>
					<c:if test="${lists.qna_check == 0 }">미답변</c:if>
					<c:if test="${lists.qna_check == 1 }">답변</c:if>
					</td>
					<td><fmt:formatDate value="${lists.qna_regdate }" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
			</table>
			<div class="page">
	   <%--          <a href="${pageMaker.startPage}">처음</a> --%>
	            
	            <c:if test="${pageMaker.prev }">
	            <a href="${pageMaker.startPage -1}">이전</a>
	            </c:if>	            
	            
	            <div class="num">
	             <c:forEach var="num"  begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	  		       <c:if test="${num==pageMaker.cri.pageNum}">
	  		        <a href="${num}">${num}</a>
	  		       </c:if>
	  		       <c:if test="${num!=pageMaker.cri.pageNum}">
	  		        <a href="${num}">${num}</a>
	  		       </c:if>
  		     	 </c:forEach>
	            </div>
	            
	  	        <c:if test="${pageMaker.next}">
	  	        <a href="${pageMaker.endPage + 1}">다음</a>
  		        </c:if>
	            
	           <%--  <a href="${pageMaker.endPage }">마지막</a> --%>
	        </div>
			<div class="admin_toll">
				<ul>
					<li>
						<a href="/qna/write">글쓰기</a>
					</li>
				</ul>
			</div>
			
		<form id="actionForm" action="/qna/list" method="get">
 			<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
			<input type='hidden' name='amount' value='${pageMaker.cri.amount }'>
 			<input type='hidden' name='type' value='<c:out value="${pageMaker.cri.type}"/>'>
 			<input type='hidden' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>'>
		</form>
			
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>