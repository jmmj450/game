<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>

<section id="about">
  <div class="container">
			<c:if test="${gBoardVO.userEmail eq userEmail }">
<%-- 			<a href="/gboard/updateForm?bNum=${gBoardVO.bNum}&page=${page}" class="btn btn-primary">수정</a> --%>
			<a href="/gboard/delete?bNum=${gBoardVO.bNum}" class="btn btn-danger">삭제</a>
			</c:if>
	<a href="/gboard/list?page=${page}" class="btn btn-primary">목록</a>
	<div class="row">
		<div class="col-lg-8 mx-auto">
			<h2 class="text-center"><b>${gBoardVO.bTitle}</b></h2>
		</div>
		<hr>
		
		  <div class="container">
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>연번 </th>
		        <th>등급분류필증번호 </th>
		        <th>게임물명 </th>
		        <th>신청자(상호) </th>
		        <th>신청일자  </th>
		        <th>결정일자 </th>
		        <th>결정등급 </th>
		        <th>접수번호 </th>
		        <th>등급분류기관 </th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="item" items="${list}" varStatus="loop">
		          <tr>
		            <td>${item.dNum}</td>
			        <td>${item.authNum}</td>
			        <td>${item.gameName}</td>
			        <td>${item.gameCompany}</td>
			        <td>${item.applyDate}</td>
			        <td>${item.decideDate}</td>
			        <td>${item.decideGrade}</td>
			        <td>${item.receiptNumber}</td>
			        <td>${item.agency}</td>
			      </tr>
		      </c:forEach>
		
		    </tbody>
		  </table>
		  </div>
				
		<!-- END -->
	</div>
  </div>
</section>

<%@include file="../footer.jsp" %>

<!-- Ajax 요청 -->
<script>


	



	function sendReply(){
		var rContent_textarea = document.querySelector('#rContent_textarea');
		var rContent = rContent_textarea.value;
		var password_textarea = document.querySelector('#password');
		var password = password_textarea.value;
		//alert(rContent);
		console.log(rContent);
		if('${userEmail}' == ''){
			if(password == ''){
				alert('비밀번호를 입력하세요');
				return false;
			}else{
				password = password_textarea.value;
			}
		}
		
		if(rContent == ''){
			alert('글을 입력하세요');
			return false;
		}
		
		
		//rContent, bNum, userID 세개를 전송
		var sessionok = {
				"rContent":rContent,
				"bNum":'${gBoardVO.bNum}',
				"userEmail":'${userEmail}',
		};
		
		var sessionno = {
				"rContent":rContent,
				"bNum":'${gBoardVO.bNum}',
				"password":password
		};
		
		var rJson;
		
		if('${userEmail}' != '' ){
			rJson = JSON.stringify(sessionok);
		}else {
			rJson = JSON.stringify(sessionno);
		}
		
		/* dataType은 호출되는 서버쪽 함수의 리턴타입 */
		/* contentType은 내가 보내는 데이터 타입 */
		/* data는 내가 전송할 데이터 */
		$.ajax({
			type:"post",
			url:"/reply/write",
			dataType:"text",
			contentType:"application/json; charset=utf-8",
			data:rJson,
			success:function(rNum){
				//alert("통신 성공");
				//밑에 뿌려줘야 함.
				//alert(rNum);
				var str = ' <div> <input type="password"  class="rere form-control" maxlength="30" style="width: 300px; display: inline-block;" placeholder="Enter repassword">';
				str += '<a href="javascript:void(0);" class="replyDelete"><i class="material-icons">cancel</i></a>';
				str += '<br>';
				str += rContent;
				str += '<hr> </div>';
				
				$('#reply').prepend(str);
				
				rContent_textarea.value = '';
				password_textarea.value = '';
			},
			error:function(){
				alert("통신 실패");
			}
		});
		
	}
</script>

