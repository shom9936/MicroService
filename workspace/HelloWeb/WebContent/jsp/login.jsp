<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% 
request.setCharacterEncoding("euc-kr");
response.setCharacterEncoding("euc-kr");
%>
	<h1> 로그인 서버 </h1>
	id : <%=request.getParameter("id") %> <br>
	pw : <%=request.getParameter("pw") %>
	
	<%--
		get 방식에서 한글 깨질때
		톰캣 - server.xml
		63라인 쯤 <Connector URIEncoding="EUC-KR" -> 넣어줌
	 --%>
</body>
</html>