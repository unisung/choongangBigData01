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
</div>
<!--  /. row -->

<div class="row">
  <div class="col-lg-12">

    <!-- /.panel -->
    <div class="panel panel-default">
      <div class="panel-heading">
        <i class="fa fa-comments fa-fw"></i> Reply
        <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
      </div>      
      
      <!-- /.panel-heading -->
      <div class="panel-body">        
        <ul class="chat">
        </ul>
        <!-- ./ end ul -->
      </div>
      <!-- /.panel .chat-panel -->

	<div class="panel-footer"></div>


		</div>
  </div>
  <!-- ./ end row -->
  
</div>

<!-- Modal -->
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
        aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">&times;</button>
              <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
            </div>
            
            <div class="modal-body">
              <div class="form-group">
                <label>Reply</label> 
                <input class="form-control" name='reply' value='New Reply!!!!'>
              </div>      
              <div class="form-group">
                <label>Replyer</label> 
                <input class="form-control" name='replyer' value='replyer'>
              </div>
              <div class="form-group">
                <label>Reply Date</label> 
                <input class="form-control" name='replyDate' value='2018-01-01 13:13'>
              </div>
            </div>
            
    <div class="modal-footer">
        <button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
        <button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
        <button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
        <button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
      </div>          
     </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->




	  <form id='operForm' action='/board/modify' method='get'>
	       <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
	       <input type='hidden' id='pageNum' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
	       <input type='hidden' id='amount' name='amount' value='<c:out value="${cri.amount}"/>'>
	       <input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
           <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
	  </form>

<!--  reply.js 라이브러리 사용 등록 -->
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
 $(document).ready(function(){
	 console.log("===============");
	 console.log("JS TEST");
	 
	 var bnoValue = '<c:out value="${board.bno}"/>';
	 var replyUL =$(".chat");
	 
	 showList(1);
	 
	 function showList(page){
		 replyService.getList({bno:bnoValue, page:page||1}, function(list){
			  var str="";
			  /* 댓글 리스트가 넘어오지 않았거나, 빈 리스트가 넘어왔다면 return */
			  if(list ==null|| list.length==0){
				  replyUL.html("");
				  return;
			  }
			  /* 댓글 리스트가 넘어왔으면 처리 */
			  for(var i=0,len=list.length||0; i<len; i++){
				  str+="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
				  str+="<div><div class='header'><strong class='primary-font'>"+list[i].replyer+"</strong>";
				  str+="   <small class='pull-right text-muted'>"+list[i].replyDate+"</small></div>";
				  str+="   <p>"+list[i].reply+"</p></div>";
				  str+="</li>";
			  }
			  
			  replyUL.html(str);
			 
		 });//end function
	 }// end showList.
	 
	 var modal = $(".modal");
	 var modalInputReply = modal.find("input[name='reply']");
	 var modalInputReplyer = modal.find("input[name='replyer']");
	 var modalInputReplyDate = modal.find("input[name='replyDate']");
	 
	 var modalModBtn = $("#modalModBtn");
	 var modalRemoveBtn = $("#modalRemoveBtn");
	 var modalRegisterBtn = $("#modalRegisterBtn");
	 
	 /* 댓글 등록 버튼 클릭 이벤트 처리 */
	 $("#addReplyBtn").on("click",function(e){
		 modal.find("input").val("");
		 modalInputReplyDate.closest("div").hide();
		 modal.find("button[id != 'modalCloseBtn']").hide();
		 
		 modalRegisterBtn.show();
		 
		 $(".modal").modal("show");
	 });
	 
	 replyService.add({reply:"JS Test", replyer:"tester", bno:bnoValue},
			                     function(result){alert("RESULT: " +result);});
	 
	 replyService.getList({bno:bnoValue,page:1},function(list){
		 for(var i=0, len=list.length||0; i<len;i++){
			 console.log(list[i]);
		 }
	 });
	 
	 replyService.remove(42, function(count){
		    console.log(count);
		    
		    if(count==='success'){
		    	alert('REMOVED');
		    }
	      }
		    ,
		    function(err){
		    	alert("ERROR....");
		    }
        );
	 
	 replyService.update({rno:43, bno:bnoValue, reply:"Modified Reply...."},
			                       function(result){alert("수정완료");}
	                               );
	 
	 replyService.get(43, function(data){console.log(data);});
	 
 });
</script>
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