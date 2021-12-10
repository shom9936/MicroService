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
			var _jsonInfo = '{"name" : "박지성", "age" : 25, "gender" : "남자", "nickname" : "날센돌이"}';
			$.ajax({
				type : "post",
				async : false,
				url : "${pageContext.request.contextPath}/json",
				data : {jsonInfo : _jsonInfo},
				success : function(data, textStatus){} ,
				error : function(data, textStatus){
					alert('에러발생');
				},
				complete : function(data, textStatus){}
			}); // end ajax
		}); // end click
	}); // end function
</script>
</head>
<body>
	<input type="button" id="checkJson" value="출력">
	<div id="output"></div>
</body>
</html>