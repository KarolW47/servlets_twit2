<%--
  Created by IntelliJ IDEA.
  User: KaWa
  Date: 31.08.2018
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form method="post", action="register" >
    Login:
    <input type="text" name="login">
    Password:
    <input type="password" name="password">
    Repeat password:
    <input type="password" name="repeatedPassword">
    <br>
    <input type="submit" value="Register">
    <br>
    <a href="index.jsp">Back</a>
</form>

</body>
</html>
