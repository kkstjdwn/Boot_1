<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>
<%-- <c:choose> --%>
<%-- <c:when test="${!empty member }"> --%>
	<div class="container">
	  <h2>Horizontal form</h2>
	  <form class="form-horizontal" action="memberUpdate">
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="id">ID:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="id" name="id" readonly="readonly" value="${member.id }">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="pw">Password:</label>
	      <div class="col-sm-10">          
	        <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="id">NAME:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="name" name="name" readonly="readonly" value="${member.name }">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="id">EMAIL:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="email" name="email" readonly="readonly" value="${member.email}">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="file">IMG:</label>
	      <div class="col-sm-10">
	      	<a href="fileDownload?id=${member.id }" style="color: black;">
	        <img alt="${files.oname }" src="../upload/${files.fname }" width="100%"></a>
	      </div>
	    </div>
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <div class="checkbox">
	          <label><input type="checkbox" name="remember"> Remember me</label>
	        </div>
	      </div>
	    </div>
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-warning">MODIFY</button>
	      </div>
	    </div>
	  </form>
	</div>
<%-- </c:when> --%>
<%-- <c:otherwise> --%>
	<script type="text/javascript">
// 		alert("로그인 해주세요!");
// 		location.href="member/memberSignIn";
	</script>
<%-- </c:otherwise> --%>
<%-- </c:choose> --%>
</body>
</html>