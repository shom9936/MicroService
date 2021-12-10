<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Surf/css/member.css?ver=3">
<link rel="icon" href="/Surf/img/surf_person.ico">
<title>Kaja Surf</title>
<script type="text/javascript">

    function checkdelete(f){
    	if(f.pwd.value==""){
    		alert('비밀번호를 입력해주세요');
    		f.pwd.focus();
    		return;
    	} else if(f.pwd.value != f.ckPW.value){
    		alert('비밀번호가 일치하지않습니다.');
    		f.pwd.focus();
    		return;
    	} else{
			f.action = "/Surf/member/delete.me";
			f.submit();
    	}
	}
</script>

</head>
<body>

	<div class = "delete-form">
		<header class="delete-title">
			<h1> <a href="/Surf/index.me">Kaja Surf</a></h1>
		</header>	
			<form>
			<table align="center">
				<tr>
					<td colspan="2">
						<h2>비밀번호인증</h2> 
						<hr>
						<h5>정보를 안전하게 보호하기 위해 비밀번호를 다시 한 번 확인합니다. 
						<br>
						<br>비밀번호가 타인에게 노출되지 않도록 항상 주의해주세요.</h5>
					</td>
				</tr>		
				
				<tr>
					<th class="input-label">비밀번호</th>
					<td class="input-box">
						<input type="password" name="pwd" placeholder="&nbsp;&nbsp;비밀번호">
						<input type="hidden" name="ckPW" value="${vo.pwd }">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="modify-box">
						<button class = "index-button" onclick="location.href='/Surf/member/myPage.me'">취소</button>
						<button class="con-button" onclick="checkdelete(this.form);">회원 탈퇴</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

