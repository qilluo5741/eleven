<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/01.css" type="text/css"></link>
  </head>
  
  <body>
  	<form action="Warehouse/updateWarehouseInfo.action" method="post">
  	 <table align="center" cellpadding="0" cellspacing="0" width="400" height="300">
  	 <input type="hidden" name="warehouseId" value="${w.warehouseId}"/>
  			<tr>
    			<td align="center">仓库名称:</td>
    			<td align="center"><input type="text" name="warehouseName" value="${w.warehouseName}"></td>
    		</tr>
    		<tr>
    			<td align="center">仓库地址:</td>
    			<td align="center"><input type="text" name="warehouseAddress"  value="${w.warehouseAddress}"></td>
    		</tr>
    		<tr>
    			<td align="center">仓库人员：</td>
    			<td align="center">
					<select name="emp.empId">
	   					<c:forEach items="${empList}" var="e">
	   						<option value="${e.empId}" style="width:120">${e.empName}</option>
	   					</c:forEach>
		   			</select>
				</td>
    		</tr>
    		<tr>
	    		<td align="center" colspan="2">
	    			<input type="submit" value="确定">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="取消">
	    		</td>
    		</tr>
   		</table>
   	</form>
  </body>
</html>
