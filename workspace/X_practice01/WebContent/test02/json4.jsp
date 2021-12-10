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
			var jsonStr = '{"members":[{"name":"박지성" , "age" : 44, "gender":"남자", "nickname" : "날센돌이"}, {"name" : "송혜교", "age" : 55, "gender" : "여자", "nickname" : "이쁜이"}]}';
			var jsonInfo = JSON.parse(jsonStr);
			var output = "회원정보<br>";
			output += "===========<br>";
			for(var i in jsonInfo.members){
				output += jsonInfo.members[i].name + "<br>";
				output += jsonInfo.members[i].age + "<br>";
				output += jsonInfo.members[i].gender + "<br>";
				output += jsonInfo.members[i].nickname + "<br><br><br>";
			}
			$("#output").htmloutput);
		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson" value="출력">
	<div id="output"></div>
</body>
</html>