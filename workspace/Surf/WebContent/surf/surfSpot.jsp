<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/layout/surfHeader.jsp"%>
<body>
	
	<br><br>
	<div id="main_box">
		<div class="info_box">
			<h3>지역</h3>
			<hr>
			<c:forEach var="area" items="${areaList}">
				<c:choose>
					<c:when test="${locationName == area.spot_location}">
						<h5><a href="/Surf/surf/surfLocation.su?location=${area.spot_location}&areaName=${areaName}" class="current">${area.spot_location}</a></h5>
					</c:when>
					<c:otherwise>
						<h5><a href="/Surf/surf/surfLocation.su?location=${area.spot_location}&areaName=${areaName}" class="notCurrent">${area.spot_location}</a></h5>
					</c:otherwise>
				</c:choose>
			</c:forEach>
      	</div>
      	<div class="info_box">
			<h3>해변</h3>
			<hr>
			<c:forEach var="location" items="${locationList}">
				<c:choose>
					<c:when test="${spotName ==  location.spot_name}">
						<h5><a href="/Surf/surf/surfSpot.su?spot=${location.spot_name}&areaName=${areaName}&locationName=${locationName}" class="current">${location.spot_name}</a></h5>
					</c:when>
					<c:otherwise>
						<h5><a href="/Surf/surf/surfSpot.su?spot=${location.spot_name}&areaName=${areaName}&locationName=${locationName}" class="notCurrent">${location.spot_name}</a></h5>
					</c:otherwise>
				</c:choose>
				<h5>
					
				</h5>
			</c:forEach>
     	</div>
      	<div class="info_box">
			<h3>서핑 샵</h3>
			<hr>
			<c:forEach var="info" items="${list}">
				<h5>
					<a href="/Surf/surf/surfShop.su?info=${info.shop_name}" class="notCurrent">${info.shop_name}</a>
				</h5>
			</c:forEach>
      	</div> 
	</div>
<%@ include file="/layout/footer.jsp"%>