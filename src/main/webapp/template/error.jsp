<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="fragment/home_header.jsp"></jsp:include>
<body>
<div class="container">
  <div class="row">
    <div class="col-10 mx-auto">
      <!-- 404 Error Text -->
      <div class="text-center">
        <div class="error mx-auto" data-text="404">Error</div>
        <p class="lead text-gray-800 mb-5">${message}</p>
        <p class="text-gray-500 mb-0">From URL : ${requestUri}</p>
        <a href="<c:url value="/"></c:url>">&larr; Back to Homepage</a>
      </div>
    </div>
  </div>
</div>
<jsp:include page="fragment/home_script.jsp"></jsp:include>
</body>
</html>
