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

<div class="bigPictureWrapper">
  <div class="bigPicture"></div>
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
		    	  var fileCallPath =  encodeURIComponent(obj.uploadPath+ "/"+obj.uuid+"_"+obj.fileName);
		        
		    	  str += "<li><div><a href='/download?fileName="+fileCallPath+"' >"
		                 +"<img src='/resources/img/attach.png'>"+obj.fileName+"</a>"+
		                   "<span data-file=\'"+fileCallPath+"\' data-type='file'>x</span>" +"</div></li>";
		      }else{
		        //str += "<li>"+ obj.fileName+"</li>";
		        var fileCallPath =  encodeURIComponent(obj.uploadPath+ "/s_"+obj.uuid+"_"+obj.fileName);
                 
		        var originPath = obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName; 
                 originPath = originPath.replace(new RegExp(/\\/g),"/");
                 console.log(fileCallPath);
                 console.log(originPath);
		        str += "<li><a href=\"javascript:showImage(\'" + originPath+"\')\">" +
		                   "<img src='/display?fileName="+fileCallPath+"'></a>"+
		                	"<span data-file=\'" +fileCallPath+"\' data-type='image'> x </span></li>"
		      }
		    });
		    
		    uploadResult.append(str);
		  } 

//이미지 파일 
function showImage(fileCallPath){
	$(".bigPictureWrapper").css("display","flex").show();
	
	$(".bigPicture").html("<img src='/display?fileName="+fileCallPath+"'>").animate({width:'100%',height:'100%'},1000);
}

//bigPictureWrappe 처리
$(document).ready(function(){
	$(".bigPictureWrapper").on("click",function(e){
		$(".bigPicture").animate({width:'0%',height:'0%'},1000);
		setTimeout(function(){$(".bigPictureWrapper").hide();},1000);
	});
});

//x버튼 클릭시 삭제처리
$(document).ready(function(){
	$(".uploadResult").on("click","span",function(e){
		var targetFile = $(this).data("file");
		var type=$(this).data("type");
		console.log(targetFile);
		
		$.ajax({
			url:'/deleteFile',
			data:{fileName:targetFile, type:type},
			dataType:'text',
			type:'POST',
			success:function(result){
				alert(result);
			}
		});//$.ajax끝.
	});
});

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