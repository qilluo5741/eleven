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
	<link rel="stylesheet" href="../css/01.css" type="text/css"></link>
  </head>
  
  <body>
  	<form action="WarehousLog/updateWarehousLogInfo.action" method="post">
  	 <table align="center" cellpadding="0" cellspacing="0" width="400" height="300">
  		 <input type="hidden" name="warehousLogId" value="${i.warehousLogId}"/>
  	 		<tr>
  	 			<td align="center">入库/出库</td>
    			<td align="center">
					<select name="isIncrease">
					<c:forEach items="${w}" var="w">
	   						<option value="${w.isIncrease}" style="width:120">${w.isIncrease==0? "入库":"出库"}</option>
	   				</c:forEach>
				</td>
  	 		</tr>
  	 		<tr>
    			<td align="center">商品名称:</td>
	    			<td align="center">
		    			<select name="outbound.outboundId">
		   					<c:forEach items="${io}" var="io">
		   						<option value="${io.outboundId}" style="width: 120">${io.goodsName}</option>
		   					</c:forEach>
				   		</select>
					</td>
    		</tr>
    		<tr>
    			<td align="center">所在仓库:</td>
    			<td align="center">
	    			<select name="warehouse.warehouseId">
	   					<c:forEach items="${iw}" var="iw">
	   						<option value="${iw.warehouseId}" style="width: 120">${iw.warehouseName}</option>
	   					</c:forEach>
			   		</select>
				</td>
    		</tr>
    		<tr>
    			<td align="center">入库类型:</td>
    			<td align="center">
	    			<select name="inbound.inboundId">
						<c:forEach items="${i}" var="i">
	   						<option value="${i.inboundId}" style="width:120">${i.reOrPo==0? "入库":"出库"}</option>
	   				</c:forEach>
			   		</select>
				</td>
    		</tr>
    		<tr>
    			<td align="center">记录备注:</td>
    			<td align="center"><input type="text" name="warehousLogRemark" value="${w.warehousLogRemark}"></td>
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
