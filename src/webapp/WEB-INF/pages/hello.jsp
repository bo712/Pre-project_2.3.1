<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<jsp:include page="logout.jsp"/>

<h2>Hello, ${user.name}!<br>
    You have no role ADMIN or USER, so you are here. You can be only here, in this page</h2>
</body>
</html>