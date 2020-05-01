<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<table>
    <tr>
        <td>
            <a href="/cars?locale=ru">Машины</a>
        </td>
        <td>
            <a href="/cars?locale=en">Cars</a>
        </td>
    </tr>
</table>

<c:forEach var="msq" items="${messages}">
    <h1>${msq}</h1>
</c:forEach>

</body>
</html>