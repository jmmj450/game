<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp" %>
<script>

	function deleteUser(userID){
		if (confirm("정말로 삭제하시겠습니까?")) {
			location.href="/admin/user/delete?userID="+userID;
		}
	}

	function userChangeValidate(userID){
		if (confirm("회원상태를 변경하시겠습니까?")) {
			location.href="/admin/user/changeValidate?userID="+userID;
		}
	}
	
</script>
<div class="container">
  <table class="table table-hover">
    <thead>
      <tr>
        <th>no</th>
        <th>아이디(이메일)</th>
        <th>이름</th>
        <th>포인트</th>
        <th>레벨</th>
        <th>출석수</th>
        <th>가입일</th>
        <th>회원상태</th>
        <th>관리자</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${list}">
	      <tr>
	        <td>${item.userID}</td>
	        <td><a href="/user/detail?userID=${item.userID}">${item.userEmail}</a></td>
	        <td>${item.userName}</td>
	        <td>${item.userPoint}</td>
	        <td>${item.userLevel}</td>
	        <td>${item.userLoginCount}</td>
	        <td>${item.userDate}</td>
	        <td><a href="#" onclick="userChangeValidate('${item.userID}');" >
	        <c:choose>
			<c:when test="${item.userValidate == 1}">
	        승인
	        </c:when>
	        <c:otherwise>
	        미승인
	        </c:otherwise>
	        </c:choose>
	        </a></td>
	        <td>
	        <c:choose>
	        	<c:when test="${item.userAdmin == 1 }">
	        		관리자
	        	</c:when>
	        	<c:otherwise>
	        		회원
	        	</c:otherwise>
	        </c:choose>
	        </td>
	        <td><a href="#" onclick="deleteUser('${item.userID}');" ><i class="material-icons">delete</i></a></td>
	      </tr>
      </c:forEach>

    </tbody>
  </table>
  <ul class="pagination">
    <c:if test="${page != 1}">
    	<li class="page-item"><a class="page-link"href="/admin/userList?page=${page -1}">Previous</a></li>
    </c:if>
    <c:if test="${list.size() == 15}">
    	<li class="page-item"><a class="page-link" href="/admin/userList?page=${page +1}">Next</a></li>
    </c:if>
  </ul>
</div>

<%@include file="../footer.jsp" %>


