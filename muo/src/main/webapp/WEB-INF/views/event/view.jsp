<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>EVENT</h3></div>
		<div class="event_view">
		    <h3 class="eve_view_tit clear_fix">이벤트 제목입니다.<span class="eve_view_cnt">조회수&nbsp;20&nbsp;|&nbsp;2021-06-10</span></h3>
		    <img src="http://placehold.it/1260x1000" alt="" class="eve_view_img">
		    <div class="admin_toll">
		        <ul class="clear_fix">
		            <li><a href="/event/write">수정</a></li>
		            <li><a href="/event">목록</a></li>
		        </ul>
		    </div>
		    <div class="eve_reply_list">
		        <div class="eve_reply_name">닉네임&nbsp;&nbsp;&nbsp;<span class="eve_reply_date">2021-05-29</span></div>
		        <div class="eve_reply_cont">이벤트 댓글입니다.이벤트 댓글입니다.이벤트 댓글입니다.이벤트 댓글입니다.이벤트 댓글입니다.</div>
		        <div class="eve_reply_btn">
		            <ul class="clear_fix">
		                <li><a href="#reply1">답변</a></li>
		                <li><a href="#reply2">수정</a></li>
		                <li><a href="#reply3">삭제</a></li>
		            </ul>
		        </div>
		    </div>
		    <form action="#" method="post">
		        <div class="eve_reply_write">
		            <textarea name="eve_reply_cont" cols="30" rows="10" style="resize: none"></textarea>
		            <ul class="reply_btn clear_fix">
		                <li><input type="reset" value="취소"></li>
		                <li><input type="submit" value="등록"></li>
		            </ul>
		            
		        </div>
		    </form>
	    </div>
    </div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>