<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>      
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
<div class="row">
  <div class="col-lg-12">
  		<div class="panel panel-default">
  		     <div class="panel-heading">
  		        BoardList Page
  		        <button id="regBtn" type="button" class="btn btn-xs pull-right">Register</button>
  		     </div>
  		     
  		     <div class="panel-body">
  		      <table class="table table-striped table-bordered table-hover">
  		        <thead>
  		         <tr>
  		           <th>#번호</th>
  		           <th>제목</th>
  		           <th>작성자</th>
  		           <th>작성일</th>
  		           <th>수정일</th>
  		         </tr>
  		        </thead>
  		        
  		      <c:forEach items="${list}" var="board">
  		        <tr>
  		          <td><c:out value="${board.bno}"/></td>
  		           <td><a class="move" href='<c:out value="${board.bno}"/>'><c:out value="${board.title}"/></a></td>
  		           <td><c:out value="${board.writer}"/></td>
  		           <td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
  		           <td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd"/></td>
  		        </tr>
  		      </c:forEach>
  		      </table>
  		     
  		     </div>
  		</div>
  </div>
</div>            
<table>

</table>

<form id="actionForm" action="/board/list" method="get">
</form>

                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                           처리가 완료되었습니다.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->

<script>
$(document).ready(function(){
	var actionForm = $("#actionForm");
      
	$(".move").on("click",function(e){
		var val = $(this).attr("href");
		//alert(val);
		//$("#myModal").modal("show");
		 /* 링크/태그<a>의 기능을 해제 */ 
		 e.preventDefault();
		 /* get속성 - 요소.attr("속성명"); , set속성 - 요소.attr("속성명","속성값");*/
		//actionForm.append("<input type='hidden' name='bno' value='$(this).attr("href")'>");
		//actionForm.attr("action","/board/get");// <form id="actionForm" action="/board/get" method="get">
		actionForm.append("<input type='hidden' name='bno' value="+val+">");
		actionForm.attr("action","/board/get");
		actionForm.submit();
	});	
});
</script>                            
<script>
$(document).ready(function(){
	var result ='<c:out value="${result}"/>';
	
	checkModal(result);
	
	history.replaceState({},null,null);
	
	function checkModal(result){
		if(result===''||history.state){
			return;
		}
		if(parseInt(result) > 0){
			$(".modal-body").html("게시글 "+parseInt(result) + " 번이 등록 되었습니다.");
		}
		/* 모달 팝업 */
		$("#myModal").modal("show");
	}
});
</script>
<script>
 $(document).ready(function(){
	 $("#regBtn").on("click",function(){
		 self.location="/board/register";
	 });
 });
</script>

 <%@include file="../includes/footer.jsp"%>