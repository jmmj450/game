<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>

<div class="container">
	 <h6>총 ${pagingVO.count}개의 글이 있습니다.</h6>
 <div style="text-align: center;">
  <table class="table table-hover">
    <thead>
      <tr>
        <th>글번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>신고 수</th>
        <th>확인 여부</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${list}">
	      <tr>
	        <td>${item.bNum}</td>
	        <td>
	        <a href="/board/reportdetail?bNum=${item.bNum}&page=${pagingVO.page}">${item.bTitle}</a>
	        </td>
	        <td>${item.userEmail}</td>
	        <td>${item.report}</td>
			<c:choose>
				<c:when test="${item.ok eq 0 }">
					<td>X</td>
				</c:when>
				<c:otherwise>
					<td>O</td>
				</c:otherwise>
			</c:choose>	        
	        </tr>
      </c:forEach>
    </tbody>
  </table>
  </div>
  <ul class="pagination justify-content-center">
    <c:if test="${pagingVO.startPage gt pagingVO.pageBlock}">
    	<li class="page-item"><a class="page-link" href="/board/reportBoard?page=${pagingVO.startPage -1}">이전</a></li>
    </c:if>
    <c:forEach var="i" begin="${pagingVO.startPage}" end="${pagingVO.endPage }" step="1">
    	<c:choose>
    			<c:when test="${pagingVO.page eq i }">
    				<li class="page-item"><a class="page-link" href="/board/reportBoard?page=${i }"><b>${i }</b></a></li>
    			</c:when>
    			<c:otherwise>
						 <li class="page-item"><a class="page-link" href="/board/reportBoard?page=${i }">${i }</a></li>   			
    			</c:otherwise>
    	</c:choose>
    </c:forEach>
    <c:if test="${pagingVO.endPage lt pagingVO.pageCount}">
    	<li class="page-item"><a class="page-link" href="/board/reportBoard?page=${pagingVO.endPage +1}">다음</a></li>
    </c:if>
  </ul>
</div>


<%@include file="../footer.jsp" %>