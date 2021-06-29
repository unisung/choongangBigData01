<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp"%>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM">
			<h3>CART</h3>
		</div>
		<div class="cart_body">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<th width="33">번호</th>
					<th width="33"><input type="checkbox" id="checkbox"></th>
					<th width="480">상품명</th>
					<th width="85">판매금액</th>
					<th width="85">수량</th>
					<th width="85">주문관리</th>
				</tr>


				<tr>
					<td>1</td>
					<td><input type="checkbox" class="checkbox" name="checkbox"></td>
					<td style="text-align: left;"><img src="DB.jpg" width="100"
						height="80">
						<div class="cart_product_text">
							반팔 스탠다드 프린트티
							<p style="font-size: 13px; font-weight: lighter;">옵션: 블랙 /
								100</p>
						</div></td>
					<td style="font-size: 17px;" class="div_price" value="11000">11000(원)</td>
					<input type="hidden" class="price" value="0">
					<td class="table_count">
						<button type="button" class="button_minus">-</button>
						<div class="button_count" value="1">1</div>
						<button type="button" class="button_plus">+</button>
					</td>
					<td><button id="button_delete">삭제</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td><input type="checkbox" class="checkbox" name="checkbox"></td>
					<td style="text-align: left;"><img src="DB.jpg" width="100"
						height="80">
						<div class="cart_product_text">
							반팔 스탠다드 프린트티
							<p style="font-size: 13px; font-weight: lighter;">옵션: 블랙 /
								100</p>
						</div></td>
					<td style="font-size: 17px;" class="div_price" value="11000">11000(원)</td>
					<input type="hidden" class="price" value="0">
					<td class="table_count">
						<button type="button" class="button_minus">-</button>
						<div class="button_count" value="1">1</div>
						<button type="button" class="button_plus">+</button>
					</td>
					<td><button id="button_delete">삭제</button></td>
				</tr>

			</table>

			<div class="total_price_container">
				<div class="div_total_price" value="0">
					총 주문가격: <b>
						<!-- ${product.price} -->&nbsp;&nbsp;&nbsp;11,000(원)
					</b>
				</div>
			</div>

			<div class="order_continue_container">
				<div class="order_continue_content">
					<button class="order_continue" style="background: #ff712b">쇼핑
						계속하기</button>
					&nbsp;&nbsp;&nbsp;
					<button class="order_continue">주문하기</button>
				</div>
			</div>
		</div>

		<form action="#" method="post">
			<input type="hidden" class="data_count" value="1"> <input
				type="hidden" class="total_price_final" value="0">
		</form>
	</div>
</section>


<%@include file="/WEB-INF/views/common/footer.jsp"%>