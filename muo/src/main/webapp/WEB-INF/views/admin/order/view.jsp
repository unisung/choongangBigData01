<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/ad_header.jsp" %>

<section>
	<div id="subPage">
		<div class="subM"><h3>ORDER</h3></div>
		<div class="ad_order_write">
		 <c:forEach items="${orderView}" var="orderView">
		  
		    <ul class="order_type clear_fix">
		        <li>주문</li>
		        <li>배송중</li>
		        <li>배송완료</li>
		        <li>교환</li>
		        <li>반품</li>
		    </ul>
		    <p class="order_info">
		        <p>주문일&nbsp;:&nbsp;2021-04-28<span class="space"></span>${orderView.od_date}</p>
		        <p>주분번호&nbsp;:&nbsp;2104281<span class="space"></span>${orderView.od_num}</p>
		        <p>주문고객ID&nbsp;:&nbsp;hong1234<span class="space"></span>${orderView.mb_id}</p>
		        <p>주문고객&nbsp;:&nbsp;홍길동${orderView.mb_name}</p>
		    </p>
		    <table id="order_item" cellspacing="0" cellpadding="0">
		        <tr class="order_item_tit">
		            <th>주문상세번호</th>
		            <th colspan="2">상품명</th>
		            <th>상품옵션</th>
		            <th>수량</th>
		            <th>판매가</th>
		            <th>금액</th>
		            <th>쿠폰</th>
		            <th>포인트</th>
		            <th>주문상태</th>
		        </tr>
		        <tr>
		            <td width="10%">21042811</td>
		            <td width="10%">
		                <img src="http://placehold.it/100x100" alt="">
		            </td>
		            <td width="20%">
		                <span class="shop_1depth">MAN</span>
		                후드집업
		            </td>
		            <td width="15%">
		                색상 : 블랙 &nbsp;|&nbsp; 사이즈 : M
		            </td>
		            <td width="7.5%">1</td>
		            <td width="7.5%">35,000 원</td>
		            <td width="7.5%">32,000 원</td>
		            <td width="7.5%">3,000 원</td>
		            <td width="7.5%">0</td>
		            <td width="7.5%">주문</td>
		        </tr>
		    </table>
		    <div class="profile clear_fix">
		        <form action="#" method="post">
		            <table cellpading="0" cellspacing="0" id="p_left">
		                <caption>주문 고객</caption>
		                <tr>
		                    <th>성명</th>
		                    <td>홍길동</td>
		                </tr>
		                <tr>
		                    <th>연락처</th>
		                    <td>010-0000-0000</td>
		                </tr>
		                <tr>
		                    <th>주소</th>
		                    <td>서울시 성동구 215-2</td>
		                </tr>
		            </table>
		            <table cellpadding="0" cellspacing="0" id="p_right">
		                <caption>받는 고객</caption>
		                <tr>
		                    <th>성명</th>
		                    <td>홍길동</td>
		                </tr>
		                <tr>
		                    <th>연락처</th>
		                    <td>010-0000-0000</td>
		                </tr>
		                <tr>
		                    <th>주소</th>
		                    <td>서울시 성동구 215-2</td>
		                </tr>
		            </table>
		            <table cellpadding="0" cellspacing="0" id="delivery">
		                <caption>택배배송</caption>
		                <tr>
		                    <th>택배사</th>
		                    <td>
		                        <input type="text" name="delivery_com" id="delivery_com">
		                    </td>
		                    <th class="d_right">메모</th>
		                </tr>
		                <tr>
		                    <th>운송장번호</th>
		                    <td>
		                        <input type="text" name="delivery_num" id="delivery_num">
		                    </td>
		                    <td class="d_right">
		                        <input type="text" value="" name="delivery_memo">
		                    </td>
		                </tr>
		                <tr>
		                	<th>배송처리</th>
		                	<td colspan="2">
		                		<input type="radio" name="delivery_chk" id="delivery_chk1">
		                		<label for="delivery_chk1">배송중</label>
		                		<input type="radio" name="delivery_chk" id="delivery_chk2">
		                		<label for="delivery_chk2">배송완료</label>
		                	</td>
		                </tr>
		            </table>
		            <table cellpadding="0" cellspacing="0" id="order_status">
		                <caption>처리상태</caption>
		                <tr>
		                    <th>처리상태</th>
		                    <td>
		                        <input type="radio" name="order_p_status" id="sts1">
		                        <label for="sts1" class="sts">교환</label>
		                        <input type="radio" name="order_p_status" id="sts2">
		                        <label for="sts2" class="sts">환불</label>
		                    </td>
		                </tr>
		            </table>
		        </form>
		    </div>
		    <div class="admin_toll">
	        <ul class="clear_fix">
	            <li><a href="#list">목록</a></li>
	            <li><input type="submit" value="수정" id="od_v_submit"></li>
	        </ul>
	    </div>
    	  </c:forEach>
    	</div>
    </div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>