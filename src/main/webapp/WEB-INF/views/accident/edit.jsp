<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование</title>
</head>
<body>
       <div style="margin: auto">
           старые данные : <c:out value="${updateAccident}"/>
           <form action="<c:url value='/update'/>" method="post">
               <input type="hidden" name="id" value="${updateAccident.id}">
               название : <input type="text" name="name" title="name">
               текст : <input type="text" name="text" title="text">
               адрес : <input type="text" name="address" title="address">
               <button type="submit" class="btn btn-success">изменить</button>
           </form>
       </div>
</body>
</html>
