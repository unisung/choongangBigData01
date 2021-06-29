<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/common/ad_header.jsp" %>

<section>
	<div id="subPage">
		<div class="admin_main">
			<div class="order_container">
				<div class="order_situation">
					<img src="/resources/img/order.png">
				</div>
				<div class="line"></div>
				<table class="order_nav">
					<tr>
						<th>신규주문</th>
						<th>배송중</th>
						<th>배송완료</th>
						<th>교환</th>
						<th>반품</th>
					</tr>
					<tr>
						<td>${neworder } 건</td>
						<td>${progress } 건</td>
						<td>${arrival } 건</td>
						<td>${change } 건</td>
						<td>${refund } 건</td>
					</tr>
				</table>
			</div>
		
		    <div class="product_container">
				<div class="product_situation">
					<img src="/resources/img/product.png" >
				</div>
				<div class="line" style="margin-top:10px;"></div>
				<table class="product_nav">
					<tr>
						<th>판매상품</th>
						<th>품절임박상품</th>
						<th>품절</th>
					</tr>
					<tr>
						<td>${Sale } 건</td>
						<td>${remainCount } 건</td>
						<td>${soldOut }건</td>
		
					</tr>
				</table>
			</div>
		
			<div class="bottom_container">
				<div class="QNA">
					<h4>1:1문의<a href="/qna/list"><img src="/resources/img/plus.png" alt="더보기"></a></h4>
					<ul>
						<c:forEach var="QList" items="${QnaList }" begin="0" end="4">
							<li>
								<a href="/qna/view&qa_num=${QList.qa_num }"><c:out value="${QList.qa_title }"/></a>
							</li>
						</c:forEach>
					</ul>
				</div>
				
				<div class="review">
					<h4>상품후기</h4>
					<ul>
						<!-- jstl 반복 -->
						<li>예시List 1</li>
						<li>예시List 1</li>
						<li>예시List 1</li>
						<li>예시List 1</li>
						<li>예시List 1</li>
					</ul>
				</div>
				
				<div class="notice">
					<h4>공지사항<a href="/notice/list"><img src="/resources/img/plus.png" alt="더보기"></a></h4>
					<ul>
						<c:forEach var="NList" items="${NoticeList }" begin="0" end="4">
							<li>
								<a href="/qna/view&qa_num=${NList.nt_num }"><c:out value="${NList.nt_title }"/></a>
							</li>
						</c:forEach>
					</ul>
				</div>
				
			</div>
		
			<div class="button_collection">
				<a href="/faq/list" class="button">FAQ</a>
				<a href="/event/list" class="button">EVENT</a>
				<a href="/magazine/list" class="button">MAGAZINE</a>
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>