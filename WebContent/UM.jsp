<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
</head>
<body>
<form action="USERM" method="get">
<table>
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>老密码:</td>
			<td><input type="text" name="npwd"></td>
		</tr>
		<tr>
			<td>新密码:</td>
			<td><input type="text" id="pwd" name="pwd"></td>
		</tr>
		<tr>
			<td>确认新密码:</td>
			<td><input type="text" id="upwd"></td>
		</tr>
		<tr>
			<td><input type="submit" id="sub" value="提交"></td>
		</tr>
</table>
</form>
<script src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function(){
	$("#sub").click(function(){
		var pwd=$("#pwd").val();
		var upwd=$("#upwd").val();
		if(pwd==null){
			alert("密码不能为空");
			return false;
		}else if(pwd.length>10){
			alert("密码长度不能超过10");
			return false;
		}else if(upwd!=pwd){
			alert("与新密码不相同");
			return false;
		}
		return true;
	})
})
</script>
</body>
</html>