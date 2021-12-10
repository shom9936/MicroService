<%-- package sawonpkg;

public class Sawon {

        private String irum;
        private String nai;
        public String getIrum() {
                return irum;
        }
        public void setIrum(String irum) {
                this.irum = irum;
        }
        public String getNai() {
                return nai;
        }
        public void setNai(String nai) {
                this.nai = nai;
        }

}

========================


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
String irum=(String)request.getParameter("irum");
String nai=(String)request.getParameter("nai");
out.println("여기는 자바스타일로 출력"+irum+","+nai+"<br>");
%>

<!-- Sawon sawon1=new Sawon() 자바스타일 -->
<!-- Sawon sawon2=new Sawon() -->

<!-- 가독성 (가능한한 자바식 표현 하지말고 태그로 표현하자) -->
<!-- id는 객체명 calss="패키지명.클래스명" (jsp스타일) -->
<jsp:useBean id="sawon1" class="sawonpkg.Sawon" />
<jsp:useBean id="sawon2" class="sawonpkg.Sawon" />


<!-- spring에서는 <bean id="sawon1" class="sawonpkg.Sawon" /> 완전 비슷함 -->

<!-- 자바에서 setter로 넘어오는 irum 및 nai를 받아보자
sawon.setIrum(request.getParameter("irum") 
sawon.setNai(request.getParameter("Nai") -->

<!-- 가독성을 위해서
   여기서 name="객체명" -->
<jsp:setProperty name="sawon1" property="irum"/>
<jsp:setProperty name="sawon1" property="nai"/>


<jsp:setProperty name="sawon2" property="*"/>
<!-- set + Irum(), Nai() . . . 즉, 10개를 set 해도 한줄로 끝이다. -->
폼에서 넘어오는 것을 all set, 단, getProperty는 *기호 사용 못함
즉, Setter에 한해서 전부 다 넘어오는 역할을 *가 담당함 
그러므로 *는 현재 irum,nai를 set하고 있음



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> jsp : getProperty출력1</h2>
이름은 <jsp:getProperty name="sawon1" property="irum"/>
나이는 <jsp:getProperty name="sawon1" property="nai"/>

<h2> jsp : getProperty출력2</h2>
이름은 <jsp:getProperty name="sawon2" property="irum"/>
나이는 <jsp:getProperty name="sawon2" property="nai"/>

</body>
</html>
 --%>