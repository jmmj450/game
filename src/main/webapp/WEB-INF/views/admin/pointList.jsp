<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp" %>
<script>

	function changeData(fn){
		if (confirm("포인트를 변경하시겠습니까?")) {
			$("#"+fn).submit();
		}
	}
	
</script>
<div class="container">
  <table class="table table-hover">
    <thead>
      <tr>
        <th>num</th>
        <th>아이템명</th>
        <th>포인트</th>
        <th>수정</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${list}">
		  <form action="/admin/pointUpdate" method="post" id="fn${item.num}">      
		  <input type="hidden" name="no" id="no" value="${item.num}">
	      <tr>
	        <td>${item.num}</td>
	        <td>${item.itemName}</td>
	        <td><input type="text" name="point" value="${item.point}"></td>
	        <td><a href="#" onclick="changeData('fn${item.num}');" ><i class="material-icons">done_outline</i></a></td>
	      </tr>
          </form>
      </c:forEach>

    </tbody>
  </table>
  <ul class="pagination">
    <c:if test="${page != 1}">
    	<li class="page-item"><a class="page-link"href="/admin/pointList?page=${page -1}">Previous</a></li>
    </c:if>
    <c:if test="${list.size() == 5}">
    	<li class="page-item"><a class="page-link" href="/admin/pointList?page=${page +1}">Next</a></li>
    </c:if>
  </ul>
</div>

<%@include file="../footer.jsp" %>


