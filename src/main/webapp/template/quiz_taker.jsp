<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<jsp:include page="fragment/home_header.jsp"></jsp:include>
	<body>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="#">Home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Dashboard</a>
					</li>
				</ul>
			</div>
			<div class="mx-auto order-0">
				<a class="navbar-brand mx-auto" href="#">Quiz Taker</a>
				<button
					class="navbar-toggler"
					type="button"
					data-toggle="collapse"
					data-target=".dual-collapse2"
				>
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
				<a href="#" class="btn btn-outline-danger btn-sm ml-auto">Logout</a>
			</div>
		</nav>
		<!-- End Navbar -->

		<section class="mt-5 container" id="list">
			<div class="row">
				<div class="col-12">
					<h2>Quiz</h2>
					<p class="lead">Thời gian làm bài còn : <b>30:00</b></p>

					<div class="mt-5 border border-1 rounded p-3" id="question__container">
						<div class="question__item">
							<p class="lead font-weight-normal">
								<u>Question 1</u> : Which is NOT a key factor that you should
								consider when planning reuse?
							</p>
							<form action="" method="POST">
								<!-- Answer 1 -->
								<div class="form-group form-check">
									<input
										type="radio"
										name="answer"
										value="1"
										class="form-check-input"
										id="answer-1"
									/>
									<label class="form-check-label" for="answer-1"
										>The criticality of the software and it‟s non-functional
										requirements</label
									>
								</div>

								<!-- Answer 2 -->
								<div class="form-group form-check">
									<input
										type="radio"
										name="answer"
										value="2"
										class="form-check-input"
										id="answer-2"
									/>
									<label class="form-check-label" for="answer-2"
										>The background, skill and experience of the development
										team</label
									>
								</div>

								<!-- Answer 3 -->
								<div class="form-group form-check">
									<input
										type="radio"
										name="answer"
										value="3"
										class="form-check-input"
										id="answer-3"
									/>
									<label class="form-check-label" for="answer-3"
										>The name of the application or component reuse</label
									>
								</div>

								<!-- Answer 4 -->
								<div class="form-group form-check">
									<input
										type="radio"
										name="answer"
										value="4"
										class="form-check-input"
										id="answer-4"
									/>
									<label class="form-check-label" for="answer-4"
										>The development schedule of the software; The application
										domain</label
									>
								</div>

								<button type="submit" class="btn btn-primary">Next question</button>
							</form>
						</div>
						<!-- End Question Item -->
					</div>
				</div>
			</div>
		</section>
		<!-- Script -->
		<jsp:include page="fragment/home_script.jsp"></jsp:include>
	</body>
</html>
