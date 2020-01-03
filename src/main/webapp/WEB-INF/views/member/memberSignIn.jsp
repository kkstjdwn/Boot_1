<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>
<c:choose>
	<c:when test="${empty member }">
		<div class="container">
		  <h2 style="text-align: center;">Welcome! Buddy</h2>
		  <form action="memberSignIn" method="post">
		    <div class="form-group">
		      <label for="email">ID:</label>
		      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id" autofocus="autofocus">
		    </div>
		    <div class="form-group">
		      <label for="pw">PW:</label>
		      <input type="password" class="form-control" id="pw" placeholder="Enter PW" name="pw">
		    </div>
		    <div class="checkbox">
		      <label><input type="checkbox" name="remember"> Remember me</label>
		    </div>
		    <button type="submit" class="btn btn-success">Submit</button>
		  </form>
		</div>
	</c:when>
	<c:otherwise>
	<script type="text/javascript">
		alert("이미 로그인 하셨습니다!");
		loaction.href = "/";
	</script>
	</c:otherwise>
</c:choose>
</body>
</html>