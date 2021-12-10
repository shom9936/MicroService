<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%-- remember : jsp는 html+자바( <%  %> scriptlet ) --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

body가 있지만 파일 확장자는 .jsp <br>

오늘 날짜를 출력해보자(자바문법을 script하여) <br>

<%                        /* 이부분은 자바를 script하므로 jsp에서는 scriptlet으로 묶어야 함 */
 Date d1 = new Date(); //html에 자바를 끼워 넣고 있는 중 /////////////
 
 %>
 
 엑박뜨면 자바에서는 ctrl+shift+o 하면 일반적인 해결법 <br>
 
 .jsp에서는, Date까지 입력한 다음 <br>
 
 ctrl + space bar 를 눌러봄<br>
 
 import가 되는 것을 확인 <br>
 
 상단에 import가 보임<br>

<%-- 주석은 이렇게 사용한다 --%>



<%
        //web에서 클라이언트로 응답을 전송하는 것, 사용자는 브라우저 화면에서 응답을 확인
        out.println("<h1>날짜 출력이라고?!</h1>"+"  "+d1+"<p>");
                                //이 문장이 바로 자바+html을 끼워넣는 문장임
                //System.out.println        : 화문 출력하는 dos 명령
                
        out.println(request.getRequestURI()+"로 요청한 URI구만"+"<br>");
         //out: jsp내장 //request : 요청담담 내장객체 //response
          // 프로젝트명/.jsp


%>

</body>
</html>