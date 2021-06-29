<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/common/header.jsp"%>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM">
			<h3>
				<span class="shopList_depth1">NEW</span>
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

				<form action="/shop/new" method="get" class="searchForm clear_fix">
					<select name='type' style="visibility: hidden">
						<option value="T" <c:out value="${pageMaker.shop2.type eq 'T'?'selected':''}"/>>
					</select> 
					<input name='keyword' type="text" value='<c:out value="${pageMaker.shop2.keyword}"/>'>
					<input type='hidden' name='pageNum' value='${pageMaker.shop2.pageNum}'>
					<input type='hidden' name='amount' value='${pageMaker.shop2.amount}'>
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

				<c:forEach var="li" items="${list }" varStatus="i">
					<c:if test="${i.index%4==0 }">
						<tr>
					</c:if>
					<td><a href="/shop/view?it_number=${li.it_number }"> <img
							src="" width="280px" height="305px"><br> <span
							class="it_list_tit"> <c:if test="${li.it_saleprice != 0 }">
									<span class="saleBtn">SALE</span>
								</c:if> ${li.it_name }
						</span>
						<c:if test="${li.it_saleprice != 0 }">
							<b style="color:red;font-size:15px;font-weight:400;text-decoration:line-through;margin-right:15px;"> ${li.it_baseprice }원 </b>
							<b>${li.it_saleprice } 원</b>
						</c:if>
						<c:if test="${li.it_saleprice == 0 }">
							<b> ${li.it_baseprice }원 </b>
						</c:if>
					</a></td>
				</c:forEach>
			</table>

			<div class="page">
				<ul class="num">
					<c:if test="${pageMaker.prev }">
						<li class="page_prevBtn pageBtn"><a
							href="${pageMaker.startPage-1 }">Prev</a></li>
					</c:if>
					<c:if test="!${pageMaker.prev }">
						<li class="page_prevBtn pageBtn"><a
							href="${pageMaker.startPage-1 }">Prev</a></li>
					</c:if>

					<c:forEach var="num" begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }">

						<c:if test="${num==pageMaker.shop2.pageNum}">
							<li class="pageBtn"><a href="${num}" class="click">${num}</a>
							</li>
						</c:if>
						<c:if test="${num!=pageMaker.shop2.pageNum}">
							<li class="pageBtn"><a href="${num}">${num}</a></li>
						</c:if>

					</c:forEach>

					<c:if test="${pageMaker.next }">
						<li class="page_nextBtn pageBtn"><a
							href="${pageMaker.endPage+1 }">Next</a></li>
					</c:if>
				</ul>
			</div>
			<form action="/shop/new" method="get" id="pageActionForm">
				<input type='hidden' name='pageNum'
					value='${pageMaker.shop2.pageNum }'> <input type='hidden'
					name='amount' value='${pageMaker.shop2.amount }'> <input
					type='hidden' name='type'
					value='<c:out value="${pageMaker.shop2.type}"/>'> <input
					type='hidden' name='keyword'
					value='<c:out value="${pageMaker.shop2.keyword}"/>'>
			</form>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp"%>