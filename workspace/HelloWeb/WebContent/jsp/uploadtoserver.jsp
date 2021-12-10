<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>upload</h2>
<% String bang="c:/upload";

MultipartRequest mr = new MultipartRequest(request, bang, 10*1024*1024, "euc-kr", new DefaultFileRenamePolicy());
String virum1=mr.getParameter("name");
String vfilename1=mr.getFilesystemName("file");

if(vfilename1 !=null){
    out.println("사용자 이름은"+virum1+"이고"+"<br>");
    out.println(vfilename1+"라는 파일 올리기 성공");
}else
    out.println("에러");

%>
</body>
</html>