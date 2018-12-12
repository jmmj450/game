<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header.jsp" %>
<%-- <%@include file="p_header.jsp" %> --%>

<div class="container">
  <h2>상품 상세정보</h2>
  <p>당신의 쇼핑을 환영합니다. ^^</p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th><img src="/resources/editor/upload/${vo.proFile}", width="340px" height="300px" /></th>
        <th>
          <table class="table table-bordered" style="height: 300px; width: 400px;">
		    <tbody>
		      <tr align="center">
		        <td>상품명</td>
		        <td>${vo.proName}</td>			  
		      </tr>
		      <tr align="center">
		        <td>상품가격</td>
		        <td><fmt:formatNumber value="${vo.proPrice}" pattern="###,###,###"/></td>
		      </tr>
		      <tr align="center">
		        <td>상품등록일시</td>
		        <td>${vo.proTime}</td>
		      </tr>
		      <tr align="center">
		        <td colspan="2">
		          <form name="form1" method="post" action="/cart/insert">
		            <input type="hidden" name="proNum" value="${vo.proNum}">
		            <input type="hidden" name="userEmail" value="admin@a.co.kr">
		            <select name="cartAmount">
		            	<c:forEach begin="1" end="10" var="i">
		            		<option value="${i}">${i}</option>
		            	</c:forEach>
		            </select>&nbsp;개
		            
		            <c:choose>
	      				<c:when test="${empty sessionScope.userEmail}">
			            	<p class="nav-item" style=" color: red">먼저 로그인 하세요!!!</p> 
			            </c:when>
			            <c:otherwise>
		        			 <input type="submit" value="장바구니에 담기">     	
	      				</c:otherwise>
		            </c:choose>
		            
		          </form>
		          <a href="/product/list">상품목록으로</a>
		        </td>	        
		      </tr>
		    </tbody>
		   </table>
		 </th>
		</tr>
		<tr align="left">
			<td colspan="2"> 상품소개<br> ${vo.proContent} 
		</tr>
  </table>
</div>


<%@include file="../footer.jsp" %>

 	      



