<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<title>Board</title>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark myNavBar">
  <a class="navbar-brand" href="/">Board</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/ps4/board?bigcategory=3001&category=4000">PS4</a>
      </li>
      	<li class="nav-item"><a class="nav-link"
					href="/ps4/board?bigcategory=3002&category=4000">PSVita</a></li>
					<li class="nav-item"><a class="nav-link"
					href="/ps4/board?bigcategory=3003&category=4000">XBOX</a></li>
					<li class="nav-item"><a class="nav-link"
					href="/ps4/board?bigcategory=3004&category=5000">SWITCH</a></li>
					<li class="nav-item"><a class="nav-link"
					href="/ps4/board?bigcategory=3005&category=5000">3DS</a></li>
					<li class="nav-item"><a class="nav-link"
					href="/ps4/board?bigcategory=3006&category=6000">PC</a></li>
					<li class="nav-item"><a class="nav-link"
					href="/ps4/board?bigcategory=3007&category=7000">휴대폰</a></li>
      
      
      <c:choose>
      	<c:when test="${empty sessionScope.userEmail}">
      	  <li class="nav-item">
	        <a class="nav-link" href="/user/loginForm">로그인</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/user/joinForm">회원가입</a>
	      </li>  
      	</c:when>
      	<c:otherwise>
 	      <li class="nav-item">
	        <a class="nav-link" href="/mypage/pointList">마이페이지</a>
	      </li>       	
 	      <li class="nav-item">
	        <a class="nav-link" href="/user/logout">로그아웃</a>
	      </li>       	
      	</c:otherwise>
      </c:choose>
 
	      <li class="nav-item">
	        <a class="nav-link" href="/admin/userList">회원목록</a>
	      </li>  
	      <li class="nav-item">
	        <a class="nav-link" href="/admin/pointList">포인트관리</a>
	      </li>  
   	      <li class="nav-item">
	        <a class="nav-link" href="/admin/levelList">레벨관리</a>
	      </li>  
 
      
       
    </ul>
  </div>  
</nav>
<br>