<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻主题修改</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
</head>
<script src="js/jquery-1.12.4.js"></script>
<script>
$(function(){
	$.get("TOPIC","text",function(d){
		d=JSON.parse(d);
		$(".qq").append("<table><tr><td>标题&nbsp&nbsp"+
				"</td><td>标题名字</td></tr>");
		$(d).each(function(){
			$(".qq").append("<tr><td>&nbsp&nbsp&nbsp"+this.tid+
					"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td>"
					+this.tname+"</td><td>"+
					'&nbsp&nbsp&nbsp<a href="TM.jsp">修改</a>'+"</td>"+"<td>"+
					'&nbsp&nbsp&nbsp&nbsp<a href="TOPICD?tid='+this.tid+'">删除</a>'+
							"</td></tr>");
		})
		$(".qq").append("</table>")
	})
})
</script>
<body>

<div class="qq"></div>
</body>
</html>