<f:form class="form-horizontal" action="boardWrite" modelAttribute="NoticeVO" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="title">TITLE</label>
      <div class="col-sm-10">
      	<f:input path="title" class="form-control" id="title" placeholder="Enter title"/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="writer">WRITER</label>
      <div class="col-sm-10">          
      	<f:input path="writer" class="form-control" id="writer" value="${member.name }" readonly="readonly"/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="contents">CONTENTS</label>
      <div class="col-sm-10">
      	<f:input path="contents" class="form-control" id="contents" placeholder="Enter Contents" />
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Write</button>
      </div>
    </div>
  </f:form>