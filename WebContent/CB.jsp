<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻编辑</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
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
				$(".div").append("<tr><td>新闻id"+this.nid+"</td><td>"+this.ntitle+
						"</td><td>"+"作者"+
						"</td><td>"+this.nauthor+
						"</td><td>"+'<a href="CM.jsp">修改</a>'+"&nbsp&nbsp&nbsp</td><td>"+
						'<a href="CONTENTD?nid='+this.nid+'">删除</a>'+"</td>");
			})
			$(".div").append(
					"<tr><td>[当前页:"+d.currPageNo+"/总页数"+d.totalPageCount+"]</td></tr><tr>"+
					
					"<td><a JavaScript:vold(0) onclick='shang("+(d.currPageNo-1)+","+d.pageSize+");'>上一页</a></td>"+
					"<td><a JavaScript:vold(0) onclick='xia("+(d.currPageNo+1)+","+d.pageSize+");'>下一页</a></td>"+
					
					"<td><a JavaScript:vold(0) onclick='first("+(d.currPageNo=1)+","+d.pageSize+");'>首页</a></td>"+
					
					"<td><a JavaScript:vold(0) onclick='end("+(d.currPageNo=d.totalPageCount)+","+d.pageSize+");'>&nbsp&nbsp尾页</a></td>"+
					"</tr>"
			);
			//alert(d)
		},error:function(){
			alert("错误");
		}
		
	})
}

	function shang(index,pageSize){
	//判断是否为第一页
	$(".div").empty();
	
	//调用show方法
	show(index,pageSize);
}
	function first(index,pageSize){
		 $(".div").empty();
		 show(index,pageSize);
	}
	function end(index,pageSize){
		 $(".div").empty();
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