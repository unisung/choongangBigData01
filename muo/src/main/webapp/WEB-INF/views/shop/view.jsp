<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>SALE</h3></div>
		<div class="item_view">
			<div class="product_info">
				<div class="img_container">
					<img src="${vo.it_img1 }" width="500" height="500"/>
				</div>
		
				<div class="product_information_container">
					<div class="product_title"><b><c:out value="${vo.it_category1 }" /></b><c:out value="${vo.it_category2 }" /></div>
					<div class="line"></div>
					<div class="product_info_cont">
						<h3><c:out value="${vo.it_name }" /></h3>
						<span>금액</span>${vo.it_baseprice } 원 <br>
						<c:if test="${vo.it_saleprice != 0 }">
							<span class="salePrice">할인금액</span>${vo.it_saleprice } 원 <br>
						</c:if>
						<span>누적 판매수</span><c:out value="${vo.it_saleCount }"></c:out><br>
						<span>구매후기</span>별별별별 (4.2)
						<a href="#" id="review_view">후기보기</a>
					</div>
					<form action="/users/payment" method="post">
						<select class="select" name="it_option1" id="size">
							<option value="">사이즈를 선택하세요</option>
							<option value="S">S</option>
							<option value="M">M</option>
							<option value="L">L</option>
						</select> <br>
		
						<select class="select" name="it_option2" id="color">
							<option value="">색상을 선택하세요</option>
							<option value="black">black</option>
							<option value="white">white</option>
							<option value="blue">blue</option>
						</select> <br>
						
						<input type="hidden" name="price"> <!-- 가격 넘겨주기 -->
						
						<div class="selectItem" >선택상품</div>
						<div class="hidden"></div>
						
						<div class="button_container">
							<button type="button" class="button" style="margin-left:-10px;" onclick="javascript:location.href='/users/cart'">장바구니</button>
							<input type="submit" class="button" value="구매하기">
						</div>
					</form>
				</div>
			</div>
	
			<div class="product_content">
				<textarea rows="10" cols="109"> 상품 설명 </textarea>
				
				<div class="product_content_img">
					<img alt="" src="http://placehold.it/600x500">
					<img alt="" src="http://placehold.it/600x500">
					<img alt="" src="http://placehold.it/600x500">
				</div>
			</div>
	
			<div class="review_list_title">
				<h3>*상품 후기*</h3>
			</div>
	
			<div class="review_container">
				<form action="#" method="post">
					<label for="nickname" class="review_title"><!-- ${user.nickname} -->닉네임</label>
					<input type="text" class="text" value="userVO.nickname">
		
					<label for="password"class="review_title">비밀번호</label>
					<input type="text" class="text">
					
					<label for="score"class="review_title">평점</label>
					<select name="score" class="text" style="width:50px;">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				
				
				<div class="content_submit">
					<textarea></textarea>
					<input type="submit" id="review_button" value="등록">
				</div>
				</form>	
			</div>
	
			<div class="reivew_list_container">
			    <form action="#" method="post">
					<label for="nickname" class="review_title"><!-- ${user.nickname} -->닉네임</label>
					<input type="text" class="text_list" value="userVO.nickname" readonly>
		
					<label for="password"class="review_title">비밀번호</label>
					<input type="text" class="text_list">
					
					<label for="score"class="review_title">평점</label>
					<input type="text" class="text_list" style="width:50px;" value="1" readonly>
				
				
				<div class="content_submit">
					<textarea readonly></textarea>
					<input type="submit" class="review_delete_button" value="삭제">
				</div>
			    </form>
			</div>
			<div class="reivew_list_container">
			    <form action="#" method="post">
					<label for="nickname" class="review_title"><!-- ${user.nickname} -->닉네임</label>
					<input type="text" class="text_list" value="userVO.nickname" readonly>
		
					<label for="password"class="review_title">비밀번호</label>
					<input type="text" class="text_list">
					
					<label for="score"class="review_title">평점</label>
					<input type="text" class="text_list" style="width:50px;" value="1" readonly>
				
				
				<div class="content_submit">
					<textarea readonly></textarea>
					<input type="button" class="review_delete_button" value="삭제">
				</div>
				</form>
			</div>
		</div>
<!-- 	</div> -->
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>