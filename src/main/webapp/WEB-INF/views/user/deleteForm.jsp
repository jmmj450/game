<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>
<script>

	function deleteUser(){
		if (confirm("정말로 탈퇴하시겠습니까?")) {
			location.href="/user/delete?";
		}
	}
	
</script>

<div class="container">
    <div class="form-group">
      회원탈퇴를 원하시면 아래 버튼을 클릭 바랍니다.
    </div>
    <button type="button" class="btn btn-warning" onclick="deleteUser()">회원탈퇴</button>

</div>

<%@include file="../footer.jsp" %>


