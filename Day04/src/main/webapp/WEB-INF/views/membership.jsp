<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
</head>
<body>
	<center>
		<h1>ȸ������</h1>
		
		
		<hr>
		<form action="insertMember.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">id</td>
					<td><input name="id" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">�н�����</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">�̸�</td>
					<td><input name="name" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">�����ȣ</td>
					<td><input id="postcode" name="postcode" placeholder="�����ȣ">
					<input type="button" onclick="execDaumPostcode()" 
					     value="�����ȣ ã��"><br>
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">���θ��ּ�</td>
					<td><input id="roadAddress" name="roadAddress" placeholder="���θ��ּ�"></td>
				</tr>
				<tr>
					<td bgcolor="orange">�����ּ�</td>
					<td><input id="jibunAddress" name="jubunAddress" placeholder="�����ּ�"></td>
					<span id="guide" style="color:#999;display:none"></span>
				</tr>
				<tr>
					<td bgcolor="orange">���ּ�</td>
					<td><input  id="detailAddress" name="detailAddress" placeholder="���ּ�"></td>
				</tr>
				<tr>
					<td bgcolor="orange">�����׸�</td>
					<td><input id="extraAddress" name="extraAddress" placeholder="�����׸�"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="�����ϱ�" />
					<input type="reset" value="�ٽ��Է�" />	
						</td>
				</tr>
			</table>
		</form>
		<hr>
	</center>
	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //�� ���������� ���θ� �ּ� ǥ�� ��Ŀ� ���� ���ɿ� ����, �������� �����͸� �����Ͽ� �ùٸ� �ּҸ� �����ϴ� ����� �����մϴ�.
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

                // ���θ� �ּ��� ���� ��Ģ�� ���� �ּҸ� ǥ���Ѵ�.
                // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
                var roadAddr = data.roadAddress; // ���θ� �ּ� ����
                var extraRoadAddr = ''; // ���� �׸� ����

                // ���������� ���� ��� �߰��Ѵ�. (�������� ����)
                // �������� ��� ������ ���ڰ� "��/��/��"�� ������.
                if(data.bname !== '' && /[��|��|��]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // �ǹ����� �ְ�, ���������� ��� �߰��Ѵ�.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // ǥ���� �����׸��� ���� ���, ��ȣ���� �߰��� ���� ���ڿ��� �����.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
                // �����׸� ���ڿ��� ���� ��� �ش� �ʵ忡 �ִ´�.
                if(roadAddr !== ''){
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // ����ڰ� '���� ����'�� Ŭ���� ���, ���� �ּҶ�� ǥ�ø� ���ش�.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(���� ���θ� �ּ� : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(���� ���� �ּ� : ' + expJibunAddr + ')';
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