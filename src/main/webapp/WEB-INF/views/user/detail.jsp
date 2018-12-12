<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>

<div class="container">
    <div class="form-group">
      이름 : ${userVO.userName}
    </div>
    <div class="form-group">
      아이디(이메일) : ${userVO.userEmail}
    </div>
    <div class="form-group">
      비밀번호 : ${userVO.userPassword}
    </div>    
    <div class="form-group">
      주소 : ${userVO.userAddr}
    </div>   
    <div class="form-group">
      포인트 : ${userVO.userPoint}
    </div>   
    <div class="form-group">
      회원레벨 : ${userVO.userLevel}
    </div>   
    <div class="form-group">
      로그인횟수 : ${userVO.userLoginCount}
    </div>   
    <div class="form-group">
      회원가입일 : ${userVO.userDate}
    </div>   
    <div class="form-group">
      관리자여부 : ${userVO.userAdmin}
    </div>   

</div>

<%@include file="../footer.jsp" %>


