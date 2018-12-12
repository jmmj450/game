<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/editor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>

<%@include file="../header.jsp" %>

<div class="container">
  <form action="/admin/levelWrite" method="POST" name="w_form">
    <div class="form-group">
      <input name="level" type="text" class="form-control" placeholder="Enter level" required="true" />
    </div>
    <div class="form-group">
      <input name="point" type="text" class="form-control" placeholder="Enter point" required="true" />
    </div>
    <button type="submit" class="btn btn-primary" onClick="">등록</button>
  </form>
</div>

<%@include file="../footer.jsp" %>

