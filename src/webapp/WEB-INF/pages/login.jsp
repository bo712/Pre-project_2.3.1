<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>

<form method="post" action="<c:url value="/login"/>">
    <input name="j_username"/>
    <input name="j_password"/>
    <input type="submit"/>
</form>

</body>
</html>
