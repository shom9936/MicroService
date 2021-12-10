<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kaja Surf</title>
<link type="text/css" rel="stylesheet" href="/Surf/css/basic.css?ver=7">
<link type="text/css" rel="stylesheet" href="/Surf/css/board.css?ver=3">
<link type="text/css" rel="stylesheet" href="/Surf/css/main.css?ver=6">
<link rel="icon" href="/Surf/img/surf_person.ico">
</head>
<body>
	<header>
		<nav id="navbar">
				<a href="/Surf/index.me" class="logo">
							<img src="/Surf/img/logo.png" class="surf_person"></a>
	
				<ul>
						<li>
							<a class="navbar-link" href="/Surf/surf/surfArea.su?area=2">동해</a>
						</li>
						<li>
							<a class="navbar-link" href="/Surf/surf/surfArea.su?area=4">서해</a>
						</li>
						<li>
							<a class="navbar-link" href="/Surf/surf/surfArea.su?area=1">남해</a>
						</li>
						<li>
							<a class="navbar-link" href="/Surf/surf/surfArea.su?area=3">제주</a>
						</li>
				</ul>
				
				<span class="headerButton" align="right">
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
						
					</span>
		</nav>
	</header>
	
		<hr>
		<div class="main">
			