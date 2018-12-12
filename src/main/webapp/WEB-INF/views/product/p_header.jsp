<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- A grey horizontal navbar that becomes vertical on small screens -->
<nav class="navbar navbar-expand-sm bg-light">
	<ul class="navbar-nav">
      <c:choose>
      	<c:when test="${sessionScope.userEmail eq 'admin@a.com'}">
	        <li class="nav-item">
		      <a class="nav-link" href="/product/write">상품등록</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="/product/adminList">등록상품목록</a>
		    </li>
      	</c:when>

      	<c:otherwise>
		    <li class="nav-item">
		      <a class="nav-link" href="#">메인화면</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="/product/list">상품목록</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="../cart/list">장바구니</a>
		    </li>     	
      	</c:otherwise>
	  </c:choose>
	</ul>


  <!-- Links -->



  <form class="form-inline" action="#">
    <input class="form-control mr-sm-2" type="text" placeholder="Search">
    <button class="btn btn-success" type="submit">Search</button>
  </form>

</nav>


<%-- 	      
	      <c:if test="${sessionScope.userEmail eq 'admin@a.com'}">
	      	 <li class="nav-item">
		        <a class="nav-link" href="/product/write">상품등록</a>
		      </li>
	      </c:if> --%>