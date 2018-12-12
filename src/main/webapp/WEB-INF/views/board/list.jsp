<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<%@include file="../header.jsp" %>

<div class="warp">
	<c:choose>
		<c:when test="${bigcategory eq  3001}">
		<%@include file="../category/ps4.jsp" %>
		</c:when>
		<c:when test="${bigcategory eq  3002}">
		<%@include file="../category/psvita.jsp" %>
		</c:when>
		<c:when test="${bigcategory eq  3003}">
		<%@include file="../category/xbox.jsp" %>
		</c:when>
		<c:when test="${bigcategory eq  3004}">
		<%@include file="../category/switch.jsp" %>
		</c:when>
		<c:when test="${bigcategory eq  3005}">
		<%@include file="../category/3ds.jsp" %>
		</c:when>
		<c:when test="${bigcategory eq  3006}">
		<%@include file="../category/pc.jsp"%>
		</c:when>
		<c:when test="${bigcategory eq  3007}">
		<%@include file="../category/phone.jsp" %>
		</c:when>
	</c:choose>
	
	<div class="boardWarp">
		<div class="boardName">PS 게임 이야기</div>
		<div class="boardBEST">
			<div class="bestTitle">게시판 <font class="bestRed">BEST</font></div>
			<hr class="bestBorder">
			<div class="bestSubjects-left">
				<div class="bestSubject">슬림 엄청 조용하네요. 프로 초기버전인데 충격먹었습니다.</div>
				<div class="bestSubject">뜬금없는데서 만난 키류쨩</div>
				<div class="bestSubject">PS4 Pro 7218 판매 시작 확인되었습니다.</div>
				<div class="bestSubject">올해 개인최고의게임은......</div>
				<div class="bestSubject">저지아이즈 요놈물건이네요</div>
				<div class="bestSubject">여긴 진짜 특이하다</div>
				<div class="bestSubject">레데리온라인 빠른이동 진짜 필요합니다 ㅡ</div>
				<div class="bestSubject">어쌔신 오딧세이 엔딩 후 레데리 2 해보니..</div>
			</div>
			<div class="bestSubjects-right">
				<div class="bestSubject">겜도안사고 까는사람들도 쉴드쳐주네 대단..</div>
				<div class="bestSubject">레데리 재미없다란 글은 당연히 할수 있고 정당합니다</div>
				<div class="bestSubject">레데리 온라인 소감</div>
				<div class="bestSubject">레데리2 1.03패치로 동료 버그 고쳐졌나 싶어 25일만에 켜봤습니다.</div>
				<div class="bestSubject">레데리2 말사는데 600시간 글은 사라졌네요</div>
				<div class="bestSubject">룰웹은 고의성 스포가 너무 심함</div>
				<div class="bestSubject">사 일 런 트 힐 추억의 이름</div>
				<div class="bestSubject">레데리2 온라인 기대했는데 실망이네여</div>
			</div>
		</div>
		<div class="boardAD">광고</div>
		<div class="boardButtonsTop">
			<a href="/board/writeForm?page=${pagingVO.page }&bigcategory=${bigcategory }" class="shadowBlueButton BGC-blue">글쓰기</a>
			<!-- <div class="imageButton"><i class="material-icons" style="font-size: 18px;">&#xe3f4;</i></div>
			<div class="noticeButton">공지</div> -->
		</div>
		<div class="boardTable">
			<form action="admin/board/delete" method="post" onsubmit="return confirm('삭제하시겠습니까?')">
			<div class="tr">
				<div class="th id">ID</div>
				<div class="th contentSubject" style="text-align:center;">제목</div>
				<div class="th name">글쓴이</div>
				<div class="th up">추천</div>
				<div class="th read">조회</div>
				<div class="th date">날짜</div>
		        <c:if test="${check==1}">
		        	<div class="th delete-btn">
		        		<input type="submit" value="삭제">
		        	</div>
		        </c:if>
			</div>
			<c:forEach var="item" items="${list}">
			<div class="tr">
				<div class="td id">${item.bNum}</div>
				<div class="td contentSubject">
					<c:if test="${item.reLev gt 0 }">
						<img src="/resources/img/level.gif" width="${otem.reLev*10 }" height="16">
						<img src="/resources/img/re.gif">
					</c:if>
			        <a href="/board/detail?bNum=${item.bNum}&page=${pagingVO.page}&bigcategory=${bigcategory}&category=${category}">${item.bTitle}</a>
				</div>

				<div class="td name">
				<c:choose>
					<c:when test="${item.userEmail ne null }">
						${item.userEmail  }
					</c:when>
					<c:otherwise>
						비회원
					</c:otherwise>
				</c:choose>
				</div>
				<div class="td up">${item.recommend }</div>
				<div class="td read">${item.bReadCount }</div>
				<div class="td date"><fmt:formatDate pattern="MM-dd" value="${item.bWriteDate}"/></div>
				<c:if test="${check==1}">
					<div class="td delete-btn">
        				<input type="checkbox" value="${item.bNum}" name="checkboxDelete">
       				</div>
        		</c:if>
			</div>
			</c:forEach>
			</form>
		</div><!-- BOARDTABLE END -->
		<div class="boardButtonsBottom-List">
			<a href="/board/writeForm?page=${pagingVO.page }&bigcategory=${bigcategory }" class="shadowBlueButton">글쓰기</a>
			<div class="boardCount">총<font style="color: #1A70DC;"> ${pagingVO.count}</font>개의 글이 있습니다.</div>
			<a href="#" class="shadowWhiteButton">목록</a>
		</div>
		
		<div class="boardPage">
			<div class="pageNums">
				<ul class="pagination justify-content-center">
					<c:if test="${pagingVO.startPage gt pagingVO.pageBlock}">
						<li class="page-item"><a class="pageLeftButton" href="/board/list?page=${pagingVO.startPage -1}&bigcategory=${bigcategory}&category=${category}">&#60;</a></li>
					</c:if>
					<c:forEach var="i" begin="${pagingVO.startPage}" end="${pagingVO.endPage }" step="1">
						<c:choose>
							<c:when test="${pagingVO.page eq i }">
								<li class="page-item"><a class="pageNum-Active" href="/board/list?page=${i }&bigcategory=${bigcategory }&category=${category}"><b>${i }</b></a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="pageNum" href="/board/list?page=${i }&bigcategory=${bigcategory }&category=${category}">${i }</a></li>   			
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pagingVO.endPage lt pagingVO.pageCount}">
						<li class="page-item"><a class="pageRightButton" href="/board/list?page=${pagingVO.endPage +1}&bigcategory=${bigcategory}&category=${category}">&#62;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="boardSearch">
			<div class="Search">
				<form action="/board/search" method="post">
					<input type="hidden" value="${bigcategory }" name="bigcategory">
					<input type="hidden" value="${category}" name="category">
					<select name="searchOption" class="searchSelect">
						<option value="title">제목</option>
						<option value="content">본문</option>
						<option value="all">제목+본문</option>
						<option value="writer">글쓴이</option>
					</select>
					<input type="text" class="searchInput" name="keyword">
					<input type="submit" value="검색" class="searchButton">
				</form>
			</div>
		</div>
		<!-- <hr>
		게시판 지기
		운영자 관리자 -->
	</div><!-- BOARDWARP END -->
</div>

<%@include file="../footer.jsp" %>