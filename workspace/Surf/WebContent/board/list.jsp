<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/layout/header.jsp"%>

	<div align="center">
		<table class="boardList">
			<tr>
				<th class="no"> No.</th>
				<th class="title"> 제목</th>
				<th class="id"> 작성자</th>
				<th class="logtime"> 작성일</th>
				<th class="hit"> 조회 </th>
			</tr>
			<c:if test="${!checkList }">
				<tr>
					<td colspan="5"> 작성된 글이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td> ${vo.seq } </td>
					
					<c:choose>
						<c:when test="${login != null }">
							<td> <a href="/Surf/board/view.brd?seq=${vo.seq }&pg=${pg}">${vo.title }</a> </td>
						</c:when>
						<c:otherwise>
							<td> ${vo.title } </td>
						</c:otherwise>
					</c:choose>
					<td> ${vo.id } </td>
					<td> ${vo.logtime } </td>
					<td> ${vo.hit } </td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" class="write">
					<button type="button" onclick="location.href='/Surf/board/write.brd'">글쓰기</button>
				</td>
			</tr>
		</table>
	</div>
	
	<div align = "center">
		<c:if test="${ startPage > block }">
			[ <a href="/Surf/board/list.brd?pg=${startPage-1 }">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end = "${endPage }">
			<c:if test="${pg == i }">
				[ ${ i } ]
			</c:if>
			<c:if test="${pg != i }">
				[ <a href="/Surf/board/list.brd?pg=${i }">${ i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${ endPage < totalPage }">
			[ <a href="/Surf/board/list.brd?pg=${endPage+1 }">다음</a> ]
		</c:if>
	</div>
<%@ include file="/layout/footer.jsp"%>