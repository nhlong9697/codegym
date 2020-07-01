<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>View product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Id: </td>
        <td>${requestScope.product.getId()}</td>
    </tr>
    <tr>
        <td>Product Name: </td>
        <td>${requestScope.product.getProductName()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope.product.getPrice()}</td>
    </tr>
    <tr>
        <td>Quantity: </td>
        <td>${requestScope.product.getQuantity()}</td>
    </tr><tr>
        <td>Price: </td>
        <td>${requestScope.product.getColor()}</td>
    </tr><tr>
        <td>Price: </td>
        <td>${requestScope.product.getDescription()}</td>
    </tr>
    <tr>
        <td>Category: </td>
        <td>${requestScope.product.getCategory()}</td>
    </tr>
</table>
</body>
</html>
