<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String name=request.getParameter("name"); 
String tel=request.getParameter("tel");
%>

이름은  <%= name %> 
전화번호는 <%= tel%> 
