<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/editor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>
    
<%@include file="../header.jsp" %>

<div class="warp">
	<div class="mainLeft">
		<div class="mainTitle">PS4</div>
		<ul class="title">
			<li class="title">
				정보 게시판
				<ul class="sub">
					<li class="sub">유저 정보</li>
					<li class="sub">예판/핫딜정보</li>
					<li class="sub">게임 심의결과</li>
				</ul>
			</li>
			<li class="title">
				게임 게시판
				<ul class="sub">
					<li class="sub Active">게임 이야기</li>
					<li class="sub">질문 게시판</li>
				</ul>
			</li>
			<li class="title">
				스샷/영상
				<ul class="sub">
					<li class="sub">스크린 샷</li>
					<li class="sub">동영상</li>
				</ul>
			</li>
			<li class="title">
				리뷰 게시판
				<ul class="subLast">
					<li class="sub">게임 추천</li>
				</ul>
			</li>
		</ul>
	</div>
	<form action="/board/write" method="POST" name="w_form">
	<input type="hidden" value="${bigcategory }" name="bigcategory">
	<div class="write">
		<div class="writer">
			<span class="category-text">카테고리</span>
			<select name="category">
	  			<option value="">게시판 선택</option>
	  			<option value="4000" >유저 정보</option>
	  			<option value="4001">예판/핫딜 정보</option>
	  			<option value="4002">게임 심의결과</option>
	  			<option value="4003">게임 이야기</option>
	  			<option value="4004">질문 게시판</option>
	  			<option value="4005">스크린샷</option>
	  			<option value="4006">동영상</option>
	  			<option value="4007">게임추천</option>
	  		</select>
	  		<c:if test="${admin eq 1 }">
	  		<select name="notice">
	  			<option value="">공지 여부</option>
	  			<option value="0">일반글</option>
	  			<option value="1">공지 사항</option>
	  		</select>
	  		</c:if>
	  		<div class="password-right">
		  		<c:choose>
		  			<c:when test="${userEmail eq null }">
		  				비밀번호 입력 <input type="password" name="password" class="passwordInput" id="password" placeholder="Enter password" maxlength="30" style="width: 300px; display: inline-block;">
		  			</c:when>
		  			<c:otherwise>
		  				<input type="hidden" name="userEmail" value="${userEmail }">
		  			</c:otherwise>
		  		</c:choose>
	  		</div>
			<div class="writeTitle">
				<font class="writeTitleFont">제목</font>
				<input type="text" class="writeTitleInput">
				&nbsp;&nbsp;&nbsp;<font style="color: #CCCCCC;"><font style="font-weight: bold;">45</font>자 제한</font>
			</div>
			<div class="source">
				<font class="sourceFont">출처</font>
				<input type="text" class="sourceInput">
			</div>
			<div class="editer">
				<textarea name="bContent" id="textAreaContent" style="width: 100%" rows="15" cols="80"></textarea>
			</div>
			<div class="writeBottom">
				<div class="shadowBlueButton-write">등록</div>
				<!-- <div class="shadowWhiteButton-cancle">취소</div> -->
			</div>
		</div>
	</div>
	</form>
		<!-- <hr>
		게시판 지기
		운영자 관리자 -->
</div>

<!-- Naver Smart Editor 2 -->
<script>
  var form = document.w_form;
  var oEditors = [];
  nhn.husky.EZCreator.createInIFrame({
      oAppRef: oEditors,
      elPlaceHolder: "textAreaContent",
      sSkinURI: "/resources/editor/SmartEditor2Skin.html",
      fCreator: "createSEditor2"
  });
   
  // submit
  function submitContents(elClickedObj) {
	  if(w_form.category.value == ""){
		  alert('카테고리를 선택하세요.');
		  return false;
	  }
	  if('${admin}' == 1){
		  if(w_form.notice.value == ""){
			  alert('공지여부를 선택하세요.');
			  return false;
		  }
	  }
	  
		  if($('#password').val() == ""){
			  alert('비밀번호를 입력하세요.');
			  return false;
		   }
	  
	  
      // 에디터의 내용이 textarea에 적용된다.
      oEditors.getById["textAreaContent"].exec("UPDATE_CONTENTS_FIELD", [ ]);
      var con = document.w_form.bContent;
      con.value = document.getElementById("textAreaContent").value;
      try {
          elClickedObj.form.submit();
      } catch(e) {
       
      }
  }
   
  // textArea에 이미지 첨부
  function pasteHTML(filepath){
      var sHTML = '<img src="/resources/editor/upload/'+ filepath + '">';
	  oEditors.getById["textAreaContent"].exec("PASTE_HTML", [ sHTML ]);
  }
</script>
<!-- Naver Smart Editor 2 END-->

<%@include file="../footer.jsp" %>