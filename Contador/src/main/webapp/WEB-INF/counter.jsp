<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 05/06/2021
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <h1>Has visitado http://localhost:8080/ <c:out value="${counter}"/> times</h1>
    <a href="/">Otra visita?</a>
    <a href="/reset">Resetear contador</a>
</head>
<body>

</body>
</html>
