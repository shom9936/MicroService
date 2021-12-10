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
		double kab = 37.8;
		String kab2 = null;
	%>
	
	<%= " 온달" %>
	${"온달" }
	${"형이 말하는데 el 니가 왜 거기서 나와 " } <br>
	${"el" } 은 참 간단해서 좋지만 공부는 해야해 <br>
	
	<br>
	${100 } ${100+200 } ${empty kab2 } ${empty "a" } ${empty "" }
	<br><br>
	
</body>
</html>