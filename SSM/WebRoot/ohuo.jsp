<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
 
  </head>
  
  <body>
 		${cookie.name.value }，${cookie.userid.value }你好 <a href="/SSM/b.action">退出</a>
 		<a href="selectcart.action?userid=${cookie.userid.value}">查看购物车</a>
 <table border="1">
		<tr>
			<td>图片</td>
			<td>简介</td>
			<td>价格</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="good">
			<tr>
				<td>${good.img}</td>
				<td>${good.name}</td>
				<td>${good.money}</td>
				<td><a href="addcart.action?userid=${cookie.userid.value}&goodid=${good.goodid}">添加到购物车</a></td>
			</tr>
		</c:forEach>
	</table>
	
  </body>
</html>
