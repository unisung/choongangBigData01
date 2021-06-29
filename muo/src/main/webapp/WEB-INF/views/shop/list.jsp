<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="/WEB-INF/views/common/header.jsp"%>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM">
			<h3>
				<span class="shopList_depth1"><c:out value="${pageMaker.shop.it_category1}"/></span>
				<c:out value="${pageMaker.shop.it_category2}"/>
			</h3>
		</div>
		<div class="item">
			<div class="item_top clear_fix">
				<ul class="item_list_btn clear_fix">
					<li><a href="#high">가격 높은순</a></li>
					<li class="sub">|</li>
					<li><a href="#low">가격 낮은순</a></li>
					<li class="sub">|</li>
					<li><a href="#sale">판매순</a></li>
				</ul>

				<form action="/shop/list" method="get" class="searchForm clear_fix">
					<%-- <select name='type' style="display:hidden">
	  		        	<option value="T" <c:out value="${pageMaker.shop.type eq 'T'?'selected':''}"/>>
	           		</select> --%>
	           		<input name='keyword' type="text" value='<c:out value="${pageMaker.shop.keyword}"/>'>
  		           	<input type='hidden' name='pageNum' value='${pageMaker.shop.pageNum}'>
  		            <input type='hidden' name='amount' value='${pageMaker.shop.amount}'>
  		            <input type='hidden' name='c1' value='<c:out value="${pageMaker.shop.it_category1}"/>'>
 					<input type='hidden' name='c2' value='<c:out value="${pageMaker.shop.it_category2}"/>'>
					<input type="submit" id="search_img" value="">
					<!--<img src="searchButton.PNG" onclick="open();"/> -->
				</form>
			</div>
			<table class="table" cellspacing="0" callpadding="0">
				<!-- border="1" -->
				<colgroup>
		
					<col style="width: 25%">
					<col style="width: 25%">
					<col style="width: 25%">
					<col style="width: 25%">
					
				</colgroup>

				<c:forEach var="li" items="${list }" varStatus="i" >
					<c:if test="${i.index%4==0 }">
						<tr>
					</c:if>
					<td>
						<a href="/shop/view?it_number=${li.it_number }">
							<img src="" width="280px" height="305px"><br>
							<span class="it_list_tit">
								<c:if test="${li.it_saleprice != 0 }"><span class="saleBtn">SALE</span></c:if>
								${li.it_name }
							</span>
							<b>
							${li.it_baseprice }원
							</b>
						</a>
					</td>
				</c:forEach>
			</table>
			
			<div class="page">
	            <ul class="num">
	            	<c:if test="${pageMaker.prev }">
	            		<li class="page_prevBtn pageBtn">
	            			<a href="${pageMaker.startPage-1 }">Prev</a>
	            		</li>
	            	</c:if>
	            	<c:if test="!${pageMaker.prev }">
	            		<li class="page_prevBtn pageBtn">
	            			<a href="${pageMaker.startPage-1 }">Prev</a>
	            		</li>
	            	</c:if>
	            	
	            	<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
	            		
	            		<c:if test="${num==pageMaker.shop.pageNum}">
			  		       	<li class="pageBtn">
			  		       		<a href="${num}" class="click">${num}</a>
			  		       	</li>
		  		       </c:if>
		  		       <c:if test="${num!=pageMaker.shop.pageNum}">
			  		       	<li class="pageBtn">
			  		       		<a href="${num}">${num}</a>
			  		       	</li>
		  		       </c:if>
		  		       
	            	</c:forEach>
	            	
	            	<c:if test="${pageMaker.next }">
	            		<li class="page_nextBtn pageBtn">
	            			<a href="${pageMaker.endPage+1 }">Next</a>
	            		</li>
	            	</c:if>
	            </ul>
	        </div>
			<form action="/shop/list" method="get" id="pageActionForm">
				<input type='hidden' name='pageNum' value='${pageMaker.shop.pageNum }'>
 				<input type='hidden' name='amount' value='${pageMaker.shop.amount }'>
 				<input type='hidden' name='type' value='<c:out value="${pageMaker.shop.type}"/>'>
 				<input type='hidden' name='keyword' value='<c:out value="${pageMaker.shop.keyword}"/>'>
 				<input type='hidden' name='c1' value='<c:out value="${pageMaker.shop.it_category1}"/>'>
 				<input type='hidden' name='c2' value='<c:out value="${pageMaker.shop.it_category2}"/>'>
			</form>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp"%>