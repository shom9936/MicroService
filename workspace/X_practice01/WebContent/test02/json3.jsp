<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#checkJson").click(function(){
			var jsonStr = '{"name":"박지성" , "age":44, "gender" : "남자" , "nickname" : "날센돌이"}';
			var jsonObj = JSON.parse(jsonStr);
			var output = "회원정보<br>";
			output += "=============<br>";
			output += jsonObj.name + "<br>";
			output += jsonObj.age + "<br>";
			output += jsonObj.gender + "<br>";
			output += jsonObj.nickname + "<br>";
			$("#output").html(output);
		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson" value="출력">
	<div id="output"></div>
</body>
</html>