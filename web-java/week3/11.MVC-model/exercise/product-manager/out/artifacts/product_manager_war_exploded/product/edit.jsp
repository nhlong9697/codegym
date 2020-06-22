<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>

<h1>Edit product</h1>
<p>
    <c:if test='${requestScope.message != null}'>
        <span class="message">${requestScope.message}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Product Name: </td>
                <td><input type="text" name="productName" id="productName" value="${requestScope.product.getProductName()}"></td>
            </tr>
            <tr>
                <td>Category: </td>
                <td><input type="text" name="category" id="category" value="${requestScope.product.getCategory()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="number" name="price" id="price" value="${requestScope.product.getPrice()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
