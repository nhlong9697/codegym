<%--
  Created by IntelliJ IDEA.
  User: longnguyen
  Date: 6/18/20
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Dictionary</title>
  </head>
  <body>
  <h2>Vietnamese dictionary</h2>
  <form action="/translate" method="post">
    <label>
      <input type="text" name="txtSearch" placeholder="Enter your word: ">
    </label>
    <input type="submit" id="submit" value="Search">
  </form>
  </body>
</html>
