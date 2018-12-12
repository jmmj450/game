<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/editor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>
    
<%@include file="../header.jsp" %>

<div class="warp">
	<c:choose>
		<c:when test="${bigcategory eq  3001}">
		<%@include file="../category/ps4.jsp" %>
		</c:when>
		<c:when test="${bigcategory eq  3002}">
		<%@include file="../category/psvita.jsp" %>
		</c:when>
		<c:when test="${bigcategory eq  3003}">
		<%@include file="../category/xbox.jsp" %>
		</c:when>
		<c:when test="${bigcategory eq  3004}">
		<%@include file="../category/switch.jsp" %>
		</c:when>
		<c:when test="${bigcategory eq  3005}">
		<%@include file="../category/3ds.jsp" %>
		</c:when>
		<c:when test="${bigcategory eq  3006}">
		<%@include file="../category/pc.jsp"%>
		</c:when>
		<c:when test="${bigcategory eq  3007}">
		<%@include file="../category/phone.jsp" %>
		</c:when>
	</c:choose>
	
	<form action="/board/write" method="POST" name="w_form">
	<input type="hidden" value="${bigcategory }" name="bigcategory">
	<div class="write">
		<div class="writer">
			<span class="category-text">카테고리</span>
			<select name="category">
	  			<c:forEach items="${cList}" var="c">
  					<option value="${c.category}">${c.categoryName}</option>
  				</c:forEach>
	  		</select>
	  		<c:if test="${userAdmin eq 1 }">
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
				<input type="text" name="bTitle" class="writeTitleInput">
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
				<div class="shadowBlueButton-write" onClick="return submitContents(this)">등록</div>
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
	  if('${userAdmin}' == 1){
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