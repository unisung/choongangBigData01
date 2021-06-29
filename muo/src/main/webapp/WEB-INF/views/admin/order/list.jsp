<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/ad_header.jsp" %>

<section>
	<div id="subPage">
		<div class="subM"><h3>ORDER</h3></div>
		<div class="ad_order_list">

			<form method="post" action="" id="search">
				<div align="right" class="ord_search">
					<div align="right" class="datepicker">
		
						<p>
							주문날짜검색 <input type="text" id="datepicker1"> <input
								type="text" id="datepicker2">
						</p>
		
						<select name="order_info" id="order_selcect">
							<option value="">주문번호</option>
							<option value="title">주문자ID</option>
						</select> <input type="text" value="내용을 입력해주세요"> <input type="submit"
							value="검색">
		
					</div>
				</div>
			</form>

			<table align="center">
				<colgroup>
		
					<col style="width: 16%">
					<!-- 주문목록 -->
					<col style="width: 16%">
					<!-- 신규주문 -->
					<col style="width: 16%">
					<!-- 배 송 -->
					<col style="width: 16%">
					<!-- 완 료 -->
					<col style="width: 16%">
					<!-- 교 환 -->
					<col style="width: 17%">
					<!-- 반 품 -->
				</colgroup>
		
				<thead>
		
					<tr>
						<td class=""><a href="#orderlist" class="orderlist_"><span>주문목록</span></a></td>
						<td class=""><a href="#new_order" class="new_order_"><span>신규주문</span></a></td>
						<td class=""><a href="#delivery" class="delivery_"><span>배송</span></a></td>
						<td class=""><a href="#completion" class="completion_"><span>완료</span></a></td>
						<td class=""><a href="#exchange" class="exchange_"><span>교환</span></a></td>
						<td class=""><a href="#return" class="return_"><span>반품</span></a></td>
					</tr>
				</thead>
			</table>
			<table align="center">
				<colgroup>
					<col style="width: 4%">
					<!-- 번호 -->
					<col style="width: 10%">
					<!-- 주문상태 :주문/배송/교환/반품  -->
					<col style="width: 10%">
					<!-- 주문일시-->
					<col style="width: 10%">
					<!-- 주문번호 -->
					<col>
					<!-- 주문상품 -->
					<col style="width: 10%">
					<!-- 주문자ID -->
					<col style="width: 10%">
					<!-- 주문자 -->
					<col style="width: 10%">
					<!-- 결제금액 -->
					<col style="width: 10%">
					<!-- 결제금액 -->
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>주문상태</th>
						<!-- 주문상태 :주문/배송/교환/반품  -->
						<th>주문일시</th>
						<th>주문번호</th>
						<th>주문상품</th>
						<th>주문자ID</th>
						<th>주문자</th>
						<th>결제금액</th>
						<th>주문관리</th>
					</tr>
					<c:forEach items="${list}" var="order">
				
					<tr>
					
						<td class=""><strong class="order_state">${order.od_status}</strong></td>
						<td class=""><strong class="order_date">${order.od_date}</strong></td>
						<td class=""><strong class="order_code">${order.od_num}</strong></td>
						<td class=""><strong class="order_product_name">${order.it_name}</strong></td>
						<td class=""><strong class="orderer_id">${order.it_name}</strong></td>
						<td class=""><strong class="orderer_name">${order.mb_name}</strong></td>
						<td class=""><strong class="order_price">${order.od_amoun}</strong></td>
						<td class=""><strong class="order_manage">
						<button type="button" class="btn_board_view"
									onclick="javascript:location.href='/admin/order/get?od_num=${order.od_num}'">
									<strong>보기</strong>
								</button>
							</td>
					</tr>
					
					</c:forEach>
		
					<tr>
						
						<td class=""><strong class="order_state">주문</strong></td>
						<td class=""><strong class="order_date">210113</strong></td>
						<td class=""><strong class="order_code">21062625</strong></td>
						<td class=""><strong class="order_product_name">청바지</strong></td>
						<td class=""><strong class="orderer_id">rong12</strong></td>
						<td class=""><strong class="orderer_name">홍길하</strong></td>
						<td class=""><strong class="order_price">12,000원</strong></td>
						<td class=""><strong class="order_manage"><a href="order_write.do">보기</a></strong></td>
					</tr>
		
		
					<tr>
					
						<td class=""><strong class="order_state">반품</strong></td>
						<td class=""><strong class="order_date">210603</strong></td>
						<td class=""><strong class="order_code">21060232</strong></td>
						<td class=""><strong class="order_product_name">청남방</strong></td>
						<td class=""><strong class="orderer_id">kong12</strong></td>
						<td class=""><strong class="orderer_name">홍길남</strong></td>
						<td class=""><strong class="order_price">9,000원</strong></td>
						<td class=""><strong class="order_manage"><a href="order_write.do">보기</a></strong></td>
					</tr>
				</thead>
			</table>

			<div class="page">
				<a href="#fir">처음</a> <a href="#prev">이전</a>
				<div class="num">
					<a href="#1">1</a> <a href="#2">2</a> <a href="#3">3</a> <a href="#4">4</a>
				</div>
				<a href="#next">다음</a> <a href="#last">마지막</a>
			</div>
		</div>
	</div>
</section>


<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->

<!-- <script> -->
// $(document).ready(function(){
// 	var actionForm = $("#actionForm");
	
// 	/* 페이지 네비게이션 버튼 클릭시 */
// 	$('.paginate_button a').on("click",function(e){
// 		e.preventDefault();
		
// 		console.log('click');
// 		/* 클릭한 <a>태그의 페이지번호를 actionForm의 input tage 에 설정 val(값); */
// 		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
// 		actionForm.submit();//action으로 전송처리
// 	});
	
// });
<!-- </script>                     -->

<!-- <script> -->
// 	$(document).ready(function(){
		
// 		$("#allCheck1").click(function(){
// 			if($(this).is(":checked")==true) {
// 				$(".p_select").prop("checked", true);
// 			} else {
// 				$(".p_select").prop("checked", false);
// 			}
// 		});
		
//       $(".p_select").click(function(){

// 		var leng = $("input[name='p_select']").length;
		
// 		if($("input[name='p_select']:checked").length == leng) {
// 			$("#allCheck1").prop("checked", true);
// 		} else {
// 			$("#allCheck1").prop("checked", false);
// 		}

//       }); 	
      
// 	  $("#remove").click(function(){
		  
// 		  var index = $("input[name='p_select']").parents("tr").next();
		  
// 		  var it_number = index.find(".it_number").val();
		  
// 		  if($(".p_select").is(":checked")==true) {
// 			  location.href="/admin/product/remove?it_number=" + it_number;  
// 		  }
		  
// 	  });
      
      
// 	});
<!-- </script> -->




<%@include file="/WEB-INF/views/common/footer.jsp" %>