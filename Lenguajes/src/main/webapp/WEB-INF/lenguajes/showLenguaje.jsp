<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 09/06/2021
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lenguaje</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
    <h1>Información del Lenguaje</h1>
    <table>
        <tr>
            <td>Nombre:</td>
            <td><c:out value="${lenguaje.name}"/></td>
        </tr>
        <tr>
            <td>Creador:</td>
            <td><c:out value="${lenguaje.creator}"/></td>
        </tr>
        <tr>
            <td>Current Version:</td>
            <td><c:out value="${lenguaje.currentVersion}"/></td>
        </tr>
    </table>
    <a class="btn btn-primary" href="edit/<c:out value="${lenguaje.id}"/>">Edit</a>
    <a class="btn btn-primary" href="delete/<c:out value="${lenguaje.id}"/>">Delete</a>
    <a class="btn btn-primary" href="/lenguajes/">Dashboard</a>
</body>
</html>
