<%--
  Created by IntelliJ IDEA.
  User: longnguyen
  Date: 6/18/20
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Converter</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
  </head>
  <body>
  <h2>Currency Converter</h2>
  <form action="/convert" method="post">
    <label for="rate">Rate: </label><br/>
    <input type="text" name="rate" id="rate" placeholder="RATE" value="22000"/><br/>
    <label for="usd">USD: </label><br/>
    <input type="text" name="usd" id="usd" placeholder="USD" value="0"/><br/>
    <input type="submit" id="submit" value="Converter"/>
  </form>
  </body>
</html>
