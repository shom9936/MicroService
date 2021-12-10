<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/layout/header.jsp" %>
<script type="text/javascript">
	function check(){
		if(document.boardModify.content.value == ""){
			alert("내용을 입력하세요!");
			document.boardWrites.content.focus();
		}
		else {
			document.boardModify.submit();
		}
	}
</script>

<div align="center">
	<form action="/Surf/board/modify.brd" name="boardModify" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td width = 70 align = "center"> 제 목 </td>
				<td><input type="text" name = "title" size = "60" value="${boardVO.title }" class="writeTitle"></td>
			</tr>
			<tr>
				<td width = 70 align = "center"> 내용 </td>
				<td>
					<textarea name="content" rows="20" cols="62" placeholder="내용을 작성하세요" class="writeContent">${boardVO.content }</textarea>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="2">
					<input type="file" name = "filename" >
				</td>
			</tr>
			<tr>
				<td colspan = "2" align = "right" class="writeCheck">
					<input type="hidden" value="${boardVO.seq }" name="seq">
					<button type="button" onclick="check()">수정</button>
				</td> 
			</tr>
		</table>
	</form>
</div>
<%@ include file="/layout/footer.jsp" %>
