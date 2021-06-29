<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp"%>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM">
			<h3>Order/Payment</h3>
		</div>
		<div class="payment">
			<div class="from_info">
				<div class=container>

					<form action="#" method="post">
						<ul>
							<li>
								<h5>고객주문 정보</h5>
							</li>

							<li><label for="name" class="title">이름</label> <input
								type="text" id="user_name" class="content"
								placeholder="내용을 입력해주세요"> <br></li>

							<li><label for="phone" class="title">휴대전화</label> <input
								type="text" id="user_phone" class="content"
								placeholder="내용을 입력해주세요"></li>

							<li><label for="email" class="title">이메일</label> <input
								type="email" id="user_email" class="content"
								placeholder="내용을 입력해주세요"> <br></li>

							<li><label for="postcode" class="title">우편번호</label> <input
								type="text" id="user_postcode" class="content content_post"
								placeholder="내용을 입력해주세요"> <input type="button"
								class="button" onclick="sample4_execDaumPostcode()"
								value="우편번호 찾기"><br></li>

							<li><label for="roadAddress" class="title">주소</label> <input
								type="text" id="user_roadAddress" class="content"
								placeholder="내용을 입력해주세요"> <br></li>

							<li><span id="guide" style="color: #999; display: none"></span>
							</li>

							<li><label for="detailAddress" class="title">상세주소</label> <input
								type="text" id="user_detailAddress" class="content"
								placeholder="내용을 입력해주세요"> <br></li>

							<li><label for="extraAddress" class="title">참고항목</label> <input
								type="text" id="user_extraAddress" class="content"
								placeholder="내용을 입력해주세요"> <br></li>
						</ul>

					</form>
				</div>
			</div>
			<div class="to_info">
				<div class=container>

					<form action="#" method="post">
						<ul>
							<li>
								<h5>배송지 정보</h5>
							</li>

							<li><label for="name" class="title">이름</label> <input
								type="text" id="user_name" class="content"
								placeholder="내용을 입력해주세요"> <br></li>

							<li><label for="phone" class="title">휴대전화</label> <input
								type="text" id="user_phone" class="content"
								placeholder="내용을 입력해주세요"></li>

							<li><label for="email" class="title">이메일</label> <input
								type="email" id="user_email" class="content"
								placeholder="내용을 입력해주세요"> <br></li>

							<li><label for="postcode" class="title">우편번호</label> <input
								type="text" id="user_postcode2" class="content content_post"
								placeholder="내용을 입력해주세요"> <input type="button"
								class="button" onclick="sample4_execDaumPostcode2()"
								value="우편번호 찾기"><br></li>

							<li><label for="roadAddress" class="title">주소</label> <input
								type="text" id="user_roadAddress2" class="content"
								placeholder="내용을 입력해주세요"> <br></li>

							<li><span id="guide" style="color: #999; display: none"></span>
							</li>

							<li><label for="detailAddress" class="title">상세주소</label> <input
								type="text" id="user_detailAddress2" class="content"
								placeholder="내용을 입력해주세요"> <br></li>

							<li><label for="extraAddress" class="title">참고항목</label> <input
								type="text" id="user_extraAddress2" class="content"
								placeholder="내용을 입력해주세요"> <br></li>
						</ul>

					</form>
				</div>
			</div>
			<div class="pay_info">
				<div class=container>
					<form action="#" method="post">
						<ul>
							<li>
								<h5>주문정보 확인</h5>
							</li>
						</ul>
					</form>
				</div>
				<div class="cart_body">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<th width="180">상품코드</th>
							<th width="500">상품명</th>
							<th width="200">판매금액</th>
							<th width="200">수량</th>
							<th width="200">주문금액</th>
						</tr>


						<tr>
							<td style="font-size: 16px;">1</td>
							<td style="text-align: left;"><img src="DB.jpg" width="100"
								height="80">
								<div class="cart_product_text">
									반팔 스탠다드 프린트티
									<p style="font-size: 13px; font-weight: lighter;">옵션: 블랙 /
										100</p>
								</div></td>
							<td style="font-size: 16px;" class="div_price" value="11000">11000(원)</td>
							<td class="table_count">
								<div class="button_count" value="1">1</div>
							</td>
							<td style="font-size: 16px;" class="div_price" value="11000">11000(원)</td>
						</tr>
						<tr>
							<td style="font-size: 16px;">1</td>
							<td style="text-align: left;"><img src="DB.jpg" width="100"
								height="80">
								<div class="cart_product_text">
									반팔 스탠다드 프린트티
									<p style="font-size: 14px; font-weight: lighter;">옵션: 블랙 /
										100</p>
								</div></td>
							<td style="font-size: 16px;" class="div_price" value="11000">11000(원)</td>
							<td class="table_count">
								<div class="button_count" value="1">1</div>
							</td>
							<td style="font-size: 16px;" class="div_price" value="11000">11000(원)</td>
						</tr>

					</table>

				</div>

			</div>
			<div class="discount_info">
				<div class=container>
					<form action="#" method="post">
						<ul>
							<li>
								<h5 style="color: #ff712b;">할인 정보</h5>
							</li>

							<li><label for="name" class="title">쿠폰</label> <!--<input type="text" id="user_name" class="content" placeholder="쿠폰폰을 선택하세요"> -->
								<select name="coupon" id="coupon-select" class="content">
									<option value="coupon1">coupon1</option>
									<option value="coupon2">coupon2</option>
									<option value="coupon3">coupon3</option>
									<option value="coupon4">coupon4</option>
									<input type="button" class="button" onclick="" value="쿠폰조회">
							</select> <br></li>

							<li><label for="phone" class="title">마일리지</label> <input
								type="text" id="user_phone" class="content"
								placeholder="내용을 입력해주세요"> point</li>
						</ul>
					</form>
				</div>
			</div>
			<div class="pay_list">
				<div class=container>
					<form action="#" method="post">
						<h5 style="color: #ff712b;">결제 수단</h5>
						<label for="phone" class="title" style="display: none;"></label> <input
							type="button" class="button" onclick="" value="카드결제"> <input
							type="button" class="button" onclick="" value="네이버페이"> <input
							type="button" class="button" onclick="" value="카카오페이">
					</form>
				</div>
			</div>
			<div class="pay_count">
				<div class="total_price_container">
					<div class="div_total_price" value="0">
						총 주문가격: <span class="bold">
							<!-- ${product.price} -->&nbsp;&nbsp;&nbsp;11,000(원)
						</span>
					</div>
				</div>
			</div>
			<div class="order_continue_container">
				<div class="order_continue_content">
					<button class="order_continue">쇼핑 계속하기</button>
					&nbsp;&nbsp;&nbsp;
					<button class="order_complete">
						<a href="order_complete.html">주문하기</a>
					</button>
				</div>
			</div>
		</div>
		<div class="quick_menu">
			<div class="quick_recent_pd">
				<ul>
					<p>최근 본 상품</p>
					<li><a href=""></a></li>
					<li><a href=""></a></li>
					<li><a href=""></a></li>
					<li><a href=""></a></li>
					<li class="kakao"><a href="">KAKAO</a></li>
				</ul>
			</div>
		</div>
		<aside class="top_btn">
			<a href="#" title="상단이동"></a>
		</aside>
		<aside class="bottom_btn">
			<a href="#" title="하단이동"></a>
		</aside>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp"%>
