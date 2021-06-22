<%@page import="org.zerock.domain.ScheduleListVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!--  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
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

* {
    margin: 0;
    padding: 0
}

.custom_calendar_table td {
    text-align: center;
}

.custom_calendar_table thead.cal_date th {
    font-size: 1.5rem;
}

.custom_calendar_table thead.cal_date th button {
    font-size: 1.5rem;
    background: none;
    border: none;
}

.custom_calendar_table thead.cal_week th {
    background-color: #288CFF;
    color: #fff;
}

.custom_calendar_table tbody td {
    cursor: pointer;
}

.custom_calendar_table tbody td:nth-child(1) {
    color: red;
}

.custom_calendar_table tbody td:nth-child(7) {
    color: #288CFF;
}

.custom_calendar_table tbody td.select_day {
    background-color: #288CFF;
    color: #fff;
}
</style>   
<%@include file="../includes/header.jsp"%>
<%-- 

<%
    Calendar cal = Calendar.getInstance();
    int year = request.getParameter("y") == null ? cal.get(Calendar.YEAR) : Integer.parseInt(request.getParameter("y"));
    int month = request.getParameter("m") == null ? cal.get(Calendar.MONTH) : (Integer.parseInt(request.getParameter("m")) - 1);

    // 시작요일 확인
    // - Calendar MONTH는 0-11까지임
    cal.set(year, month, 1);
    int bgnWeek = cal.get(Calendar.DAY_OF_WEEK);

    // 다음/이전월 계산
    // - MONTH 계산시 표기월로 계산하기 때문에 +1을 한 상태에서 계산함
    int prevYear = year;
    int prevMonth = (month + 1) - 1;
    int nextYear = year;
    int nextMonth = (month  + 1) + 1;

    // 1월인 경우 이전년 12월로 지정
    if (prevMonth < 1) {
        prevYear--;
        prevMonth = 12;
    }

    // 12월인 경우 다음년 1월로 지정
    if (nextMonth > 12) {
        nextYear++;
        nextMonth = 1;
    }
%>
<div class="container">
<table class="table">
<tr height="10px">
    <th align="center" style="heigth:10px;"><a href="/calendar/monthly?y=<%=prevYear%>&m=<%=(prevMonth>9?prevMonth:"0"+prevMonth)%>">◁</a> <%=year%>년 <%=month+1%>월 <a href="/calendar/monthly?y=<%=nextYear%>&m=<%=(nextMonth>9?nextMonth:"0"+nextMonth)%>">▷</a></th>
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
<%
    // 시작요일까지 이동
    for (int i=1; i<bgnWeek; i++) out.println("<td>&nbsp;</td>");

    // 첫날~마지막날까지 처리
    // - 날짜를 하루씩 이동하여 월이 바뀔때까지 그린다
    int j=0;
    while (cal.get(Calendar.MONTH) == month) {
        out.print("<td><a href=javascript:writeSchedule('"
                         +year+"-"+month+"-"+cal.get(Calendar.DATE)+"')>" 
        		         +cal.get(Calendar.DATE)+ "<span style='font-size:5px; color:pink;' class='glyphicon glyphicon-pencil'></span>"+"</a>");
                     
                     //스케줄 목록 
          		     List<ScheduleListVO> list = ((List<ScheduleListVO>)(request.getAttribute("schedule")));
          		     if(list !=null && list.size()>0){
          		    for(int i=0;i<list.size();i++){
          		    	 if(Integer.parseInt(list.get(i).getD())==cal.get(Calendar.DATE)){
          		    	//	List<ScheduleVO> sList =list.get(i).getScheduleList();
          		    		out.print("<ul style='padding-left:0px;'>");
          		    	//	for(ScheduleVO s:sList){
          		    			out.print("<li>"+s.getSeq()+":<a href='./get?id="+(list.get(0)).getId()
          		    			             +"&y="+(list.get(0)).getY()+"&m="+(list.get(0)).getM()
          		    			             +"&d="+(cal.get(Calendar.DATE)<9?"0"+cal.get(Calendar.DATE):cal.get(Calendar.DATE))+"&seq="+s.getSeq()+"'>"+s.getTitle()+",start:"+s.getStartTime()+"~ end:"+s.getEndTime()+"</a></li>");
          		    		}
          		    		out.print("</ul>");
          		    	}
          		    }
          		  }
                 /*  if(cal.get(Calendar.DATE)==Integer.parseInt(list.get)){
                	  
                  } */
        
        out.println("</td>");

        // 토요일인 경우 다음줄로 생성
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) 
        	     out.println("</tr><tr>");

        // 날짜 증가시키기
        cal.set(cal.get(Calendar.YEAR), 
        		  cal.get(Calendar.MONTH), cal.get(Calendar.DATE)+1);
    }

    // 끝날부터 토요일까지 빈칸으로 처리
    for (int i=cal.get(Calendar.DAY_OF_WEEK); i<=7; i++) 
    	out.println("<td>&nbsp;</td>");
%>
        </tr>
        </table>

    </td>
</tr>
</table>
</div>
<!-- 댓글 등록용  Modal -->
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
        aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">&times;</button>
              <h4 class="modal-title" id="myModalLabel">Schedule Register</h4>
            </div>
            <div class="modal-body"> 
            
            <form role="form" name="frm" action="/calendar/register" method="post"> 
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
             
              <div class="form-group">
                <label>title</label> 
                <input class="form-control" name='title' value=''>
              </div>
              <div class="form-group">
                <label>content</label> 
                <input class="form-control" name='content' value=''>
              </div>
             <div class="form-group">
                <label>id</label> 
                <input class="form-control" name='id'  value='<sec:authentication property="principal.username"/>'  readonly>
               </div> 
              <div class="form-group">
                <label>year</label> 
                <input class="form-control" name='y' value='<c:out value="<%=year %>"/>' readonly>
               </div>
                <div class="form-group">
                <label>month</label> 
                <input class="form-control" name='m' value='<c:out value="<%=(month+1)>9?(month+1):(\"0\"+(month+1))%>"/>' readonly>
               </div>
               <div class="form-group">
                <label>date</label> 
                <input class="form-control" name='d' value='<c:out value="<%=cal.get(Calendar.DATE)%>"/>'  readonly>
               </div>
               <div class="form-group">
                <label>startTime</label> 
                <input class="form-control" name='startTime' type="time">
               </div>
               <div class="form-group">
                <label>endTime</label> 
                <input class="form-control" name='endTime' type="time">
               </div>
 
               </form>
               
            </div><!-- ./modal-body -->
            
      <div class="modal-footer">
        <button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
        <button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
        <button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
        <button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
      </div>          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->
      
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->

  <script>
var modal = $(".modal");

function writeSchedule(date){
	//alert(date);
	var modal = $(".modal");
	var modalId = modal.find("input[name='id']");
    var modalYear = modal.find("input[name='y']");
    var modalMonth = modal.find("input[name='m']");
    var modalDate=modal.find("input[name='d']");
    
    var modalModBtn = $("#modalModBtn");
    var modalRemoveBtn = $("#modalRemoveBtn");
    var modalRegisterBtn = $("#modalRegisterBtn");
    
   // modal.find("input").val("");
   // modalInputReplyDate.closest("div").hide();
    modal.find("button[id !='modalCloseBtn']").hide();
    
    modal.find("input[name='d']").val(date.substr(date.lastIndexOf('-')+1)>9?date.substr(date.lastIndexOf('-')+1):'0'+date.substr(date.lastIndexOf('-')+1));//2021-4-20
    
    modalRegisterBtn.show();
    
    $(".modal").modal("show");
    
}
</script>  
<script>
$(document).ready(function(){
	var modal = $(".modal");
	
	$("#modalRegisterBtn").on("click",function(e){
		var formObj = $("form[role='form']");
		    e.preventDefault();
		    console.log("submit clicked");
		    formObj.submit();
	    });
	
	//var modal = $(".modal");
	
	 $("#modalCloseBtn").on("click", function(e){
	    	modal.modal('hide');
	    });
	 
});
</script>       --%>
<div id="calendarForm"></div>
<script>
(function () {
    calendarMaker($("#calendarForm"), new Date());
})();

var nowDate = new Date();
function calendarMaker(target, date) {
    if (date == null || date == undefined) {
        date = new Date();
    }
    nowDate = date;
    if ($(target).length > 0) {
        var year = nowDate.getFullYear();
        var month = nowDate.getMonth() + 1;
        $(target).empty().append(assembly(year, month));
    } else {
        console.error("custom_calendar Target is empty!!!");
        return;
    }

    var thisMonth = new Date(nowDate.getFullYear(), nowDate.getMonth(), 1);
    var thisLastDay = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, 0);


    var tag = "<tr>";
    var cnt = 0;
    //빈 공백 만들어주기
    for (i = 0; i < thisMonth.getDay(); i++) {
        tag += "<td></td>";
        cnt++;
    }

    //날짜 채우기
    for (i = 1; i <= thisLastDay.getDate(); i++) {
        if (cnt % 7 == 0) { tag += "<tr>"; }

        tag += "<td>" + i + "</td>";
        cnt++;
        if (cnt % 7 == 0) {
            tag += "</tr>";
        }
    }
    $(target).find("#custom_set_date").append(tag);
    calMoveEvtFn();

    function assembly(year, month) {
        var calendar_html_code =
            "<table class='custom_calendar_table'>" +
            "<colgroup>" +
            "<col style='width:200px'/>" +
            "<col style='width:200px'/>" +
            "<col style='width:200px'/>" +
            "<col style='width:200px'/>" +
            "<col style='width:200px'/>" +
            "<col style='width:200px'/>" +
            "<col style='width:200px'/>" +
            "</colgroup>" +
            "<thead class='cal_date'>" +
            "<th><button type='button' class='prev'><</button></th>" +
            "<th colspan='5'><p><span>" + year + "</span>년 <span>" + month + "</span>월</p></th>" +
            "<th><button type='button' class='next'>></button></th>" +
            "</thead>" +
            "<thead  class='cal_week'>" +
            "<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>" +
            "</thead>" +
            "<tbody id='custom_set_date'>" +
            "</tbody>" +
            "</table>";
        return calendar_html_code;
    }

    function calMoveEvtFn() {
        //전달 클릭
        $(".custom_calendar_table").on("click", ".prev", function () {
            nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() - 1, nowDate.getDate());
            calendarMaker($(target), nowDate);
        });
        //다음날 클릭
        $(".custom_calendar_table").on("click", ".next", function () {
            nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, nowDate.getDate());
            calendarMaker($(target), nowDate);
        });
        //일자 선택 클릭
        $(".custom_calendar_table").on("click", "td", function () {
            $(".custom_calendar_table .select_day").removeClass("select_day");
            $(this).removeClass("select_day").addClass("select_day");
        });
    }
}
</script>
<%@include file="../includes/footer.jsp"%>