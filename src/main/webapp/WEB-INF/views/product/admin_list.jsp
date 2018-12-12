<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header.jsp" %>

<script>

$(document).ready(function(){
	$("#insertBtn").click(function(){
		location.href="../product/write";
	});
});
</script>

<div class="container">
  <h2>상품목록</h2> 
  <c:if test="${sessionScope.userEmail eq 'admin@a.com'}">
    <p>관리자 상품등록 페이지 입니다.</p> 
    <button type="button" id="insertBtn">상품등록</button>
  </c:if>
           
  <table class="table table-striped">
    <thead>
      <tr align="center">
        <th>상품번호</th>
        <th>상품이미지</th>
        <th>상품명</th>
        <th>가격(원)</th>
        <th>등록시간</th> 
        <td>삭제</td>  <!-- 전체삭제 링크예정 -->      
      </tr>
    </thead>

    <tbody>
      <c:forEach var="row" items="${list }">
	      <tr align="center">
	        <td>${row.proNum}</td>
	        <td>
	        	<a href="/product/edit?proNum=${row.proNum}">
	        		<img src="/resources/editor/upload/${row.proFile}", width="120px" height="110px" />
	        	</a>
	        </td>
	        <td align="center">
	        	<a href="/product/edit?proNum=${row.proNum}">${row.proName}</a><br>
	        	<c:if test="${sessionScope.userEmail eq 'admin@a.com'}">
	        		<a href="/product/edit?proNum=${row.proNum}">[상품편집]</a>
	        	</c:if>
	        </td>
	        <td>
	        	<fmt:formatNumber value="${row.proPrice}" pattern="###,###,###" />  	        	
	        </td>
	        <td>${row.proTime}</td>
	        <td>
	          <a href="/product/delete?proNum=${row.proNum}">
				<i class='material-icons'>cancel</i>
		      </a>
	        </td>
	      </tr>
      </c:forEach>

    </tbody>
  </table>
</div>
<%@include file="../footer.jsp" %>


