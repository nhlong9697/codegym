<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
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
<h1>Delete product</h1>
<form method="post">
    <h3>Are you sure?</h3>
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
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope.product.getColor()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope.product.getDescription()}</td>
            </tr>
            <tr>
                <td>Category: </td>
                <td>${requestScope.product.getCategory()}</td>
            </tr>
            <tr>
                <td><input type="submit" class="btn btn-danger" value="Delete"></td>
                <td><a class="btn btn-secondary" href="/products">Back</a></td>
            </tr>
        </table>
</form>
</body>
</html>
