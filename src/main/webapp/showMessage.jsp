<%@ page import="com.sda.twit2.Message" %><%--
  Created by IntelliJ IDEA.
  User: KaWa
  Date: 27.08.2018
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>

<body>

<p>message: <%=((Message)request.getAttribute("message")).getContent()%> <br>
    author: <%=((Message)request.getAttribute("message")).getAuthor()%></p>

</body>
</html>