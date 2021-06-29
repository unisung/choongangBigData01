<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>MAGAZINE</h3></div>
	    <div class="magazineWrite">
		    <form action="#" method="post">
				<ul>
					<li>
					<label for="magazine_title" class="magazine_li_title">제목</label>
					<input type="text" class="magazine_content" placeholder="내용을 입력하세요">
					</li>
					
					<li>
					<label for="magazine_file" class="magazine_li_title">첨부파일</label>
					<input type="file" class="magazine_content2">
					</li>
					
					<li>
					<textarea></textarea>
					</li>
					
					<li>
					<div class="magazine_button">
					<input type="reset" class="button" value="다시 작성">&nbsp;&nbsp;&nbsp;
					<input type="submit" class="button" value="글 등록">
					</li>
				</ul>
			</form>
		</div>
    </div>	
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>