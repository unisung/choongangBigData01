<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
tr {
   line-height: 50px;
   min-height: 50px;
   height: 50px;
}
.weekAdayhead{
line-height: 10px;
   min-height: 10px;
   height: 10px;
}
td{
     height: 90px;
     font-size:40%;
     padding-left:0px;
     text-align: right;
}
th{ text-align: center;}
}
ul {
  margin-left:-100px;
    list-style:none;
    width: 100%;
    font-size: 5%;
    
    padding-left:0px;
}
li{  list-style: none;}
</style>   
<meta charset="UTF-8">
<title>Insert title here</title>
${currentYear }-${currentMonth } - ${currentDate }
</head>
<body>
<div class="container">
<table class="table">
<tr height="10px">
<%--   <th align="center" style="heigth:10px;"><a href="/calendar/monthly?y=<%=prevYear%>&m=<%=(prevMonth>9?prevMonth:"0"+prevMonth)%>">◁</a> <%=year%>년 <%=month+1%>월 <a href="/calendar/monthly?y=<%=nextYear%>&m=<%=(nextMonth>9?nextMonth:"0"+nextMonth)%>">▷</a></th>
 --%>
 </tr>
<tr>
    <td>

        <table class="table table-striped" border="1">
        <tr class="weekAdayhead">
            <th width="14%">일</th>
            <th width="14%">월</th>
            <th width="14%">화</th>
            <th width="14%">수</th>
            <th width="14%">목</th>
            <th width="14%">금</th>
            <th width="14%">토</th>
        </tr>
        <tr>
        </tr>
        </table>

    </td>
</tr>
</table>
</div>
</body>
</html>