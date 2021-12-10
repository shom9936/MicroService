<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="true"%>
<% response.setStatus(200); %>
<%-- 404 , 500 .... : 간혹 이 페이지를 500으로 처리하는 경우 방지
	정상 200: 이 페이지는 문제 없음 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<pre> 에러 발생 </pre>
<h3> <%= exception.getMessage() %></h3>
<%-- isErrorPage = "true" 없으면 exception 객체 사용 못함 --%>

</body>
</html>