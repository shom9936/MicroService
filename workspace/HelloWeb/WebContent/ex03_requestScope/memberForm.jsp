<%-- memberForm.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 가입 </title>
</head>
<body>
	<form action="forward.jsp" method="post">
		<table align = "center">
			<tr>
				<td width="200"> <p align="right"> ID </p></td>
				<td width="400"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width="200"> <p align="right"> PW </p></td>
				<td width="400"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width="200"> <p align="right"> 이름 </p></td>
				<td width="400"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="200"> <p align="right"> E-mail </p></td>
				<td width="400"><input type="text" name="email"></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="가입하기"> 
				&nbsp; <input type = "reset" value="다시입력"> </td>
			</tr>
		</table>
	</form>
	
</body>
</html>