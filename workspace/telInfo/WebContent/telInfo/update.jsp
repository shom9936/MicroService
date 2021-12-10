<%@page import="vo.TelInfoVO"%>
<%@page import="dao.TelInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	TelInfoDAO dao = new TelInfoDAO();
	TelInfoVO vo = dao.getOneInfo(request.getParameter("name"));
	
	%>
	
	<h1>사원 정보 수정</h1>
	<form action="updateProcess.jsp">
		<table border = "1">
			<tr>
				<th>사번</th>
				<td> <%=vo.getId() %> </td>
			</tr>
			<tr>
				<th> 이름 </th>
				<td> <%=vo.getName() %> </td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td> <input type="text" name="tel" value="<%=vo.getTel()%>"> </td>
			</tr>
			<tr>
				<th>입사일</th>
				<td> <input type="text" name="date" value="<%=vo.getDate()%>"> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name = "name" value = "<%=vo.getName() %>">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<td> <a href="insertForm.jsp">[입력]</a> </td>
			<td> <a href="deleteForm.jsp">[삭제]</a> </td>
			<td> <a href="view.jsp">[모두 보기]</a> </td>
		</tr>
	</table>
</body>
</html>