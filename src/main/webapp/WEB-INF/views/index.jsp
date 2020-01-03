<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<c:import url="template/boot.jsp"/>
</head>
<body>
<c:import url="template/nav.jsp"/>
<div class="container">
	<form action="/">
		<select name="lang">
			<option value="ko">KO</option>
			<option value="en">EN</option>
		</select>
		<button type="submit">change</button>
	</form>
	
	<h1 style="text-align: center;"> 
		<spring:message code="hello"></spring:message>
		<spring:message code="hello2" text="No MSG"></spring:message><br>
		<c:if test="${!empty member }">
			<spring:message code="loginMessage" arguments="${member.id }-${member.email }" argumentSeparator="-"></spring:message>
		</c:if> 
	</h1>
</div>
<img alt="안나오겠지 뻔하다" src="imgs/mk.jpg" width="100%" height="800px">
</body>
</html>