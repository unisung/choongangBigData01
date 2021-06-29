<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp"%>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM">
			<h3>비밀번호 찾기</h3>
		</div>
		<div class="inputarea">
			<div class="radioArea">
				<input type="radio" id="phoneRadioBtn" name="findPWType" value="phone" checked>
				<label for="phoneRadioBtn" onclick="javascript:changeFndTarget('phone')">휴대폰</label>
				&nbsp;&nbsp; 
				<input type="radio" id="emailRadioBtn" name="findPWType" value="email">
				<label for="emailRadioBtn" onclick="javascript:changeFndTarget('email')">이메일</label>
			</div>

			<div class="n-form-item">
				<input class="n-input" type="text" placeholder="아이디 입력"
					id="memberID" name="mb_id">
				<p class="n-validation" id="searchVaildMemberId"
					style="display: blcok;"></p>
			</div>

			<div class="n-form-item">
				<input class="n-input" type="text" placeholder="이름 입력"
					id="memberNAME" name="mb_name">
				<p class="n-validation" id="searchVaildMemberName"
					style="display: blcok;"></p>
			</div>

			<div class="n-form-item">
				<input class="n-input" type="text" placeholder="휴대폰번호 입력(-없이)"
					id="memberPHONE" name="mb_phone">
				<p class="n-validation" id="searchVaildMemberPhone"
					style="display: blcok;"></p>
			</div>

			<div class="n-form-item">
				<input class="n-input" type="text" placeholder="이메일 입력"
					id="memberEMAIL" name="mb_email">
				<p class="n-validation" id="searchVaildMemberEmail"
					style="display: blcok;"></p>
			</div>
		</div>



		<div class="member-btn">
			<button type="submit" id="findPWBtn" disabled="">비밀번호 찾기</button>
		</div>

	</section>

<%@include file="/WEB-INF/views/common/footer.jsp"%>