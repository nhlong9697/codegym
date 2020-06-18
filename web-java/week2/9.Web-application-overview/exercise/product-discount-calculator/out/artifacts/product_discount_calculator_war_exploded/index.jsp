<%--
  Created by IntelliJ IDEA.
  User: longnguyen
  Date: 6/18/20
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <h1>Product Discount Calculator</h1>
  <form action="${pageContext.request.contextPath}/display-discount" method="post">
    <label>
      Product description: <input type="text" name="productDescription" placeholder="Enter product description">
    </label> <br>
    <label>
      List price: <input type="text" name="listPrice" placeholder="Enter list price">
    </label> <br>
    <label>
      Discount percent: <input type="text" name="discountPercent" placeholder="Enter discount percent">
    </label> <br>
    <input type="submit" id="submit" value="Calculate Discount">
  </form>
  </body>
</html>
