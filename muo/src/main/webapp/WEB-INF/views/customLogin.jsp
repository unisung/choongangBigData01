<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
	<div class="sub_slider"></div>
	<div id="subPage">
		<div class="subM"><h3>LOGIN</h3></div>
		<div class="login">
		
	
		
		 <div class="panel-body">
						<h1>Custom Login Page</h1>
						<h2><c:out value="${error}"/></h2>
						<h2><c:out value="${logout}"/></h2>
			<center>
		<!-- 로긴 폼  -->
		<form role="form" method="post" action="/login">
		  <ul>
			<li>
				<label for="id" class="title">아이디</label>
				<input type="text" name='username' id="user_id" class="content" placeholder="아이디" value=''  autofocus >
			</li>
	
			<li>
				<label for="pw" class="title">비밀번호</label>
				<input type="password" name='password' id="user_pw" class="content" placeholder="비밀번호" value='' >
			</li>
			
			
			<!-- csrf 토큰 설정 -->
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			
		
			<li class="button_list">
				<a href="/member/register" id="registerlogin" class="btn btn-lg btn-primary btn-block">회원가입</a>
				<a href="index.html" id="submit" class="btn btn-lg btn-success btn-block">Login</a>
				<a href="/member/findPW" id="pw_find" class="button">비밀번호찾기</a>
			</li>
		   </ul>
		     </form>
		     </center>
		   	</div>		
	</div>
</div>	
	
	

<script>
  $(".btn-success").on("click",function(e){
	  e.preventDefault();
	  $("form").submit();
	  
  });
</script>

 <c:if test="${param.logout!=null }">
      <script>
      	$(document).ready(function(){
      		alert("로그아웃하였습니다.");
      	});
      </script>
 </c:if>
 









</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>






