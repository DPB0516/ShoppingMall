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
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <c:choose>
  	<c:when test="${cookie.userid.value!=null}">
  	<script type="text/javascript">window.location="/SSH/getGoods"</script>
  	</c:when>
  	<c:otherwise>
	   <form action="getuser" method="post" >
   	账号:<input type="text" name="name">
   		<br>
   		密码:<input type="password" name="pwd">
   		<br>
   <input type="submit" >
   </form>
</c:otherwise>
  </c:choose>
 </body>
</html>

