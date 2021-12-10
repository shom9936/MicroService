<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> 구매창 </h1>
	<%
		String vid = request.getParameter("id");
		String vpw = request.getParameter("pw");
	%>
	<%
		session.setAttribute("sid", vid);
		session.setAttribute("spw", vpw);
	%>
	
	가방 쇼핑 <a href="bag.jsp"> 가방 </a> <br>
	구두 쇼핑 <a href="heel.jsp"> 구두 </a> <br>
</body>
</html>