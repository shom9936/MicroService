<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��� ���� �Է�</h1>
	<form action="insert.jsp">
		<table border = "1">
			<tr>
				<th>���</th>
				<td> <input type="text" name="id"> </td>
			</tr>
			<tr>
				<th>�̸� </th>
				<td> <input type="text" name="name"> </td>
			</tr>
			<tr>
				<th> ��ȭ��ȣ</th>
				<td> <input type="text" name="tel"></td>
			</tr>
			<tr>
				<th> �Ի���</th>
				<td> <input type="text" name="date"></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="�߰�"></td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<td> <a href="insertForm.jsp">[�Է�]</a> </td>
			<td> <a href="updateForm.jsp">[����]</a> </td>
			<td> <a href="deleteForm.jsp">[����]</a> </td>
			<td> <a href="view.jsp">[��� ����]</a> </td>
		</tr>
	</table>
	
</body>
</html>