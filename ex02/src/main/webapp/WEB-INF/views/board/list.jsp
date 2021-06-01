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
  		      
  		      <!--  검색 -->
  		      <div class="row">
  		        <div class="col-lg-12">
  		         <form id="searchForm" action="/board/list" method="get">
  		           <select name='type'>
  		           <option value=""  <c:out  value="${pageMaker.cri.type==null?'selected':''}"/>>----</option>
  		           <option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목
  		           <option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
  		           <option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
  		           <option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목 or 내용</option>
  		           <option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목 or 작성자</option>
  		           <option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW'?'selected':''}"/> >제목 or 내용 or 작성자</option>
  		           </select>
  		           <input name='keyword' type="text" value='<c:out value="${pageMaker.cri.keyword}"/>'>
  		           <input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
  		           <input type='hidden' name='amount'' value='${pageMaker.cri.amount}'>
  		           <button class="btn btn-default">Search</button>
  		         </form>

  		        </div>
  		      
  		      </div>
  		      
  		      <ul class="pagination">
  		      
  		      <c:if test="${pageMaker.prev}">
  		      <li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
  		      <a href="${pageMaker.startPage -1}">Previous</a></li>
  		      </c:if>
  		       <c:if test="${!pageMaker.prev}">
  		      <li class="paginate_button previous disabled" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
  		      <a href="${pageMaker.startPage -1}">Previous</a></li>
  		      </c:if>
  		      
  		      <c:forEach var="num"  begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	  		       <c:if test="${num==pageMaker.cri.pageNum}">
	  		       <li class="paginate_button active" aria-controls="dataTables-example" tabindex="0">
	  		        <a href="${num}">${num}</a></li>
	  		       </c:if>
	  		       <c:if test="${num!=pageMaker.cri.pageNum}">
	  		       <li class="paginate_button" aria-controls="dataTables-example" tabindex="0">
	  		        <a href="${num}">${num}</a></li>
	  		       </c:if>
  		      </c:forEach>
  		      
  		      <c:if test="${pageMaker.next}">
  		      <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next">
  		      <a href="${pageMaker.endPage + 1}">Next</a></li>
  		      </c:if>
  		      </ul>
  		     
  		     </div>
  		</div>
  </div>
</div>            
<table>

</table>

<form id="actionForm" action="/board/list" method="get">
 <input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
 <input type='hidden' name='amount' value='${pageMaker.cri.amount }'>
 <input type='hidden' name='type' value='<c:out value="${pageMaker.cri.type}"/>'>
 <input type='hidden' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>'>
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
	
	/* 페이지 네비게이션 버튼 클릭시 */
	$('.paginate_button a').on("click",function(e){
		e.preventDefault();
		
		console.log('click');
		/* 클릭한 <a>태그의 페이지번호를 actionForm의 input tage 에 설정 val(값); */
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();//action으로 전송처리
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
<script>
$(document).ready(function(){
	var searchForm=$("#searchForm");

	$("#searchForm button").on("click",function(e){
		if(!searchForm.find("option:selected").val()){
			alert("검색 조건을 선택하세요");
			return false;
		}
		
		if(!searchForm.find("input[name='keyword']").val()){
			alert("검색 키워드를 입력하세요");
			return false;
		}
		
		searchForm.find("input[name='pageNum']").val("1");
		e.preventDefault();
		
		searchForm.submit();
		
	});
	
});



</script>

 <%@include file="../includes/footer.jsp"%>