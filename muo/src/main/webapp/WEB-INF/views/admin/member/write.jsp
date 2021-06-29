<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/ad_header.jsp" %>

<section>
	<div id="subPage">
		<div class="subM"><h3>MEMBER</h3></div>
		<div class="ad_member_write">
			<table border="1" id="memberManageViewTable">
				<tr>
					<td>아이디</td>
					<td>hong1234</td>
					<td>비밀번호</td>
					<td>password</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>홍길동</td>
					<td>닉네임</td>
					<td>hong</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>여성</td>
					<td>회원등급</td>
					<td><input type="text" value="뉴비" class="ad_memBox"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>010-0000-0000</td>
					<td>포인트</td>
					<td><input type="text" value="3000" class="ad_memBox"></td>
				</tr>
				<tr>
					<td>회원가입일</td>
					<td>2021-06-01</td>
					<td>이벤트 참여횟수</td>
					<td>5</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td colspan="3">hong@naver.com</td>
				</tr>
				<tr>
					<td>주소</td>
					<td colspan="3" class="addressArea" align="left">
						<input type="text" id="zipcode" placeholder="우편번호"> &nbsp;
						<input type="button" onclick="sample_6execDaumPostcode_ad()" value="우편번호 찾기"><br>
						<input type="text" id="addr" placeholder="주소"><br>
						<input type="text" id="addrdetail" placeholder="상세주소"><br>
						<input type="text" id="addrextra" placeholder="참고항목"><br>
					</td>
				</tr>
			</table>
			<div class="admin_toll">
				<ul>
					<li>
						<input type="submit" id="updateMemberBtn" value="수정"> &nbsp;		
					</li>
					<li>
						<input type="submit" id="deleteMemberBtn" value="삭제">
					</li>
				</ul>
			</div>
			<div class="member-btn">
				
			</div>
		</div>
	</div>
</section>
<%@include file="/WEB-INF/views/common/footer.jsp" %>