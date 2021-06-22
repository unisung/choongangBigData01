<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Schedule</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Schedule</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group">
          <label>Bno</label> <input class="form-control" name='seq'
            value='<c:out value="${schedule.seq }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${schedule.title }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Text area</label>
          <textarea class="form-control" rows="3" name='content'
            readonly="readonly"><c:out value="${schedule.content}" /></textarea>
        </div>

        <div class="form-group">
          <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${calendar.id }"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>times</label> <input class="form-control" name='startTime'
            value='<c:out value="${schedule.startTime}"/>' readonly="readonly">
        </div>
        <div class="form-group">
          <label>times</label> <input class="form-control" name='endTime'
            value='<c:out value="${schedule.endTime}"/>' readonly="readonly">
        </div>



<button data-oper='modify' class="btn btn-default">Modify</button>
<button data-oper='list' class="btn btn-info">List</button>



<form id='operForm' action="/calendar/modify" method="get">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
  <input type='hidden' id='id' name='id' value='<c:out value="${calendar.id }"/>'>
  <input type='hidden' name='y' value='<c:out value="${calendar.y }"/>'>
  <input type='hidden' name='m' value='<c:out value="${calendar.m }"/>'>
  <input type='hidden' name='d' value='<c:out value="${calendar.d }"/>'>
  <input type='hidden' name='seq' value='<c:out value="${calendar.seq}"/>'>  
 
</form>



      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->


<script type="text/javascript" src="/resources/js/reply.js"></script>

<script>
$(document).ready(function() {
	  
	  var operForm = $("#operForm"); 
	  
	  $("button[data-oper='modify']").on("click", function(e){
	    
	    operForm.attr("action","/calendar/modify").submit();
	    
	  });
	  
	    
	  $("button[data-oper='list']").on("click", function(e){
	    
	    operForm.find("#bno").remove();
	    operForm.attr("action","/calendar/monthly")
	    operForm.submit();
	    
	  });  
	});
</script>


<%@include file="../includes/footer.jsp"%>
