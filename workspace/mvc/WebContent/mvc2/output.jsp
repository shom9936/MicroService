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
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		char yourScore;
		int score = Integer.parseInt(request.getParameter("score"));
		if(score >= 90) yourScore = 'A';
		else if(score >= 80) yourScore = 'B';
		else if(score >= 70) yourScore = 'C';
		else if(score >= 60) yourScore = 'D';
		else yourScore = 'F';
		request.setAttribute("yourScore", yourScore);
		request.getRequestDispatcher("/viewjsp/" + "view.jsp").forward(request, response);
	%>
	
	
</body>
</html>