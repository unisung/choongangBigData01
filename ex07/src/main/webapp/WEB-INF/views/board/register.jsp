<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- security 태그 추가  -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	   			    	<label>Writer</label>
	   			    	<input class="form-control" name="writer" 
	   			    	          value='<sec:authentication property="principal.username"/>' readonly>
	   			    </div>
	   			    
	   			    <button type="submit" class="btn btn-default">Submit Button</button>
	   			    <button type="reset" class="btn btn-default">Reset Button</button>
	   			    <!-- 보안 토큰  -->
	   			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	   			   </form>
	   			
	   			</div>
	   			<!-- end panel-body  -->
	   	</div>
	   	<!--  end panel -->
	 </div>
</div>
<!--  /. row -->

<!--  파일 업로드 영역 추가  -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">File Attach</div>
			<div class="panel-body">
			   <div class="form-group uploadDiv">
			   	<input type="file" name='uploadFile' multiple>
			   </div>
			   
			    <div class="uploadResult">
			    	<ul></ul>
			    </div>
			</div><!-- /. end panel-body -->
		</div><!-- /.end panel-->
	</div>
</div> <!-- /.row -->

<script>
$(document).ready(function(){
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)");
	var maxSize=5242880;//5 mb
	
	function checkExtension(fileName, fileSize){
		
		if(fileSize>=maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}
	
//파일 선택 변경시이벤트 처리	
 $("input[type='file']").change(function(e){
	 var formData = new FormData();//<form>요소 생성
	 var inputFile = $("input[name='uploadFile']");
	 //선택된 파일 목록 출력
	 var files = inputFile[0].files;
	 
	 for(var i=0;i<files.length; i++){
		 if(!checkExtension(files[i].name, files[i].size)){
			 return false;
		 }
		 formData.append("uploadFile", files[i]); //<form><input type='file' name='uploadFile'>
	 }
	 
	 //파일 전송
	 $.ajax({
		 url:'/uploadAjaxAction',
		 processData:false,
		 contentType:false,
		 data:formData,
		 type:'POST',
		 dataType:'json',
		 success:function(result){
			 //console.log(result);
			 showUploadResult(result);
			 }
	 });//$.ajax 끝.
	 
 });	
	
 function showUploadResult(uploadResultArr){
	    
	    var str = "";
	    
	    var uploadUL = $(".uploadResult ul");
	    
	    $(uploadResultArr).each(function(i, obj){
	      
	      if(!obj.image){
	    	  var fileCallPath =  encodeURIComponent(obj.uploadPath+ "/"+obj.uuid+"_"+obj.fileName);
	        
	    	   var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
	    	   
	    	  str += "<li data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid;
	    	  str += "' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'><div>";
	    	  str +="<span> "+obj.fileName+"</span>";
	    	  str +="<button type='button'  data-file=\'"+fileCallPath+"\' data-type='file' ";
	    	  str +=" class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
	    	  str +="<img src='/resources/img/attach.png'></a></div></li>";

	      }else{
	        var fileCallPath =  encodeURIComponent(obj.uploadPath+ "/s_"+obj.uuid+"_"+obj.fileName);
          
	        str += "<li data-path='"+obj.uploadPath+"'";
	        str += " data-uuid='"+obj.uuid+"' data-filename='";
	        str += obj.fileName+"' data-type='"+obj.image+"'><div>";
	        str +="<span>" + obj.fileName+"</span>";
	        str +="<button type='button'  data-file=\'"+fileCallPath+"\' ";
	        str +=" data-type='image' class='btn btn-warning btn-circle'>";
	        str +="<i class='fa fa-times'></i></button><br>";
	        str +="<img src='/display?fileName="+fileCallPath+"' ></div></li>";
	        
	      }
	      
	    });
	    
	    uploadUL.append(str);
	  } //showUploadResult 끝.
	  
/* 파일 업로드 처리 후 결과 화면 클릭시 처리 이벤트 */	  
$(".uploadResult").on("click","button",function(e){
	console.log("delete file");
	
	var targetFile =$(this).data("file");
	var type = $(this).data("type");
	
	var targetLi = $(this).closest("li");
	
	$.ajax({
		url:'/deleteFile',
		data:{fileName:targetFile, type:type},
		dataType:'text',
		type:'POST',
		success:function(result){alert(result); 
		                                      targetLi.remove();}
	});
});//

$(document).ready(function(e){
	
	var formObj = $("form[role='form']");
	
	$("button[type='submit']").on("click", function(e){
		e.preventDefault();
		
		console.log("submit clicked");
		
		var str="";
		
		 $(".uploadResult ul li").each(function(i,obj){
			 var jobj = $(obj);
			 
			 console.log(jobj);
			 console.log("----------------------------");
			 console.log(jobj.data("filename"));
		
			 /* 첨부파일 리스트 정보를 hidden으로 추가 */
        str +="<input type='hidden'  name='attachList["+i+"].fileName'  value='"
                  +jobj.data("filename")+"'>";
        str +="<input type='hidden'  name='attachList["+i+"].uuid'  value='"
                 +jobj.data("uuid")+"'>";
        str +="<input type='hidden'  name='attachList["+i+"].uploadPath'  value='"
                +jobj.data("path")+"'>";
        str+="<input type='hidden' name='attachList["+i+"].fileType' value='" 
               +jobj.data("type")+"'>";         
        
		 });//each 끝.
		 
		 console.log(str);
		
		 /* hidden으로 추가된 요소를 저장후 게시글 등록 controller로 이동. */
		 formObj.append(str).submit();
	});
});

 
 
});

</script>


<%@include file="../includes/footer.jsp"%>