<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>MAGEZINE</h3></div>
		<div class="magazineList">
			<table class="table"> <!-- border="1" -->
				<tr>
					<td>
						<img alt="" src="http://placehold.it/280x305"><br>
						<b>MAGAZINE1</b>
					</td>
					<td>
						<img alt="" src="http://placehold.it/280x305"><br>
						<b>MAGAZINE2</b>
					</td>
					<td>
						<img alt="" src="http://placehold.it/280x305"><br>
						<b>MAGAZINE3</b>
					</td>
					<td>
						<img alt="" src="http://placehold.it/280x305"><br>
						<b>MAGAZINE4</b>
					</td>
				</tr>
				
			<%-- <c:forEach var="li" items="${list }" varStatus="i">	
			<c:if test="${i.index%4==0 }">
				<tr>
			</c:if>
					<td><img src="${a}" width="280px" height="305px"><br>
					${i.count}-${li.name }<br>
					${li.price }원</td>
					
			</c:forEach> --%>
			</table>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>