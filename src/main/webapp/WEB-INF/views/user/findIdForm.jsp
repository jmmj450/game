<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>

<div class="container">
  <form action="/user/findId" method="POST">
    <div class="form-group">
      <input name="userName" type="text" class="form-control" placeholder="Enter userName" required="true" />
    </div>
    <div class="form-group">
      <input name="userPhone" type="text" class="form-control" placeholder="Enter Phone Number" required="true" />
    </div>       
    <input type="submit" class="btn btn-primary" value="확인" />
  </form>
</div>

<%@include file="../footer.jsp" %>


