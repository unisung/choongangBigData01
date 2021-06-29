<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<section>
     <div class="slider">
         <!-- Swiper -->
         <div class="swiper-container mySwiper">
             <div class="swiper-wrapper">
                 <div class="swiper-slide"><img src="/resources/img/m01.jpg" alt=""></div>
                 <div class="swiper-slide"><img src="/resources/img/m02.jpg" alt=""></div>
                 <div class="swiper-slide"><img src="/resources/img/m03.jpg" alt=""></div>
                 <div class="swiper-slide"><img src="/resources/img/m04.jpg" alt=""></div>
                 <div class="swiper-slide"><img src="/resources/img/m05.jpg" alt=""></div>
                 <div class="swiper-slide"><img src="/resources/img/m06.jpg" alt=""></div>
             </div>
             <div class="swiper-scrollbar"></div>
         </div>
     </div>
    <div class="timePd">
        <div class="mainM"><h3>실시간 인기상품</h3></div>
        
        <ul>
        	<%-- <c:forEach var="li" items="${list }" varStatus="i">	
				<c:if test="${i.index%4==0 }">
					<tr>
				</c:if>
					<td><a><img src="${a}" width="280px" height="305px"><br>
					<b>${i.count}-${li.name }<b><br>
					${li.price }원</a></td>
					
			</c:forEach> --%>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
        </ul>
        
    </div>
    <div class="newPd">
        <div class="mainM"><h3>신상품</h3></div>
        <ul>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
        </ul>
        <div class="bg01"><img src="/resources/img/bg01.jpg" alt=""></div>
    </div>
    <div class="salePd">
        <div class="mainM"><h3>할인상품</h3></div>
        <ul>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
            <li><a href=""><img src="" alt=""></a></li>
        </ul>
        <div class="bg02"><img src="/resources/img/bg02.jpg" alt=""></div>
    </div>
    
    
</section>

<%@include file="/WEB-INF/views/common/footer.jsp" %>