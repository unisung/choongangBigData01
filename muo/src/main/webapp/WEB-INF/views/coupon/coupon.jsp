<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div id="subPage">
		<div class="subM">
			<h3>COUPON</h3>
		</div>
		<div class="ad_product_write">

			<div>
				<h3>다운로드 완료 My쿠폰</h3>
				<!-- //다운로드 완료되어 고객 보유중인 쿠폰   -->

				<ul class="mycoupon_list">
					<li class="mycoupon_name"><strong>부자되자 쿠폰1</strong></li>
					<li><img class="mycoupon_img" alt="공지_image"
						src="images/cc.png" width="80"></li>
					<li class="mycoupon_validity_period">21.01.01~21.05.21</li>
					<li class="mycoupon_discount">50% discount</li>
				</ul>


				<ul class="mycoupon-list">
					<li class="mycoupon-name"><strong>부자되자 쿠폰2</strong></li>
					<li><img class="mycoupon_img" alt="공지_image"
						src="images/cc.png" width="80"></li>
					<li class="mycoupon_ validity_period">21.01.01~21.05.21</li>
					<li class="mycoupon_discount">50% discount</li>
				</ul>


				<ul class="mycoupon_list">
					<li class="mycoupon-name"><strong>부자되자 쿠폰3</strong></li>
					<li><img class="mycoupon_img" alt="공지_image"
						src="images/cc.png" width="80"></li>
					<li class="mycoupon_ validity_period">21.01.01~21.05.21</li>
					<li class="mycoupon_discount">50% discount</li>
				</ul>


				<ul class="mycoupon_list">
					<li class="mycoupon_name"><strong>부자되자 쿠폰4</strong></li>
					<li><img class="mycoupon_img" alt="공지_image"
						src="images/cc.png" width="80"></li>
					<li class="mycoupon_ validity_period">21.01.01~21.05.21</li>
					<li class="mycoupon_discount">50% discount</li>
				</ul>



			</div>

			<div class="page">

				<a href="#prev">이전</a>
				<div class="num">

					<a href="#1">1</a> <a href="#2">2</a> <a href="#3">3</a>

				</div>
				<a href="#next">다음</a>

			</div>
			<!-- //pagination -->

			<!-- //다운로드 완료 My쿠폰  -->

			<div>
				<h3>다운로드 가능 NEW 쿠폰</h3>


				<tr style="height: 10px">



					<table>

						<tr>
							<td rowspan="2"><img class="coupon_img" alt="공지_image"
								src="images/cc.png" width="80"></td>
							<td class="coupon_name"><strong>가입기념 쿠폰</strong></td>

							<td class="coupon_issuance" rowspan="2">
								<button type="button" class="p_btn" onclick="cou_btn_issuance">
									<strong>다운로드</strong>
								</button> <!-- 다운로드시 고객 사용가능한 쿠폰이 발급됨 -->
							</td>

						</tr>
						<tr>
							<td class="board_tit"><strong>21.01.01~21.05.21</strong></td>
						</tr>

						<tr>
							<td rowspan="2"><img class="n_img" alt="공지_image"
								src="images/cc.png" width="80"></td>
							<td class="board_tit"><strong>여름맞이 썸머 쿠폰</strong></td>

							<td rowspan="2">
								<button type="button" class="p_btn" onclick="cou_btn_issuance">
									<strong>다운로드</strong>
								</button>
							</td>
							<!-- 다운로드시 고객 사용가능한 쿠폰이 발급됨 -->
						</tr>
						<tr>
							<td class="board_tit"><strong>21.01.01~21.05.21</strong></td>
						</tr>



					</table>


					<div class="page">

						<a href="#prev">이전</a>
						<div class="num">

							<a href="#1">1</a> <a href="#2">2</a> <a href="#3">3</a>

						</div>
						<a href="#next">다음</a>

					</div>
					<!-- //pagination -->
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>