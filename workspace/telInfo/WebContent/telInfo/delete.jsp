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
		request.setCharacterEncoding("euc-kr");
		TelInfoDAO dao = new TelInfoDAO();
		TelInfoVO vo = dao.getOneInfo(request.getParameter("name"));
	%>

	<h1>��� ���� ����</h1>
	<form action="insert.jsp">
		<table border = "1">
			<tr>
				<th>���</th>
				<th>�̸�</th>
				<th>��ȭ��ȣ</th>
				<th>�Ի���</th>	
			</tr>
			<tr>
				<td> <%=vo.getId() %> </td>
				<td> <%=vo.getName() %> </td>
				<td> <%=vo.getTel() %> </td>
				<td> <%=vo.getDate() %> </td>
			</tr>
			<tr>
				<td colspan="4"><input type="button" value="����" onclick="location.href='deleteProcess.jsp?name=<%=vo.getName()%>';"> </td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<td> <a href="insertForm.jsp">[�Է�]</a> </td>
			<td> <a href="updateForm.jsp">[����]</a> </td>
			<td> <a href="view.jsp">[��� ����]</a> </td>
		</tr>
	</table>
	
</body>
</html>