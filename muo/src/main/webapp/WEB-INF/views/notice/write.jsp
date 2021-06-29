<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>NOTICE</h3></div>
		<div class="notice_view">

			<form name="frmWrite" id="frmWrite" action="./board_ps.jsp" method="post" enctype="multipart/form-data" class="frmWrite">
				<input type="hidden" name="bdId" value="qa">
				<input type="hidden" name="sno" value="">
				<input type="hidden" name="mode" value="write">
				<input type="hidden" name="returnUrl" value="bdId=qa">
	
				<div class="board_zone_write">
					<div class="board_write_box">
						<table class="notice_write_table">
							<tbody>
							<tr>
								<th>제목</th>
								<td ><input class="title" type="text" name="subject"/></td>
							</tr>
							<tr>
	                            <th>첨부파일</th>
	                            <td><input type="file" name="fileName"></td>
	                        </tr>
							<tr>
								<th>본문</th>
								<td class="write_editor">
									<textarea id="editor" name="contents" style="resize:none"></textarea>
								</td>
							</tr>
							
							</tbody>
						</table>
					</div>
	            </div>
				<div class="admin_toll">
					<ul>
						<li>
							<a href="/notice">목록</a>
						</li>
						<li>
							<input type="reset" value="작성취소" id="cancel" >
						</li>
						<li>
							<input type="submit" value="작성완료" id="register">
						</li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>