<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<jsp:include page="logout.jsp"/>

<c:forEach var="msq" items="${messages}">
    <h1>${msq}</h1>
</c:forEach>
<a href="<c:url value="/admin/users"/>">USERS</a>
</body>
</html>