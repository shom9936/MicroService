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
	String sid = (String)session.getAttribute("sid");
	String spw = (String)session.getAttribute("spw");
	
	if(!sid.equals("babo") || !spw.equals("ondal")) {
		out.println("<h2>id �� ��ȣ �Է� �����Դϴ�. �α���ȭ������ ���ϴ�.</h2>");
	} else {
		out.println("<img src='../img/good.png'>");
	}
	
	%>
	
</body>
</html>