<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>User's page</title>
</head>
<body>

<jsp:include page="logout.jsp"/>

<table border="1" width="40%" cellpadding="1">
    <colgroup>
        <col span="6" style="background:burlywood"><!-- Set color for table cells-->
    </colgroup>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Salary</th>
        <th>Username</th>
        <th>Password</th>
        <th>Role(s)</th>
    </tr>
    <tr>
        <td>${user.name}</td>
        <td>${user.lastName}</td>
        <td>${user.salary}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.userRoles}</td>
    </tr>
</table>
</body>
</html>
