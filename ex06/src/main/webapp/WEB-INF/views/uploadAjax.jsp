<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Upload with Ajax</h1>

<div class='uploadDiv'>
<input type='file' name='uploadFile' multiple>
</div>

<button id='uploadBtn'>Upload</button>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#uploadBtn").on("click",function(e){
		var formData = new FormData();
		
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		
		console.log(files);
		
		//add files to formData
		for(var i=0;i<files.length; i++){
			formData.append("uploadFile",files[i]);
		}
		
		//전송처리
		$.ajax({
			url:'/uploadAjaxAction',
			processData:false,
			contentType:false,
			data:formData,
			type:'post',
			success:function(result){alert("Uploaded");}
		});
		
	});
});
</script>

</body>
</html>