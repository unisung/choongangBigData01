/**
 * 
 */
console.log("Reply Module........");
var replyService = (function(){
  	 
      function add(reply, callback, error){
	   console.log("add reply.................");
       $.ajax({
	    type:'post',
        url:'/replies/new',
        data:JSON.stringify(reply),
        contentType:"application/json; charset=utf-8",
        success:function(result, status, xhr){
					 if(callback){callback(result);}
    },
        error:function(xhr, status, er){
	     if(error){error(er);}
    }
})
} /* end-add. */

/* page Navigation 처리 */
function getList(param, callback, error){
var bno = param.bno;
var page = param.page || 1;

    $.getJSON("/replies/pages/" + bno + "/" + page + ".json",
        function(data) {
          if (callback) {
            //callback(data);
            //ReplyPageDTO-cnt, list 추출
            callback(data.replyCnt, data.list);
            
          }
        }).fail(function(xhr, status, err) {
      if (error) {
        error(err);
      }
    });

} /* end-getList. */

/* replyer 추가후 수정.... */
function remove(rno, replyer, callback, error){
	$.ajax({type:'delete', 
	            url:'/replies/'+rno, 
	            
	            data:JSON.stringify({rno:rno, replyer:replyer}),
	            contentType:"application/json; charset=utf-8",
	            
	            success:function(deleteResult, status, xhr){
	                 if(callback){callback(deleteResult);}
	                 }, 
	            error:function(xhr, status, er){
	                 if(error){error(er);}
	                }
	            });
}/* end-remove.*/

function update(reply, callback, error){
	console.log("RNO: "+ reply.rno);
	
    $.ajax({type:'put', 
                url:'/replies/'+reply.rno, 
                data:JSON.stringify(reply), 
                contentType:'application/json; charset=utf-8', 
                success:function(result, status, xhr){
                	if(callback){callback(result);}
                }, 
                error:function(xhr, status, er){
                	if(error){error(er);}
                }
                });
    	
}/* end-update. */
	
function get(rno, callback, error){
	$.get("/replies/"+rno+".json", 
	         function(result){
	         if(callback){
	            callback(result);
	            }
	          }
	         )
	  .fail(function(xhr, status, err){
	        if(error){
	            error(err);
	          }
	         }
	       );
}/* end-get. */

function displayTime(timeValue){
	 var today = new Date();
	 
	 //현재시간과 전달된 시간 차 계산
	 var gap = today.getTime() - timeValue;
	 var dateObj = new Date(timeValue);
	 var str ="";
	 
	 //당일 날짜이면
	 if(gap < (1000*60*60*24)){
	    var hh = dateObj.getHours();
	    var mi = dateObj.getMinutes();
	    var ss = dateObj.getSeconds();
	    
	    return [(hh>9?'':'0') + hh, ':', (mi>9?'':'0')+mi, ':', (ss>9?'':'0')+ss].join(' ');
	    
	 }else{//24시간이 지난 댓글 
	 var yy=dateObj.getFullYear();
	 var mm=dateObj.getMonth()+1;//
	 var dd = dateObj.getDate();
	 
	 return [yy,'/',(mm>9?'':'0')+mm,'/', (dd>9?'':'0')+dd].join(' ');
	 }
}

	
      return {add:add, 
                  getList:getList,
                  remove:remove,
                  update:update,
                  get:get,
                  displayTime:displayTime}

})();