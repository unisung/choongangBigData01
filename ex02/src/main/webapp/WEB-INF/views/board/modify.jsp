<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>@
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %>
<div class="row">
	<div class="col-lg-12">
	    <h1 class="page-header">Board Modify</h1>
	</div>
	<!--  /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	 <div class="col-lg-12">
	   	<div class="panel panel-default">
	   			
	   			<div class="panel-heading">Board Modify</div>
	   			<div class="panel-body">
	   			   <form role="form" action="/board/modify" method="post">
	   			       <input type='hidden' name='pageNum' value='${cri.pageNum}'>
	   			       <input type='hidden' name='amount' value='${cri.amount}'>
	   			       <input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
                       <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
           
	   			   <div class="form-group">
	   			     <label>Bno</label>
	   			     <input class="form-control" name='bno' 
	   			                value='<c:out value="${board.bno}"/>' readonly="readonly">
	   			   </div>
	   			   
	   			    <div class="form-group">
	   			    	<label>Title</label><input class="form-control" name="title" value="${board.title}">
	   			    </div>
	   			   
	   			   <div class="form-group">
	   			    	<label>Text Area</label>
	   			    	<textarea rows="3" cols="form-control" name='content'><c:out value="${board.content}"/></textarea>
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
	   			    <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
	   			    <button type="submit" data-oper='list' class="btn btn-info">List</button>
	   			    
	   			   </form>
	   			
	   			</div>
	   			<!-- end panel-body  -->
	   	</div>
	   	<!--  end panel -->
	 </div>
</div>
<!--  /. row -->
<script>
$(document).ready(function(){
	/* ?????? ????????? */
	var formObj = $("form");//form ????????? ?????? 
	$('button').on('click',function(e){
		/* ???????????? ?????? */
		e.preventDefault();
		var operation = $(this).data("oper");
		
		
		console.log(operation);
		
		if(operation==='remove'){
			formObj.attr("action","/board/remove");
		}else if(operation==='list'){
          //move to list
          formObj.attr("action","/board/list").attr("method","get");
	
           var pageNumTag = $("input[name='pageNum']").clone();
           var amountTag = $("input[name='amount']").clone();
			
			/* form????????? input ???????????? ?????? ?????? */
			formObj.empty();
			
			formObj.append(pageNumTag);//<form><input type='hidden' name='pageNum' value='???'>
			formObj.append(amountTag);//                <input type='hidden' name='amount' value='10'></form>
		}
		/* ???????????? ???????????? */
		formObj.submit();
	});
});
</script>
<%@include file="../includes/footer.jsp"%>