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
    out.println("����� �̸���"+virum1+"�̰�"+"<br>");
    out.println(vfilename1+"��� ���� �ø��� ����");
}else
    out.println("����");

%>
</body>
</html>