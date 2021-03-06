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
  <form action="/user/update" method="POST" name="form" id="form">
    <div class="form-group">
      <input name="userName" id="userName" type="text" class="form-control" placeholder="Enter userName" required="true" value="${userVO.userName}" />
    </div>
    <div class="form-group">
      <input name="userEmail" id="userEmail" type="email" class="form-control" placeholder="Enter userEmail" required="true" value="${userVO.userEmail}" readonly="true"/>
      <span id="dupIdMsg"></span>
    </div>
    <div class="form-group">
      <input name="userPassword" id="userPassword" type="password" class="form-control" placeholder="Enter userPassword" required="true" value="${userVO.userPassword}" />
    </div>    
    <div class="form-group">
      <button type="button" class="btn btn-warning" onclick="goPopup()">주소검색</button>
      <input name="userAddr" type="text" class="form-control" placeholder="Enter userAddr" required="true" readonly="true"  value="${userVO.userAddr}" />
    </div>    
    <input type="submit" class="btn btn-primary" value="수정하기" />
  </form>
</div>

<%@include file="../footer.jsp" %>


