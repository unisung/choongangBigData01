<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
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
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Upload with Ajax</h1>

<div class='uploadDiv'>
<input type='file' name='uploadFile' multiple>
</div>
<button id='uploadBtn'>Upload</button>

<div class="uploadResult">
  <ul>
  </ul>
</div>

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

var uploadResult =$(".uploadResult ul");
//upload결과 출력함수

		 
		 function showUploadedFile(uploadResultArr){
			    
		    var str = "";
		    
		    $(uploadResultArr).each(function(i, obj){
		      
		      if(!obj.image){
		        str += "<li><img src='/resources/img/attach.png'>"+obj.fileName+"</li>";
		      }else{
		        //str += "<li>"+ obj.fileName+"</li>";
		        
		        var fileCallPath =  encodeURIComponent(obj.uploadPath+ "/s_"+obj.uuid+"_"+obj.fileName);
                 var originPath = obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName; 
                 originPath = originPath.replace(new RegExp(/\\/g),"/");
                 console.log(fileCallPath);
                 console.log(originPath);
		        str += "<li><img src='/display?fileName="+fileCallPath+"'><li>";
		      }
		    });
		    
		    uploadResult.append(str);
		  } 


$(document).ready(function(){
	//요소 복제
	var cloneObj = $(".uploadDiv").clone();
	
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
			dataType:'json',//응답 데이타 json타입
			success:function(result){
				//alert("Uploaded");
				console.log(result);
				
				showUploadedFile(result);
				
				$(".uploadDiv").html(cloneObj.html());
			}
		});
	});
});
</script>

</body>
</html>