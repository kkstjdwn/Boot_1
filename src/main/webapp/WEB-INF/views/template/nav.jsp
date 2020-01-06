<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SPRING BOOT</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath }/">Home</a></li>
      <li><a href="${pageContext.request.contextPath }/board/NoticeList">Notice</a></li>
      <c:choose>
      	<c:when test="${empty member }">
			<li><a href="${pageContext.request.contextPath }/member/memberSignUp">SIGN UP</a></li>
			<li><a href="${pageContext.request.contextPath }/member/memberSignIn">SiGN IN</a></li>      	
      	</c:when>
      	<c:otherwise>
      		<li><a href="${pageContext.request.contextPath }/member/memberSignOut">SIGN OUT</a></li>
			<li><a href="${pageContext.request.contextPath }/member/memberInfo">MYPAGE</a></li>
      	</c:otherwise>
      </c:choose>
    </ul>
    <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Search</button>
    </form>
  </div>
</nav>