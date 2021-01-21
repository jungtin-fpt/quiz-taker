<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Quiz</title>
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
			crossorigin="anonymous"
		/>
		<style>
			#home__container {
				width: 100%;
				height: 100vh;
			}

			#home__container > * {
				height: inherit;
			}

			#home__img {
				width: 100%;
				height: 100%;

				object-fit: cover;
				object-position: center;
			}

			#home__content {
				display: flex;
				flex-direction: column;

				justify-content: center;
				align-items: flex-start;
				padding: 0 20px 0 50px;
			}

			#home__content h1 {
				font-size: 4.2rem;
				font-weight: 500;
			}
		</style>
	</head>
	<body>
		<div class="container-fluid g-0" id="home__container">
			<div class="row g-0">
				<div class="col-6">
					<img
						src="https://images.unsplash.com/photo-1434030216411-0b793f4b4173?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80"
						id="home__img"
					/>
				</div>
				<div class="col-6" id="home__content">
					<h1>Quiz Taker</h1>
					<p class="lead">
						Xin chào bạn đã đến với Quiz Taker, trang web làm bài kiểm tra lớn nhất Việt
						Nam
					</p>
					<a href="<c:url value="/home"></c:url>" class="btn btn-outline-success">Truy cập</a>
				</div>
			</div>
		</div>
		<!-- Script -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
			crossorigin="anonymous"
		></script>
	</body>
</html>
