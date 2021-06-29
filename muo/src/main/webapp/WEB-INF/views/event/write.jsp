<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>EVENT</h3></div>
		<div class="event_write">
		    <form action="#" method="post" id="eve_w_form">
		        <table cellpadding="0" cellspacing="0">
		            <tr>
		                <th>제목</th>
		                <td><input type="text" name="event_w_tit" placeholder="제목을 입력하세요"></td>
		            </tr>
		            <tr>
		                <th>기간</th>
		                <td>
		                    <input type="text" name="eve_startDay" id="datepicker">
		                    &nbsp; - &nbsp;
		                    <input type="text" name="eve_endDay" id="datepicker2">
		                </td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>
		                    <input type="file" name="eve_file">
		                </td>
		            </tr>
		            <tr>
		                <td colspan="2" class="smartEditor">
		                    <textarea name="eve_w_cont" id="eve_w_cont" cols="30" rows="20"></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="admin_toll">
		            <ul class="clear_fix">
		                <li><a href="/event">목록</a></li>
		                <li><input type="submit" value="작성완료" id="eve_submit"></li>
		            </ul>
		        </div>
	    	</form>
    	</div>
    </div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>