<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: longnguyen
  Date: 6/19/20
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404 Not found</title>
    <style>
        .message {
            color:red;
        }
    </style>
</head>
<body>
    <h1>Page does not exists</h1>
    <c:if test="${requestScope.message != null}">
       <span class="message">${requestScope.message}</span>
    </c:if>
</body>
</html>
