<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header.jsp" %>
<%-- <%@include file="p_header.jsp" %> --%>

<script>
	$(document).ready(function(){
		// 리스트 페이지로 이동
		$("#btnList").click(function(){
			location.href="$product/list";
		});
		
		$('#btnBuy').click(function () {
			$('#form1').attr('action', 'buy').submit();
		});
		
		
	});
</script>

<div class="container">
  <h2>장바구니보기</h2>
  <p>${sessionScope.userEmail} 님의 장바구니 입니다.</p>     
  <c:choose>
  	<c:when test="${map.count == 0 }"> <p>장바구니가 비었습니다.</p></c:when>
  	<c:otherwise>
  	  <form name="form1" id="form1" method="post" action="update">
 	    <table class="table table-striped">
		  <thead>
		    <tr>
		      <th>상품명</th>
		      <th>단가</th>
		      <th>수량</th>
		      <th>금액</th>
		      <th>취소</th>
			</tr>
		  </thead>
		  <tbody>
		    <c:forEach var="row" items="${map.list }" varStatus="i">		  
				<tr> 	
				  <td>${row.proName }</td>
				  <td style="width: 80px" align="right">
				    <fmt:formatNumber value="${row.proPrice}" pattern="###,###,###"/>
				  </td>
				  <td>
				    <input type="number" style="width: 40px" name="amount" value="${row.cartAmount}" min="1"/>
				    <input type="hidden" name="proNum" value="${row.proNum}"/>
				  </td>
				  <td style="width: 100px" align="right">
				    <fmt:formatNumber value="${row.money}" pattern="###,###,###"/>
				  </td>                                                                                                                                                                                                                                                                                                                                                    
				  <td>
				    <a href="delete?cartNum=${row.cartNum}"><i class="material-icons">delete</i></a>
				  </td>
				</tr>
		    </c:forEach>
		    <tr>
	      	  <td colspan="5" align="right">
	      	 	장바구니 금액합계 : <fmt:formatNumber value="${map.sumMoney}" pattern="###,###,###"/><br>
	      		배송료 : ${map.fee}<br>
	      		전체 주문금액 : <fmt:formatNumber value="${map.allSum}" pattern="###,###,###"/>
	      	  </td> 
	        </tr>
		  </tbody>
	    </table>
	    <input type="hidden" name="count" value="${map.count}"/>
	    <button type="submit" id="btnUpdate" class="btn btn-outline-success">수정</button>
		<button type="button" id="btnBuy" class="btn btn-outline-success">구매결정</button>
<!-- 	    <button type="button" id="btnBuy1" class="btn btn-outline-success"><a href="/cart/buy">구매결정</a></button> -->
	  </form>
    </c:otherwise>
  </c:choose>
  <button type="button" id="btnList" class="btn btn-outline-dark"><a href="/product/list">상품목록</a></button>
</div>

<%@include file="../footer.jsp" %>


