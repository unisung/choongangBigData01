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
	   			    <sec:authentication property="principal"  var="pinfo"/>
	   			    <sec:authorize access="isAuthenticated()">
	   			    	<c:if test="${pinfo.username eq board.writer}">
	   			    <button type="submit"  data-oper='modify' class="btn btn-default">Modify</button>
	   			    <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
	   			    	</c:if>	   			    
	   			    </sec:authorize>
	   			    <button type="submit" data-oper='list' class="btn btn-info">List</button>
	   			    
	   			    <!-- ?????? ??????  -->
	   			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	   			   </form>
	   			
	   			</div>
	   			<!-- end panel-body  -->
	   	</div>
	   	<!--  end panel -->
	 </div>
</div>
<!--  /. row -->

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
 list-style: none; /* li??? bullet?????? */ 
 padding:10px;/* ?????? ?????? 10px */
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
      <div class="panel panel-default">
      	<div class="panel-heading">Files 	</div>
      	<!-- /.panel-heaing -->
      	<div class="panel-body">
      	       <div class="form-group uploadDiv">
      	            <input type="file" name='uploadFile' multiple>
      	       </div>
      	
      		 <div class='uploadResult'>
      		   <ul></ul>
      		 </div>
      		 
      		 
      	</div><!-- end panel-body -->
      
      </div><!--  end panel -->
  </div>
</div><!--  end row. -->


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
           var keywordTag = $("input[name='keyword']").clone();
           var typeTag = $("input[name='type']").clone();
			
			/* form????????? input ???????????? ?????? ?????? */
			formObj.empty();
			
			formObj.append(pageNumTag);//<form><input type='hidden' name='pageNum' value='???'>
			formObj.append(amountTag);//                <input type='hidden' name='amount' value='10'></form>
		    formObj.append(keywordTag);
		    formObj.append(typeTag);
		}else if(operation==='modify'){
			console.log("submit clicked");
			
			var str="";
			
			$(".uploadResult ul li").each(function(i,obj){
				var jobj = $(obj);
				
				console.log(jobj);
				
				str +="<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
				str +="<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
				str +="<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
				str +="<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data("type")+"'>";
			});
			
			formObj.append(str).submit();
		}
		/* ???????????? ???????????? */
		formObj.submit();
	}); // "button".on("click") ????????? ???.
	
});
</script>
<script>
//???????????? ????????? ?????????
$(document).ready(function(){
	(function(){
		var bno ='<c:out value="${board.bno}"/>';
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
			    +"<span>"+attach.fileName+"</span>"
			    +"<button type='button' data-file=\'"+fileCallPath+"\' data-type='image' "
			    +" class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>"
			    +"<img src='/display?fileName="+fileCallPath+"'></div></li>";
				 }else{
			str+="<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"
			    +attach.fileName+"' data-type='"+attach.fileType+"'>"
			    +"<div><span> "+attach.fileName+"</span><br>"
			    +"<button type='button'  data-file=\'"+fileCallPath+"\' data-type='file' "
			    +" class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>"
			    +"<img src='/resources/img/attach.png'></a></div></li>";		 
				 }
			 });/* end each().  */
			 
			//???????????? ????????? ?????????
			$(".uploadResult ul").html(str);
		});
		
	
	})();//?????? ????????????
	
	//???????????? ????????? ????????? ??????
	$(".uploadResult").on("click","button",function(e){
		console.log("delete file");
		
		if(confirm("Remove this file? ")){
			var targetLi = $(this).closest("li");
			targetLi.remove();
		}
	});
	
	/* ?????? ?????? */
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var maxSize = 5242880;//5MB
	
	function checkExtension(fileName, fileSize){
		if(fileSize >=maxSize){
			alert("?????? ????????? ??????");
			return false;
		}
		if(regex.test(fileName)){
			alert("?????? ????????? ????????? ????????? ??? ??? ????????????.");
			return false;
		}
		return true;
	}
	
var csrfHeaderName ="${_csrf.headerName}";
var csrfTokenValue="${_csrf.token}";
	
	$("input[type='file']").change(function(e){
		var formData = new FormData();
		
		var inputFile = $("input[name='uploadFile']");
		
		var files = inputFile[0].files;
		
		for(var i=0;i<files.length;i++){
			if(!checkExtension(files[i].name, files[i].size)) return false;
			
		    formData.append("uploadFile",files[i]);
		}
		
		//???????????? upload??????
		$.ajax(
				{
					url:'/uploadAjaxAction',
					processData:false,
					contentType:false,
					
					/* ???????????? ??????  */
					beforeSend:function(xhr){
						xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
					},
					
					data:formData,
					type:'POST',
					dataType:'json',
					success:function(result){
						console.log(result);
						showUploadResult(result);//????????? ?????? ?????? ?????? ??????
					}
				});//$.ajax???.
		
	});//change() ???.
	
});

//upload???????????? ??????
function showUploadResult(uploadResultArr){
	//upload?????? ????????? ??????
	if(!uploadResultArr || uploadResultArr.length==0 ){return;}
	//upload?????? ??????
	
	var uploadUL = $(".uploadResult ul");
	var str="";
	
	$(uploadResultArr).each(function(i,obj){
		if(obj.image){
			var fileCallPath=
				  encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
			
			str+="<li data-path='"+obj.uploadPath+"'";
			str+=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'";
			str+=" ><div><span> "+obj.fileName+" </span>";
			str+="<button type='button' data-file=\'"+fileCallPath+"\' ";
			str+=" data-type='image' class='btn btn-warning btn-circle'>";
			str+="<i class='fa fa-times'></i></button><br>";
			str+="<img src='/display?fileName="+fileCallPath+"'></div></li>";
			
		}else{
		
			var fileCallPath = 
				encodeURIComponent(obj.uploadPath + "/" +obj.uuid+"_"+obj.fileName);
			var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
			
			 str+="<li data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='";
			 str+=obj.fileName+"' data-type='"+obj.image+"'>";
			 str+= "<div><span>"+obj.fileName+"</span>";
			 str+="<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' ";
			 str+=" class='btn brn-warning btn-circle'><i class='fa fa-times'></i>";
			 str+="</button><br><img src='/resources/img/attach.png'></a></div></li>";
		}
		
	});
	  /* each() ????????? ?????? */
		uploadUL.append(str);
};

</script>


<%@include file="../includes/footer.jsp"%>