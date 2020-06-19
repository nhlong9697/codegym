<%--
  Created by IntelliJ IDEA.
  User: longnguyen
  Date: 6/18/20
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
    <h1>Calculator</h1>
    <form action="/calculate" method="post">
      <fieldset>
        <legend>Calculator</legend>
        <table>
          <tr>
            <td>First operand</td>
            <td><input type="text" name="firstOperand" placeholder="Enter first operand"></td>
          </tr>
          <tr>
            <td>Operator</td>
            <td>
              <select name="operator" id="operator">
                <option value="+">Addition</option>
                <option value="-">Subtraction</option>
                <option value="*">Multiply</option>
                <option value="/">Division</option>
              </select>
            </td>
          </tr>
          <tr>
            <td>Second operand</td>
            <td><input type="text" name="secondOperand" placeholder="Enter second operand"></td>
          </tr>
          <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
          </tr>
        </table>
      </fieldset>
    </form>
  </body>
</html>
