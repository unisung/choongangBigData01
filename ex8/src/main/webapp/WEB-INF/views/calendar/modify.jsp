<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Register</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Modify</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

 <form role="form" action="/calendar/modify" method="post">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
 
  <input type='hidden' id='id' name='id' value='<c:out value="${calendar.id }"/>'>
  <input type='hidden' name='y' value='<c:out value="${calendar.y }"/>'>
  <input type='hidden' name='m' value='<c:out value="${calendar.m }"/>'>
  <input type='hidden' name='d' value='<c:out value="${calendar.d }"/>'>
  <input type='hidden' name='seq' value='<c:out value="${calendar.seq}"/>'>  
      
 
<div class="form-group">
          <label>Bno</label> <input class="form-control" name='seq'
            value='<c:out value="${schedule.seq }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${schedule.title }"/>' >
        </div>

        <div class="form-group">
          <label>Text area</label>
          <textarea class="form-control" rows="3" name='content'>
          <c:out value="${schedule.content}" /></textarea>
        </div>

        <div class="form-group">
          <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${calendar.id }"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>times</label> <input class="form-control" name='startTime'
            value='<c:out value="${schedule.startTime}"/>' >
        </div>
        <div class="form-group">
          <label>times</label> <input class="form-control" name='endTime'
            value='<c:out value="${schedule.endTime}"/>' >
        </div>

          

  <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
  <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
  <button type="submit" data-oper='list' class="btn btn-info">List</button>
</form>


      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {


	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    var operation = $(this).data("oper");
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/calendar/remove");
	      
	    }else if(operation === 'list'){
	      //move to list
	      formObj.attr("action", "/calendar/monthly").attr("method","get");
	      
	      var idTag = $("input[name='id']").clone();
	      var yTag = $("input[name='y']").clone();
	      var mTag = $("input[name='m']").clone();
	      var dTag = $("input[name='d']").clone();
	      var seqTag = $("input[name='seq']").clone();
	      
	      formObj.empty();
	      
	      formObj.append(idTag);
	      formObj.append(yTag);
	      formObj.append(mTag);
	      formObj.append(dTag);	 
	      formObj.append(seqTag);	    
	    }
	    
	    formObj.submit();
	  });

});
</script>
  




<%@include file="../includes/footer.jsp"%>
