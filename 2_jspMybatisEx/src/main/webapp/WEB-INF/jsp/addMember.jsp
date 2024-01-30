<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addMember" method="post">
		<table align="center" border="1">
			<tr align="center">
				<td>name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr align="center">
				<td>username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr align="center">
				<td>password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr align="center">
				<td>address:</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr align="center">
				<td>phone:</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr align="center">
				<td>mobile:</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr align="center">
				<td colspan=2><input type="submit" value="註冊"></td>
			</tr>
		</table>
	</form>
</body>
</html>