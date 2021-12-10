<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function (){
		$("#checkJson").click(function(){
			var jsonStr = '{"age" : [22,33,44]}';
			var jsonInfo = JSON.parse(jsonStr);
			var output = "회원나이<br>";
			output += "============<br>";
			for(var i in jsonInfo.age){
				output += jsonInfo.age[i] + "<br>";
			}
			$("#output").html(output);
		});
		$("#checkJson2").click(function(){
			var jsonStr = '{"name" : ["홍길동", "이순신", "임꺽정"]}';
			var jsonInfo = JSON.parse(jsonStr);
			var output = "회원이름<br>";
			output += "=======<br>";
			for(var i in jsonInfo.name){
				output += jsonInfo.name[i] + "<br>";
			}
			$("#output").html(output);
		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson" value="출력">
	<input type="button" id="checkJson2" value="출력2">
	<div id="output"></div>
</body>
</html>