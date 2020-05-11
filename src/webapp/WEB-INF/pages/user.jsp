<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>User's page</title>
</head>
<body>

<table border="1" width="40%" cellpadding="1">
    <colgroup>
        <col span="7" style="background:burlywood"><!-- Set color for table cells-->
    </colgroup>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Salary</th>
        <th>Username</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.lastName}</td>
        <td>${user.salary}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.userRoles}</td>
    </tr>
</table>
<a href="<c:url value="/admin/add"/>">Add new user</a>
</body>
</html>
