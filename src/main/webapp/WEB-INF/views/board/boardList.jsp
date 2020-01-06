<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지's</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>

<div class="container">
  <h2 style="text-align: center;">Notice List</h2>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>글번호</th>
        <th>글제목</th>
        <th>글쓴이</th>
        <th>작성날짜</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${list }" var="notice">
      <tr>
        <td>${notice.num }</td>
        <td><a href="NoticeSelect?num=${notice.num }">${notice.title }</a></td>
        <td>${notice.writer }</td>
        <td>${notice.regDate }</td>
        <td>${notice.hit }</td>
      </tr>      
	</c:forEach>
    </tbody>
  </table>
<!-- PAGER ----------------------------------------------------->  
 	<div class="or-pager">
		<c:if test="${pager.curBlock gt 1 }">
			
			<button type="button" class="btn-pager" id="none-hover"> << </button>
		</c:if>
		<c:if test="${pager.curBlock ne 1 }">
			<button type="button" class="btn-pager" id="none-hover"> < </button>
		</c:if>
		<c:forEach begin="${pager.startNum }" end="${pager.lastNum}" var="p">
		<c:choose>
			<c:when test="${pager.curPage eq p }">
				<button type="button" style="color: black; font-weight: bold;" title="${p }" class="btn-pager"> ${p } </button>
			</c:when>
			<c:otherwise>
				<a href="NoticeList?curPage=${p }">${p }</a>
<%-- 				<button type="button" title="${p }"  class="btn-pager"> ${p } </button> --%>
			</c:otherwise>
		</c:choose>
		
		</c:forEach>
		<c:if test="${pager.curBlock lt pager.totalBlock }">
			<button type="button" class="btn-pager" id="none-hover"> > </button>
			<c:if test="${pager.totalBlock gt pager.curBlock+1 }">
				<button type="button" class="btn-pager" id="none-hover"> >> </button>
			</c:if>
		</c:if>
<!-- PAGER ----------------------------------------------------->
	<select name="kind" id="kind">
		<option value="tt">제목</option>
		<option value="wt">작성자</option>
		<option value="ct">내용</option>
	</select>
	
	<input name="search" type="text" id="search">
	
	<button type="button" onclick="search()">검색</button>
	</div>
	
</div>

<script type="text/javascript">
	function search() {
		location.href = "NoticeSearch?kind="+$("#kind").val()+"&search="+$("#search").val();
		}
</script>
</body>
</html>