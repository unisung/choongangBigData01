<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>1:1 QNA</h3></div>
		<div class="qna_write">

			<form action="/qna/write" method="post" enctype="multipart/form-data"
				name="registerqna">
				<table class="table">
					<tr>
						<th width="100">문의유형</th>
						<td><select name="qna_type">
								<option value="">문의유형 선택</option>
								<option value="배송">배송문의</option>
								<option value="주문">주문문의</option>
								<option value="결제">결제문의</option>
								<option value="교환">교환문의</option>
								<option value="반품">반품문의</option>
								<option value="상품">상품문의</option>
								<option value="기타">기타문의</option>
						</select></td>
					</tr>
					<tr>
						<!-- 				상품정보, 기타문의 제외 -->
						<th>주문번호</th>
						<td><input type="text" name="order_bno" placeholder="ex)1234">
						<input type="button" value="조회"> </td> 
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="writer" value="{member.id}"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="qna_title" placeholder="제목을 입력해주세요"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="uploadFile"></td>
					</tr>
					<tr>
						<th>문의내용</th>
						<td><textarea name="qna_content" cols="40" rows="10" style="resize:none"></textarea></td>
					</tr>
				</table>
				<div class="admin_toll">
					<ul>
						<li>
							<input type="submit" value="등록">
						</li>
						<li>
						
						 	<!-- 체크여부 값 전달 -->
							<input type="hidden" name="qna_check" value="0">
							
							<!-- 고객번호 값 전달 -->
							<input type="hidden" name="member_bno" value="2">
							<a href="/qna/list">목록</a>
						</li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>