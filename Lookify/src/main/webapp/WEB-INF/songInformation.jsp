<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 11/06/2021
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Song</title>
</head>
<body>
    <div class="container text-center">
        <h1 class="mb-3">Información del Lenguaje</h1>
        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th>Name:</th>
                    <th>Artist:</th>
                    <th>Rating:</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><c:out value="${song.title}"/></td>
                    <td><c:out value="${song.artist}"/></td>
                    <td><c:out value="${song.rating}"/></td>
                </tr>
            </tbody>
        </table>
        <a class="btn btn-primary mt-3" href="delete/<c:out value="${song.id}"/>">Delete</a>
        <a class="btn btn-primary mt-3" href="/dashboard">Dashboard</a>
    </div>
</body>
</html>
