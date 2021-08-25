<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/customize.css">
    <!-- Add icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Log In - Mobile Store</title>
  </head>
  <body>
    <div class="container p-5 my-3 bg-light">
      <a class="btn float-right border mr-2" href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i> Home</a>
        <h1>Mobile Store</h1>
    </div>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-sm-4">
          <div class="card">
            <div class="card-header">Please sign in</div>
            <div class="card-body">
              <form id="login-form" method="POST" action="${pageContext.request.contextPath}/login">
                <div class="form-group">
                  <input type="text" class="form-control" placeholder="User Name" name="userName" required>
                </div>
                <div class="form-group">
                  <input type="password" class="form-control" placeholder="Password" name="password" required>
                </div>
                <button type="submit" class="btn btn-success btn-block">Login</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>