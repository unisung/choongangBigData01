<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

 



</head>

<body>

<div class="container">
  <div class="row">
  	<div class="col-md-4 col-md-offset-4">
  		<div class="login-panel panel panel-default">
  			<div class="panel-heading">
  				<h3 class="panel-title">Log out</h3>
  			</div>
  			
  			<div class="panel-body">
  			  
		<form role="form" action="/customLogout" method="post">
		<fieldset>
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<a href="index.html" class="btn btn-lg btn-success btn-block">Logout</a>
		
		</fieldset>
		</form>
  			</div>
  		</div>
  	</div>
  </div>
</div>



 
 <!-- 로그아웃 버튼 클릭시 처리  -->   
 <script>
 $(".btn-success").on("click",function(e){
	 e.preventDefault();
	 $("form").submit();
 });
 </script> 
 

</body>
</html>