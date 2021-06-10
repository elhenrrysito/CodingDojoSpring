<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 06/06/2021
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Bienvenido!</h1>
    <c:out value="${error}"/>
    <form method="POST" action="/code">
        <label>What is the code?</label>
        <input type="text" name="code">
        <input type="submit" value="GO!">
    </form>
</body>
</html>
