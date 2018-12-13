<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header.jsp" %>
<%-- <%@include file="p_header.jsp" %> --%>

<script>
/* function check() {
 else {
		alert("ok");
		return true;
	}
	return false;

} */

$(document).ready(function(){
	// 상품등록 유효성 검사
	$("#form1").submit(function(){
		var proName = $("#proName").val();
		var proPrice = $("#proPrice").val();
		var proContent = $("#proContent").val();
		var proFile = $("#proFile").val();
		
		if (proName == ""){
			alert("상품명을 입력해 주세요.");
		//	proName.foucs();
			return false;
		} else if (proPrice == ""){
			alert("상품 가격을 입력해 주세요.");
		//	proPrice.foucs();
			return false;
		} else if (proContent == ""){
			alert("상품 상세설명을 입력해 주세요.");
		//	proContent.foucs();
			return false;
		} else if (proFile == ""){
			alert("상품 사진을 입력해 주세요.");
		//	proFile.foucs();
			return false;
		}
		//alert(proName);
		//$('#form1').attr('action', 'insert').submit();
	});
});
</script>

<div class="container">
<p class="bg-success text-white">관리자 ${sessionScope.userEmail} 님이 접속중입니다.</p>
	<form id="form1" name="form1" enctype="multipart/form-data" method="post" action="insert">
	  <table class="table">
	    <thead>
	      <tr>
	        <th colspan="2">상 품 등 록</th>
	      </tr>
	    </thead>
	    <tbody>     
	      <tr class="table-primary">
	        <td>상품명</td>
	        <td><input type="text" name="proName" class="form-control" id="proName"></td>
	      </tr>
	      <tr class="table-success">
	        <td>가격(원)</td>
	        <td><input type="number" name="proPrice" class="form-control" id="proPrice"></td>
	      </tr>
	      <tr>
	        <td>상품설명</td>
	        <td>
	  		  <textarea class="form-control" rows="5" cols="60" name="proContent" id="proContent"></textarea>
			</td>
	      </tr> 
	      <tr class="table-warning">
	        <td>상품이미지</td>
	        <td><input type="file" class="btn btn-success" name="file" id="proFile" value="파일선택"/></td>
	      </tr>
	      <tr class="table-dark text-dark">
	        <td colspan="2">
	          <input type="submit" class="btn btn-primary" value="상품 등록" id="addBtn">
	          <a href="/product/adminList"><button type="button" class="btn btn-warning">등록상품목록</button></a>
	        </td>
	      </tr>
	    </tbody>
	  </table>
	</form> 
</div>


<%@include file="../footer.jsp" %>


