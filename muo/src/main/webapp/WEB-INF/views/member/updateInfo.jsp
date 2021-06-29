<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>회원정보수정</h3></div>
		<div class="updateInfo">
			<table id="updateMemberTable">
				<tr>
					<td>아이디</td>
					<td>hong1234</td>
				</tr>
				<tr>	
					<td>비밀번호</td>
					<td><input type="password" value=""></td>
					<td>비밀번호확인</td>
					<td><input type="password" value=""></td>
				</tr>
				<tr>
					<td>이름</td>
					<td>홍길동</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" value="hong"></td>
					<td><input type="submit" value="중복체크"> </td>
				</tr>
				<tr>
					<td>성별</td>
					<td>여성</td>
					<td>회원등급</td>
					<td>뉴비</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" value="01012345678"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td >
					<input type="text" id="email_id">@
					<select>
						<option value="naver">naver.com</option>
						<option value="daum">daum.net</option>
						<option value="google">google.com</option>
						<option value="nate">nate.com</option>
					</select> 
					
					</td>
				</tr>
				<tr>
					<td>포인트</td>
					<td>3000</td>
					<td>회원가입일</td>
					<td>2021-06-01</td>
				</tr>
				<tr>
					<td>이벤트<br>참여횟수</td>
					<td>5</td>
					
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" value="123-456">
					</td>
					<td><input type="submit" value="찾기"> </td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" value="서울 성동구 성수동">
					</td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td>
						<input type="text" value="성수빌딩">
					</td>
				</tr>		
			</table>
			<div class="member-btn">
				<input type="submit" id="updateBtn" value="수정">
			</div>
		</div>
	</div>
</section>
			

<%@include file="/WEB-INF/views/common/footer.jsp" %>