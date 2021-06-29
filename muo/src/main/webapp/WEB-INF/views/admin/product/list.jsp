<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../common/ad_header.jsp"%>

<!doctype html>
<html>
<head>
</head>
<body>


<section>
	<div id="subPage">
		<div class="subM">
			<h3>PRODUCT</h3>
		</div>
		<div class="ad_product_list">

				<div align="right" class="button_move">
					<button type="button" class="btn_board_"
						onclick="javascript:location.href='/admin/product/write'">
						<strong>상품등록</strong>
					</button>
					<button type="button" class="btn_board_" id="remove">
						<strong>상품삭제</strong>
					</button>
				</div>

				<table align="center">
					<colgroup>
						<col style="width: 4%">
						<!-- 체크박스 -->
						<col>
						<!-- 상품코드 -->
						<col style="width: 12%">
						<!-- 이미지 -->
						<col style="width: 12%">
						<!-- 상품명 -->
						<col style="width: 12%">
						<!-- 판매가격 -->
						<col style="width: 12%">
						<!-- 시중가격 -->
						<col style="width: 9%">
						<!-- 재고수량 -->
						<col style="width: 9%">
						<!-- 판 매 -->
						<!-- 판매: 재고수량 0일경우 품절로 판매 비활성화  -->
						<col style="width: 9%">
						<!-- 세 일 -->
						<!-- 세일: 활성화, 비활성화로 수정탭에서 선택가능  -->
						<col>
						<!-- 상품관리 -->
					</colgroup>

					<thead>
						<tr>
							<th rowspan="2">
								<div class="form_element">
									<input type="checkbox" id="allCheck1" class="p_select_all">

								</div>
							</th>
							<th rowspan="2">상품코드</th>
							<th rowspan="2">이미지</th>
							<th colspan="3">분류</th>
							<th rowspan="2">재고수량</th>
							<th rowspan="2">세 일</th>
							<th rowspan="2">상품관리</th>
						</tr>
						<tr>
							<th>상품명</th>
							<th>판매가격</th>
							<th>시중가격</th>
						</tr>
					</thead>
					
					
					<tbody>
					<c:forEach items="${list }" var="product">
					<form action="/admin/product/listModify">
						<tr>
							<td rowspan="2" class="td_chk">
								<div class="form_element">
									<input type="checkbox" id="itemno" class="p_select" name="p_select">

								</div>
							</td>
							<td rowspan="2"><strong class="p_code">${product.it_number }</strong></td>
							<td rowspan="2" class="p_img"><img src="${product.it_img1 }" alt="청바지">
							</td>

							<td colspan="3">
								<ul>
									<li><select class="p_classification1"
										name="it_category1">
										<option value="1" <c:if test="${product.it_category1 == 1 }">selected</c:if>>MAN</option>
										<option value="2" <c:if test="${product.it_category1 == 2 }">selected</c:if>>WOMAN</option>
										<option value="3" <c:if test="${product.it_category1 == 3 }">selected</c:if>>BEAUTY</option>
									</select></li>
									<li><select style="width: 270px;"
										class="p_classification_2" name="it_category2">
										<option value="Top" <c:if test="${product.it_category2 == 'Top' }">selected</c:if>>Top</option>
										<option value="Outer" <c:if test="${product.it_category2 == 'Outer' }">selected</c:if>>Outer</option>
										<option value="Pants" <c:if test="${product.it_category2 == 'Pants' }">selected</c:if>>Pants</option>
										<option value="Bag" <c:if test="${product.it_category2 == 'Bag' }">selected</c:if>>Bag</option>
										<option value="Shoes" <c:if test="${product.it_category2 == 'Shoes' }">selected</c:if>>Shoes</option>
										<option value="Other" <c:if test="${product.it_category2 == 'Other' }">selected</c:if>>Other</option>
									</select></li>
								</ul>
							</td>


							<!-- 재고수량 -->
							<td rowspan="2" class="Stock_amount"><strong>${product.it_remainCount }</strong></td>
							<!-- 세일, 판매: 활성화, 비활성화로 수정탭에서 선택가능  -->
							<td rowspan="2">
								<div class="p_sale_State">
								<select name="it_sale">
									<option value="1"  <c:if test="${product.it_sale == 1 }">selected</c:if>>활성화</option>
									<option value="0" <c:if test="${product.it_sale == 0 }">selected</c:if>>비활성화</option>
								</select>
								</div>
							</td>
							<td>
								<button type="button" class="btn_board_view"
									onclick="javascript:location.href='/admin/product/get?it_number=${product.it_number}'">
									<strong>보기</strong>
								</button>
							
							</td>
						</tr>

						<tr>
							<td><strong class="p_name">${product.it_name}</strong></td>

							<td class="price">
								<div class="p_price">
									<strong>${product.it_saleprice}원</strong>

								</div>
							</td>
							<!-- 시중가격: 세일전 금액 -->
							<td class="before_sale">
								<div class="p_before_sale">
									<strong>${product.it_baseprice }원</strong>

								</div>
							</td>
							<td>
								<input type="hidden" class="it_number" name="it_number" value="${product.it_number }">
								<input type="submit" class="p_btn" value="수정" style="font-weight:bold">
							</td>


						</tr>
					</form>
					</c:forEach>
					</tbody>
					
				

				</table>

			
		</div>
		
		 <ul class="pagination">
  		      
  		      <c:if test="${pageMaker.prev}">
  		      <li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
  		      <a href="${pageMaker.startPage -1}">Previous</a></li>
  		      </c:if>
  		       <c:if test="${!pageMaker.prev}">
  		      <li class="paginate_button previous disabled" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
  		      <a href="${pageMaker.startPage -1}">Previous</a></li>
  		      </c:if>
  		      
  		      <c:forEach var="num"  begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	  		       <c:if test="${num==pageMaker.cri.pageNum}">
	  		       <li class="paginate_button active" aria-controls="dataTables-example" tabindex="0">
	  		        <a href="${num}">${num}</a></li>
	  		       </c:if>
	  		       <c:if test="${num!=pageMaker.cri.pageNum}">
	  		       <li class="paginate_button" aria-controls="dataTables-example" tabindex="0">
	  		        <a href="${num}">${num}</a></li>
	  		       </c:if>
  		      </c:forEach>
  		      
  		      <c:if test="${pageMaker.next}">
  		      <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next">
  		      <a href="${pageMaker.endPage + 1}">Next</a></li>
  		      </c:if>
  		      </ul>
  		      
  		      <form id="actionForm" action="/admin/product/list" method="get">
 				<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
 				<input type='hidden' name='amount' value='${pageMaker.cri.amount }'>
			  </form>
	</div>
</section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
$(document).ready(function(){
	var actionForm = $("#actionForm");
	
	/* 페이지 네비게이션 버튼 클릭시 */
	$('.paginate_button a').on("click",function(e){
		e.preventDefault();
		
		console.log('click');
		/* 클릭한 <a>태그의 페이지번호를 actionForm의 input tage 에 설정 val(값); */
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();//action으로 전송처리
	});
	
});
</script>                    

<script>
	$(document).ready(function(){
		
		$("#allCheck1").click(function(){
			if($(this).is(":checked")==true) {
				$(".p_select").prop("checked", true);
			} else {
				$(".p_select").prop("checked", false);
			}
		});
		
      $(".p_select").click(function(){

		var leng = $("input[name='p_select']").length;
		
		if($("input[name='p_select']:checked").length == leng) {
			$("#allCheck1").prop("checked", true);
		} else {
			$("#allCheck1").prop("checked", false);
		}

      }); 	
      
	  $("#remove").click(function(){
		  
		  var index = $("input[name='p_select']").parents("tr").next();
		  
		  var it_number = index.find(".it_number").val();
		  
		  if($(".p_select").is(":checked")==true) {
			  var it_number = [index.find(".it_number").val()];
			  
			  for(var i=0; i<it_number.length; i++) {
				  location.href="/admin/product/remove?it_number=" + it_number[i];  
			  }
		  }
		  
	  });
      
      
	});
</script>

<%@ include file="../../common/footer.jsp"%>


</body>

</html>