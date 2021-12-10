<%-- forward.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
request.setAttribute("address", "서울시 오디?");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> forward </title>
</head>
<body>
	<jsp:forward page = "member.jsp"></jsp:forward>
</body>
</html>