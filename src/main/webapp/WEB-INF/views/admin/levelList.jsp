<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp" %>
<script>

	function deleteData(num){
		if (confirm("정말로 삭제하시겠습니까?")) {
			location.href="/admin/levelDelete?num="+num;
		}
	}

	function changeData(fn){
		if (confirm("수정하시겠습니까?")) {
			$("#"+fn).submit();
		}
	}
	
</script>
<div class="container">
  <a href="/admin/levelWriteForm" class="btn btn-success">등록</a>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>레벨</th>
        <th>포인트</th>
        <th>수정</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${list}">
        <form action="/admin/levelUpdate" method="post" id="fn${item.num}">
        <input type="hidden" name="num" id="num" value="${item.num}">     
	      <tr>
	        <td><input type="text" name="levels" value="${item.levels}"></td>
	        <td><input type="text" name="point" value="${item.point}"></td>
	        <td><a href="#" onclick="changeData('fn${item.num}');" ><i class="material-icons">done_outline</i></a></td>
	        <td><a href="#" onclick="deleteData('${item.num}');" ><i class="material-icons">delete</i></a></td>
	      </tr>
	    </form>
      </c:forEach>

    </tbody>
  </table>
  <ul class="pagination">
    <c:if test="${page != 1}">
    	<li class="page-item"><a class="page-link"href="/admin/levelList?page=${page -1}">Previous</a></li>
    </c:if>
    <c:if test="${list.size() == 5}">
    	<li class="page-item"><a class="page-link" href="/admin/levelList?page=${page +1}">Next</a></li>
    </c:if>
  </ul>
</div>

<%@include file="../footer.jsp" %>


