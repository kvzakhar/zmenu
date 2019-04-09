<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Product</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.4/css/mdb.min.css" rel="stylesheet">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
<script src="/webstore/static/js/controllers.js"></script>

<link rel="stylesheet" href="http://localhost:8080/webstore/static/css/style.css">
<link rel="stylesheet" href="http://localhost:8080/webstore/static/css/file.css">
</head>

<body>

	<div class="container">
		<h1>Product</h1>
	</div>

	<section class="food-area section-padding" ng-app="cartApp">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div class="row">
						<div class="single-food">
							<div class="food-img">
								<img src="<c:url value="/static/images/phones/${product.productId}.png"></c:url>" class="img-fluid" alt="">
							</div>
							<div class="food-content">
								<div class="d-flex justify-content-between">
									<h5>${product.name}</h5>
									<span class="style-change">${product.unitPrice}р.</span>
								</div>
								<p>
									<strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
								</p>
								<p><strong>manufacturer</strong> : ${product.manufacturer}</p>
								<p><strong>category</strong> : ${product.category}</p>
								<p>	<strong>Availble units in stock </strong> : ${product.unitsInStock}</p>
								<h4>${product.unitPrice}USD</h4>
								
								<p ng-controller="cartCtrl">
									<a href="<spring:url value="/market/products"/>" class="btn btn-default">
										<span class="glyphicon-hand-left glyphicon"></span>back
									</a> 
									<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')">
										<span class="glyphicon-shopping-cart glyphicon"></span>Order now
									</a>
									<a href="<spring:url value="/cart" />" class="btn btn-default">
										<span class="glyphicon-hand-right glyphicon"></span> View Cart
									</a>
								</p>
								
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
	</section>


	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.4/js/mdb.min.js"></script>
</body>
</html>