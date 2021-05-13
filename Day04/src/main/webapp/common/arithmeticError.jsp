<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor="#fff" text="#000">
  <table width="100%" border="1" cellspacing=0 cellpadding=0>
        <tr>
        	<td align="center" bgcolor="orange"><b>수치 에러 화면입니다.</b></td>
        </tr>
  </table>
   <br>
  <table  width="100%" border="1" cellspacing=0 cellpadding=0>
            <tr>
            	<td align="center">
            	<br><br><br><br>
            	 Message:${exception.message}
            	 <br>
            	 <%=exception.getMessage() %>
            	 <br><br><br><br>
            </tr>
  </table>

</body>
</html>