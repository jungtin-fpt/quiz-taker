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
					<h2>Subject</h2>
					<ul>
						<li># : ${subject.id}</li>
						<li>Name : ${subject.name}</li>
						<li>Create Date : ${subject.createDate}</li>
					</ul>
					<div class="row mt-5">
						<div class="col-10 mx-auto">
							<table class="table table-hover">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Name</th>
										<th scope="col">Timeout</th>
										<th scope="col">Subject</th>
										<th scope="col">Create Date</th>
										<th></th>
										<th></th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${subject.quizzes}" var="quiz">
									<tr>
										<th scope="row">${quiz.id}</th>
										<td><a href="${pageContext.request.contextPath}/dashboard/quizzes?id=${quiz.id}">${quiz.name}</a></td>
										<td>${quiz.timeout}</td>
										<td>${quiz.subjectName}</td>
										<td>${quiz.createDate}</td>
										<td><a class="btn btn-outline-warning btn-sm"
										       href="<c:url value = "/dashboard/quizzes/update?id=${quiz.id}"/>">Update</a></td>
										<td><a class="btn btn-sm btn-danger"
										       href="<c:url value = "/dashboard/quizzes/delete?id=${quiz.id}"/>">Delete</a></td>
									</tr>
								</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- Script -->
		<jsp:include page="../fragment/dashboard_script.jsp"></jsp:include>
	</body>
</html>
