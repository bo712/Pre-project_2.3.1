<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<table border="1" width="40%" cellpadding="1">
    <colgroup>
        <col span="9" style="background:aquamarine"><!-- Set color for table cells-->
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
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.salary}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.userRoles}</td>
            <td><a href="<c:url value="/admin/edit?id=${user.id}"/>">Edit user</a></td>
            <td><a href="<c:url value="/admin/delete?id=${user.id}"/>">Delete user</a></td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/admin/add"/>">Add new user</a>
</body>
</html>
