<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header.jsp" %>
<%-- <%@include file="p_header.jsp" %> --%>

<div class="container">
  <h2> 구매가 완료 되었습니다.</h2>
    <p class="bg-success text-white">${sessionScope.userEmail} 님 구매해 주셔서 감사합니다.</p>
    ※ 결재관련 모듈은 준비중입니다. 
  <button type="button" id="btnList" class="btn btn-outline-dark">  <a href="/product/list">상품목록</a></button>
</div>

<%@include file="../footer.jsp" %>


