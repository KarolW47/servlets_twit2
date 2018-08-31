<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
Log In :
<form method="post" action="loginUser" >
    Type your login :
    <input type="text" name="login">
    <br>
    Type your password:
    <input type="password"  name="password">
    <br>
    <input type="submit" value="Log in!">
</form>
Don't have account here yet?
<a href="registerUser.jsp">Sign up!</a>
</body>
</html>
