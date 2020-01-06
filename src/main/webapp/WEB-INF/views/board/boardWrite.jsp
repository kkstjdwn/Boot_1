<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 작성</title>
<c:import url="../template/boot.jsp"/>
<!-- 서머노트 -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
</head>
<body>
<c:import url="../template/nav.jsp"/>
<div class="container">
  <h2 style="text-align: center;">Notice Write</h2>
  
  <form:form class="form-horizontal" action="NoticeWrite" modelAttribute="noticeVO" method="post" id="frm" enctype="multipart/form-data">
    <div class="form-group">
      <label class="control-label col-sm-2" for="title">TITLE</label>
      <div class="col-sm-10">
      	<form:input path="title" cssClass="form-control" id="title" placeholder="Enter title"/>
      	<form:errors path="title" cssStyle="color:red;"/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="writer">WRITER</label>
      <div class="col-sm-10">          
      	<form:input path="writer" cssClass="form-control" id="writer" value="${member.name }" readonly="readonly"/>
      	<form:errors path="writer" cssStyle="color:red;"/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="contents">CONTENTS</label>
      <div class="col-sm-10">
      	<form:textarea path="contents" cssClass="form-control" id="contents" placeholder="Enter Contents" />
      </div>
    </div>
    <div class="form-group" >
    	<div class="col-sm-offset-2 col-sm-10">
		<input type="button"  class="btn btn-info" id="add" value="ADD FILE">
		<div id="files" class="col-sm-12">
<!-- 			<div class="input-group col-xs-3"> -->
<!-- 				<input type="file" name="files" class="form-control"> -->
<!-- 				<span class="input-group-addon"> -->
<!-- 					<i class="glyphicon glyphicon-remove del"> -->
<!-- 					</i> -->
<!-- 				</span> -->
<!-- 			</div> -->
		</div>
		</div>
	</div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Write</button>
      </div>
    </div>
  </form:form>
</div>
<script type="text/javascript">
	$("#contents").summernote({
			height : 500
		});

	var count=0;
	
	$("#add").click(function() {
		if(count<5){
			var result ='<div class="input-group col-xs-3"><input type="file" name="files" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-remove del"></i></span> </div>';
			$("#files").append(result);
			count++;
		}else {
			alert("첨부파일은 최대 5개만 가능합니다.");
		}
	});
	
	$("#files").on("click", ".del", function() {
		$(this).parent().parent().remove();
		//$(this).remove();
		count--;
	});
</script>
</body>
</html>