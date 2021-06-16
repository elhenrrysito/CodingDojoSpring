<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 08/06/2021
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Lenguajes</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center mt-3">Todos los Lenguajes</h1>
        <div class="col mt-4">

    <table class="table table-sm ">
        <thead class="table-dark">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Creator</th>
                <th scope="col">Current Version</th>
                <th scope="col">Delete</th>
                <th scope="col">Edit</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lenguajes}" var="lenguaje">
                <tr>
                    <td><a href="/lenguajes/${lenguaje.id}"><c:out value="${lenguaje.name}"/></a></td>
                    <td><c:out value="${lenguaje.creator}"/></td>
                    <td><c:out value="${lenguaje.currentVersion}"/></td>
                    <td><a href="/lenguajes/delete/${lenguaje.id}">Delete</a></td>
                    <td><a href="/lenguajes/edit/${lenguaje.id}">Edit</a></td>
                </tr>
           </c:forEach>
        </tbody>
    </table>
        </div>
    <form:form cssClass="row g-3" action="/lenguajes" method="post" modelAttribute="lenguaje">
        <div class="col-md-6">
            <form:label cssClass="form-label" path="name">Name</form:label>
            <form:input cssClass="form-control" path="name"/>
            <form:errors path="name"/>
        </div>

        <div class="col-md-6">
            <form:label cssClass="form-label" path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:input cssClass="form-control" path="creator"/>
        </div>

        <div class="col-md-12">
            <form:label cssClass="form-label" path="currentVersion">Current Version</form:label>
            <form:errors path="currentVersion"/>
            <form:input cssClass="form-control" path="currentVersion"/>
        </div>
        <input type="submit" class="btn btn-primary mt-3" value="Submit"/>
    </form:form>
    </div>

</body>
</html>
