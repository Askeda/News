<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
<form action="REG" method="get">
<table>
<tr><td>姓名：<input type="text" name="name" id="name"></td>
<td><div id="namea" style="display: inline"></div></td></tr>
<tr><td>密码：<input type="password" name="pwd" id="pwd"></td>
<td><div id="pwda" style="display: inline"></div></td></tr>
<tr><td><input type="submit" value="注册"></td></tr>
</table>
</form>
     <script src="js/jquery-1.12.4.js"></script>
     <script type="text/javascript">
     $(document).ready(function() {
      	$("#name").blur(function() {
     		 var name = this.value;
     		 if (name == null) {
     		 $("#namea").html("用户名不能为空！");
     		 }else if(name.length>10){
     			 $("#namea").html("用户名长度不能超过10位！");
     		 } else {
     			 $.ajax({
                      url       : "UY",   
                      type      : "GET",          
                      data	   : "name="+name,    
                      dataType  : "text",          
                      success   : callBack,        
                      error     : function() {    
                          alert("用户名验证时出现错误，请稍后再试或与管理员联系！");
                      }
                  });

     			 function callBack(data) {
     			 	if (data == "true") {
     				 	$("#namea").html("用户名已被使用！");
     				 	return false;
     				 } else {
     				 	$("#namea").html("用户名可以使用！");
     				 }
     			 }
     	 	}
     	 });
     	 $("#pwd").blur(function() {
     	 	var pwd = this.value;
     		 if (pwd == null || pwd == "") {
     		 	$("#pwda").html("密码不能为空！");
     		 }else{
     			 $("#pwda").html("密码可以使用！");
     		 }
     	 });
  });
     
     
     </script>
</body>
</html>