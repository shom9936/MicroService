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
	
	<%= " �´�" %>
	${"�´�" }
	${"���� ���ϴµ� el �ϰ� �� �ű⼭ ���� " } <br>
	${"el" } �� �� �����ؼ� ������ ���δ� �ؾ��� <br>
	
	<br>
	${100 } ${100+200 } ${empty kab2 } ${empty "a" } ${empty "" }
	<br><br>
	
</body>
</html>