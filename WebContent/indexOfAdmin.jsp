<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户主页</title>
</head>
<body>

<h2>Welcome ${admin.user }</h2>
<a href='${pageContext.request.contextPath }/index.jsp'>退出</a>
<a href='${pageContext.request.contextPath }/DeleteAdminServlet?user=${admin.user }'>注销帐号</a>
<a href="${pageContext.request.contextPath }/update.jsp?user=${admin.user }">修改密码</a>

</body>
</html>