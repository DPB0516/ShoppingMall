<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectcarts.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
  <body>
 		${cookie.name.value }，${cookie.userid.value }你好 <a href="/SSM/b.action">退出</a>
 		 <table border="1">
		<tr>
			<td>图片</td>
			<td>简介</td>
			<td>价格</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${list.keySet()}" var="good">
			<tr>
				<td>${list.get(good).img}</td>
				<td>${list.get(good).name}</td>
				<td>${list.get(good).money}</td>
				<td><a href="deleteCart.action?cartid=${good}&userid=${cookie.userid.value}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	
  </body>
</html>
