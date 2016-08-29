<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
</style>
</head>
<body>
<center><h3>登陆界面</h3></center>
<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
<table align="center" border="1" width="400px">
	<tr>
    	<th>帐号</th>
        <td><input type="text" name="user" value="${admin.user }"/><font color="red">${msg1 }</font><font color="red">${msg7 }</font></td>
    </tr>
    <tr>
    	<th>密码</th>
        <td><input type="password" name="pwd" value="${admin.pwd }"/><font color="red">${msg6 }</font><font color="red">${msg8 }</font></td>
    </tr>
    <tr>
    	<td colspan="2" align="center">
        <input type="submit" value="登录">&nbsp;
        <input type="button" value="注册" onclick="location.href='${pageContext.request.contextPath }/register.jsp'"></td>
    </tr>
</table>
</form>
</body>
</html>