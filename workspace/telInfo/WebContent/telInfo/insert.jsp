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
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String date = request.getParameter("date");
	
	TelInfoDAO dao = new TelInfoDAO();
	int result = dao.insert(id, name, tel, date);
	request.getRequestDispatcher("view.jsp").forward(request, response);
	%>
</body>
</html>