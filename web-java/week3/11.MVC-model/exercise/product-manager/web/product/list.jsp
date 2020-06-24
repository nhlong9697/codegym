<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
    <h1>Customers</h1>
    <p>
        <c:if test="${requestScope.message != null}">
            <span class="message">${requestScope.message}</span>
        </c:if>
    </p>
    <p>
        <a href="/products?action=add">Create new customer</a>
    </p>
    <form action="/products?action=search" method="get">
        <input type="text" name="nameToSearch" placeholder="Enter name to search">
        <input type="submit" id="submit" value="Submit">
    </form>
    <form action="/products?action=sort" method="get">
        <select name="category" onchange="this.form.submit()">
            <option value="id">Sort by ID</option>
            <option value="productName">Sort by product name</option>
            <option value="category">Sort by category</option>
            <option value="price">Sort by price</option>
        </select>
    </form>
    <table border="1">
       <tr>
           <td>Name</td>
           <td>Category</td>
           <td>Price</td>
           <td>Edit</td>
           <td>Delete</td>
       </tr>
        <c:forEach items='${requestScope.products}' var="product">
           <tr>
               <td><a href="/products?action=view&id=${product.getId()}">${product.getProductName()}</a></td>
               <td>${product.getCategory()}</td>
               <td>${product.getPrice()}</td>
               <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
               <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
           </tr>
        </c:forEach>
    </table>
</body>
</html>
