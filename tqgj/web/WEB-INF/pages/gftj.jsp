<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购房统计与报表运维工具</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/icon.css">
	<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
	<script>
	function formatter2(date){
		if (!date){return '';}
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		return y + '-' + (m<10?('0'+m):m);
	}
	function parser2(s){
		if (!s){return null;}
		var ss = s.split('-');
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		if (!isNaN(y) && !isNaN(m)){
			return new Date(y,m-1,1);
		} else {
			return new Date();
		}
	}
</script></head>
<body>
<form action="./search" method = "get">
<table class="easyui-datagrid" style="width:850px;height:320px"	
		title="购房统计与报表运维工具" toolbar="#tb"
		singleSelect="true" fitColumns="true">
	<thead>
		<tr>
			<th field="id" align="center" width="10%">ID</th>
			<th field="excelname" align="center" width="40%">Excel名称</th>
			<th field="date" align="center" width="20%">统计日期</th>
			<th field="download" align="center" width="20%">是否下载</th>
			<th field="status" align="center" width="10%">状态</th>
		</tr>
	</thead>
	 <c:forEach items="${elist}" var="p">
	 <tr>
     <td>${p.id}</td>
     <td>${p.excelname}</td>
     <td>${p.date}</td>
     <td><a href ="${p.location}">下载</a></td>
 </tr>
 </c:forEach>
</table>





<!-- ToolBar编写 -->
<div id="tb" style="padding:5px;height:auto">
	<div>
		     统计日期:<input   name= "date"  class="easyui-datetimespinner" value="7/16/2017" data-options="formatter:formatter2,parser:parser2,selections:[[0,4],[5,7]]" style="width:180px;height:25px;text-align:center">
	<!-- 		<a href="./conDemo"  class="easyui-linkbutton" iconCls="icon-ok" style="height:20px"  >统计</a> -->
				<input type = "submit" class = "easyui-linkbutton" value ="统计" style="height:25px;width:50px;"/>
	<!-- 		<input class="easyui-textbox" data-options="multiline:true" value="暂时没有运行信息..." style="width:497px;height:260px;border:0;" disabled = "disabled"> -->
	</div>
	<div id = "message" style="width:100%;height:100%;border:0;margin-Top:10px;margin-Left:5px">
		
		</div>
</div>
</form>
</body>
</html>