<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>
<div class="container">
  <h2 style="text-align: center;">Welcome! Buddy</h2>
  <form:form action="memberSignUp" method="post" enctype="multipart/form-data" modelAttribute="memberVO">
  	<div class="form-group">
      <label for="email">ID:</label>
      <form:input path="id" type="text" class="form-control" id="id" placeholder="Enter ID"/>
      <form:errors path="id" cssStyle="color:red;"/>
    </div>
    <div class="form-group">
      <label for="pw">PW:</label>
      <form:password path="pw" class="form-control" id="pw" placeholder="Enter PW"/>
      <form:errors path="pw" cssStyle="color:red;"/>
    </div>
    <div class="form-group">
      <label for="pw2">PW-RE:</label>
      <form:password path="pw2" class="form-control" id="pw2" placeholder="Enter PW-re"/>
      <form:errors path="pw2" cssStyle="color:red;"/>
    </div>
    <div class="form-group">
      <label for="name">NAME:</label>
      <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter NAME" />
      <form:errors path="name" cssStyle="color:red;" />
    </div>
    <div class="form-group">
      <label for="email">EMAIL:</label>
      <form:input path="email" class="form-control" id="email" placeholder="Enter EMAIL" />
    </div>
    <div class="form-group">
      <label for="file">FILE:</label>
      <input type="file" class="form-control" id="files" name="files">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
  </form:form>
</div>
</body>
</html>