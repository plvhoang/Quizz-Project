<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
    <title>View Products - Mobile Store</title>
  </head>
  <body>
    <div class="container p-5 my-3 bg-light" id="head-container">
    	<% 
    		String username = (String) request.getAttribute("username");
    		if (username != null) {
    	%>
    	<a class="btn btn-danger float-right" href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i> Log out</a>
    	<%
    		} else {
    	%>
    	<a class="btn float-right border" href="${pageContext.request.contextPath}/login"><i class="fa fa-sign-in"></i> Log in</a>
    	<%
    		}
    		String acctype = (String) request.getAttribute("acctype");
    		if (acctype != null) if (acctype.equals("admin")){
    	%>
    		<a class="btn float-right border mr-2" href="${pageContext.request.contextPath}/addProduct"><i class="fa fa-plus"></i> Add Product</a>
    	<%
    		}
    	%>
        <a class="btn float-right border mr-2" href="${pageContext.request.contextPath}/cart"><i class="fa fa-shopping-cart"></i> View Cart</a>
        <h1>Products</h1>
        <h3><small>All the available products in our store</small></h3>
    </div>
    
    <div class="container">
        <div class="row justify-content-center" id="display-list">
        
            <!-- Products will show up in here -->
            <c:forEach items="${productList}" var="product" >
				<div class="col-sm-2 m-4 p-2 border rounded">
                <h6>${product.name}</h6>
	                <img src="${product.imgurl}" class="img-responsive" width="100%">
	                <p class="pDescription">
	                    ${product.description}
	                </p>
	                <p class="pPrice"> ${product.price} USD </p>
	                <p class="pInStock"> ${product.instock} units in stock </p>
	                <div class="btn-toolbar" role="toolbar">
	                	<form method="post" action="${pageContext.request.contextPath}/detail">
	                		<input type="hidden" name="productId" value=${product.code}>
	                		<button type="submit" class="btn btn-info btn-sm mr-2"><i class="fa fa-info-circle"></i> Details</button>
	                	</form>
	                	<form method="get" action="${pageContext.request.contextPath}/cart">
	                		<input type="hidden" name="addCartItem" value=${product.code}>
	                		<button type="submit" class="btn btn-warning btn-sm"><i class="fa fa-shopping-cart"></i> Order Now</button>
	                	</form>
	                    
	                </div>
            	</div>
       		</c:forEach>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>