<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp" %>
<style>
li {
	list-style: none;
	font-size: 12px;
	padding-top: 5px;
}

.leftBar{
	border: 1px solid gray ;
	height: 350px;
	width: 100px;
	display: inline-block;
}
.leftBar a{
	text-decoration: none;
	color: black;
}

</style>


 	<div class="leftBar">
 		<a href="/gboard/list?year=${year }&month=${month}">
 		<h3>PS4</h3>
 		</a>
 		<h6><b>정보 게시판</b></h6>
       <a href="/gboard/list?year=${year }&month=4000"><li>유저 정보</li></a>
       <a href="/gboard/list?year=${year }&month=4001"><li>예판/핫딜 정보</li></a>
       <a href="#"><li>게임 심의결과</li></a>
       <h6><b>게임 게시판</b></h6>
       <a href="#"><li>게임 이야기</li></a>
       <a href="#"><li>질문 게시판</li></a>
       <h6><b>스샷 / 영상</b></h6>
       <a href="#"><li>스크린샷</li></a>
       <a href="#"><li>동영상</li></a>
       <h6><b>리뷰 게시판</b></h6>
       <a href="#"><li>게임 추천</li></a>   
 	</div> 
<div class="container"  style="display: inline-block;">
  <a href="/gboard/writeForm?page=${pagingVO.page }&year=${year }" class="btn btn-success">글쓰기</a> <h6>총 ${pagingVO.count}개의 글이 있습니다.</h6>
  <form action="/gboard/search" method="post">
  	<input type="hidden" value="${year }" name="year">
  	<input type="hidden" value="${month}" name="month">
     <select name="searchOption">
     <option value="all">제목+본문</option>
     <option value="title">제목</option>
     <option value="content">본문</option>
     <option value="writer">글쓴이</option>
  </select>
  <input name="keyword" type="text">
  <input type="submit" value="검색" class="btn btn-success">
  </form>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>글번호</th>
        <th>제목</th>
        <th>조회수</th>
        <th>날짜</th>
        <th>삭제</th> 
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${list}">
	      <tr>
	        <td>${item.bNum}</td>
	        <td>
	        <a href="/gboard/detail?bNum=${item.bNum}&page=${pagingVO.page}&year=${year}&month=${month}">${item.bTitle}</a>
	        </td>
	        <td>${item.bReadCount}</td>
	        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.bWriteDate}"/>  </td>
	        <td><a href="/admin/gboard/delete?bNum=${item.bNum}"><i class="material-icons">delete</i></a></td>
	      </tr>
      </c:forEach>

    </tbody>
  </table>
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
    	<li class="page-item"><a class="page-link" href="/gboard/list?page=${pagungVO.endPage +1}&year=${year}&month=${month}">다음</a></li>
    </c:if>
  </ul>
</div>

<%@include file="../footer.jsp" %>

