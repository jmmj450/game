<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%-- <%@include file="../header.jsp" %> --%>

<div class="warp">
	<div class="mainLeft">
		<div class="mainTitle">
		<a href="/ps4/board?bigcategory=${bigcategory }&category=${category}">PS4</a>
		</div>
		<ul class="title">
			<li class="title">
				정보 게시판
				<ul class="sub">
					<li class="sub"><a href="/ps4/board?bigcategory=${bigcategory }&category=4000">유저 정보</a></li>
					<li class="sub"><a href="/ps4/board?bigcategory=${bigcategory }&category=4001">예판/핫딜정보</a></li>
					<li class="sub">게임 심의결과</li>
				</ul>
			</li>
			<li class="title">
				게임 게시판
				<ul class="sub">
					<li class="sub">게임 이야기</li>
					<li class="sub">질문 게시판</li>
				</ul>
			</li>
			<li class="title">
				스샷/영상
				<ul class="sub">
					<li class="sub">스크린 샷</li>
					<li class="sub">동영상</li>
				</ul>
			</li>
			<li class="title">
				리뷰 게시판
				<ul class="subLast">
					<li class="sub">게임 추천</li>
				</ul>
			</li>
		</ul>
	</div>
	
	<div class="mainCenter">
	<font style="font-size: 16px; color:#575757; font-weight:bold;">PS4 뉴스<br></font>
		<div class="newsTop">
			<div class="newsTopImage"><img src="/resources/img/sample.png"></div>
			<div class="newsTopTitle"><a href="#" class="subjectDeco">‘탐정 진구지 사부로 프리즘 오브 아이즈’ 한국어판, 예약 판매 12월 18일 시작</a></div><div class="subjectComment"> [10]</div>
			<div class="newsTopContent"><a href="#" class="contentDeco"> 아크시스템웍스 아시아지점은 다가오는 12월 18일(화) 출시 예정인 하드보일드 추리 어드벤처 게임 「탐정 진구지 사부로 프리즘 오브 아이즈」의 PlayStation®4와 Nintendo Switch™ 한국어판의 예약 판매를 오늘부터 진행한다.</a></div>			
		</div>
		<div class="newsMid">
			<div class="newsMidLeft">
				<div style="font-weight:bold;">뉴스</div>
				<ul class="news">
					<li class="news">
						<div class="subject"><a href="#" class="subjectDeco">‘뮬라카’ 한국어판, PS4 버전 선행 판매</a></div>
						<div class="comment"> [10]</div>
					</li>
					<li class="news">
						<div class="subject"><a href="#" class="subjectDeco">포트나이트, 전 세계 플레이어 수 ‘2억’ 돌파 </a></div>
						<div class="comment" >[10]</div>
					</li>
					<li class="news">
						<div class="subject"><a href="#" class="subjectDeco">아주르 레인 크로스 웨이브, 5인의 플레이어블 캐릭터 </a></div>
						<div class="comment"> [10]</div>
					</li>
					<li class="news">
						<div class="subject"><a href="#" class="subjectDeco">‘라이드 3’ PC, PS4, Xbox One 12월 정식 출시 예정 </a></div>
						<div class="comment"> [10]</div>
					</li>
					<li class="news">
						<div class="subject"><a href="#" class="subjectDeco">점프 포스, ‘바람의 검심’ 주인공과 보스 참전 </a></div>
						<div class="comment"> [10]</div>
					</li>
					<li class="news">
						<div class="subject"><a href="#" class="subjectDeco">어쌔신 크리드: 오디세이, 최초의 암살검이 등장한다 </a></div>
						<div class="comment"> [10]</div>
					</li>
					<li class="news">
						<div class="subject"><a href="#" class="subjectDeco">레드 데드 온라인, 베타 출시 얼리 액세스 시작 </a></div>
						<div class="comment"> [10]</div>
					</li>
					<li class="news">
						<div class="subject"><a href="#" class="subjectDeco">‘다크사이더스 III’ PS4, XboxOne, PC 한국어판 오늘 출시</a></div>
						<div class="comment"> [10]</div>
					</li>
					<li class="news">
						<div class="subject"><a href="#" class="subjectDeco">데스티니 가디언즈 공식 아트북 오늘부터 예약 구매 시작</a></div>
						<div class="comment"> [10]</div>
					</li>
				</ul>
			</div>
			<div class="newsMidRight">
				<div style="font-weight:bold;">유저정보</div>
				<ul class="news">
					<li class="news"><div class="subject"><a href="#" class="subjectDeco">‘뮬라카’ 한국어판, PS4 버전 선행 판매</a></div><div class="comment"> [10]</div></li>
					<li class="news"><div class="subject"><a href="#" class="subjectDeco">포트나이트, 전 세계 플레이어 수 ‘2억’ 돌파 </a></div><div class="comment" >[10]</div></li>
					<li class="news"><div class="subject"><a href="#" class="subjectDeco">아주르 레인 크로스 웨이브, 5인의 플레이어블 캐릭터 </a></div><div class="comment"> [10]</div></li>
					<li class="news"><div class="subject"><a href="#" class="subjectDeco">‘라이드 3’ PC, PS4, Xbox One 12월 정식 출시 예정 </a></div><div class="comment"> [10]</div></li>
					<li class="news"><div class="subject"><a href="#" class="subjectDeco">점프 포스, ‘바람의 검심’ 주인공과 보스 참전 </a></div><div class="comment"> [10]</div></li>
					<li class="news"><div class="subject"><a href="#" class="subjectDeco">어쌔신 크리드: 오디세이, 최초의 암살검이 등장한다 </a></div><div class="comment"> [10]</div></li>
					<li class="news"><div class="subject"><a href="#" class="subjectDeco">레드 데드 온라인, 베타 출시 얼리 액세스 시작 </a></div><div class="comment"> [10]</div></li>
					<li class="news"><div class="subject"><a href="#" class="subjectDeco">‘다크사이더스 III’ PS4, XboxOne, PC 한국어판 오늘 출시</a></div><div class="comment"> [10]</div></li>
					<li class="news"><div class="subject"><a href="#" class="subjectDeco">데스티니 가디언즈 공식 아트북 오늘부터 예약 구매 시작</a></div><div class="comment"> [10]</div></li>
				</ul>
			</div>
		</div>
		<div class="newsBottom">
			<font style="font-size: 16px; color:#575757; font-weight:bold;">PS4 게임 인기 순위<br></font>
			<div class="populRanking">
				<div class="rank1st">
					<span class="ImageSet">
						<span class="rankNum1st">1</span>
						<span class="Image1st"><img src="/resources/img/red_dead.jpg" width="350px"></span>
					</span>
					<span class="rankTitle1st">
						레드 데드 리뎀션2<br>
						<span class="score1st">8.5</span><font style="color:red;">점</font><span class="rankFont"> (416명 참여)<br>
						어드벤처, 액션<br>
						새글 </span>614
					</span>
				</div>
				<div class="rank">
					<span class="rankNum">2</span>
					<span class="rankTitle">월드 사커 위닝 일레븐 2019</span>
					<span class="rankNew">새 글 <font style="font-weight:bold;">134</font></span>
				</div>
				<div class="rank">
					<span class="rankNum">3</span>
					<span class="rankTitle">몬스터 헌터 월드</span>
					<span class="rankNew">새 글 <font style="font-weight:bold;">112</font></span>
				</div>
				<div class="rank">
					<span class="rankNum">4</span>
					<span class="rankTitle">데스티니 가디언즈</span>
					<span class="rankNew">새 글 <font style="font-weight:bold;">109</font></span>
				</div>
				<div class="rank">
					<span class="rankNum">5</span>
					<span class="rankTitle">다크 소울 3</span>
					<span class="rankNew">새 글 <font style="font-weight:bold;">89</font></span>
				</div>
				<div class="rank">
					<span class="rankNum">6</span>
					<span class="rankTitle">어쌔신 크리드: 오디세이</span>
					<span class="rankNew">새 글 <font style="font-weight:bold;">76</font></span>
				</div>
				<div class="rank">
					<span class="rankNum">7</span>
					<span class="rankTitle">슈퍼로봇대전 X</span>
					<span class="rankNew">새 글 <font style="font-weight:bold;">54</font></span>
				</div>
				<div class="rank">
					<span class="rankNum">8</span>
					<span class="rankTitle">FIFA 19</span>
					<span class="rankNew">새 글 <font style="font-weight:bold;">48</font></span>
				</div>
				<div class="rank">
					<span class="rankNum">9</span>
					<span class="rankTitle">다크 사이더스 3</span>
					<span class="rankNew">새 글 <font style="font-weight:bold;">32</font></span>
				</div>
			</div>
		</div>
	</div>
	
	<div class="mainRight"></div>
</div>

<%-- <%@include file="../footer.jsp" %> --%>