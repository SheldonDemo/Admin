<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
<table align="center" border="1" width="400px">
<caption><h3>注册界面</h3></caption>
    <tr>
    	<th>账户</th>
        <td><input type="text" name="user" value="${admin.user }"/><font color="red">${msg2 }</font><font color="red">${msg5 }</font>
        </td>
    </tr>
    <tr>
    	<th>密码</th>
        <td>
        <input type="password" name="pwd" value="${admin.pwd }"/><font color="red">${msg3 }</font>
        </td>
    </tr>
    <tr>
    	<th>确认密码</th>
        <td>
		<input type="password" name="checkpwd"/><font color="red">${msg4 }</font>
        </td>
    </tr>
    <tr>
    	<th>邮箱</th>
        <td>
		<input type="text" name="email"/>(选填)
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
        <input type="submit" value="注册"/>&nbsp;
        <input type="reset" value="重置"/></td>
    </tr>
</table>



</form>

</body>
</html>