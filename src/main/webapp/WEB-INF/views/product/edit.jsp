<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header.jsp" %>
<%-- <%@include file="p_header.jsp" %> --%>

<script>
$(document).ready(function(){
	// 상품등록 유효성 검사
	$("#form1").submit(function(){
		var proName = $("#proName").val();
		var proPrice = $("#proPrice").val();
		var proContent = $("#proContent").val();
		var proFile = $("#proFile").val();
		
		if (proName == ""){
			alert("상품명을 입력해 주세요.");
			proName.foucs();
//			return false;
		} else if (proPrice == ""){
			alert("상품 가격을 입력해 주세요.");
			proPrice.foucs();
//			return false;
		} else if (proContent == ""){
			alert("상품 상세설명을 입력해 주세요.");
			proContent.foucs();
//			return false;
 		} else if (proFile == ""){
			alert("상품 사진을 입력해 주세요.");
			proFile.foucs();
//			return false; 
		}
		//alert(proName);
		//$('#form1').attr('action', 'insert').submit();
	});
	
	// delete로 이동	
	$('#deleteBtn').click(function () {
		$('#form1').attr('action', 'delete?proNum=${vo.proNum}').submit();
	});
});
</script>

<div class="container">
<p class="bg-success text-white">관리자 ${sessionScope.userEmail} 님이 접속중입니다.</p>
	<form id="form1" name="form1" enctype="multipart/form-data" method="post" action="update">
	  <table class="table">
	    <thead>
	      <tr>
	        <th colspan="2">상 품 수정 & 삭제</th>
	      </tr>
	    </thead>
	    <tbody>     
	      <tr class="table-primary">
	        <td>상품명</td>
	        <td><input type="text" name="proName" class="form-control" id="proName" value="${vo.proName}"></td>
	      </tr>
	      <tr class="table-success">
	        <td>가격(원)</td>
	        <td><input type="text" name="proPrice" class="form-control" id="proPrice" value="${vo.proPrice}"></td>
	      </tr>
	      <tr>
	        <td>상품설명</td>
	        <td>
	  		  <textarea class="form-control" rows="5" cols="60" name="proContent" id="proContent" >${vo.proContent}</textarea>
			</td>
	      </tr> 
	      <tr class="table-warning">
	        <td>상품이미지</td>
	        <td>
	          <img src="/resources/editor/upload/${vo.proFile}" height="300px" width="310px">
	          <input type="file" class="btn btn-success" name="filename" id="proFile" value="파일선택"/>
	          <input type="hidden" name="orgFilename" value="${vo.proFile}">
	        </td>
	      </tr>
	      <tr class="table-dark text-dark">
	        <td colspan="2" align="center">
	          <input type="hidden" name="proNum" value="${vo.proNum}">
	          <input type="submit" class="btn btn-primary" value="수정" id="edit"/>
	          <input type="button" class="btn btn-danger" value="삭제" id="deleteBtn"/>
	          <a href="/product/adminList"><button type="button" class="btn btn-warning">등록상품목록</button></a>
	        </td>
	      </tr>
	    </tbody>
	  </table>
	</form> 
</div>

<%@include file="../footer.jsp" %>

<%@include file="../footer.jsp" %>
