<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改信息</title>
<style type="text/css">
	
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
</style>
<%
	String user = request.getParameter("user");
%>
</head>
<body>
<form action="${pageContext.request.contextPath }/UpdateAdminServlet?user=<%=user %>" method="post">
	<table align="center" border="1" width="600px">
	<caption><h3>修改密码界面</h3></caption>
		<tr>
		<th>旧密码</th>
		<td><input type="password" name="oldpwd" value="${oldpwd }"/><font color="red">${msg9 }</font>
		</td>
		</tr>
		<tr>
		<th>新密码</th>
		<td><input type="password" name="newpwd"/>
		</td>
		</tr>
		<tr>
		<th>确认新密码</th>
		<td><input type="password" name="checknewpwd"/><font color="red">${msg10 }</font>
		</td>
		</tr>
		<tr>
		<td colspan="2" align="center">
		<input type="submit" value="提交"/>&nbsp;
		<input type="reset" value="重置"/>
		</td>
		</tr>
	</table>
</form>
</body>
</html>