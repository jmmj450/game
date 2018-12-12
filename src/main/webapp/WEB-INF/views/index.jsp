<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<c:out value="${sessionScope.userEmail}" />
<c:out value="${sessionScope.userAdmin}" />

<%@include file="footer.jsp" %>

