<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>

<jsp:include page="logout.jsp"/>

<form method="post" action="<c:url value="/admin/edit"/>">
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
            <td>
                <c:forEach var="role" items="${roles}">
                    <input type="checkbox" name="role"
                           value="${role.role}" ${user.userRoles.contains(role.role) ? "checked" : ""}>${role.role}<br>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Save changes"></td>
        </tr>
    </table>
</form>
</body>
</html>
