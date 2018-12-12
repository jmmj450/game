<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/editor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>

<%@include file="../header.jsp" %>

<div class="container">
  <form action="/board/reWrite" method="POST" name="w_form">
  <input type="hidden" value="${page}" name="page">
  <input type="hidden" value="${reRef}" name="reRef">
  <input type="hidden" value="${reLev}" name="reLev">
  <input type="hidden" value="${reSeq}" name="reSeq">
  <input type="hidden" value="${bigcategory}" name="bigcategory">
  <input type="hidden" value="${category}" name="category">
  
  	<div class="form-group" >
  		<c:choose>
  			<c:when test="${userEmail eq null }">
  				<input type="password" name="password" class="form-control" id="password" placeholder="Enter password" maxlength="30" style="width: 300px; display: inline-block;">
  			</c:when>
  			<c:otherwise>
  				<input type="hidden" name="userEmail" value="${userEmail }">
  			</c:otherwise>
  		</c:choose>
  	</div>
    <div class="form-group">
      <input name="bTitle" type="text" class="form-control" placeholder="Enter title">
    </div>
    <div class="form-group">
      <textarea name="bContent" id="textAreaContent" style="width: 100%" rows="15" cols="80"></textarea>
    </div>
    <button type="button" class="btn btn-primary" onClick="return submitContents(this)">글쓰기</button>
  </form>
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

