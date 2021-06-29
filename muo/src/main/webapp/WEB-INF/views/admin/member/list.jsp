<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/ad_header.jsp" %>

<section>
	<div id="subPage">
		<div class="subM"><h3>MEMBER</h3></div>
		<div class="ad_member_list">

			<div class="searchdiv">
				<form method="post" action="" id="search">
					<select name="member" id="search-select">
						<option value="id">아이디</option>
						<option value="name">이름</option>
						<option value="nickname">닉네임</option>
						<option value="rank">등급</option>
					</select>
					<input type="text" placeholder="내용을 입력해주세요">
					<input type="submit" value="검색">
				</form>
			</div>

			<table border="1" id="memberManageTable">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>닉네임</th>
					<th>연락처</th>
					<th>가입일</th>
					<th>등급</th>
					<th>포인트</th>
					<th>이벤트<br>참여횟수
					</th>
					<th>회원관리</th>
				</tr>
		
				<tr>
					<td>hong1234</td>
					<td>홍길동</td>
					<td>hong</td>
					<td>010-0000-0000</td>
					<td>2021-06-03</td>
					<td>뉴비</td>
					<td>3000</td>
					<td>5</td>
					<td><input type="button" value="수정" id="updateBtn"
						onclick="location.href='/admin/member/write'"></td>
				</tr>
		
		
		
			</table>
			<div class="page">
	            <a href="#fir">처음</a>
	            <a href="#prev">이전</a>
	            <div class="num">
	                <a href="#1" class="click">1</a>
	                <a href="#2">2</a>
	                <a href="#3">3</a>
	                <a href="#4">4</a>
	            </div>
	            <a href="#next">다음</a>
	            <a href="#last">마지막</a>
	        </div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>