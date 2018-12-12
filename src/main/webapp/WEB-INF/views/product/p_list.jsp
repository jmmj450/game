<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header.jsp" %> 
<%--<%@include file="p_header.jsp" %> --%>

<div class="container" style="margin-top: 10px;">
  <h2>상품목록</h2> 
  <p>당신의 쇼핑을 환영합니다. ^^</p>            
  <table class="table table-striped">
    <thead>
      <tr align="center">
        <th>상품번호</th>
        <th>상품이미지</th>
        <th>상품명</th>
        <th>가격(원)</th>
        <th>등록시간</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="row" items="${list }">
	      <c:if test="${list.size() == 0}"><h4>등록된 상품이 없습니다.</h4></c:if>
	      <tr align="center">
	        <td>${row.proNum}</td>
	        <td>
	        	<a href="/product/detail?proNum=${row.proNum}">
	        		<img src="/resources/editor/upload/${row.proFile}", width="120px" height="110px" />
	        	</a>
	        </td>
	        <td>
	        	<a href="/product/detail?proNum=${row.proNum}">${row.proName}</a>
	        </td>
	        <td>
	        	<fmt:formatNumber value="${row.proPrice}" pattern="###,###,###" />  	        	
	        	<%--  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 라이브러리 불러와야사용가능 --%>
	        </td>
	        <td>${row.proTime}</td>
	      </tr>
      </c:forEach>

    </tbody>
  </table>
  
  <ul class="pagination">
    <c:if test="${page != 1}">
    	<li class="page-item"><a class="page-link"href="/product/list?page=${page -1}">Previous</a></li>
    </c:if>
    <c:if test="${list.size() == 5}">
    	<li class="page-item"><a class="page-link" href="/product/list?page=${page +1}">Next</a></li>
    </c:if>
  </ul>
</div>


<%@include file="../footer.jsp" %>


