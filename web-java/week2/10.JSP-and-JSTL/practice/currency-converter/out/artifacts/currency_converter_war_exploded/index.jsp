<%--
  Created by IntelliJ IDEA.
  User: longnguyen
  Date: 6/18/20
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Converter</title>
  </head>
  <body>
    <h2>Currency Converter</h2>
    <form action="converter.jsp" method="post">
      <label>
        Rate: <input type="text" name="rate" placeholder="RATE" value="22000"/>
      </label><br/>
      <label>
        USD: <input type="text" name="usd" placeholder="USD" value="0">
      </label><br/>
      <input type="submit" id="submit" value="Convert">
    </form>
  </body>
</html>
