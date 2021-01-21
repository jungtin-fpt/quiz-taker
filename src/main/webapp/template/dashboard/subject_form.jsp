<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragment/dashboard_header.jsp"></jsp:include>
<body>
<jsp:include page="../fragment/dashboard_navbar.jsp"></jsp:include>
<!-- End Navbar -->

<section class="mt-5 container" id="list">
  <div class="row">
    <div class="col-12">
      <h2>Subject</h2>
      <div class="row mt-5">

        <div class="col-10 mx-auto">
          <form action="${pageContext.request.contextPath}/dashboard/subjects/process" method="POST">
            <input type="hidden" name="id" value="${subject.id}">
            <div class="form-group">
              <label>Name</label>
              <input type="text" name="name"
                     class="form-control ${errors.name != null ? 'is-invalid' : ''}"
                     value="${subject.name}">
              <div class="invalid-feedback">
                ${errors.name}
              </div>
            </div>
            <button type="submit" class="btn btn-success">Submit</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Script -->
<jsp:include page="../fragment/dashboard_script.jsp"></jsp:include>
</body>
</html>
