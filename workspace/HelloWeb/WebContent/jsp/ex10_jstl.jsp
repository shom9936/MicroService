<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:out value="�ȳ� jstl"/> <br>
	<% out.println("�ȳ� jstl"); %>
	
	<% int score = 100; %>
	<%= score %>
	<c:set var="score2">100</c:set>
	${score2 }<br>
</body>
</html>