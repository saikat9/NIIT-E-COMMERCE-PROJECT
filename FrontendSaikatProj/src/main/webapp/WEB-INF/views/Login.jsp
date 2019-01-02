<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>NIIT ECOMMERCE</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">

body {
    background-color: silver;
}
</style>
</head>
<body>
<section class="login-block">
<div class="container">
<div class="row">
<div class="col-md-4 login-sec">
<h2 class="text-center">Login Now</h2>
<form class="login-form" action="perform_login" method="post">
<div class="form-group">
<label for="exampleInputEmail1" class="text-uppercase">Username</label>
<input type="text" class="form-control" placeholder="" name="username">
</div>
<div class="form-group">
<label for="exampleInputPassword1" class="text-uppercase">Password</label>
<input type="password" class="form-control" placeholder="" name="password">
</div>
<div class="copy-text">
<c:if test="${requesturl=='/login_failure'}">
      <p>Invalid Logon.Try again</p>
</c:if>
</div>
<div class="form-check">
<label class="form-check-label">
<input type="checkbox" class="form-check-input">
<small>Remember Me</small>
</label>
<button type="submit" class="btn btn-login float-right">Submit</button>
</div>
</form>
</div>
<div class="col-md-8 banner-sec">
<img class="d-block img-fluid" src="https://static.pexels.com/photos/33972/pexels-photo.jpg" >
</div>
</div>
</div>
</section>
</body>
</html>