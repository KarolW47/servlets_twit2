<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="com.sda.twit2.hibernate.dao.MessageDao" %>
<%@ page import="com.sda.twit2.hibernate.entity.Message" %>
<%@ page import="java.util.List" %><%--
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

<%
    List<Message> messageList = MessageDao.getInstance().getAll();
    request.setAttribute("messageList", messageList);
%>

<body>
<div>
    <h2>Posted Messages:</h2>
    <div>
        <c:forEach var="message" items="${messageList}">
            <table border="2" bgcolor="white">
                <tr>
                    <td colspan="3">
                        <b>Message: </b> <c:out value="${message.content}"/>
                    </td>
                    <td colspan="3">
                        <b>Author: </b> <c:out value="${message.user.login}"/>
                    </td>
                </tr>
            </table>
        </c:forEach>
    </div>
</div>
</body>
</html>
