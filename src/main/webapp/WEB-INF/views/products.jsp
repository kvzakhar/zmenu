<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<style type="text/css">
.bg {
	/* The image used */
	background-image:
		url("https://static.tildacdn.com/tild3032-3764-4935-a531-623832363666/170757-OVQW0N-791112.jpg");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script>
	utils = {
		getData : function(url){
			console.log(url);
		},
		
		getWeek : function() {
			var curr = new Date();
			var dayOfWeek = curr.getDay();
			var dayOfMonth = curr.getDate();
			var curWeek = Math.floor(dayOfMonth / 7) + 1;
			return curWeek;
		},
		
		getDay : function() {
			var curr = new Date();
			var dayOfWeek = curr.getDay();
			return dayOfWeek;
		}	
	},
	
	$(function() {
		$(".accordion").accordion({
			heightStyle : "content",
			icons : false,
			active : utils.getWeek() - 1,
			activate: function( event, ui ) {
				//console.log(ui.newHeader.context.attributes["data-week"].value + " " + ui.newHeader[0].id + " " + ui.oldHeader[0].id);
				utils.getData(ui.newHeader.context.attributes["data-week"].value);
			}
		});
	});
	
	$(function() {
		$(".accordion-inner").accordion({
			heightStyle : "content",
			icons : false,
			active : utils.getDay() - 1,
			activate: function( event, ui ) {
				utils.getData(ui.newHeader.context.attributes["data-week"].value);
			}
		});
	});
</script>
<style>
.accordion1 {
	background-color: #eee;
	color: #444;
	cursor: pointer;
	padding: 18px;
	width: 100%;
	border: none;
	text-align: left;
	outline: none;
	font-size: 15px;
	transition: 0.4s;
}

.active, .accordion1:hover {
	background-color: #ccc;
}

.panel1 {
	padding: 0 14px;
	display: none;
	background-color: white;
	overflow: hidden;
}

.ui-accordion .ui-accordion-content {
	padding: 0.5em 0.5em;
	border-top: 0;
	overflow: auto;
}

.top5 {
	margin-top: 5px;
}

.top7 {
	margin-top: 7px;
}

.top10 {
	margin-top: 10px;
}

.top15 {
	margin-top: 15px;
}

.top17 {
	margin-top: 17px;
}

.top30 {
	margin-top: 30px;
}
</style>
<link rel="stylesheet" href="http://localhost:8080/webstore/static/css/style.css">
<link rel="stylesheet" href="http://localhost:8080/webstore/static/css/file.css">
</head>

<body>

	<div class="bg">

		<div class="container">
			<h1>Наше меню</h1>
			<p>Всегда свежая и вкусная еда!</p>
		</div>

		<section class="food-area section-padding">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<ul class="accordion">
							<li><a class="head" data-week="1" href="#">Первая неделя</a>
								<ul class="accordion-inner">
									<li><a data-week="11" href="#">Понедельник</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
									<li><a data-week="12" href="#">Вторник</a>
										<div class="panel card bg-light mb-3">
											<h6>Супы</h6>
											<ul>
												<li>Кукси 300гр 70р</li>
												<li>Куриная лапша 300гр 60р</li>
												<li>Пельменная похлебка 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Картофельный гратен 150гр 55р</li>
												<li>Пенне под сыром 150гр 50р</li>
												<li>Соба с овощами 180гр 55р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Блинчики с курицей и грибами 150гр 75р</li>
												<li>Бедро индейки с травами 125гр 100р</li>
												<li>Шашлычок свиной 130гр 90р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>С сельдереем и копчёной курицей 150гр 70р</li>
												<li>С куриной печенью 150гр 55р</li>
												<li>С фасолью и томатами 150гр 60р</li>
											</ul>
										</div></li>
									<li><a data-week="13" href="#" class="accordion1">Среда</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
									<li><a data-week="14" href="#" class="accordion1">Четверг</a></li>
									<li><a data-week="15" href="#" class="accordion1">Пятница</a></li>
								</ul></li>
							<li><a data-week="2" href="#">Вторая неделя</a>
								<ul class="accordion-inner">
									<li><a data-week="21" href="#">Понедельник</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
									<li><a data-week="22" href="#">Вторник</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
									<li><a data-week="23" href="#">Среда</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
									<li><a data-week="24" href="#">Четверг</a>
									<li><a data-week="25" href="#">Пятница</a>
								</ul></li>
							<li><a data-week="3" href="#">Третья неделя</a>
								<ul class="accordion-inner">
									<li><a data-week="31" href="#">Понедельник</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
									<li><a data-week="32" href="#">Вторник</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
									<li><a data-week="33" href="#">Среда</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
									<li><a data-week="34" href="#">Четверг</a>
									<li><a data-week="35" href="#">Пятница</a>
								</ul></li>
							<li><a data-week="4" href="#">Четвертая неделя</a>
								<ul class="accordion-inner">
									<li><a href="#">Понедельник</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
									<li><a href="#">Вторник</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
									<li><a href="#" class="accordion1">Среда</a>
										<div class="panel">
											<h6>Супы</h6>
											<ul>
												<li>Солянка 300гр 90р</li>
												<li>Тыквенный крем-суп 250гр 75р</li>
												<li>Чечевичный с курицей 300гр 75р</li>
											</ul>
											<br>
											<h6>Гарниры</h6>
											<ul>
												<li>Рис с овощами 150гр 55р</li>
												<li>Цветная капуста с сыром 150гр 65р</li>
												<li>Отварной картофель с зеленью 150гр 35р</li>
											</ul>
											<br>
											<h6>Вторые блюда</h6>
											<ul>
												<li>Тефтели в томатном соусе 180гр 75р</li>
												<li>Шашлычок куриный 100гр 80р</li>
												<li>Плов с курицей 160гр 65р</li>
											</ul>
											<br>
											<h6>Салаты</h6>
											<ul>
												<li>Чафан 150гр 65р</li>
												<li>Овощной с мясным сбором 150гр 60р</li>
												<li>Из краснокочанной капусты 135гр 50р</li>
											</ul>
										</div></li>
								</ul></li>
						</ul>

					</div>
					<div class="col-md-9">
						<div class="container-fluid">
							<div class="row">
								<c:forEach var="product" items="${products}" varStatus="index">
									<div class="col-md-4 col-sm-4">
										<div class="single-food">
											<div class="food-img">
												<img src="${product.imageSource}" class="img-fluid" alt="">
											</div>
											<div class="food-content">
												<div class="d-flex justify-content-between">
													<h5>${product.name}</h5>
													<span class="style-change">${product.unitPrice}р.</span>
												</div>
												<p>Вес: ${product.unitsInStock} гр.</p>
												<p>${product.description }.</p>
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
	</div>

	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.4/js/mdb.min.js"></script>
</body>
</html>