<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/layout/header.jsp"%>
<link type="text/css" rel="stylesheet" href="/Surf/css/shopInfo.css?ver=3" >
<script type="text/javascript">
	function check(f){
		if(f.content.value == ""){
			alert("리뷰를 입력하세요!");
			f.content.focus();
			return;
		}
		
		f.action = "/Surf/board/reviewWrite.su";
		f.submit();
	}

</script>
	<div class="shop">
		<h2>${shopVO.shop_name }</h2>
		<table align="center" class="shopInfo">
			<tr>
				<td rowspan="3">
					<div id="map" style="width: 450px; height: 250px;"></div>
				</td>
			</tr>
			<tr>
				<th>위치</th>
				<td>${shopVO.spot_name }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${shopVO.spot_address }</td>
			</tr>
		</table>
	</div>
	
	<!-- review -->
	<br>
	<div class="review">
		<c:choose>
			<c:when test="${isEmpty}">
				<p> 아직 리뷰가 없습니다. </p>
			</c:when>
			<c:otherwise>
				<c:forEach var="review" items="${reviewList }">
					<div class="reviewEach">
						<font style="font-size: 12pt; font-weight: bold;">${review.id }</font> &nbsp; <img src="/Surf/img/star${review.star_rating }.png"> <br>
						&nbsp;<font>${review.content }</font>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<br>
		<div>
			<c:if test="${login != null }">
				<form>
					<br>
					<font style="font-size: 12px;">${login }</font> &nbsp;&nbsp;
					<select name = "star_rating">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5" selected="selected">5</option>
					</select>
					<br>
					<span class="writeReview">
						<textarea name="content" rows="3" cols="112" placeholder="리뷰를 작성하세요"></textarea>
					</span>
					<span class="submitReview">
						<input type="hidden" value="${shopVO.shop_name }" name="shop_name">
						<input type="button" value="등록" onclick="check(this.form)">
					</span>
				</form>
			</c:if>
		</div>
	</div>
	
	
	
	
	<!-- 지도 api -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf4802799d198d87eddef043e02c9e4b&libraries=services"></script>
	<script>				
		var address = "<c:out value="${shopVO.spot_address}"></c:out>";
		var shopName = "<c:out value="${shopVO.shop_name}"></c:out>";
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(address,
						function(result, status) {

							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {

								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);

								// 결과값으로 받은 위치를 마커로 표시합니다
								var marker = new kakao.maps.Marker({
									map : map,
									position : coords
								});

								// 인포윈도우로 장소에 대한 설명을 표시합니다
								var infowindow = new kakao.maps.InfoWindow(
										{
											content : '<div style="width:150px;text-align:center;padding:3px 0;font-size:13px;"><c:out value="${shopVO.shop_name}"></c:out></div>'
										});
								infowindow.open(map, marker);

								// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								map.setCenter(coords);
							}
						});
	</script>

<%@ include file="/layout/footer.jsp"%>