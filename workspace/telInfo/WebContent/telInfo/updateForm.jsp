<%@page import="vo.TelInfoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.TelInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	table {
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>사원 전체 명단</h1>
	<%
	request.setCharacterEncoding("euc-kr");
	TelInfoDAO dao = new TelInfoDAO();
	ArrayList <TelInfoVO> list = dao.getAllInfo();
	%>
	
	<table border=2>
		<tr>
			<th> 사번 </th>
			<th> 이름 </th>
			<th> 전화번호 </th>
			<th> 입사일 </th>
		</tr>
		<% for(TelInfoVO vo : list){ %>
			<tr>
				<td> <%=vo.getId() %> </td>
				<td> <a href="update.jsp?name=<%=vo.getName() %>"><%=vo.getName() %></a> </td>
				<td> <%=vo.getTel() %> </td>
				<td> <%=vo.getDate() %> </td>
			</tr>
		<%} %>
	</table>
	
	<table>
		<tr>
			<td> <a href="insertForm.jsp">[입력]</a>
			<td> <a href="updateForm.jsp">[수정]</a>
			<td> <a href="deleteForm.jsp">[삭제]</a>
		</tr>
	</table>
</body>
</html>