<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/demos/style.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="../resources/css/subpage.css">
    <script src="jquery-1.12.0.min.js"></script>
    <script src="jquery.easing.1.3.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<section>
	<div id="subPage">
		<div class="subM">
			<h3>COUPON</h3>
		</div>
		<div class="ad_coupon_write">

		<form action="#" method="post">
			<ul>
				<li>
					<p class="title">쿠폰이름</p> <input type="text" id="code"
					class="content" placeholder="내용을 입력해주세요">
				</li>
	
				<li class="date_check">
					<p class="title">사용기간</p> <label for="from" class="away">From</label>
					<input type="text" id="from" name="from" class="content2"
					placeholder="시작일"> <span>-</span> <label for="to"
					class="away">to</label> <input type="text" id="to" name="to"
					class="content3" placeholder="종료일"> <li>
					<p class="title">할인금액</p>
	                <input type="text" id="user_name" class="content"
					placeholder="내용을 입력해주세요"> <br>
	                </li>
	
	                <li>
	                <p class="title">최소금액</p>
	                <input type="text" id="user_name" class="content"
					placeholder="내용을 입력해주세요">
	                 </li>
	                <li>
	                <p class="title">쿠폰 다운로드 후 사용기간</p>
	                <select name="date" id="day-select" class="content"
					style="font-size: 16px;">
	                    <option value="date">15일</option>
	                    <option value="date">30일</option>
	                    <option value="date">60일</option>
	                    <option value="date">90일</option>
	                </select>
	                </li>
	                
	                <li>
	                <p class="title">이미지</p>
	                <input type="file" id="real-input"
					class="image_inputType_file"
					style="font-size: 14px; padding: 5px 10px; " accept="img/*" required
					multiple>
	                <button class="browse-btn"
						style="font-size: 14px; padding: 1px 5px; ">사진 업로드</button>
	                </li>
	                 
	                <li>
	                <button id="wBtn" onclick="">쿠폰생성</button>
	                <button id="wBtn2" onclick="">삭제</button>
	                <button id="wBtn2" onclick="">수정</button>
	                </li>
	            </ul>
	        </form>
        </div>
	</div>
</section>