<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>

<div class="container">
  <form action="/user/findPwd" method="POST" id="form">
  <input type="hidden" id="authChk" required="true">
    <div class="form-group">
      <input name="userName" id="userName" type="text" class="form-control" placeholder="Enter userName" required="true" />
    </div>
    <div class="form-group">
      <input name="userEmail" id="userEmail" type="email" class="form-control" placeholder="Enter userEmail" required="true" />
    </div>       
    
    <div class="form-group">
      <button type="button" id="btnAuth" class="btn btn-warning" onclick="sendAuthEmail()">이메일인증</button>
      <span id="spanAuth" style="display:none;">인증번호 발송중...</span>
      <input name="userAuthNum" id="userAuthNum" type="text" class="form-control" placeholder="Enter Pin" />
    </div> 
        
    <input type="submit" class="btn btn-primary" value="확인" />
  </form>
</div>

<%@include file="../footer.jsp" %>



<script>

	$(document).ready(function () {

		$('#form').submit(function (event) {
			var authChk = $('#authChk').val();
			if (authChk.length == 0) {
				alert('이메일 인증을 해주세요');
				return false;
			}
			var userAuthNum = $('#userAuthNum').val();
			if (userAuthNum.length == 0) {
				alert('인증번호를 입력해주세요');
				return false;
			}
		});
		
	});


	<!-- Ajax 요청 -->
	function sendAuthEmail(){
		$( "#btnAuth" ).hide();
		$( "#spanAuth" ).show();

		var userEmail = document.getElementById('userEmail').value;
		var userName = document.getElementById('userName').value;

		if(userEmail == ''){
			alert('이메일을 입력하세요');
			return false;
		}
		if(userName == ''){
			alert('이름을 입력하세요');
			return false;
		}		

		var rJson = {
				"userEmail":userEmail,
				"userName":userName
		};

		rJson = JSON.stringify(rJson);
		
		/* dataType은 호출되는 서버쪽 함수의 리턴타입 */
		/* contentType은 내가 보내는 데이터 타입 */
		/* data는 내가 전송할 데이터 */
		$.ajax({
			type:"post",
			url:"/user/sendAuthEmail",
			dataType:"text",
			contentType:"application/json; charset=utf-8",
			data:rJson,
			success:function(data){
				if (data == "success") { // 난수생성 및 이메일 발송 성공시
					$('#authChk').val("1");
					alert("이메일로 인증번호가 발송되었습니다.\n인증번호를 입력해주세요.");
				} else { // 이메일 발송 실패시
					alert("이메일 발송 실패");
				}
				
				$( "#btnAuth" ).show();
				$( "#spanAuth" ).hide();
			},
			error:function(){
				alert("통신 실패");
			}
		});
		
	}
	
</script>
