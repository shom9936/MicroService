<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Surf/css/member.css?ver=4">
<link rel="icon" href="/Surf/img/surf_person.ico">
<title>Kaja Surf</title>
<script type="text/javascript">
		function ckCheck(f){
			var ck=cb1.checked;
			if(ck==''){
				alert("약관에 동의해주십시오");
				return;
			}else{
				f.action = "/Surf/member/deleteForm.me";
				f.submit();
			}
		}
</script>
</head>
<body>
		<div class="delete-guide">
		<h1>회원 탈퇴 안내</h1>
		<h4>탈퇴 시 주의사항</h4>
		<hr>
			<form>
			<div class="delete-mention">
			<ol>
				<li>사용하고 계신 아이디는 탈퇴할 경우<font color="#FE2E2E"><ins> 재사용 및 복구가 불가능</ins></font> 합니다.</li><br>
				<li>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</li><br>
				<li>리뷰와 문의 같은 게시판형 서비스에 등록 된 게시물은 <font color="#FE2E2E"><ins> 탈퇴 후에도 자동 삭제 되지 않습니다.</ins></font></li><br>
			</ol>
			</div>
	    	
			<div class="join-button">
			
			<input type="checkbox" id="cb1"> 
			<label for="cb1">안내사항을 모두 확인하였으며, 이에 동의합니다.</label> <br><br><br>
			
		
				<button class="index-button" onclick="location.href='/Surf/member/index.me'">취소</button>
				<button class="con-button" onclick="ckCheck(this.form)">확인</button>
				<!--<button class="con-button" onclick="location.href='/Surf/member/deleteResult.me'">확인</button>-->
			</div>
		</form>
		</div>
</body>
</html>