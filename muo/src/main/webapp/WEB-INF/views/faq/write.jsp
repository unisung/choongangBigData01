<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>FAQ</h3></div>
		<div class="faq_write">
		    <form action="#" method="post" id="faq_view">
		        <table cellspacing="0" cellpadding="0">
		            <tr>
		                <td>
		                    <input type="radio" name="faq_type" id="faq_type_1" checked=checked>
		                    <label for="faq_type_1">주문</label>
		                    <input type="radio" name="faq_type" id="faq_type_2">
		                    <label for="faq_type_2">배송</label>
		                    <input type="radio" name="faq_type" id="faq_type_3">
		                    <label for="faq_type_3">교환</label>
		                    <input type="radio" name="faq_type" id="faq_type_4">
		                    <label for="faq_type_4">환불</label>
		                </td>
		            </tr>
		            <tr>
		                <td>
		                    <input type="text" name="faq_view_tit" placeholder="제목">
		                </td>
		            </tr>
		            <tr>
		                <td>
		                    <textarea name="faq_view_cont" cols="30" rows="10" style="resize: none"></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="admin_toll">
			        <ul>
			            <li>
			                <a href="/faq">목록</a>
			            </li>
			            <li>
			                <input type="submit" value="수정">
			            </li>
			            <li>
			                <input type="button" value="삭제">
			            </li>
			        </ul>
		        </div>
		    </form>
	    </div>
    </div>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>