<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="login.jsp" method="get">
		아이디 <input type="text" name = "id" required> <br>
		암호	<input type="password" name="pw" required> <br>
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
	</form>
</body>
</html>