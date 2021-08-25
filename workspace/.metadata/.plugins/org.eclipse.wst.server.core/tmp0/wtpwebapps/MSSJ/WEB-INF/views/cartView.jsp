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
    <title>Cart - Mobile Store</title>
  </head>
  <body>
    <div class="container p-5 my-3 bg-light" id="head-container">
    	<a class="btn btn-danger float-right" href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i> Log out</a>
        <h1>Carts</h1>
        <h3><small>All the seleted products in your cart</small></h3>
    </div>
    
    <div class="container p-3">
        <div class="row justify-content-center">
            <div class="col-sm-10">
                <div class="btn-toolbar justify-content-between" role="toolbar">
                	<form method="get" action="${pageContext.request.contextPath}/cart">
                		<input type="hidden" name="clearCart" value="clear"/>
                		<button type="submit" class="btn btn-danger"><i class="fa fa-times-circle"></i> Clear Cart</button>
                    	<button type="submit" class="btn btn-success"><i class="fa fa-shopping-cart"></i> Check Out</button>
                	</form>
                </div>
                <table class="table table-sm" id="cart">
                    <thead>
                        <tr class="d-flex">
                            <th class="col-sm-4"><h6>Product</h6></th>
                            <th class="col-sm-2"><h6>Quantity</h6></th>
                            <th class="col-sm-2"><h6>Unit Price</h6></th>
                            <th class="col-sm-2"><h6>Price</h6></th>
                            <th class="col-sm-2"><h6>Action</h6></th>
                        </tr>
                    </thead>
                    <c:set var="total" value="${0}"/>
                    <c:forEach items="${cartItemList}" var="cartItem" >
                    	<c:set var="pIndex" value="${0}"/>
                    	<c:set var="i" value="${0}"/>
                    	<c:forEach items="${productList}" var="product">	
                    		<c:if test="${cartItem.code == product.code}"> 
                    			<c:set var="pIndex" value="${i}" />
                    		</c:if>
                    		<c:set var="i" value="${i + 1}"/>
                    	</c:forEach>
                    	<c:set var="total" value="${total + productList[pIndex].price * cartItem.quantity}" />
                    	<tr class="d-flex">
                        <td class="col-sm-4">${productList[pIndex].name}</td>
                        <td class="col-sm-2">${cartItem.quantity }</td>
                        <td class="col-sm-2">${productList[pIndex].price}</td>
                        <td class="col-sm-2">${productList[pIndex].price * cartItem.quantity}</td>
                        <td class="col-sm-2">
                        	<form method="get" action="${pageContext.request.contextPath}/cart">
                        		<input type="hidden" name="removeCartItem" value="${cartItem.code}" />
                        		<button class="btn btn-danger btn-sm"><i class="fa fa-close"></i> Remove</button>
                        	</form>
                        </td>
                    </tr>
                    </c:forEach>
                    
                    <tr class="d-flex">
                        <td class="col-sm-6"></td>
                        <td class="col-sm-2"><h6>Grand Total</h6></td>
                        <td class="col-sm-2"><h6><span id=total><c:out value = "${total}"/></span></h6></td>
                    </tr>
                </table>
                <a class="btn btn-success mr-2" href="${pageContext.request.contextPath}/"><i class="fa fa-arrow-circle-left"></i> Continue Shopping</a>
            </div>
        </div>
    </div>

    <!-- Scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/shoppingcart.js"></script>
  </body>
</html>