<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> ����â </h1>
	<%
		String vid = request.getParameter("id");
		String vpw = request.getParameter("pw");
	%>
	<%
		session.setAttribute("sid", vid);
		session.setAttribute("spw", vpw);
	%>
	
	���� ���� <a href="bag.jsp"> ���� </a> <br>
	���� ���� <a href="heel.jsp"> ���� </a> <br>
</body>
</html>