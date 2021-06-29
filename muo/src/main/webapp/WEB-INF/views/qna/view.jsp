<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>1:1 QNA</h3></div>
		<div class="qna_view">
		    <table class="qna_view_member">
		        <tr class="qna_tit">
		            <th>
		                Q.&nbsp;&nbsp;${qna.qna_type } - ${qna.qna_title }
		                <span class="qna_tit_info">
		                    {member.id }&nbsp;|&nbsp;
		                    <fmt:formatDate value="${qna.qna_regdate }" pattern="yyyy-MM-dd hh:mm:ss" />
		                </span>
		            </th>
		        </tr>
		        <tr class="qna_cont">
		            <td>
		                <div class="file"><span><input type="file" name="uploadFile"></span></div>
		        
		                <div name="qna_view_content">
		                <img src="${qna.qna_img }">
		                    ${qna.qna_content }
		                </div>
		            </td>
		        </tr>
		    </table>
		    <table class="qna_view_admin">
		        <tr class="qna_tit">
		            <th>
		                A.&nbsp;&nbsp;답변 준비 중
		                <span class="qna_tit_info">
		                    admin&nbsp;|&nbsp;2020.02.25
		                </span>
		            </th>
		        </tr>
		        <tr class="qna_cont">
		            <td>
		                <div name="qna_view_content">
		                    답변 준비 중입니다.
		                </div>
		            </td>
		        </tr>
		    </table>
		    <div class="admin_toll">
			    <ul class="clear_fix">
			    	<li><a href="/qna/list">목록</a></li>
			    	<li><form action="/qna/modify" method="get">
			    	<input type="hidden" name="qna_bno" value="${qna.qna_bno }">
			        <input type="submit" value="수정">
			        </form></li>
			        <li><a href="/qna/remove?qna_bno=${qna.qna_bno }">삭제</a></li>
			        <li><a href="#reply">답변</a></li>
			    </ul>
		    </div>
		    <div class="qna_admin_reply">
		        <a href="#close" class="qna_reply_closeBtn">&#9447;</a>
		        <div class="qna_admin_tit">
		            1:1문의 답변하기
		            <span>-&nbsp;ADMIN</span>
		        </div>
		        <form action="#" method="post">
		            <textarea name="qna_reply" cols="30" rows="10" style="resize: none"></textarea>
		            <input type="submit" value="작성완료">
		            <input type="reset" value="작성취소" class="qna_admin_reset">
		        </form>
		        
		    </div>
    		<div class="qna_admin_replyBg"></div>
   		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>