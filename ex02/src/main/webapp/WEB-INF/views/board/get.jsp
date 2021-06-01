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
	   <form role="form" action="/board/modify" method="post">
	   			   <div class="form-group">
	   			     <label>Bno</label>
	   			     <input class="form-control" name='bno' 
	   			                value='<c:out value="${board.bno}"/>' readonly="readonly">
	   			   </div>
	   			   
	   			    <div class="form-group">
	   			    	<label>Title</label><input class="form-control" name="title" value="${board.title}" readonly="readonly">
	   			    </div>
	   			   
	   			   <div class="form-group">
	   			    	<label>Text Area</label>
	   			    	<textarea rows="3" cols="form-control" name='content' readonly="readonly"><c:out value="${board.content}"/></textarea>
	   			    </div>
	   			    
	   			    <div class="form-group">
	   			    	<label>Writer</label>
	   			    	<input class="form-control" name="writer" 
	   			    	           value="<c:out value="${board.writer}"/>" readonly="readonly">
	   			    </div>
	   			    <div class="form-group">
	   			    	<label>RegDate</label>
	   			    	<input class="form-control" name="regdate" 
	   			    	           value="<fmt:formatDate pattern="yyyy/MM/dd" 
	   			    	            value="${board.regdate}"/>" readonly="readonly">
	   			    </div>
	   			    <div class="form-group">
	   			    	<label>Update Date</label>
	   			    	<input class="form-control" name="updateDate" 
	   			    	           value="<fmt:formatDate pattern="yyyy/MM/dd" 
	   			    	            value="${board.updateDate}"/>" 
	   			    	            readonly="readonly">
	   			    </div>
	   			    
	   			    <button type="submit"  data-oper='modify' class="btn btn-default">Modify</button>
	   			    <button type="submit" data-oper='remove' class="btn btn-danger" disabled>Remove</button>
	   			    <button type="submit" data-oper='list' class="btn btn-info">List</button>
	   			    
	   			   </form>
	   			
	   			</div>
	   			<!-- end panel-body  -->
	   	</div>
	   	<!--  end panel -->
	 </div>
	  <form id='operForm' action='/board/modify' method='get'>
	       <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
	       <input type='hidden' id='pageNum' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
	       <input type='hidden' id='amount' name='amount' value='<c:out value="${cri.amount}"/>'>
	       <input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
           <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
	  </form>
</div>
<!--  /. row -->
<script>
$(document).ready(function(){
	/* 태그 선택자 */
	//var formObj = $("form");//form 요소의 정보 
	var operForm = $("#operForm");
	
	$("button[data-oper='modify']").on('click',function(e){
		e.preventDefault();
		 operForm.attr("action","/board/modify").submit();
	 });	 
		
	$("button[data-oper='list']").on('click',function(e){
		e.preventDefault();
		operForm.find("#bno").remove(); 
		operForm.attr("action","/board/list");
		operForm.submit();
	 });
		
});
</script>
<%@include file="../includes/footer.jsp"%>