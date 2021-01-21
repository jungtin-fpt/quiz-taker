<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="fragment/home_header.jsp"></jsp:include>
<body>
<jsp:include page="fragment/home_navbar.jsp"></jsp:include>
<!-- End Navbar -->

<section class="mt-5 container" id="list">
    <div class="row">
        <div class="col-12">
            <h2>Subjects</h2>
            <p class="lead">Hãy chọn subject mà bạn mong muốn</p>

            <div class="mt-5 border border-1 rounded p-3" id="list__item-container">
                <div class="card" style="width: 18rem">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">
                            Some quick example text to build on the card title and make up
                            the bulk of the card's content.
                        </p>
                        <a href="#" class="btn btn-success">Xem Quiz</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Script -->
<jsp:include page="fragment/home_script.jsp"></jsp:include>
</body>
</html>
