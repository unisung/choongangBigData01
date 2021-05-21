<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<center>
		<h1>회원가입</h1>
		
		
		<hr>
		<form action="insertMember.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">id</td>
					<td><input name="id" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">패스워드</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">이름</td>
					<td><input name="name" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">우편번호</td>
					<td><input id="postcode" name="postcode" placeholder="우편번호">
					<input type="button" onclick="execDaumPostcode()" 
					     value="우편번호 찾기"><br>
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">도로명주소</td>
					<td><input id="roadAddress" name="roadAddress" placeholder="도로명주소"></td>
				</tr>
				<tr>
					<td bgcolor="orange">지번주소</td>
					<td><input id="jibunAddress" name="jubunAddress" placeholder="지번주소"></td>
					<span id="guide" style="color:#999;display:none"></span>
				</tr>
				<tr>
					<td bgcolor="orange">상세주소</td>
					<td><input  id="detailAddress" name="detailAddress" placeholder="상세주소"></td>
				</tr>
				<tr>
					<td bgcolor="orange">참고항목</td>
					<td><input id="extraAddress" name="extraAddress" placeholder="참고항목"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="가입하기" />
					<input type="reset" value="다시입력" />	
						</td>
				</tr>
			</table>
		</form>
		<hr>
	</center>
	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>	
	
</body>
</html>