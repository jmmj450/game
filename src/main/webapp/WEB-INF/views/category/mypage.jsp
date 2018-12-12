<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 	<div class="mainLeft">
		<div class="mainTitle">
			<a href="/board/list?bigcategory=${bigcategory }&category=${category}">마이페이지</a>
		</div>
		<ul class="title">
			<li class="title">
				커뮤니티
				<ul class="sub">
					<li class="sub"><a href="/mypage/pointList">포인트</a></li>

				</ul>
			</li>
			<li class="title">
				쇼핑몰
				<ul class="sub">
					<li class="sub"><a href="/cart/list">장바구니</a></li>
				</ul>
			</li>
			<li class="title">
				회원
				<ul class="sub">
					<li class="sub"><a href="/user/updateForm">회원정보수정</a></li>
					<li class="sub"><a href="/user/deleteForm">회원탈퇴</a></li>
				</ul>
			</li>
		</ul>
	</div>