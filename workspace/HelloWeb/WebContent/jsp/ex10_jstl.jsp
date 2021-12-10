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
	<c:out value="안녕 jstl"/> <br>
	<% out.println("안녕 jstl"); %>
	
	<% int score = 100; %>
	<%= score %>
	<c:set var="score2">100</c:set>
	${score2 }<br>
</body>
</html>