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
	<h1>��� ��ü ���</h1>
	<%
	request.setCharacterEncoding("euc-kr");
	TelInfoDAO dao = new TelInfoDAO();
	ArrayList <TelInfoVO> list = dao.getAllInfo();
	%>
	
	<table border=2>
		<tr>
			<th> ��� </th>
			<th> �̸� </th>
			<th> ��ȭ��ȣ </th>
			<th> �Ի��� </th>
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
			<td> <a href="insertForm.jsp">[�Է�]</a>
			<td> <a href="updateForm.jsp">[����]</a>
			<td> <a href="deleteForm.jsp">[����]</a>
		</tr>
	</table>
</body>
</html>