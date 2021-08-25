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
    <title>Add Product - Mobile Store</title>
  </head>
  <body>
    <div class="container p-5 my-3 bg-light">
    	<% 
    		String username = (String) request.getAttribute("username");
    		if (username != null) {
    	%>
    	<a class="btn btn-danger float-right" href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i> Log out</a>
    	<%
    		}
    	%>
        <a class="btn float-right border mr-2" href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i> Home</a>
        <h1>Add Product</h1>
    </div>
    
    <div class="container p-3">
        <div class="row justify-content-center">
            <div class="col-11">
                Add new product
                <hr>
                <form id='add-product-form' method="POST" action="${pageContext.request.contextPath}/addProduct" enctype="multipart/form-data">
                    <div class="form-group row ml-5">
                      <label for="productName" class="col-sm-2 col-form-label text-right">Product Name</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" name="name" required>
                      </div>
                    </div>
                    <div class="form-group row ml-5">
                        <label for="unitPrice" class="col-sm-2 col-form-label text-right">Unit Price</label>
                        <div class="col-sm-4">
                          <input type="number" class="form-control" name="price" required>
                        </div>
                    </div>
                    <div class="form-group row ml-5">
                        <label for="unitStock" class="col-sm-2 col-form-label text-right">Unit in Stock</label>
                        <div class="col-sm-4">
                          <input type="number" class="form-control" name="instock" required>
                        </div>
                    </div>
                    <div class="form-group row ml-5">
                        <label for="description" class="col-sm-2 col-form-label text-right">Description</label>
                        <div class="col-sm-4">
                          <textarea rows="2" class="form-control" name="description"></textarea>
                        </div>
                    </div>
                    <div class="form-group row ml-5">
                        <label for="manufacturer" class="col-sm-2 col-form-label text-right">Manufacturer</label>
                        <div class="col-sm-4">
                          <input type="text" class="form-control" name="manufacturer" required>
                        </div>
                    </div>
                    <div class="form-group row ml-5">
                        <label for="category" class="col-sm-2 col-form-label text-right">Category</label>
                        <div class="col-sm-4">
                          <input type="text" class="form-control" name="category">
                        </div>
                    </div>
                    <div class="form-group row ml-5">
                        <label class="col-sm-2 col-form-label text-right">Condition</label>
                        <div class="col-sm-4">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="condition" value="New" required>
                                <label class="form-check-label" for="radio-new">New</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="condition" value="Old">
                                <label class="form-check-label" for="radio-old">Old</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="condition" value="Refurbished">
                                <label class="form-check-label" for="radio-refur">Refurbished</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row ml-5">
                        <label for="product-image" class="col-sm-2 col-form-label text-right">Product Image File</label>
                        <div class="col-sm-4">
                          <input type="file" class="form-control" name="product-image" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-3"></div>
                        <button type="submit" class="btn btn-primary" id="btn-submit-product">Add Product</button>
                    </div>
                  </form>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>