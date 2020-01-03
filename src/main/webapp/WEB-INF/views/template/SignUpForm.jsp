<form action="memberSignUp" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="email">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
    </div>
    <div class="form-group">
      <label for="pw">PW:</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter PW" name="pw">
    </div>
    <div class="form-group">
      <label for="pw-re">PW-RE:</label>
      <input type="password" class="form-control" id="pw-re" placeholder="Enter PW-re" name="pw=re">
    </div>
    <div class="form-group">
      <label for="name">NAME:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter NAME" name="name">
    </div>
    <div class="form-group">
      <label for="email">EMAIL:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter EMAIL" name="email">
    </div>
    <div class="form-group">
      <label for="file">FILE:</label>
      <input type="file" class="form-control" id="files" name="files">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
  </form>