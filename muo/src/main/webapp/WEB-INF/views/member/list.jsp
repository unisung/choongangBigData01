<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/common/ad_header.jsp"%>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM">
			<h3>회원관리</h3>
		</div>
		
		<div class="searchdiv">
			<form method="get" action="/member/list" id="searchForm">
				<select name="type">
					<option value="id" <c:out value="${pageMaker.cri.type eq 'id'?'selected':'' }"/> >아이디</option>
					<option value="name" <c:out value="${pageMaker.cri.type eq 'name'?'selected':'' }"/>>이름</option>
					<option value="nickname" <c:out value="${pageMaker.cri.type eq 'nickname'?'selected':'' }"/>>닉네임</option>
					<option value="grade" <c:out value="${pageMaker.cri.type eq 'grade'?'selected':'' }"/>>등급</option>
				</select> 
				<input type="text" name='keyword' placeholder="내용을 입력해주세요" value='<c:out value="${pageMaker.cri.keyword }"/>'> 
				<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
				<input type='hidden' name='amouont' value='${pageMaker.cri.amount }'>
				<button>검색</button>
			</form>
		</div>

		<table border="1" id="memberManageTable">
			<thead>
			<tr>
				<th>고객번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>닉네임</th>
				<th>연락처</th>
				<th>가입일</th>
				<th>등급</th>
				<th>포인트</th>
				<th>이벤트<br>참여횟수
				</th>
				<th>회원관리</th>
			</tr>
			</thead>
			
			<c:forEach items="${memberList }" var="member">
				<tr>
					<td><c:out value="${member.mb_seq }"/></td>
					<td><c:out value="${member.mb_id }"/></td>
					<td><c:out value="${member.mb_name }"/></td>
					<td><c:out value="${member.mb_nickname }"/></td>
					<td><c:out value="${member.mb_phone }"/></td>
					<td><fmt:formatDate value="${member.mb_joinDate }" pattern="yyyy-MM-dd" /></td>
					<td><c:out value="${member.mb_grade }"/></td>
					<td><c:out value="${member.mb_point }"/></td>
					<td><c:out value="${member.mb_eventNum }"/></td>
					<td><input type="button" value="조회" id="updateBtn" class="move"></td>
				</tr>	
			</c:forEach>
		</table>

		
		<div>
		 <ul class="pagination">
  		      
  		      <c:if test="${pageMaker.prev}">
  		      <li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
  		      <a href="${pageMaker.startPage -1}">Previous</a></li>
  		      </c:if>
  		       <c:if test="${!pageMaker.prev}">
  		      <li class="paginate_button previous disabled" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
  		      <a href="${pageMaker.startPage -1}">Previous</a></li>
  		      </c:if>
  		
  		      <c:forEach var="num"  begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	  		       <c:if test="${num==pageMaker.cri.pageNum}">
	  		       <li class="paginate_button active" aria-controls="dataTables-example" tabindex="0">
	  		        <a href="${num}">${num}</a></li>
	  		       </c:if>
	  		       <c:if test="${num!=pageMaker.cri.pageNum}">
	  		       <li class="paginate_button" aria-controls="dataTables-example" tabindex="0">
	  		        <a href="${num}">${num}</a></li>
	  		       </c:if>
  		      </c:forEach>
  		      
  		      <c:if test="${pageMaker.next}">
  		      <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next">
  		      <a href="${pageMaker.endPage + 1}">Next</a></li>
  		      </c:if>
  		      </ul>
		
		</div>
		
		
		<form id="actionForm" action="/member/list" method="get">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
			<input type="hidden" name="type" value="<c:out value='${pageMaker.cri.type }'/>">
			<input type="hidden" name="keyword" value="<c:out value='${pageMaker.cri.keyword }'/>">
		</form>
	</div>
</section>
	
<%@include file="/WEB-INF/views/common/footer.jsp"%>