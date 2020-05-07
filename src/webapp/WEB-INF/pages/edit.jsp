<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<form method="post" action="<c:url value="/save"/>">
    <table width="30%">
        <tr>
            <td>Id</td>
            <td><input type="text" name="id" readonly value="${user.id}"></td>
        </tr>
        <tr>
            <td>First name</td>
            <td><input type="text" name="name" required value="${user.name}"></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input type="text" name="lastName" required value="${user.lastName}"></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input type="text" name="salary" required value="${user.salary}"></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username" required value="${user.username}"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" required value="${user.password}"></td>
        </tr>
        <tr>
            <td>Role(s)</td>
            <td><input type="checkbox" name="roleAdmin" ${user.userRoles.contains("admin") ? "checked" : ""}>Administrator<br>
                <input type="checkbox" name="roleUser" ${user.userRoles.contains("user") ? "checked" : ""}>User<br>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Save changes"></td>
        </tr>
    </table>
</form>
</body>
</html>
