<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="true"%>
<% response.setStatus(200); %>
<%-- 404 , 500 .... : ��Ȥ �� �������� 500���� ó���ϴ� ��� ����
	���� 200: �� �������� ���� ���� --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<pre> ���� �߻� </pre>
<h3> <%= exception.getMessage() %></h3>
<%-- isErrorPage = "true" ������ exception ��ü ��� ���� --%>

</body>
</html>