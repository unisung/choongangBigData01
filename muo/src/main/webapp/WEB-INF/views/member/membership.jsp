<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>MEMBERSHIP</h3></div>
		<div class="membership">
		
			<ul>
               <li>
                   <img src="/resources/img/member_discount.png" alt="">
                   <p>상시할인</p>
                   <span>회원등급에 따라<br>즉시할인적용</span>
               </li>
               <li>
                   <img src="/resources/img/member_point.png" alt="">
                   <p>멤버쉽 포인트</p>
                   <span>모든회원에게 결제액의<br>1-5%포인트적립</span>
               </li>
               <li>
                   <img src="/resources/img/member_set.png" alt="">
                   <p>공식몰 단독 세트</p>
                   <span>공식몰에서만 만날 수 있는<br>단독 세트 구매 찬스</span>
               </li>
               <li>
                   <img src="/resources/img/member_free.png" alt="">
                   <p>배송비 무료</p>
                   <span>사이트 전 상품<br>무료배송 적용</span>
               </li>
               
           </ul>
           <div class="subM"><h3>멤버쉽 혜택</h3></div>
           
       </div>

       <!--table-->
       <div class="membership_coin">
           <ul>
               <li>
                   <img src="/resources/img/member_new.png" alt="">
                   <p>NEW</p>
               </li>
               <li>
                   <img src="/resources/img/member_bronze.png" alt="">
                   <p> BRONZE</p>
               </li>
               <li>
                   <img src="/resources/img/member_silver.png" alt="">
                   <p>SILVER</p>
               </li>
               <li>
                   <img src="/resources/img/member_gold.png" alt="">
                   <p>GOLD</p>
               </li>
           </ul>
       </div>
       <div class="member_Box">
            <table>
                <caption></caption>
                <tr>
                    <th class="coin">등급</th>
                    <th>등급기준</th>
                    <th>적립금</th>
                    <th>배송비</th>
                </tr>
                <tr class="new">
                    <td class="coin">
                      NEW
                    </td>
                    <td>회원가입 시</td>
                    <td>1%</td>
                    <td rowspan="4">무료배송</td>
                </tr>
                <tr class="BRONZE">
                    <td class="coin">
                        BRONZE
                    </td>
                    <td>6만원 이상 구매 시</td>
                    <td>2%</td>
                </tr>
                <tr class="SILVER">
                    <td class="coin">
                       SILVER
                    </td>
                    <td>10만원 이상 구매 시</td>
                    <td>3%</td>
                </tr>
                <tr class="GOLD">
                    <td class="coin">
                      GOLD
                    </td>
                    <td>20만원 이상 구매 시</td>
                    <td>5%</td>
                </tr>
            </table>
        
        </div>
        <div class="member_add">
            <span class="star">*</span>매주 첫째 주 화요일, 직전 6개월 금액을 합산하여 등급이 책정됩니다.(공휴일의 경우, 영업일 기준 익일)<br>
            <span class="star">*</span>모든 적립금은 발급일로부터 30일 내 사용가능하며, 미사용 시 자동으로 소멸됩니다. <br>
            <span class="star">*</span>적립금을 사용하기 위한 조건으로 최소구매금액이 적용될 수 있습니다.
		</div>
	</div>
</section>
		
<%@include file="/WEB-INF/views/common/header.jsp" %>