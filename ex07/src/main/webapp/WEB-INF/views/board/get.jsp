<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>@
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@include file="../includes/header.jsp" %>

<style>
 .uploadResult{
 width:100%;
 background-color:gray;
 }
 
 .uploadResult ul{
  display: flex;
  flex-flow: row;
  justify-content: center;
  align-items: center;
 }
 
 .uploadResult ul li {
 list-style: none; /* li의 bullet제거 */ 
 padding:10px;/* 안쪽 여백 10px */
 }
 
 .uploadResult ul li img{
 width:20px;
 }
 
 .bigPictureWrapper{
  position:absolute;
  display:none;
  justify-content: center;
  align-items:center;
  width: 100%;
  height: 100%;
  top:0%;
  background-color: gray;
  z-index:100;
  background: rgba(255,255,255,0.5);
 }
 .bigPicture{
   position: relative;
   display:flex;
   justify-content: center;
   align-items: center;
 }
 .bigPicture img{
 width: 600px;
 }
</style>

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
	   			    
	   			    <sec:authentication property="principal" var="pinfo"/>
	   			    <sec:authorize access="isAuthenticated()">
						<c:if test="${pinfo.username eq board.writer}">
	   			    <button type="submit"  data-oper='modify' class="btn btn-default">Modify</button>						     
	   			    <button type="submit" data-oper='remove' class="btn btn-danger" disabled>Remove</button>
						</c:if>	   			    
	   			    </sec:authorize>
	   			    
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
      <div class="panel panel-default">
      	<div class="panel-heading">Files 	</div>
      	<!-- /.panel-heaing -->
      	<div class="panel-body">
      		 <div class='uploadResult'>
      		   <ul></ul>
      		 </div>
      	</div><!-- end panel-body -->
      
      </div><!--  end panel -->
  </div>
</div><!--  end row. -->

<div class="bigPictureWrapper">
  <div class="bigPicture"></div>
</div>

<div class="row">
  <div class="col-lg-12">

    <!-- /.panel -->
    <div class="panel panel-default">
      <div class="panel-heading">
        <i class="fa fa-comments fa-fw"></i> Reply
        <!-- 로그인 한 사용자만 댓글 등록 처리 -->
      <sec:authorize access="isAuthenticated()">
        <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
      </sec:authorize>  
      
      
      </div>      
      
      <!-- /.panel-heading -->
      <div class="panel-body">        
        <ul class="chat">
        </ul>
        <!-- ./ end ul -->
      </div>
      
      <!-- /.panel .chat-panel -->

	<div class="panel-footer">
	
	</div>


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
                <input class="form-control" name='replyer' value='replyer' readonly="readonly">
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
/* 첨부파일 	불러오기  */
$(document).ready(function(){
	var bno = '<c:out value='${board.bno}'/>';
	
	$.getJSON("/board/getAttachList", {bno:bno}, function(arr){
		 console.log("attachList:", arr);
		 
		 var str="";
		 
		 $(arr).each(function(i, attach){
			 //image type check
			 if(attach.fileType){
				 var fileCallPath =
					encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid+"_"+attach.fileName);
		str+="<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"
		    +attach.fileName+"' data-type='"+attach.fileType+"'><div>"
		    +"<img src='/display?fileName="+fileCallPath+"'></div></li>";
			 }else{
		str+="<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"
		    +attach.fileName+"' data-type='"+attach.fileType+"'>"
		    +"<div><span> "+attach.fileName+"</span><br>"
		    +"<img src='/resources/img/attach.png'></a></div></li>";		 
			 }
		 });/* end each().  */
		 
		 $(".uploadResult ul").html(str);
	});//end getJSON.
	
	/* 첨부파일 클릭시 이벤트 처리 */
	$(".uploadResult").on("click","li", function(e){
		console.log("view image");
		
		var liObj = $(this);//클릭한 li요소 얻기
		
		var path = encodeURIComponent(liObj.data("path")+"/"+liObj.data("uuid")+"_"+liObj.data("filename"));
		
		if(liObj.data("type")){//image타입이면 
			showImage(path.replace(new RegExp(/\\/g),"/"));//이미지 출력
		}else{//일반파일이면 다운로드
			self.location="/download?fileName="+path;
		}
	});//on() 끝.
	
	/* 이미지 출력 함수 */
	function showImage(fileCallPath){
		alert(fileCallPath);
		
		//원본 이미지 영역 스타일을 display:none -> display:flex로 변경후 화면에 보이기 show();
		$(".bigPictureWrapper").css("display","flex").show();
		
		//이미지보이기 animate(속성, 시간);
		$(".bigPicture").html("<img src='/display?fileName="+fileCallPath+"'>")
		                       .animate({width:'100%',height:'100%'},1000);
	}
	
	/* 원본 이미지 클릭시 닫기 이벤트 */
	$(".bigPictureWrapper").on("click",function(e){
		$(".bigPicture").animate({width:'0%',height:'0%'},1000);
		/* 1초 후 처리 함수 setTimeout(함수, 시간) */
		setTimeout(function(){
			$('.bigPictureWrapper').hide();//화면에서 사라지기
		},1000);
	}); //on() 이벤트 끝.
	
});
</script>
<script>
 $(document).ready(function(){
	 console.log("===============");
	 console.log("JS TEST");
	 
	 var bnoValue = '<c:out value="${board.bno}"/>';
	 var replyUL =$(".chat");
	 
	 showList(1);
	 
   var pageNum = 1;
   var replyPageFooter = $(".panel-footer");
   
   function showReplyPage(replyCnt){
	   //끝페이지 번호
	   var endNum = Math.ceil(pageNum / 10.0) * 10;
	   //시작페이지 번호
	   var startNum = endNum - 9;
	   
	   //이전 페이지 그룹 버튼 활성화 여부처리
	   var prev = startNum  !=1;
	   //다음 페이지 그룹 버튼 활성화 여부처리
	   var next = false;
	   
	   //종료페이지 보정처리
	   if(endNum * 10 >= replyCnt){
		   endNum = Math.ceil(replyCnt/10.0);
	   }
	   //다음 페이지 그룹 활성화 처리
	   if(endNum*10 < replyCnt) {
		   next = true;
	   }
	   //
	  var str = "<ul class='pagination pull-right'>";
	  
	  if(prev){
		  str+="<li class='page-item'><a class='page-link' href='"
		                                                +(startNum - 1)+"'>Previous</a></li>"; 
	  }
	  for(var i=startNum; i<=endNum; i++){
		  var active = pageNum==i?"active":"";
		  str +="<li class='page-item " +active +"' ><a class='page-link' href='" +i+"'>"+i+"</a></li>"; 
	  }
	 if(next){
		 str +="<li class='page-item'><a class='page-link' href='"+(endNum +1) +"'></a></li>";
	 } 
	 str += "</ul>";
	
	 //콘솔에 출력
	 console.log(str);
	 
	 //footer영역에 붙이기
	 replyPageFooter.html(str);
   }
	 
	 
// repyPageFooter클릭시 이벤트 처리
replyPageFooter.on("click","li a",function(e){
	e.preventDefault();
	
	console.log("page click");
	
	var targetPageNum = $(this).attr("href");
	
	console.log("targetNum: ", targetPageNum);
	
	pageNum = targetPageNum;
	
	showList(pageNum);
	
});

/****************************************/	 
	 //callback함수 파라미터 처리
	 function showList(page){
		 replyService.getList({bno:bnoValue, page:page||1}, function(replyCnt, list){
			  var str="";
			  
			  console.log("replyCnt",replyCnt);
			  console.log("list: ", list);
			  console.log(list);
			  
			  //-1이 전달되면 마지막 페이지 보여주기
			  if(page == -1){
				  pageNum = Math.ceil(replyCnt/10.0);
				  showList(pageNum);
				  return;
			  }
			  
			  
			  /* 댓글 리스트가 넘어오지 않았거나, 빈 리스트가 넘어왔다면 return */
			  if(list ==null|| list.length==0){
				  replyUL.html("");
				  return;
			  }
			  /* 댓글 리스트가 넘어왔으면 처리 */
			  for(var i=0,len=list.length||0; i<len; i++){
				  str+="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
				  str+="<div><div class='header'><strong class='primary-font'>"+list[i].replyer+"</strong>";
				  str+="   <small class='pull-right text-muted'>"+replyService.displayTime(list[i].replyDate)+"</small></div>";
				  str+="   <p>"+list[i].reply+"</p></div>";
				  str+="</li>";
			  }
			  
			  replyUL.html(str);
			  
			  //페이지 네이게이션 부분 추가
			  showReplyPage(replyCnt);
			 
		 },function(err){alert(err);});//end function
	 }// end showList.
	 
	 var modal = $(".modal");
	 var modalInputReply = modal.find("input[name='reply']");
	 var modalInputReplyer = modal.find("input[name='replyer']");
	 var modalInputReplyDate = modal.find("input[name='replyDate']");
	 
	 var modalModBtn = $("#modalModBtn");
	 var modalRemoveBtn = $("#modalRemoveBtn");
	 var modalRegisterBtn = $("#modalRegisterBtn");
	 
	 /* 로그인한 작성자만 댓글 작성하게 처리 */
     var replyer = null;
	 
	 <sec:authorize access="isAuthenticated()">
	     replyer ='<sec:authentication property="principal.username"/>';
	 </sec:authorize>
	 
	 var csrfHeaderName="${_csrf.headerName}";
	 var csrfTokenValue="${_csrf.token}";
	 
	 
	 /* 댓글 등록 버튼 클릭 이벤트 처리 */
	 $("#addReplyBtn").on("click",function(e){
		 modal.find("input").val("");
		 /* 댓글 작성자 모달에 로그인 유저의 id 등록처리 */
		 modal.find("input[name='replyer']").val(replyer);
		 
		 modalInputReplyDate.closest("div").hide();
		 modal.find("button[id != 'modalCloseBtn']").hide();
		 
		 modalRegisterBtn.show();
		 
		 $(".modal").modal("show");
	 });
	 
	 //Ajax security header 전송처리....
	 $(document).ajaxSend(function(e, xhr, options){
		 xhr.setRequestHeader(csrfHeaderName,csrfTokenValue)
	 });
	 
	 /* 댓글 등록 모달내 등록 버튼 클릭 이벤트 처리 */
	 modalRegisterBtn.on("click",function(e){
		   var reply={reply:modalInputReply.val(),
				             replyer:modalInputReplyer.val(),
				             bno:bnoValue};
		   
		   replyService.add(reply, function(result){
			    alert(result);
			    modal.find("input").val("");//모달창의 input태그 초기화
			    modal.modal("hide");//모달창 숨기기
			    
		   //등록후 댓글 리스트 재 출력
		  // showList(1);
			  showList(-1);
		   });
		 });
	 /*--------------------------*/
	 
 /* 모달 닫기 버튼 클릭 이벤트 처리 */
 $("#modalCloseBtn").on("click",function(e){
	 modal.modal('hide');
 });
 
	 
	 //댓글 조회 클릭 이벤트 처리
	 $(".chat").on("click","li",function(e){
		 var rno=$(this).data("rno");// this<- <li>
		 
		 replyService.get(rno,function(reply){
			 // 모달창에 데이타 세팅
			 modalInputReply.val(reply.reply);
			 modalInputReplyer.val(reply.replyer);
			 modalInputReplyDate.val(replyService.displayTime(reply.replyDate))
			                                 .attr("readonly","readonly");
			 modal.data("rno",reply.rno);
			 
			 //모달창 버튼 초기화
			 modal.find("button[id!='modalCloseBtn']").hide();//클로즈버튼 외 숨김처리
			 modalModBtn.show();//수정버튼 보이기
			 modalRemoveBtn.show();//삭제버튼 보이기
			 
			 //모달 화면에 나타내기
			 $(".modal").modal("show");
		 });
	 });
	 
/*------------------------------------------------------*/
	 
	//댓글 조회 화면의 수정버튼 이벤트 처리
	 modalModBtn.on("click",function(e){
		 //수정할 JSON데이타 처리
		 var reply = {rno:modal.data("rno"), reply:modalInputReply.val()};
		 
		 //update()함수 호출
		 replyService.update(reply,function(result){
			 alert(result);
			 modal.modal("hide");
			 showList(pageNum);//댓글영역 refresh
		 });
	 });

/*------------------------------------------------------*/

//댓글 조회 화면의 삭제버튼 이벤트 처리
	 modalRemoveBtn.on("click", function(e){
		 //삭제할 댓글 번호 얻기
		 var rno = modal.data("rno");
		  
		 //삭제처리메소드 호출
		 replyService.remove(rno, function(result){
			 alert(result);
			 modal.modal("hide");
			 showList(pageNum);
		 });
	 });

 
 
 
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