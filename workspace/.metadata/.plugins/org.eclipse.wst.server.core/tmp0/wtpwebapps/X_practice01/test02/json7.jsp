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
				url : "${pageContext.request.contextPath}/json3",
				success : function(data, textStatus){
					var jsonInfo = JSON.parse(data);
					var memberInfo = "회원정보<br>";
					memberInfo += "=============<br>";
					
					for(var i in jsonInfo.members){
						memberInfo += jsonInfo.members[i].name + "<br>";
						memberInfo += jsonInfo.members[i].age + "<br>";
						memberInfo += jsonInfo.members[i].gender + "<br>";
						memberInfo += jsonInfo.members[i].nickname + "<br><br><br>";
					}
					
					var bookInfo = "책 정보<br>";
					bookInfo += "==========<br>";
					
					for(var i in jsonInfo.books){
						bookInfo += "제목 : " + jsonInfo.books[i].title + "<br>";
						bookInfo += "지은이 : " + jsonInfo.books[i].writer + "<br>";
						bookInfo += "가격 : " + jsonInfo.books[i].price + "<br>";
						bookInfo += "장르 : " + jsonInfo.books[i].genre + "<br>";
						imageURL = jsonInfo.books[i].image;
						bookInfo += "<img src=" + imageURL + " /><br><br><br>";
					}
					
					$("#output").html(memberInfo + "<br>" + bookInfo);
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
	<input type="button" id="checkJson"value="data 수신">
	<div id="output"></div>
</body>
</html>