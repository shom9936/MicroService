<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/layout/surfHeader.jsp"%>

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
				<h5>
					<a href="/Surf/surf/surfSpot.su?spot=${location.spot_name}&areaName=${areaName}&locationName=${locationName}" class="notCurrent">${location.spot_name}</a>
				</h5>
			</c:forEach>
     	</div>
      	<div class="info_box">
			<h3>서핑 샵</h3>
			<hr>
      	</div> 
	</div>
<%@ include file="/layout/footer.jsp"%>