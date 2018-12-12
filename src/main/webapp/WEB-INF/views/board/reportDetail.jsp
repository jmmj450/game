<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>

<section id="about">
  <div class="container">
          
	<a href="/board/reportBoard?page=${page }" class="btn btn-primary">목록</a>
	<div class="row">
		<div class="col-lg-8 mx-auto">
			<h2 class="text-center"><b>${reportVO.bTitle}</b></h2>
			<hr>
			<a href="${reportVO.uri}"><p class="lead">${reportVO.uri}</p></a>
			<hr>
		</div>
		<hr>
		
		
		<!-- END -->
	</div>
  </div>
</section>

<%@include file="../footer.jsp" %>


