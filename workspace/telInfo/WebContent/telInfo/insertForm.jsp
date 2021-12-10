<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 정보 입력</h1>
	<form action="insert.jsp">
		<table border = "1">
			<tr>
				<th>사번</th>
				<td> <input type="text" name="id"> </td>
			</tr>
			<tr>
				<th>이름 </th>
				<td> <input type="text" name="name"> </td>
			</tr>
			<tr>
				<th> 전화번호</th>
				<td> <input type="text" name="tel"></td>
			</tr>
			<tr>
				<th> 입사일</th>
				<td> <input type="text" name="date"></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="추가"></td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<td> <a href="insertForm.jsp">[입력]</a> </td>
			<td> <a href="updateForm.jsp">[수정]</a> </td>
			<td> <a href="deleteForm.jsp">[삭제]</a> </td>
			<td> <a href="view.jsp">[모두 보기]</a> </td>
		</tr>
	</table>
	
</body>
</html>