<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="dish" items="${dishes}" varStatus="index">
	<div class="col-md-4 col-sm-4">
		<div class="single-food">
			<div class="food-img">
				<img src="${dish.imageSource}" class="img-fluid" alt="">
			</div>
			<div class="food-content">
				<div class="d-flex justify-content-between">
					<h5>${dish.name}</h5>
					<span class="style-change">${dish.unitPrice}р.</span>
				</div>
				<p>Вес: ${dish.weight} гр.</p>
				<p>${dish.description }.</p>
			</div>
		</div>
	</div>
</c:forEach>