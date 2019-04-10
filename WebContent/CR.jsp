<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.entity.Topic"%>
<%@page import="java.util.List"%>
<%@page import="com.Dao.TopicDao"%>
<%@page import="com.Dao.TopicDaoImpl"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻添加</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
</head>
<%
   TopicDao cd=new TopicDaoImpl();
   List<Topic> list=cd.getall();
   session.setAttribute("list", list);
%>
<body>
<form action="CONTENTR" method="get">
<table class="sa">
	<tr>
		<td>
			<select >
			<c:forEach items="${list}" var="t">
				
	        	<option value="${t.getTid()}">${t.getTname()}</option>
	        </c:forEach>
			</select>
		</td>
	</tr>
	<tr>
	<td>标题:</td>
	<td><input type="text" name="ntitle" ></td>
	
	</tr>
		<tr>
	<td>作者:</td>
	<td><input type="text" name="nauthor" ></td>
		</tr>
	<tr>
	<td>内容:</td>
	<td class="a"><input type="text" name="ncontent" ></td>
	</tr>
	<tr>
	<td>备注:</td>
	<td><input type="text" name="nsummary" ></td>
		</tr>
		<tr>
		<td><input type="submit" value="提交"></td>
		<td><a href="upload.jsp" >上传文件</a></td>
		</tr>
</table>
</form>
</body>
</html>