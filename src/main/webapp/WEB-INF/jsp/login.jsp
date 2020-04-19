<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/14
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>登录</h3>
    <font color="red">${msg}</font>
    <form method="post" action="/login_success">
        <input type="text" name="name"/><br/>
        <input type="text" name="password"/><br/>
        <input type="submit" name="登录"/><br/>
    </form>
</body>
</html>
