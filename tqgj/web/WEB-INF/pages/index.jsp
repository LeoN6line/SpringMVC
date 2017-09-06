<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>运维工具</title>
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/icon.css">
	<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
	<script>
	$(function(){
		$("a").mouseover(function(){
			var tooltip = "<div >"+this.title +"</div>";
			$("#content").empty();
			$("#content").append(tooltip);
		}).mouseout(function(e){
			$("#content").empty();
		})
	})	
	</script>
</head>
<body>
<h1 style="text-align:center">提取运维工具包</h1>
<div class="easyui-layout" style="width:850px;height:320px;">
<div id ="accord"  title ="运维项目" region = "west"  class="easyui-accordion"  split="true" style="width:500px">
		<div title="公积金项目运维">
				<ul id="tt2" class="easyui-tree">
			<li>
				<span>运维文档</span>
				
			<li>
				<span>运维工具</span>
				<ul>
				<li>
				<a href ="gftj"  title="所属项目：公积金项目  运维说明：为了统计购房报表" >购房统计报表运维工具</a>
				</li>
				
				</ul>
			</li>
			
		</ul>
	</div>
</div>
<div id="content" region="center" title="运维说明" style="padding:5px;width:350px">
	无
	</div>
</div>
</body>
</html>