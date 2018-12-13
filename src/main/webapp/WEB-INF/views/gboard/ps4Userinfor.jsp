<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp" %>

 	
<div class="container">
  <c:if test="${sessionScope.userAdmin == 1}">
  <a href="/gboard/writeForm?page=${pagingVO.page }" class="btn btn-success">글쓰기</a> 
  </c:if>
  
  <div style="text-align: center; background-color: white; margin-top: 100px;">
  <table class="table table-hover">
    <thead>
      <tr>
        <th>글번호</th>
        <th>년 </th>
        <th>월 </th>
        <th>제목</th>
        <th>조회수</th>
        <th>날짜</th>
        <c:if test="${sessionScope.userAdmin == 1}">
          <th>삭제</th> 
        </c:if>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${list}">
	      <tr>
	        <td>${item.bNum}</td>
	        <td>${item.bYear}</td>
	        <td>${item.bMonth}</td>
	        <td>
	        <c:if test="${item.reLev gt 0 }">
	        	<img src="../resources/img/level.gif" width="${item.reLev*10 }" height="16">
	        	<img src="../resources/img/re.gif">
	        </c:if>
	        <a href="/gboard/detail?bNum=${item.bNum}&page=${pagingVO.page}&bYear=${bYear}&bMonth=${bMonth}">${item.bTitle}</a>
	        </td>
	        <td>${item.bReadCount}</td>
			<td>${item.bWriteDate}</td> 
			<c:if test="${sessionScope.userAdmin == 1}">
	        <td><a href="/admin/gboard/delete?bNum=${item.bNum}"><i class="material-icons">delete</i></a></td>
	        </c:if>
	      </tr>
      </c:forEach>

    </tbody>
  </table>
  </div>
  <ul class="pagination justify-content-center">
    <c:if test="${pagingVO.startPage gt pagingVO.pageBlock}">
    	<li class="page-item"><a class="page-link" href="/gboard/list?page=${pagingVO.startPage -1}&year=${year}&month=${month}">이전</a></li>
    </c:if>
    <c:forEach var="i" begin="${pagingVO.startPage}" end="${pagingVO.endPage }" step="1">
    	<c:choose>
    			<c:when test="${pagingVO.page eq i }">
    				<li class="page-item"><a class="page-link" href="/gboard/list?page=${i }&year=${year }&month=${month}"><b>${i }</b></a></li>
    			</c:when>
    			<c:otherwise>
						 <li class="page-item"><a class="page-link" href="/gboard/list?page=${i }&year=${year }&month=${month}">${i }</a></li>   			
    			</c:otherwise>
    	</c:choose>
    </c:forEach>
    <c:if test="${pagingVO.endPage lt pagingVO.pageCount}">
    	<li class="page-item"><a class="page-link" href="/gboard/list?page=${pagingVO.endPage +1}&year=${year}&month=${month}">다음</a></li>
    </c:if>
  </ul>
</div>



<%@include file="../footer.jsp" %>

