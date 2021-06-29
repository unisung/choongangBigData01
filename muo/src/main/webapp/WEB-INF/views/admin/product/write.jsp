<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/ad_header.jsp"%>

<section>
	<div id="subPage">
		<div class="subM">
			<h3>PRODUCT</h3>
		</div>
		<div class="ad_product_write">
			<form action="/admin/product/write" method="post" enctype="multipart/form-data">
				<ul>
					<li><label for="id" class="p_title"
						style="margin-bottom: 20px;">기본분류</label>
						<div class="content">
							<select style="width: 270px;" class="classification_1"
								name="it_category1">
								<option value="1">MAN</option>
								<option value="2">WOMAN</option>
								<option value="3">BEAUTY</option>
							</select>
						</div></li>

					<li><label for="pw" class="p_title"
						style="margin-bottom: 20px;">2차분류</label>
						<div class="content">
							<select style="width: 270px;" class="classification_1"
								name="it_category2">
								<option value="Top">Top</option>
								<option value="Outer">Outer</option>
								<option value="Pants">Pants</option>
								<option value="Bag">Bag</option>
								<option value="Shoes">Shoes</option>
								<option value="Other">Other</option>
							</select>
						</div> <br></li>

					<li><label for="name" class="p_title">상품명</label> <input
						type="text" id="p_name" name="it_name"class="content" placeholder="내용을 입력해주세요">
						<br></li>

					<li><label for="description" class="p_title">상품설명</label> <textarea
							style="height: 250px; resize: none;" type="text" id="p_descrip"
							class="content" name="it_content" placeholder="내용을 입력해주세요"></textarea><br></li>

					<li><label for="price" class="p_title">판매가격</label> <input
						type="text" id="p_price" name="it_saleprice" class="content" placeholder="내용을 입력해주세요">
						<br></li>

					<li><label for="market_price" class="p_title">시중가격</label> <input
						type="text" name="it_baseprice"id="p_market_price" class="content"
						placeholder="내용을 입력해주세요"> <br></li>

					<li><label for="sale" class="p_title">세일상품</label> <label><input
							type="radio" name="it_sale" value="1" checked>활성화 &nbsp;</label>
						<label><input type="radio" name="it_sale" value="0">비활성
							<br></label></li>

					<li><label for="sold_out" class="p_title">재고수량</label> <input
						type="text" id="p_stock_quantity" name="it_remainCount" class="content"
						placeholder="내용을 입력해주세요"> <br></li>


					<li><label for="option_title1" class="p_title"> 옵션상품1</label>
						<input type="text" id="p_option_title1" name="it_option1"class="content"
						placeholder="내용을 입력해주세요"> <br></li>

					<li><label for="option_content1" class="p_title">옵션상품1
							항목</label> <input type="text" id="p_option_content1" name="it_option2"class="content"
						placeholder="내용을 입력해주세요"> <br></li>

					<li><label for="option_title2" class="p_title"> 옵션상품2</label>
						<input type="text" id="p_option_title2" name="it_option3" class="content"
						placeholder="내용을 입력해주세요"> <br></li>

					<li><label for="option_content2" class="p_title">옵션상품2
							항목</label> <input type="text" id="p_option_content2" name="it_option4" class="content"
						placeholder="내용을 입력해주세요"> <br></li>
						
					<li><input type="hidden" name="it_saleCount" value="0"></li>


					<li><label for="attached_file1" class="p_title">첨부파일1</label>
						<input type="file" name="uploadFile1"> <br></li>

					<li><label for="attached_file2" class="p_title">첨부파일2</label>
						<input type="file" name="uploadFile2"><br></li>

					<li><label for="attached_file2" class="p_title">첨부파일3</label>
						<input type="file" name="uploadFile3"> <br></li>



					<span class="button_list_register"> <input type="button"
						value="목록으로" id="list" onclick="javascript:location.href='/admin/product/list'"
						class="p_button"> <input type="submit" value="작성완료"
						id="register" class="p_button">
					</span>
			</form>
		</div>
	</div>
</section>

<%@ include file="../../common/footer.jsp"%>