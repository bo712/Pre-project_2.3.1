<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<table border="1" width="30%" cellpadding="1">
    <colgroup>
        <col span="5" style="background:aquamarine"><!-- Set color for table cells-->
    </colgroup>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Salary</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.salary}</td>
            <td><a href="<c:url value="/edit?id=${user.id}"/>">Edit user</a></td>
            <td><a href="<c:url value="/delete?id=${user.id}"/>">Delete user</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
