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
					<div class="row mt-5">
						<div class="col-10 mx-auto">
							<table class="table table-hover">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Name</th>
										<th scope="col">Create Date</th>
										<th scope="col" colspan="2">
											<a href="${pageContext.request.contextPath}/dashboard/subjects/create" class="btn btn-success"
												>Create new subject</a
											>
										</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${subjects}" var="subject">
									<tr>
										<th scope="row">${subject.id}</th>
										<td><a href="${pageContext.request.contextPath}/dashboard/subjects?id=${subject.id}">${subject.name}</a></td>
										<td>${subject.createDate}</td>
										<td><a class="btn btn-outline-warning btn-sm"
										       href="<c:url value = "/dashboard/subjects/update?id=${subject.id}"/>">Update</a></td>
										<td><a class="btn btn-sm btn-danger"
										       href="<c:url value = "/dashboard/subjects/delete?id=${subject.id}"/>">Delete</a></td>
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
