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

var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");

var maxSize = 5242880; //5mb - 크기 체크

function checkExtension(fileName, fileSize){
	
	if(fileSize >= maxSize) {
		alert("파일 사이즈 초과");
		return false;
	}
	//정규표현식에 맞는 지여부 확인 메소드 test(값) -맞으면 true, 아니면 false
	if(regex.test(fileName)){
		alert("해당 종류의 파일은 업로드할수 없습니다.");
		return false;
	}
	
	return true;
}

$(document).ready(function(){
	$("#uploadBtn").on("click",function(e){
		//동적을 FormData요소 객체 생성
		var formData = new FormData();//<form></form>
		
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		
		console.log(files);
		
		//add files to formData
		for(var i=0;i<files.length; i++){
			//파일확장자와 크기 체크하여 기준에 맞지않으면 return처리;
			if(!checkExtension(files[i].name, files[i].size)) return false;
			
			formData.append("uploadFile",files[i]);//<form><input type='file' name='uploadFile'></form>
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