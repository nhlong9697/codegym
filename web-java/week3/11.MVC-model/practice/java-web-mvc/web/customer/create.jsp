<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
    <style>
        .message {
            color:green;
        }
    </style>
</head>
<body>
    <h1>Create new customer</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message"></span>
        </c:if>
    </p>
</body>
</html>
