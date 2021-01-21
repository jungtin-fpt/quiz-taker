<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
  <title>Register</title>

  <!-- Font Icon -->
  <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css"
  />

  <!-- Main css -->
  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/register_login.css"/>
</head>
<body>
<div class="main">
  <!-- Sign up form -->
  <section class="signup">
    <div class="container">
      <div class="signup-content">
        <div class="signup-form">
          <h2 class="form-title">Sign up</h2>
          <form method="POST" class="register-form" id="register-form">
            <div class="form-group">
              <label for="name"
              ><i class="zmdi zmdi-account material-icons-name"></i
              ></label>
              <input
                      type="text"
                      name="name"
                      id="name"
                      placeholder="Your Name"
              />
            </div>
            <div class="form-group">
              <label for="email"><i class="zmdi zmdi-email"></i></label>
              <input
                      type="email"
                      name="email"
                      id="email"
                      placeholder="Your Email"
              />
            </div>
            <div class="form-group">
              <label for="pass"><i class="zmdi zmdi-lock"></i></label>
              <input
                      type="password"
                      name="pass"
                      id="pass"
                      placeholder="Password"
              />
            </div>
            <div class="form-group">
              <label for="re_pass"
              ><i class="zmdi zmdi-lock-outline"></i
              ></label>
              <input
                      type="password"
                      name="re_pass"
                      id="re_pass"
                      placeholder="Repeat your password"
              />
            </div>
            <div class="form-group form-button">
              <input
                      type="submit"
                      name="signup"
                      id="signup"
                      class="form-submit"
                      value="Register"
              />
            </div>
          </form>
        </div>
        <div class="signup-image">
          <figure>
            <img
                    src="https://miro.medium.com/max/1302/1*nh4e2k1IjeXjrbPKn4S7sg.png"
                    alt="sing up image"
            />
          </figure>
          <a href="#" class="signup-image-link">I am already member</a>
        </div>
      </div>
    </div>
  </section>

  <!-- Sing in  Form -->
  <section class="sign-in">
    <div class="container">
      <div class="signin-content">
        <div class="signin-image">
          <figure>
            <img
                    src="data:image/jpeg;base64,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"
                    alt="sing up image"
            />
          </figure>
          <a href="#" class="signup-image-link">Create an account</a>
        </div>

        <div class="signin-form">
          <h2 class="form-title">Sign up</h2>
          <form method="POST" class="register-form" id="login-form">
            <div class="form-group">
              <label for="your_name"
              ><i class="zmdi zmdi-account material-icons-name"></i
              ></label>
              <input
                      type="text"
                      name="your_name"
                      id="your_name"
                      placeholder="Your Name"
              />
            </div>
            <div class="form-group">
              <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
              <input
                      type="password"
                      name="your_pass"
                      id="your_pass"
                      placeholder="Password"
              />
            </div>
            <div class="form-group form-button">
              <input
                      type="submit"
                      name="signin"
                      id="signin"
                      class="form-submit"
                      value="Log in"
              />
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</div>
</body>
</html>
