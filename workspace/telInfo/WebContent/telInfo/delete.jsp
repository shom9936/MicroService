<%@page import="vo.TelInfoVO"%>
<%@page import="dao.TelInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr");
		TelInfoDAO dao = new TelInfoDAO();
		TelInfoVO vo = dao.getOneInfo(request.getParameter("name"));
	%>

	<h1>사원 정보 삭제</h1>
	<form action="insert.jsp">
		<table border = "1">
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>입사일</th>	
			</tr>
			<tr>
				<td> <%=vo.getId() %> </td>
				<td> <%=vo.getName() %> </td>
				<td> <%=vo.getTel() %> </td>
				<td> <%=vo.getDate() %> </td>
			</tr>
			<tr>
				<td colspan="4"><input type="button" value="삭제" onclick="location.href='deleteProcess.jsp?name=<%=vo.getName()%>';"> </td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<td> <a href="insertForm.jsp">[입력]</a> </td>
			<td> <a href="updateForm.jsp">[수정]</a> </td>
			<td> <a href="view.jsp">[모두 보기]</a> </td>
		</tr>
	</table>
	
</body>
</html>