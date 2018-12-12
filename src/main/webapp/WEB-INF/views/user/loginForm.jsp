<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>


<link href="/resources/css/join.css" rel="stylesheet" type="text/css">

	<div class="box2">
		<div class="main">
			<br> <img src="/resources/img/icon.png">
			<form method="post" id="login_form"
				action="/user/login" target="_self">
				<div class="input_area">
					<h4 class="input_title">아이디</h4>
					<input type="text"
						style="text-align: left; width: 380px; height: 65px; font-size: 30px"
						class="input_value input_ruli" id="userEmail" name="userEmail"
						placeholder="ID">
				</div>
				<div class="input_area">
					<h4 class="input_title">비밀번호</h4>
					<input type="password"
						style="text-align: left; width: 380px; height: 65px; font-size: 30px"
						class="input_value input_ruli" id="userPassword" name="userPassword"
						placeholder="PASSWORD">
				</div>
				<br> <br>
				<div class="input_area">
					<div style="float: left; width: 60%;"><a href="/user/findIdForm">ID</a>·<a href="/user/findPwdForm">PW</a>찾기</div>
					<div style="float: right; width: 40%;">
						자동로그인 <input name="keepLogin" type="checkbox" value="yes" />
					</div>
				</div>
			<br> <br> <br>
			<div class="row">
				<input type="submit" class="bigBlueButton login-btn" value="로그인">
			</div>
			</form>
			<div class="row">
				<button class="bigWhiteButton" style="margin-left: 5px;" onclick="location.href='/user/joinForm'">루리웹 회원가입</button>
				<br>
			</div>
		</div>
	</div>


<%@include file="../footer.jsp" %>

