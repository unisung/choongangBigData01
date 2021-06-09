<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product List Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
.container {
	padding: 15px;
	border: 1px solid black;
	margin: 0 auto;
	width:1024px;
}
span {
	font-weight:bold;
	margin-left:10px;
}

ul {
	list-style-type: none;
	font-weight:bold;
	display:flex;
	/* border: 1px solid black; */
	width:320px;
	text-align: left;
	padding:0;
	margin-top:35px;
	margin-left:10px;
}

li a{
	text-decoration: none;
	color:gray;
}

li {
	color:gray;
}

.sub {
	margin-top:-2px;
}

.searchForm {
	/* border:1px solid black; */
	display:inline-block;
	float:right;
	position:relative;
	top:-40px;
}

#searchForm {
	width: 160px;
	height: 23px;
	position:relative;
	top:-9px;
	border: 1px solid lightgray;
	border-radius: 4px;
}

#search_img {
	background-image: url(searchButton.PNG);
	background-position:2px center;
	background-repeat:no-repeat;
	position:relative;
	width:40px;
	height:27px;
	border:none;
	cursor:pointer;
	border-radius: 4px;
}

table {
  border-collapse: collapse;
  width: 100%;
  position:relative;
  top:-20px;
  margin-top:60px;
}

td {
  height: 30px;
  color: gray;
  text-align:center;
}
</style>

</head>
<body>

<div class="container">
	<span style="font-size:20px;">NEW</span>
	<span style="color:gray; font-size:17px;">신상품</span> <br>

	<ul>
		<li><a href="#">가격 높은순&nbsp;</a></li>
		<li class="sub">|&nbsp; </li>
		<li><a href="#">가격 낮은순&nbsp;</a></li>
		<li class="sub">|&nbsp; </li>
		<li><a href="#">판매순&nbsp;</a></li>
		<li class="sub">|&nbsp; </li>
		<li><a href="#">조회순</a></li>
	</ul>

	<form action="newPage.html" method="post" class="searchForm">
		<input type="text" id="searchForm">
		<input type="submit" id="search_img" value=""><!-- <img src="searchButton.PNG" onclick="open();"/> -->
	</form>
	
	<table class="table"> <!-- border="1" -->
		<tr>
			<th><img src="DB.jpg" width="235px" height="235px"></th><th><img src="DB.jpg" width="235px" height="235px"></th><th><img src="DB.jpg" width="235px" height="235px"></th><th><img src="DB.jpg" width="235px" height="235px"></th>
		</tr>
		<tr>
			<td>3조 DB</td><td>3조 DB</td><td>3조 DB</td><td>3조 DB</td>
		</tr>
		<tr>
			<td>10000원</td><td>10000원</td><td>10000원</td><td>10000원</td>
		</tr>
	</table>
	<table class="table"> <!-- border="1" -->
		<tr>
			<th><img src="DB.jpg" width="235px" height="235px"></th>
			<th><img src="DB.jpg" width="235px" height="235px"></th>
			<th><img src="DB.jpg" width="235px" height="235px"></th>
			<th><img src="DB.jpg" width="235px" height="235px"></th>
		</tr>
		<tr>
			<td>3조 DB</td>
			<td>3조 DB</td>
			<td>3조 DB</td>
			<td>3조 DB</td>
		</tr>
		<tr>
			<td>10000원</td>
			<td>10000원</td>
			<td>10000원</td>
			<td>10000원</td>
		</tr>
	</table>
	<table class="table"> <!-- border="1" -->
		<tr>
			<th><img src="DB.jpg" width="235px" height="235px"></th>
			<th><img src="DB.jpg" width="235px" height="235px"></th>
			<th><img src="DB.jpg" width="235px" height="235px"></th>
			<th><img src="DB.jpg" width="235px" height="235px"></th>
		</tr>
		<tr>
			<td>3조 DB</td>
			<td>3조 DB</td>
			<td>3조 DB</td>
			<td>3조 DB</td>
		</tr>
		<tr>
			<td>10000원</td>
			<td>10000원</td>
			<td>10000원</td>
			<td>10000원</td>
		</tr>
	</table>

</div>


<script>
</script>
</body>
</html>