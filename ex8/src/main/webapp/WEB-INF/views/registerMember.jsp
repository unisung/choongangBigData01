<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- security 태그 추가  -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@include file="./includes/header.jsp" %>
<div class="row">
	<div class="col-lg-12">
	    <h1 class="page-header">Member Register</h1>
	</div>
	<!--  /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	 <div class="col-lg-12">
	   	<div class="panel panel-default">
	   			
	   			<div class="panel-heading">Member Register</div>
	   			<div class="panel-body">
	   			   <form role="form" action="/registerMember" method="post">
	   			    <div class="form-group">
	   			    	<label>id</label><input class="form-control" name="userid">
	   			    </div>
	   			   
	   			   <div class="form-group">
	   			    	<label>pwd</label><input type="password" class="form-control" name="userpw">
	   			    </div>
	   			    
	   			    <div class="form-group">
	   			    	<label>name</label>
	   			    	<input class="form-control" name="userName" >
	   			    </div>
	   			    
	   			    <button type="submit" class="btn btn-default btn-primary">Submit Button</button>
	   			    <button type="reset" class="btn btn-default btn-success">Reset Button</button>
	   			    <!-- 보안 토큰  -->
	   			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	   			   </form>
	   			
	   			</div>
	   			<!-- end panel-body  -->
	   	</div>
	   	<!--  end panel -->
	 </div>
</div>
<!--  /. row -->






<%@include file="./includes/footer.jsp"%>