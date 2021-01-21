<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragment/dashboard_header.jsp"></jsp:include>
<body>
<jsp:include page="../fragment/dashboard_navbar.jsp"></jsp:include>
<!-- End Navbar -->

<section class="mt-5 container" id="list">
  <div class="row">
    <div class="col-12">
      <h2>Quiz</h2>
      <div class="row mt-5">

        <div class="col-10 mx-auto">
          <form action="${pageContext.request.contextPath}/dashboard/quizzes/process" method="POST">
            <input type="hidden" name="id" value="${quiz.id}">
            <div class="form-group">
              <label>Name</label>
              <input type="text" name="name"
                     class="form-control ${errors.name != null ? 'is-invalid' : ''}"
                     value="${quiz.name}">
              <div class="invalid-feedback">
                ${errors.name}
              </div>
            </div>

            <div class="form-group">
              <label>Timeout</label>
              <input type="number" name="timeout"
                     class="form-control ${errors.timeout != null ? 'is-invalid' : ''}"
                     placeholder="minutes"
                     value="${quiz.timeout}">
              <div class="invalid-feedback">
                ${errors.timeout}
              </div>
            </div>

            <div class="form-group">
              <label>Subject</label>
              <select class="form-control" name="subject_id">
              <c:forEach items="${subjects}" var="subject">
                <option value="${subject.id}" ${subject.id == quiz.subjectId ? 'selected' : ''}>${subject.name}</option>
              </c:forEach>
              </select>
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
