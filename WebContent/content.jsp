<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>新闻发布系统管理后台</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<%
    String name=(String)session.getAttribute("name");
if(name==null){
	out.print("<script>alert('您还没有登录，请登录...'); window.location='index.jsp'</script>"); 
}
%>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：<%=session.getAttribute("name") %> 登录  &#160;&#160;&#160;&#160; <a href="goout.jsp">login out</a>
  &#160;&#160;&#160;&#160;<a href="UM.jsp">修改密码</a>
  </div>
  <div id="channel"> </div>
</div>
<div id="opt_list">
  <ul>
    <li><a href="CR.jsp">添加新闻</a></li>
    <li><a href="CB.jsp">编辑新闻</a></li>
    <li><a href="TR.jsp">添加主题</a></li>
    <li><a href="zhuti.jsp">编辑主题</a></li>
  </ul>
</div>

</head>
<script src="js/jquery-1.12.4.js"></script>
<script>
function show(index,pageSize){
	if(index==null && pageSize==null){
		
		index=1;
		pageSize=10;
	}else if(index<1){
		index=1;
	}
	
	$.ajax({
		url:"index2",
		type:"post",
		data:{"index":index,"pageSize":pageSize},
		dataType:"text",
		success:function(d){
			 d=JSON.parse(d);
			
			var list=d.newsList; 	
			console.log(d);
			$(list).each(function(){
				$(".div").append("<tr><td>"+this.ntitle+
						"</td><td>"+"作者"+
						"</td><td>"+this.nauthor+
						"</td>");
			})
			$(".div").append(
					"<tr><td>[当前页:"+d.currPageNo+"/总页数"+d.totalPageCount+"]</td></tr><tr>"+
					"<td><a JavaScript:vold(0) onclick='shang("+(d.currPageNo-1)+","+d.pageSize+");'>上一页</a></td>"+
					"<td><a JavaScript:vold(0) onclick='xia("+(d.currPageNo+1)+","+d.pageSize+");'>下一页</a></td>"+
					"<td><a JavaScript:vold(0) onclick='first("+(d.currPageNo=1)+","+d.pageSize+");'>首页</a></td>"+
					
					"<td><a JavaScript:vold(0) onclick='end("+(d.currPageNo=d.totalPageCount)+","+d.pageSize+");'>&nbsp&nbsp尾页</a></td>"+
					"<td></td></tr>"
			);
			//alert(d)
		},error:function(){
			alert("错误");
		}
		
	})
}

function first(index,pageSize){
	 $(".div").empty();
	 show(index,pageSize);
}
function end(index,pageSize){
	 $(".div").empty();
	 show(index,pageSize);
}
	function shang(index,pageSize){
	//判断是否为第一页
	$(".div").empty();
	
	//调用show方法
	show(index,pageSize);
}
	function xia(index,pageSize){
		//判断是否为第一页
		$(".div").empty();
		
		//调用show方法
		show(index,pageSize);
	}
</script>
<body onload="show()">
<div class="div"></div>
</body>
</html>