<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 08/06/2021
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Editar Lenguaje</title>
</head>
<body>
    <form:form action="/lenguajes/${lenguaje.id}" method="PUT" modelAttribute="lenguaje">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:input path="creator"/>
        </p>
        <p>
            <form:label path="currentVersion">CurrentVersion</form:label>
            <form:errors path="currentVersion"/>
            <form:input path="currentVersion"/>
        </p>
        <input class="btn btn-primary" type="submit" value="Submit"/>
        <a class="btn btn-primary" href="/lenguajes/delete/${lenguaje.id}">Delete</a>
        <a class="btn btn-primary" href="/lenguajes">Dashboard</a>
    </form:form>

</body>
</html>
