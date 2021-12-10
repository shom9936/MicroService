<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<jsp:include page="/layout/header.jsp"/> --%>
<%@ include file="/layout/header.jsp"%>
<br>
	<table class="mainTable" align="center">
		<tr>
			<td>
				<img src="/Surf/img/southSea.jpg" onclick="location.href='/Surf/surf/surfArea.su?area=1'">
			</td>
			<td>
				<img src="/Surf/img/eastSea.jpg" onclick="location.href='/Surf/surf/surfArea.su?area=2'">
			</td>
		</tr>
		<tr>
			<td>
				<img src="/Surf/img/jejudo.jpg" onclick="location.href='/Surf/surf/surfArea.su?area=3'">
			</td>
			<td>
				<img src="/Surf/img/westSea.jpg" onclick="location.href='/Surf/surf/surfArea.su?area=4'">
			</td>
		</tr>
		<tr>
			<td colspan="2" class="freeBoard">
				<a href="/Surf/board/list.brd?pg=1" class="boardIcon">
							<img src="/Surf/img/boardIcon.png" class="surf_person" style="margin-right: 5px;">자유 게시판</a>
			</td>
		</tr>
	</table>
	
	
	<!-- 	<table class="mainTable"> 
		<tr>
			<td>
				<img src="./resources/img/eastSea.jpg" 
						width="360px" height="240px" onclick="location.href='/Surf/surf/surfArea.su?area=2'">
			</td>
			<td>
				<img src="./resources/img/northSea.jpg" 
						width="360px" height="240px" onclick="location.href='/Surf/surf/surfArea.su?area=4'">
			</td>
		</tr>
		<tr>
			<td>
				<img src="./resources/img/busan.jpg" 
						width="360px" height="240px" onclick = "location.href='/Surf/surf/surfArea.su?area=1'">
			</td>
			<td>
				<img src="./resources/img/jeju.jpg" 
					 	width="360px" height="240px" onclick="location.href='/Surf/surf/surfArea.su?area=3'">				
			</td>
		</tr>
		</table> -->
		</div>
	</div>
<%@ include file="/layout/footer.jsp"%>