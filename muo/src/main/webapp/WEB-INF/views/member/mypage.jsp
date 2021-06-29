<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>MYPAGE</h3></div>
		<div class="mypage">
			 <div class="myPage_Layout">
				<h3>회원 ${memberInfo.mb_nickname }(님)<span><a href="/member/updateInfo">회원정보수정</a></span></h3>
				<ul>
					<li><span>회원등급</span><br><b>ex)뉴비</b></li>
					<li><span>적립금</span><br><b>3000</b></li>
					<li><span>이벤트 참여</span><br><b>10 건</b></li>
					<li><a href="/coupon/list"><span>쿠폰</span><br><b>5 개</b></a></li>
				</ul>
			</div>
			<div class="line"></div>
			<div class="help_LayOut">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<th colspan="2"><h3>고객센터</h3></th>
					</tr>
					<tr>
						<td><a href="/qna/list">1:1 Q&amp;A</a></td>
						<td><a href="/member/membership">Membership</a></td>
					</tr>
					<tr>
						<td><a href="/faq/list">자주묻는 질문</a></td>
						<td><a href="/event/list">Event</a></td>
					</tr>
					<tr>
						<td><a href="/notice/list">공지사항</a></td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</section>
		
		
		
<%@include file="/WEB-INF/views/common/footer.jsp" %>