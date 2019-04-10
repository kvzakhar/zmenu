<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Products</title>
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

<link rel="stylesheet" href="<c:url value="/static/css/style.css"></c:url>">
<link rel="stylesheet" href="<c:url value="/static/css/file.css"></c:url>">
</head>

<body>
		<div class="container">
			<h1>Products</h1>
		</div>
		
		<section class="food-area section-padding">
			<div class="container">
				<div class="row">
					<div class="col-md-2">					
					</div>
					<div class="col-md-10">
						<div class="container-fluid">
							<div class="row">
								<c:forEach var="product" items="${products}" varStatus="index">
									<div class="col-sm-6 col-md-3">
										<div class="single-food">
											<div class="food-img">
												<img src="<c:url value="/static/images/phones/${product.productId}.png"></c:url>" class="img-fluid" alt="">
											</div>
											<div class="food-content">
												<div class="d-flex justify-content-between">
													<h5>${product.name}</h5>
													<span class="style-change">${product.unitPrice}р.</span>
												</div>
												<p>Вес: ${product.unitsInStock} гр.</p>
												<p>${product.description }.</p>
												<p>
													<a href="<spring:url value="/market/product?id=${product.productId}"/>"
													class="btn btn-primary">
													<span class=" glyphicon-info-sign glyphicon"></span>Details
													</a>
												</p>
											</div>
										</div>
									</div>
								</c:forEach>
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