<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/ad_header.jsp" %>

<section>
	<div id="subPage">
		<div class="subM">
			<h3>MEMBER</h3>
		</div>
		
		<div class="ad_coupon_list">
			<div>
				<table class="coupon_list" cellspacing="0" cellpadding="0">
					<tr>
						<th width="100">번호</th>
						<th width="500">쿠폰이름</th>
						<th width="200">금액</th>
						<th width="280">기한</th>
						<th width="200">관리</th>

					</tr>
					<tr>
						<td>1</td>
						<td>무료배송인데 배송비를 주는 2,500원 쿠폰</td>
						<td>2,500</td>
						<td>2021-05-02</td>
						<td><button id="wBtn"
								onclick="window.open('/admin/coupon/write','window_name','width=800,height=600,location=no,status=no,scrollbars=yes');">수정</button></td>
					</tr>
					<tr>
						<td>2</td>
						<td>기분이다 8,888쿠폰</td>
						<td>8,888</td>
						<td>2021-05-19</td>
						<td><button id="wBtn"
								onclick="window.open('/admin/coupon/write','window_name','width=800,height=600,location=no,status=no,scrollbars=yes');">수정</button></td>
					</tr>
					<tr>
						<td>3</td>
						<td>백만 원 이상 결제 시 15,000 적용가능</td>
						<td>15,000</td>
						<td>2021-05-02</td>
						<td><button id="wBtn"
								onclick="window.open('/admin/coupon/write','window_name','width=800,height=600,location=no,status=no,scrollbars=yes');">수정</button></td>
					</tr>
					<tr>
						<td>4</td>
						<td>7만원 이상 구매 시 증정 쿠폰</td>
						<td>5,000</td>
						<td>2021-05-02</td>
						<td><button id="wBtn"
								onclick="window.open('/admin/coupon/write','window_name','width=800,height=600,location=no,status=no,scrollbars=yes');">수정</button></td>
					</tr>
					<tr>
						<td>5</td>
						<td>얘 봄감자가 맛있단다</td>
						<td>2,000</td>
						<td>2021-05-02</td>
						<td><button id="wBtn"
								onclick="window.open('/admin/coupon/write','window_name','width=800,height=600,location=no,status=no,scrollbars=yes');">수정</button></td>
					</tr>
				</table>
				<div class="admin_toll">
					<ul>
						<li>
							<button id="wBtn" onclick="window.open('/admin/coupon/write','window_name','width=800,height=600,location=no,status=no,scrollbars=yes');">쿠폰생성</button>
               			</li>
					</ul>
				</div>
				
			</div>
		</div>
		
		<div class="page">
         <a href="#fir">처음</a>
         <a href="#prev">이전</a>
         <div class="num">
             <a href="#1" class="click">1</a>
             <a href="#2">2</a>
             <a href="#3">3</a>
             <a href="#4">4</a>
         </div>
         <a href="#next">다음</a>
         <a href="#last">마지막</a>
		
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>