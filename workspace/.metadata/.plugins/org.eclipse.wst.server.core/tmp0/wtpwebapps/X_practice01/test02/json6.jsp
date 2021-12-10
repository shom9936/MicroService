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
			$.ajax({
				type : "post",
				async : false,
				url : "${pageContext.request.contextPath}/json2",
				success : function(data, textStatus){
					var jsonInfo = JSON.parse(data);
					var memberInfo = "회원정보<br>";
					memberInfo += "=============<br>";
					
					for(var i in jsonInfo.members){
						memberInfo += jsonInfo.members[i].name + "<br>";
						memberInfo += jsonInfo.members[i].age + "<br>";
						memberInfo += jsonInfo.members[i].gender + "<br>";
						memberInfo += jsonInfo.members[i].nickname + "<br>";
					}
					$("#output").html(memberInfo);
				} ,
				error : function(data, textStatus){
					alert("에러발생");
				}, 
				complete : function(data, textStatus){}
			});
		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson"value="회원 정보 수신">
	<div id="output"></div>
</body>
</html>