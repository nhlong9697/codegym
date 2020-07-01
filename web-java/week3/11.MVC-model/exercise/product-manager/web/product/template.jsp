<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
    <style>
        body {
            color: #566787;
            background: #f7f5f2;
            font-family: 'Roboto', sans-serif;
        }
        .table-responsive {
            margin: 30px 0;
        }
        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0,0,0,.05);
        }
        .table-title {
            color: #fff;
            background: white;
            padding: 16px 25px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }
        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }
        .search-box {
            position: relative;
            float: right;
        }
        .search-box .input-group {
            min-width: 300px;
            position: absolute;
            right: 0;
        }
        .search-box .input-group-addon, .search-box input {
            border-color: #ddd;
            border-radius: 0;
        }
        .search-box input {
            height: 34px;
            padding-right: 35px;
            background: #f4fcfd;
            border: none;
            border-radius: 2px !important;
        }
        .search-box input:focus {
            background: #fff;
        }
        .search-box input::placeholder {
            font-style: italic;
        }
        .search-box .input-group-addon {
            min-width: 35px;
            border: none;
            background: transparent;
            position: absolute;
            right: 0;
            z-index: 9;
            padding: 6px 0;
        }
        .search-box i {
            color: #a0a5b1;
            font-size: 19px;
            position: relative;
            top: 2px;
        }
        table.table {
            table-layout: fixed;
            margin-top: 15px;
        }
        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
        }
        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }
        table.table th:first-child {
            width: 60px;
        }
        table.table th:last-child {
            width: 120px;
        }
        table.table td a {
            color: #a0a5b1;
            display: inline-block;
            margin: 0 5px;
        }
        table.table td a.view {
            color: #03A9F4;
        }
        table.table td a.edit {
            color: #FFC107;
        }
        table.table td a.delete {
            color: #E34724;
        }
        table.table td i {
            font-size: 19px;
        }
    </style>
    <script>

    </script>
</head>
<body>
<h1>Products</h1>
<p>
    <c:if test="${requestScope.message != null}">
        <span class="message">${requestScope.message}</span>
    </c:if>
</p>
<div class="container-lg">
    <form action="/products" method="get">
        <input type="hidden" name="action" value="sort">
        <select name="categoryToSort" onchange="this.form.submit()">
            <option value="id">Sort by ID</option>
            <option value="productName">Sort by product name</option>
            <option value="price">Sort by price</option>
            <option value="quantity">Sort by quantity</option>
            <option value="color">Sort by color</option>
            <option value="category">Sort by category</option>
        </select>
    </form>
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <a class="btn btn-primary" href="#" role="button">Add new product</a>

                    </div>
                    <div class="col-sm-6">
                        <div class="search-box">
                            <form action="/products" method="get">
                                <input type="hidden" name="action" value="search">
                                <div class="input-group">
                                    <input type="text" id="nameToSearch" class="form-control"
                                           placeholder="Search by Name">
                                    <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
                                </div>
                                <input class="btn btn-primary" type="submit" value="Search">
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th style="width: 22%;">Product Name</th>
                    <th style="width: 22%;">Price</th>
                    <th>Quantity</th>
                    <th>Color</th>
                    <th>Category</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items='${requestScope.products}' var="product">
                    <tr>
                        <td>${product.getId()}</td>
                        <td><a href="/products?action=view&id=${product.getId()}">${product.getProductName()}</a></td>
                        <td>${product.getPrice()}</td>
                        <td>${product.getQuantity()}</td>
                        <td>${product.getColor()}</td>
                        <td>${product.getCategory()}</td>
                        <td><a href="/products?action=edit&id=${product.getId()}" data-toggle="tooltip"><i class="material-icons">&#xE254;</i>
                        </a></td>
                        <td><a href="/products?action=delete&id=${product.getId()}" data-toggle="tooltip"><i
                                class="material-icons">&#xE872;</i></a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
