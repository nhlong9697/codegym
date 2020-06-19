<%--
  Created by IntelliJ IDEA.
  User: longnguyen
  Date: 6/18/20
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
    <link rel="stylesheet" href="style/style.css">
  </head>
  <body>
  <h1>Vietnamese Dictionary</h1>
  <form action="dictionary.jsp" method="post">
    <label>
      <input type="text" name="word" placeholder="Enter your word: ">
    </label>
    <input type="submit" id="submit" value="Search">
  </form>

  </body>
</html>
