<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/editor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>

<%@include file="../header.jsp" %>

<div class="container">
  <form action="/gboard/write" method="POST" name="w_form"  enctype="multipart/form-data" >
  <input type="hidden" name="userEmail" value="${userEmail }">
  	<div class="form-group" >
  		<select name="bYear">
  			<option value="">년 선택</option>
  			<option value="2018">2018</option>
  			<option value="2019">2019</option>
  		</select>
   		<select name="bMonth">
  			<option value="">월 선택</option>
  			<option value="1">1</option>
  			<option value="2">2</option>
  			<option value="3">3</option>
  			<option value="4">4</option>
  			<option value="5">5</option>
  			<option value="6">6</option>
  			<option value="7">7</option>
  			<option value="8">8</option>
  			<option value="9">9</option>
  			<option value="10">10</option>
  			<option value="11">11</option>
  			<option value="12">12</option>
  		</select> 		
  	</div>
    <div class="form-group">
      <input name="bTitle" type="text" class="form-control" placeholder="Enter title">
    </div>
     <div class="form-group">
      <input type="file" class="btn btn-success" name="file" id="proFile" value="파일선택"/>
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
	  if(w_form.bYear.value == ""){
		  alert('년을 선택하세요.');
		  return false;
	  }
	  
	  if(w_form.bMonth.value == ""){
		  alert('월을 선택하세요.');
		  return false;
	  }

	  if(w_form.bTitle.value == ""){
		  alert('제목을 입력하세요 .');
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

