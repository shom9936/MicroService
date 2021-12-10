<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이름과 점수를 입력</h1>
	<form method="get" action="getScore.do">
		이름 : <input type="text" name="name">
		점수 : <input tytype="text" name="score"> <br>
		<input type="submit" value="제출">
	</form>
</body>
</html>