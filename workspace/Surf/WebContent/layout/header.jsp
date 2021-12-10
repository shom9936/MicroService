<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kaja Surf</title>
<link type="text/css" rel="stylesheet" href="/Surf/css/basic.css?ver=9">
<link type="text/css" rel="stylesheet" href="/Surf/css/board.css?ver=3">
<link type="text/css" rel="stylesheet" href="/Surf/css/main.css?ver=4">
<link rel="icon" href="/Surf/img/surf_person.ico">
</head>
<body>
	<div class="surf">
		<header>
			<table class="headerTable" align="center">
				<tr>
					<td class="headerTitle" align="right" >
						<a href="/Surf/index.me" class="logo">
							<img src="/Surf/img/logo.png" class="surf_person"></a>
					</td>
					<td class="headerButton" align="right">
						<c:choose>
							<c:when test="${login == null }">
								<button type="button" class = "login" onclick="location.href='/Surf/login/loginForm.me'">로그인</button>  &nbsp;
								<button type="button" class = "join" onclick="location.href='/Surf/member/joinForm.me'">회원가입</button>
							</c:when>
							<c:otherwise>
								<button type="button" class="logout" onclick="location.href='/Surf/login/logout.me'">로그아웃</button>
								<button type="button" class="join"  onclick="location.href='/Surf/member/myPage.me'">내 정보</button>
							</c:otherwise>
						</c:choose>
						
					</td>
				</tr>
			</table>
		</header>
		<br>
		<div class="main">
			