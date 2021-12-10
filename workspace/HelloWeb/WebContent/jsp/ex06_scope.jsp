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
		pageContext.setAttribute("page1", "pageLove");
		request.setAttribute("req1", "reqLove");
		session.setAttribute("ses1", "sesLove");
		application.setAttribute("app1", "appLove");
	%>
	<a href="./scope.jsp">scope 확인</a>
</body>
</html>