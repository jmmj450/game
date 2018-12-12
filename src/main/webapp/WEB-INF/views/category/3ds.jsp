<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 	<div class="mainLeft">
		<div class="mainTitle">
			<a href="/board/list?bigcategory=${bigcategory }&category=${category}">3DS</a>
		</div>
		<ul class="title">
			<li class="title">
				정보 게시판
				<ul class="sub">
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=5000">유저 정보</a></li>
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=5001">예판/핫딜정보</a></li>
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=5002">게임 심의결과</a></li>
				</ul>
			</li>
			<li class="title">
				게임 게시판
				<ul class="sub">
					<li class="sub Active"><a href="/board/list?bigcategory=${bigcategory }&category=5003" class="BGC-blue">게임 이야기</a></li>
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=5004">질문 게시판</a></li>
				</ul>
			</li>
			<li class="title">
				리뷰 게시판
				<ul class="sub">
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=5005">게임 추천</a></li>
				</ul>
			</li>
			<li class="title">
				스샷/영상
				<ul class="subLast">
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=5006">스크린 샷</a></li>
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=5007">동영상</a></li>
				</ul>
			</li>
		</ul>
	</div>