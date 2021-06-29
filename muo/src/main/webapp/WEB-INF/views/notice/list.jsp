<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>NOTICE</h3></div>
		<div class="notice_list">
			<form method="post" action="" id="search">
				<select name="s_select" >
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="">제목+내용</option>
				</select>
				<input type="text" name="s_input">
				<input type="submit" value="검색"> 
			</form>

			<table class="table">
				<colgroup>
					<col style="width: 50px">
					<col style="width: 65%;">
					<col style="width: 130px">
					<col style="width: 130px">

				</colgroup>
				<thead>
					<tr class="table_th">
						<th>번호</th>
						<th>제목</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>

					<tr style="height: 10px">
						<td>1</td>
						<td class="board_tit"><a href="/notice/view"> <strong>신규회원
									및 회원 등급별 혜택</strong>

						</a></td>
						<td>2020.09.13</td>

						<td>1551</td>
					</tr>

					<tr>
					<tr data-sno="2" data-auth="y" style="height: 10px">
						<td>2</td>
						<td class="board_tit"><a href="/notice/view"> 신규회원 및
								회원 등급별 혜택2 </a></td>
						<td>2020.09.14</td>

						<td>1552</td>
					</tr>
				</tbody>
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
	        
	        <div class="admin_toll">
	        	<ul>
	        		<li>
	        			<a href="/notice/write">글쓰기</a>
	        		</li>
	        	</ul>
	        </div>
	        
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>