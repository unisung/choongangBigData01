<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>      
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
<div class="row">
  <div class="col-lg-12">
  		<div class="panel panel-default">
  		     <div class="panel-heading">
  		        BoardList Page
  		        <button id="regBtn" type="button" class="btn btn-xs pull-right">Register</button>
  		     </div>
  		     
  		     <div class="panel-body">
  		      <table class="table table-striped table-bordered table-hover">
  		        <thead>
  		         <tr>
  		           <th>#번호</th>
  		           <th>제목</th>
  		           <th>작성자</th>
  		           <th>작성일</th>
  		           <th>수정일</th>
  		         </tr>
  		        </thead>
  		        
  		      <c:forEach items="${list}" var="board">
  		        <tr>
  		          <td><c:out value="${board.bno}"/></td>
  		           <td><c:out value="${board.title}"/></td>
  		           <td><c:out value="${board.writer}"/></td>
  		           <td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
  		           <td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd"/></td>
  		        </tr>
  		      </c:forEach>
  		      </table>
  		     
  		     </div>
  		</div>
  </div>
</div>            
<table>

</table>
 <%@include file="../includes/footer.jsp"%>