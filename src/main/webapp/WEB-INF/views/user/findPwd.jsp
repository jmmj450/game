<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>

<div class="container">
<c:choose>
	<c:when test="${userVO != null}">
		아이디(이메일) : ${userVO.userEmail} <br />
		임시비밀번호 :   ${randomPwd}
	</c:when>
	<c:otherwise>
		해당하는 아이디가 없습니다.
	</c:otherwise>
	</c:choose>
</div>

<%@include file="../footer.jsp" %>

