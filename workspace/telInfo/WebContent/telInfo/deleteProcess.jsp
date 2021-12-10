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
	int result = dao.delete(request.getParameter("name"));
	request.getRequestDispatcher("view.jsp").forward(request, response);

%>
</body>
</html>