<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form modelAttribute="employee" method="post" action="addEmployee">
    <table>
        <tr>
            <td><form:label path="id">Employee Id:</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Employee Name:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Employee Contact number:</form:label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>