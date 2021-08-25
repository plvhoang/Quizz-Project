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
    <title>Product Detail - Mobile Store</title>
  </head>
  <body>
    <div class="container p-5 my-3 bg-light" id="head-container">
        <a class="btn float-right border mr-2" href="${pageContext.request.contextPath}/cart"><i class="fa fa-shopping-cart"></i> View Cart</a>
        <h1>Products</h1>
    </div>
    
    <div class="container p-3">
        <div class="row justify-content-center">
            <div class="col-sm-6">
                <img src="${product.imgurl}" class="img-responsive" width=70% id="product-detail-img">
            </div>
            <div class="col-sm-6" id="product-detail">
                <h4>${product.name}</h4>
                <p>
                    ${product.description}
                </p>
                <p><b>Item code : </b> <span class="item-code">123321123</span></p>
                <p><b>Manufacturer : </b> ${product.manufacturer}</p>
                <p><b>Category : </b> ${product.category}</p>
                <p><b>Available units in stock : </b> ${product.instock}</p>
                <h4><small>${product.price} USD</small></h4>
                <div class="btn-toolbar" role="toolbar">
                    <a class="btn btn-success mr-2" href="${pageContext.request.contextPath}/"><i class="fa fa-arrow-circle-left"></i> Back</a>
                    <form method="get" action="${pageContext.request.contextPath}/cart">
                    	<input type="hidden" name="addCartItem" value="${product.code }"/>
                    	<button type="submit" class="btn btn-warning"><i class="fa fa-shopping-cart"></i> Order Now</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/shoppingcart.js"></script>
  </body>
</html>