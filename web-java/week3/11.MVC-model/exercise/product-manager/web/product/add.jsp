<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <c:if test='${requestScope.message != null}'>
        <span class="message">${requestScope.message}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to customer</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Product name: </td>
                <td><input type="text" name="productName" id="productName"></td>
            </tr>
            <tr>
                <td>Category: </td>
                <td><input type="text" name="category" id="category"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="number" name="price" id="price"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" id="submit"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
