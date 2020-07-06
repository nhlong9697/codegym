<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Products</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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
    <table>
        <tr>
            <td>Product name: </td>
            <td><input type="text" name="productName" id="productName"
                       value="${requestScope.product.getProductName()}"></td>
        </tr>
        <tr>
            <td>Price: </td>
            <td><input type="number" name="price" id="price"
                       value="${requestScope.product.getPrice()}"></td>
        </tr>
        <tr>
            <td>Quantity: </td>
            <td><input type="number" name="quantity" id="quantity"
                       value="${requestScope.product.getQuantity()}"></td>
        </tr>
        <tr>
            <td>Color: </td>
            <td><input type="text" name="color" id="color"
                       value="${requestScope.product.getColor()}"></td>
        </tr>
        <tr>
            <td>Description: </td>
            <td><input type="text" name="description" id="description"
                       value="${requestScope.product.getDescription()}"></td>
        </tr>
        <tr>
            <td>Category: </td>
            <td><input type="text" name="category" id="category"
                       value="${requestScope.product.getCategory()}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update" class="btn btn-success"></td>
            <td><a class="btn btn-secondary" href="/products">Back</a></td>
        </tr>
    </table>
</form>
</body>
</html>
