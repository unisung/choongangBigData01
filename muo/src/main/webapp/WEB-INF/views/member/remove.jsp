<%@ page contentType="text/html; charset=UTF-8"%>
<%-- <%@ include file="../common/header.jsp"%> --%>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>회원관리<span class="sub_tit_ko">고객번호 ${member.mb_seq }</h3></div>
		<div class="join">
			<form role="form" action="/member/modify" method="post" id="modifyForm">
			<input type="hidden" id="mb_seq" name='mb_seq' value="<c:out value='${member.mb_seq }'/>">
			<input type="hidden" name='pageNum' value="${cri.pageNum }">
			<input type="hidden" name="amount" value="${cri.amount }">
			<input type="hidden" name="type" value='<c:out value="${cri.type }"/>'>
			<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }" />'>
		
		</form>
		
	
		<table border="1" id="memberManageViewTable">
			<tr>
				<td>아이디</td>
				<td><input type="text" class="form-control" name='mb_id' value="${member.mb_id }"></td>
				<td>비밀번호</td>
				<td><input class="form-control" name='mb_pw' value="${member.mb_pw }"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input class="form-control" name='mb_name' value="${member.mb_name }"></td>
				<td>닉네임</td>
				<td><input class="form-control" name='mb_nickname' value="${member.mb_nickname }"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input class="form-control" name='mb_phone' value="${member.mb_phone }"></td>
				<td>성별</td>
				<td><input class="form-control" name='mb_gender' value="${member.mb_gender }"></td>
				
			</tr>
			<tr>
				<td>회원등급</td>
				<td><input class="form-control" name='mb_grade' value="${member.mb_grade }"></td>
				<td>이메일</td>
				<td><input class="form-control" name='mb_email' value="${member.mb_email }"></td>
			</tr>
			<tr>
				<td>포인트</td>
				<td><input class="form-control" name='mb_point' value="${member.mb_point }"></td>
				<td>회원가입일</td>
				<td><input class="form-control" name='mb_joinDate' value='<fmt:formatDate pattern="yyyy/MM/dd" 
	   			    	            value="${member.mb_joinDate}"/>' readonly="readonly"></td>
			</tr>
			<tr>
				<td>이벤트<br>참여횟수</td>
				<td><input class="form-control" name='mb_eventNum' value="${member.mb_eventNum }"></td>
				<td>참고항목</td>
				<td><textarea class="form-control" name="mb_notes" >${member.mb_notes }</textarea>
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td colspan="3" class="addressArea" align="left">
				
					<input type="text" value="${member.mb_zipcode }" name="mb_zipcode"> &nbsp; <button>우편번호찾기</button><br>
					<input type="text" value="${member.mb_addr }" name="mb_addr"><br>
					<input type="text" value="${member.mb_detailAddr }" name="mb_detailAddr"><br>
				</td>
			</tr>		
		</table>
		<div class="member-btn">
			<button type="submit" data-oper='modify' id="updateMemberBtn">수정</button>
			&nbsp;
			<button type="submit" data-oper='remove' id="deleteMemberBtn">삭제</button>
			&nbsp;
			<button type="submit" data-oper='list' id="listMemberBtn">목록</button>
			
		</div>
	</section>

<%-- <%@ include file="../common/footer.jsp"%> --%>