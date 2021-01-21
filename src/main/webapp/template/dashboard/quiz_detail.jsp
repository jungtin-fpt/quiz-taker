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
					<ul>
						<li># : ${quiz.id}</li>
						<li>Name : ${quiz.name}</li>
						<li>Timeout : ${quiz.timeout} minute(s)</li>
						<li>Subject Name : ${quiz.subjectName}</li>
						<li>Create Date : ${quiz.createDate}</li>
					</ul>
					<div class="row mt-5">
						<div class="col-10 mx-auto">
							<div class="accordion" id="accordionExample">

								<div class="card">
									<div class="card-header" id="headingOne">
										<h2 class="mb-0">
											<button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
												Collapsible Group Item #1
											</button>
										</h2>
									</div>

									<div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
										<div class="card-body">
											Some placeholder content for the first accordion panel. This panel is shown by default, thanks to the <code>.show</code> class.
										</div>
									</div>
								</div> <%--End Card--%>

								<div class="card">
									<div class="card-header" id="headingTwo">
										<h2 class="mb-0">
											<button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
												Collapsible Group Item #2
											</button>
										</h2>
									</div>
									<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
										<div class="card-body">
											Some placeholder content for the second accordion panel. This panel is hidden by default.
										</div>
									</div>
								</div> <%--End Card--%>

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- Script -->
		<jsp:include page="../fragment/dashboard_script.jsp"></jsp:include>
	</body>
</html>
