<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>1:1 QNA</h3></div>
		<div class="qna_write">

				<form action="/qna/modify" method="post" enctype="multipart/form-data"
				name="registerqna">
				<table class="table">
					<tr>
						<th width="100">문의유형</th>
						<td><select name="qna_type">
								<option value="">문의유형 선택</option>
								<option value="배송" <c:if test="${qna.qna_type=='배송' }">selected</c:if>>배송문의</option>
								<option value="주문" <c:if test="${qna.qna_type=='주문' }">selected</c:if>>주문문의</option>
								<option value="결제" <c:if test="${qna.qna_type=='결제' }">selected</c:if>>결제문의</option>
								<option value="교환" <c:if test="${qna.qna_type=='교환' }">selected</c:if>>교환문의</option>
								<option value="반품" <c:if test="${qna.qna_type=='반품' }">selected</c:if>>반품문의</option>
								<option value="상품" <c:if test="${qna.qna_type=='상품' }">selected</c:if>>상품문의</option>
								<option value="기타" <c:if test="${qna.qna_type=='기타' }">selected</c:if>>기타문의</option>
						</select></td>
					</tr>
					<tr>
						<!-- 				상품정보, 기타문의 제외 -->
						<th>주문번호</th>
						<td><input type="text" name="order_bno" value="${qna.order_bno }">
						<input type="button" value="조회"> </td> 
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="writer" value="{member.id}"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="qna_title" value="${qna.qna_title }"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="uploadFile"></td>
					</tr>
					<tr>
						<th>문의내용</th>
						<td><textarea name="qna_content" cols="40" rows="10" style="resize:none">
							${qna.qna_content }
						</textarea></td>
					</tr>
				</table>
				<div class="admin_toll">
					<ul>
						<li>
							<input type="submit" value="등록">
						</li>
						<li>
						
							<input type="hidden" name="qna_bno" value="${qna_bno }">
						
						 	<!-- 체크여부 값 전달 -->
							<input type="hidden" name="qna_check" value="${qna.qna_check }">
							
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