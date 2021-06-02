<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>@
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %>
<div class="row">
	<div class="col-lg-12">
	    <h1 class="page-header">Board Register</h1>
	</div>
	<!--  /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	 <div class="col-lg-12">
	   	<div class="panel panel-default">
	   			
	   			<div class="panel-heading">Board Register</div>
	   			<div class="panel-body">
	   			   <form role="form" action="/board/register" method="post">
	   			    <div class="form-group">
	   			    	<label>Title</label><input class="form-control" name="title">
	   			    </div>
	   			   
	   			   <div class="form-group">
	   			    	<label>Text Area</label>
	   			    	<textarea rows="3" cols="form-control" name='content'></textarea>
	   			    </div>
	   			    
	   			    <div class="form-group">
	   			    	<label>Writer</label><input class="form-control" name="writer">
	   			    </div>
	   			    
	   			    <button type="submit" class="btn btn-default">Submit Button</button>
	   			    <button type="reset" class="btn btn-default">Reset Button</button>
	   			   </form>
	   			
	   			</div>
	   			<!-- end panel-body  -->
	   	</div>
	   	<!--  end panel -->
	 </div>
</div>
<!--  /. row -->
<%@include file="../includes/footer.jsp"%>