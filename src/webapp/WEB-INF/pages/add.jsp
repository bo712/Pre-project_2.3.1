<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Edit user</title>
</head>

<jsp:include page="logout.jsp"/>

<body>
<form method="post" action="<c:url value="/admin/add"/>">
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
            <td>Salary</td>
            <td><input type="text" name="salary" required></td>
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
            <td valign="top">Role(s)</td>
            <td>
                <c:forEach var="role" items="${roles}">
                    <input type="checkbox" name="role" value="${role.role}">${role.role}<br>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Save user"></td>
        </tr>
    </table>
</form>
</body>
</html>
