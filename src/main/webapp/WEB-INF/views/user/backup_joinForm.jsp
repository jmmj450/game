<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>
<script language="javascript">
// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadFullAddr){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.userAddr.value = roadFullAddr;
}

</script>
<div class="container">
  <form action="/user/join" method="POST" name="form" id="form">
  <input type="hidden" id="authChk" required="true">
    <div class="form-group">
      <input name="userName" id="userName" type="text" class="form-control" placeholder="Enter userName" required="true" />
    </div>
    <div class="form-group">
      <input name="userEmail" id="userEmail" type="email" class="form-control" placeholder="Enter userEmail" required="true" />
      <span id="dupIdMsg"></span>
    </div>
    <div class="form-group">
      <input name="userPassword" id="userPassword" type="password" class="form-control" placeholder="Enter userPassword" required="true" />
    </div>    
    <div class="form-group">
      <button type="button" class="btn btn-warning" onclick="goPopup()">주소검색</button>
      <input name="userAddr" type="text" class="form-control" placeholder="Enter userAddr" required="true" readonly="true"/>
    </div>    
    <div class="form-group">
      <button type="button" id="btnAuth" class="btn btn-warning" onclick="sendAuthEmail()">이메일인증</button>
      <span id="spanAuth" style="display:none;">인증번호 발송중...</span>
      <input name="userAuthNum" id="userAuthNum" type="text" class="form-control" placeholder="Enter Pin" />
    </div>  
    <input type="submit" class="btn btn-primary" value="가입완료" />
  </form>
</div>

<%@include file="../footer.jsp" %>



<script>
	
	$(document).ready(function () {
	
		$('#userEmail').keyup(function() {
			var userEmail = $(this).val();
			
			$.ajax({
				url: '/user/chkDupId',
				data: {userEmail: userEmail},
				success: function (result) {
					//alert(result.count);
					if (result.count == 0) {
						$('#dupIdMsg').text('사용가능한 아이디입니다.').css('color', 'green');
					} else {
						$('#dupIdMsg').text('이미 사용중인 아이디입니다.').css('color', 'red');
					}
				}
			});
		});
		
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

