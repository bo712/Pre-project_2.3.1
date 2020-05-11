<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Register new user</title>
</head>
<body>
<form method="post" action="<c:url value="/register"/>">
    <table width="30%">
        <tr>
            <td>First name</td>
            <td><input type="text" name="name" required></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input type="text" name="lastName" required></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username" required></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" required></td>
        </tr>
        <tr>
            <td><input type="submit" value="Register user"></td>
        </tr>
    </table>
</form>
</body>
</html>
