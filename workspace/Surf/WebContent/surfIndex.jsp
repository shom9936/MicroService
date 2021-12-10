<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/layout/surfHeader.jsp" %>
<html>
<head>
<title>Kajasurf Index test</title>
<style>
	
	.bd-placeholder-img {
		font-size: 3.5rem;
		text-anchor: middle;
		-webkit-user-select: none;
		-moz-user-select: none;
		user-select: none;
	}
	
	@media (min-width:768px) {
		.bd-placeholder-img-lg {
		font-size: 3.5rem;
		}
	}
	
	.text_center {		
		text-align: center;
	}
	
	.nav-tabs > li {
		float: none;
		display: inline-block;
		zoom: 1;
	}
	
	.nav-tabs {
		text-align: center;
	}
	
	img {
		max-width: 100%;
		max-hetght: 100%;
	}
</style>
</head>

<body class= "d-flex flex-column">
	<div class="container d-flex justify-content-center pt-4" id="index">
		<div class="jumbotron mt-5 pt-5"> 
		<table class="mainTable"> 
		<tr>
			<td>
				<img src="./resources/img/eastSea.jpg" 
						width="360px" height="240px" onclick="location.href='#'">
			</td>
			<td>
				<img src="./resources/img/northSea.jpg" 
						width="360px" height="240px" onclick="location.href='#'">
			</td>
		</tr>
		<tr>
			<td>
				<img src="./resources/img/busan.jpg" 
						width="360px" height="240px" onclick="location.href='#'">
			</td>
			<td>
				<img src="./resources/img/jeju.jpg" 
					 	width="360px" height="240px" onclick="location.href='#'">				
			</td>
		</tr>
		</table>
		</div>
	</div>
<%@ include file="/layout/surfFooter.jsp" %>