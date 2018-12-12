<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../header.jsp" %>

<div class="warp">
	<c:choose>
		<c:when test="${boardVO.bigcategory eq  3001}">
		<%@include file="../category/ps4.jsp" %>
		</c:when>
		<c:when test="${boardVO.bigcategory eq  3002}">
		<%@include file="../category/psvita.jsp" %>
		</c:when>
		<c:when test="${boardVO.bigcategory eq  3003}">
		<%@include file="../category/xbox.jsp" %>
		</c:when>
		<c:when test="${boardVO.bigcategory eq  3004}">
		<%@include file="../category/switch.jsp" %>
		</c:when>
		<c:when test="${boardVO.bigcategory eq  3005}">
		<%@include file="../category/3ds.jsp" %>
		</c:when>
		<c:when test="${boardVO.bigcategory eq  3006}">
		<%@include file="../category/pc.jsp"%>
		</c:when>
		<c:when test="${boardVO.bigcategory eq  3007}">
		<%@include file="../category/phone.jsp" %>
		</c:when>
	</c:choose>
	
	<div class="boardWarp">
		<div class="boardName">PS 게임 이야기</div>
		<div class="contentButtonsTop">
			<a href="/board/writeForm?page=${page }&bigcategory=${boardVO.bigcategory }" class="shadowBlueButton BGC-blue">글쓰기</a>
			<div class="boardListButton">
				<a href="/board/list?page=${page }&bigcategory=${boardVO.bigcategory}&category=${boardVO.category}">
					<i class="material-icons" style="font-size: 12px;">&#xe241;</i>목록 
				</a>
				<font style="color: #EEEEEE;">|</font> 
				이전 
				<font style="color: #EEEEEE;">|</font> 
				다음글
			</div>
		</div>
		<div class="content">
			<div class="contentTop">
				<div class="contentTitle">${boardVO.bTitle}</div>
				<div class="contentProfile">
					<div class="profileImage">
						<img src="/resources/img/profile.png" class="profileIMG">
					</div>
					<div class="userProfile">
						<span class="username">운영자</span> <span class="userID">(1)</span><br>
						<span class="message">쪽지 보내기</span><br>
						<span class="day">출석일수 : <font style="font-weight: bold;">433일</font> <font style="color: gray;">|</font> <font style="color: #FF8181; font-weight: bold;">LV.24</font></span><br>
						<div class="profileExp">
							<span class="exp"><span class="expNow"></span></span>Exp.<span class="expPer">99%</span><br>
						</div>
						<div class="upAndRead">
							추천 <font style="color: red;">${boardVO.recommend }</font> <font style="color:gray;">|</font> 조회 ${boardVO.bReadCount }<br>
						</div>
						일시 2018.12.01 (23:46:42)<br>
						IP : 2018.235.***.***
					</div>
				</div>
				<div class="contentLine">
					<form action="/board/report?bNum=${boardVO.bNum}" method="post">
	                    <input type="hidden" value="${uri }" name="uri">
						<span style="cursor: pointer;" onClick="return submitContents(this)">신고</span>
					</form>
				</div>
			</div>
			
			<div class="contentMiddle">
				<div class="contentText">	
					${boardVO.bContent}
				</div>             
             	<c:if test="${userEmail ne null}">
				<div class="contentUp">
					<div class="recommend">
						<div style="color: red;">0</div>
						<div class="recommentIcon" onclick="location.href='recommend?bNum=${boardVO.bNum}'"><i class="material-icons">&#xe815;</i></div>
					</div>
					<!-- <div class="decommendation">
						<div style="color: red;">0</div>
						<div class="decommendationIcon"><i class="material-icons">&#xe814;</i></div>
					</div> -->
				</div>
				</c:if>
				<div class="contentButtonMiddle">
					<a href="/board/writeForm?page=${page }&bigcategory=${boardVO.bigcategory }" class="shadowBlueButton BGC-blue">글쓰기</a>
					<c:choose>
						<c:when test="${userEmail ne null and boardVO.userEmail eq userEmail or userAdmin eq 1 }">
						<a href="/board/updateForm?bNum=${boardVO.bNum}&page=${page}&bigcategory=${boardVO.bigcategory}&category=${boardVO.category}" class="shadowBlueButton BGC-blue middle-left">수정</a>
						<a href="/board/delete?bNum=${boardVO.bNum}" class="shadowBlueButton BGC-blue middle-left" style="background-color: #C51515;" onclick="return confirm('삭제하시겠습니까?')">삭제</a> 
						</c:when>
						
						<c:otherwise>
						<c:if test="${boardVO.userEmail eq null }">
						<a href="/board/updateForm?bNum=${boardVO.bNum}&page=${page}&bigcategory=${boardVO.bigcategory}&category=${boardVO.category}" class="shadowBlueButton BGC-blue middle-left">수정</a>
						<a href="/board/delete?bNum=${boardVO.bNum}" class="shadowBlueButton BGC-blue middle-left" style="background-color: #C51515;" onclick="return passCheck()">삭제</a> 
						</c:if>
						</c:otherwise>					
					</c:choose>
					<a href="/board/reWriteForm?page=${page }&bNum=${boardVO.bNum}" class="shadowBlueButton BGC-blue middle-left">답글</a>
					<div class="boardListButton float-right">
						<a href="/board/list?page=${page }&bigcategory=${boardVO.bigcategory}&category=${boardVO.category}">
							<i class="material-icons" style="font-size: 12px;">&#xe241;</i>목록 
						</a>
						<font style="color: #EEEEEE;">|</font> 
						이전 
						<font style="color: #EEEEEE;">|</font> 
						다음글
					</div>
				</div>
			</div>
		</div>
		<div class="contentBottom">
			<div class="bottomText"><font style="font-size: 18px;">덧글</font> <font style="color: gray; padding: 0px 5px 0px 10px;">|</font> 총 <font style="color: #1A70DC; font-weight: bold;">0</font>개</div>
			<div class="comment">
				<div id="reply">
					<c:forEach var="item" items="${list}" varStatus="loop">
					<div class="commentContent rNumber">
						<div class="commentContentName">
							<%-- <c:when test="${item.userEmail eq null }">
								<br>
								<font style="color:#AAAAAA;">비회원</font><br>
								<br>
							</c:when>
							<c:otherwise> --%>
								${item.userEmail}<br>
								(userID)<br>
								<font style="color:#AAAAAA;">(아이피)</font><br>
							<%-- </c:otherwise> --%>
						</div>
						<input type="hidden" class="rNum" value="${item.rNum }">
						<input type="hidden" class="rpass" value="${item.password  }">
						<div class="commentContentText">
							${item.rContent}
						</div>
						<div class="commentDelete">
							<c:choose>
								<c:when test="${userEmail ne null and item.userEmail eq userEmail or userAdmin eq 1 }">
									<a href='javascript:void(0);' class='replyDelete'>
									<i class='material-icons'>cancel</i>
									</a>
								</c:when>
								<c:otherwise>
									<c:if test="${item.password ne null}">
										<input type="password"  class="rere" maxlength="30" style="width: 120px; display: inline-block;" placeholder="Enter repassword">
										<a href='javascript:void(0);' class='replyDelete'><i class='material-icons'>cancel</i></a>
									</c:if>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					</c:forEach>
				</div>
				<div class="commentText">
					<c:choose>
			  			<c:when test="${userEmail eq null }">
			  				<font style="color: black;">비회원 비밀번호</font> <input type="password" name="password" id="password" placeholder="Enter password" maxlength="30" style="width: 300px; display: inline-block;">
			  			</c:when>
			  			<c:otherwise>
			  				<input type="hidden" name="userEmail" value="${userEmail }">
			  			</c:otherwise>
			  		</c:choose>
					<div class="commentTextBox">
						<textarea class="commentTextArea" placeholder="덧글 텍스트에이리어 플레이스 홀더 테스트" id="rContent_textarea"></textarea>
					</div>
					<div class="commentButton" onclick="sendReply()">
						등록
					</div>
				</div>
			</div>
			<hr>
			<div class="contentButtonBottom">
				<a href="/board/writeForm?page=${page }&bigcategory=${boardVO.bigcategory }" class="shadowBlueButton BGC-blue">글쓰기</a>
				<div class="boardListButton float-right">
					<a href="/board/list?page=${page }&bigcategory=${boardVO.bigcategory}&category=${boardVO.category}">
						<i class="material-icons" style="font-size: 12px;">&#xe241;</i>목록 
					</a>
					<font style="color: #EEEEEE;">|</font> 
					이전 
					<font style="color: #EEEEEE;">|</font> 
					다음글
				</div>
			</div>
		</div>
	</div><!-- BOARDWARP END -->
</div>

<%@include file="../footer.jsp" %>

<!-- Ajax 요청 -->
<script>

function  redelete(){
	
	var rNum = $(this).closest('div.rNumber').find('.rNum').val();		
	var password = $(this).closest('div.rNumber').find('.rpass').val();
	
	
	if(password == ''){
		location.href='/reply/delete?rNum='+rNum+'&bNum='+'${boardVO.bNum}'+'&page='+'${page}'; 
		alert('삭제함');
	}
	
	if(password != ''){
		var inpassword = $(this).closest('div.rNumber').find('.rere').val();
		
		
		if(inpassword == '' && '${userAdmin}' != 1){
			console.log('${userAdmin}');
			alert('비밀번호 입력해');
			$(this).closest('div.rNumber').find('.rere').focus();
			return false;
		}
		
		if(password == inpassword || '${userAdmin}' == 1){
			console.log(inpassword);
			location.href='/reply/delete?rNum='+rNum+'&bNum='+'${boardVO.bNum}'+'&page='+'${page}'; 
			alert('삭제함2');
		}else{
			alert('비밀번호 틀림');
			$(this).closest('div.rNumber').find('.rere').val('');
			$(this).closest('div.rNumber').find('.rere').focus();
			console.log($(this).closest('div.rNumber').find('.rere').val());
			return false;
			
		}			
	}
	
}


	
// 	$('.rNumber .replyDelete').click(redelete);

	$(document).on("click", ".replyDelete", redelete);	



	function sendReply(){
		var rContent_textarea = document.querySelector('#rContent_textarea');
		var rContent = rContent_textarea.value;
		
		
		//alert(rContent);
		console.log(rContent);
		
		if('${userEmail}' == ''){
			var password_textarea = document.querySelector('#password');
			var password  = password_textarea.value;
			if(password == ''){
				alert('비밀번호를 입력하세요');
				document.querySelector('#password').focus();
				return false;
			}
		}
		
		if(rContent == ''){
			alert('글을 입력하세요');
			document.querySelector('#rContent_textarea').focus();
			return false;
		}
		
		
		//rContent, bNum, userID 세개를 전송
		var sessionok = {
				"rContent":rContent,
				"bNum":'${boardVO.bNum}',
				"userEmail":'${userEmail}',
		};
		
		var sessionno = {
				"rContent":rContent,
				"bNum":'${boardVO.bNum}',
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
				
				var str;
				var userEmail = '${userEmail}';
				
				if('${userEmail}' != ''){
					var str = ' <div class="rNumber"> <b>'+userEmail+'</b> <input type="hidden" class="rNum" value="'+rNum+'" > ' ; 
						  str += '<input type="hidden" class="rpass" value="">'	;
						  str +=	'<a href="javascript:void(0);" class="replyDelete"> <i class="material-icons">cancel</i> </a> <br>'+rContent+'<hr> </div>';  
					}
				
				if('${userEmail}' == ''){
				var str = ' <div class="rNumber"> <input type="hidden" class="rNum" value="'+rNum+'" >'; 
					str +='<input type="hidden" class="rpass" value="'+password+'"> ' ;  
					str +='<input type="password"  class="rere form-control" maxlength="30" style="width: 300px; display: inline-block;" placeholder="Enter repassword">';
				str += '<a href="javascript:void(0);" class="replyDelete"><i class="material-icons">cancel</i></a>';
				str += '<br>';
				str += rContent;
				str += '<hr> </div>';
				
				
				}
				
				$('#reply').prepend(str);
				rContent_textarea.value = '';
				if(password != null){
					password_textarea.value = '';
				}
				
			},
			error:function(){
				alert("작성 실패");
			}
		});
		
	}
</script>