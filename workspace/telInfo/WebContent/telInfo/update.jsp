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
	
	<h1>��� ���� ����</h1>
	<form action="updateProcess.jsp">
		<table border = "1">
			<tr>
				<th>���</th>
				<td> <%=vo.getId() %> </td>
			</tr>
			<tr>
				<th> �̸� </th>
				<td> <%=vo.getName() %> </td>
			</tr>
			<tr>
				<th>��ȭ��ȣ</th>
				<td> <input type="text" name="tel" value="<%=vo.getTel()%>"> </td>
			</tr>
			<tr>
				<th>�Ի���</th>
				<td> <input type="text" name="date" value="<%=vo.getDate()%>"> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name = "name" value = "<%=vo.getName() %>">
					<input type="submit" value="����">
				</td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<td> <a href="insertForm.jsp">[�Է�]</a> </td>
			<td> <a href="deleteForm.jsp">[����]</a> </td>
			<td> <a href="view.jsp">[��� ����]</a> </td>
		</tr>
	</table>
</body>
</html>