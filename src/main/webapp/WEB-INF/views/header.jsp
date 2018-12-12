<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<link href="/resources/css/header.css" rel="stylesheet" type="text/css">
	<link href="/resources/css/default.css" rel="stylesheet" type="text/css">
	<title>GameCommunity</title>
	<script>
	$(document).ready(function(){
		$(".headLine-Button").on("mouseover", function(){
			$(this).removeClass("headLine-Button");
			$(this).addClass("headLine-Active");
		});
		$(".headLine-Button").on("mouseout", function(){
			$(this).addClass("headLine-Button");
			$(this).removeClass("headLine-Active");
		});
	});
	</script>
</head>
<body>
<div class="header-warp">
	<a href="/"><img src="/resources/img/ruliweb.png" class="ruliweb"></a>
	<input type="text" class="searchBar">
	<input type="button" class="boardSearchButton" value="게시판 찾기">
	<div class="float-right">
		<div class="rightText">
			<c:choose>
	      	<c:when test="${empty sessionScope.userEmail}">
	      		<a href="/user/joinForm" class="headerDeco">회원가입</a> &middot; 
				<a href="/user/loginForm" class="loginDeco"><font style="color:#1A70DC;">로그인</font></a>
	      	</c:when>
	      	<c:otherwise>
		        <a href="/mypage/pointList" class="loginDeco"><font style="color:#1A70DC;">마이페이지</font></a>  &middot;
		        <a href="/cart/list" class="loginDeco"><font style="color:#1A70DC;">장바구니</font></a>  &middot;
		        <a href="/user/logout" class="headerDeco">로그아웃</a>
	      	</c:otherwise>
	      </c:choose>
	      <c:if test="${sessionScope.userAdmin == 1}">
		         &middot; <a href="/admin/userList" class="headerDeco">회원목록</a>
		         &middot; <a href="/admin/pointList" class="headerDeco">포인트관리</a>
		         &middot; <a href="/admin/levelList" class="headerDeco">레벨관리</a> 
		         &middot; <a href="/board/reportBoard" class="headerDeco">신고게시판</a>
		         &middot; <a href="/product/write" class="headerDeco">상품등록</a>
		         &middot; <a href="/product/adminList" class="headerDeco">등록상품목록</a>
		  </c:if>
		</div>
	</div>
</div>
<div class="headLine">
	<div class="margin-left5px">
		<a href="/board/list?bigcategory=3001&category=4000"><div class="headLine-Button">PS4</div></a>
		<a href="/board/list?bigcategory=3002&category=4000"><div class="headLine-Button">PSVita</div></a>
		<a href="/board/list?bigcategory=3003&category=4000"><div class="headLine-Button">XBOX ONE</div></a>
		<a href="/board/list?bigcategory=3004&category=4000"><div class="headLine-Button">SWITCH</div></a>
		<a href="/board/list?bigcategory=3005&category=4000"><div class="headLine-Button">3DS</div></a>
		<a href="/board/list?bigcategory=3006&category=4000"><div class="headLine-Button">PC</div></a>
		<a href="/board/list?bigcategory=3007&category=4000"><div class="headLine-Button">휴대폰</div></a>
		<a href="/gboard/list"><div class="headLine-Button" style="color: #3EFEFF;">등급분류 게임물 정보</div></a>
		<a href="/product/list"><div class="headLine-Button">쇼핑몰</div></a>
	</div>
</div>