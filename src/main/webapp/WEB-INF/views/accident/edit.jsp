<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование названия</title>
</head>
<body>
<div style="margin: auto">
    старое название : <c:out value="${updateAccident.name}"/>
    <form action="<c:url value='/update?id=${updateAccident.id}'/>"
          method="post">
       новое название : <input type="text" name="name" title="name">
        <button type="submit" class="btn btn-success">изменить</button>
    </form>
</div>
</body>
</html>
