<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 	<div class="mainLeft">
		<div class="mainTitle">
			<a href="/board/list?bigcategory=${bigcategory }&category=${category}">PC</a>
		</div>
		<ul class="title">
			<li class="title">
				정보 게시판
				<ul class="sub">
					<li class="sub Active"><a href="/board/list?bigcategory=${bigcategory }&category=6000" class="BGC-blue">PC 정보</a></li>
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=6001">예판/핫딜정보</a></li>
				</ul>
			</li>
			<li class="title">
				게임 게시판
				<ul class="sub">
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=6002">게임 추천</a></li>
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=6003">질문 게시판</a></li>
				</ul>
			</li>
			<li class="title" style="margin-top: 5px;">
				<a href="/board/list?bigcategory=${bigcategory }&category=6004">PC 업체 견적</a>
				<ul class="sub">
					<li class="sub"></li>
				</ul>
			</li>
			<li class="title">
				H/W 게시판
				<ul class="subLast">
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=6005">모니터</a></li>
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=6006">노트북/데스크탑</a></li>
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=6007">기타/주변기기</a></li>
					<li class="sub"><a href="/board/list?bigcategory=${bigcategory }&category=6008">소프트웨어</a></li>
				</ul>
			</li>
		</ul>
	</div>