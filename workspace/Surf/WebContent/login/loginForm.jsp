<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Surf/css/login.css?ver=2">
<title></title>
<script type="text/javascript">
    function checkLogin(f){
		if(f.id.value==''){
			alert('아이디를 입력하세요!')
			f.id.focus();
			return;
		}
		if(f.pwd.value==''){
			alert('비밀번호를 입력하세요!')
			f.password.focus();
			return;
		}
		
		f.action = "/Surf/login/login.me";
		f.submit();
	}
</script>
</head>
<body>
	<div class = "login-form">
		<header class="login-title">
			<h1> <a href="/Surf/member/index.me">Kaja Surf</a></h1>
		</header>
		
		<form>
			<div class="input-box">
				<input id = "id" type="text" name="id" value="${id }" placeholder="&nbsp;&nbsp;아이디">
	
			</div>
			<div class="input-box">
				<input id="password" type="password" name="pwd" placeholder="&nbsp;&nbsp;비밀번호">		
			</div>
			<br>
			
			<span class="login-button">
				<input type="button" value = "로그인" onclick="checkLogin(this.form);">
			</span>
			<br><br>
			<div class="go-join">
				<font>Kaja Surf 회원이 아니시라면 </font><a href="/Surf/member/joinForm.me">지금 가입하세요</a>
			</div>
		</form>
	</div>
</body>
</html>