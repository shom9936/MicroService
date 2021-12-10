<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/Surf/css/join.css?ver=3">
<link rel="stylesheet" href="/Surf/css/member.css?ver=5">
<link rel="icon" href="/Surf/img/surf_person.ico">
<div align="center">
	
	<div class = "join-form">
		<header class="join-title">
			<h1> <a href="/Surf/index.me">Kaja Surf</a></h1>
		</header>
		<table class = "info">
			<tr>
				<th> ID </th>
				<td> <input type="text" name="id" value = "${vo.id }" disabled="disabled""></td>
			</tr>
			<tr>
				<th> Name</th>
				<td> <input type="text" name="name" value = "${vo.name }" disabled="disabled" ></td>
			</tr>
			<tr>
				<th> E-mail</th>
				<td> <input type="text" name="id" value = "${vo.email }" disabled="disabled"></td>
			</tr>
			<tr>
				<th> TEL</th>
				<td> <input type="text" name="id" value = "${vo.tel }" disabled="disabled"></td>
			</tr>
		</table>
		<br>
		<div class="page-button">
			<input type="button" value="수정" onclick="location.href='/Surf/member/updateForm.me'"> 
			<input type="button" value="탈퇴" onclick="location.href='/Surf/member/deleteForm.me'">
		</div>
	</div>
</div>
