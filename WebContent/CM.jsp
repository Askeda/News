<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻修改</title>
</head>
<body>
<form action="CONTENTM" method="get">
<table>
	<tr>
		<td>请输入新闻ID进行确认:</td>
		<td><input type="text" name="nid"></td>
	</tr>
	<tr>
		<td>请输入新的新闻标题:</td>
		<td><input type="text" name="ntitle"></td>
	</tr>
	<tr>
		<td><input type="submit" value="提交"></td>
	</tr>
</table>
</form>
</body>
</html>