<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp" %>

<div class="container">

<%@include file="../category/mypage.jsp" %>

  <table class="table table-hover" style="width: 800px; float: left;">
    <thead>
      <tr>
        <th>no</th>
        <th>userEmail</th>
        <th>itemType</th>
        <th>point</th>
        <th>date</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${list}">
	      <tr>
	        <td>${item.no}</td>
	        <td>${item.userEmail}</td>
	        <td>${item.itemType}</td>
	        <td>${item.point}</td>
	        <td>${item.date}</td>
	      </tr>
      </c:forEach>

    </tbody>
  </table>
  <div style="clear: both;"></div>
  <div style="margin-left: 500px;">
	<div>
		<ul class="pagination">
			<c:if test="${page != 1}">
				<li class="page-item"><a class="page-link"href="/mypage/pointList?page=${page -1}">Previous</a></li>
			</c:if>
			<c:if test="${list.size() == 15}">
				<li class="page-item"><a class="page-link" href="/mypage/pointList?page=${page +1}">Next</a></li>
			</c:if>
		</ul>
	</div>
  </div>
</div>

<%@include file="../footer.jsp" %>

