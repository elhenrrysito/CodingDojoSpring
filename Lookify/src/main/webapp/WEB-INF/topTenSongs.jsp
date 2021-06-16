<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 12/06/2021
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Top Ten Songs</title>
</head>
<body>
    <div class="container mt-3">
        <table class="table">
            <thead class="table-dark">
            <tr>
                <th scope="col">Title</th>
                <th scope="col">Rating</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${topTenSongs}" var="song">
                <tr>
                    <td><a href="/song/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a></td>
                    <td><c:out value="${song.rating}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary mt-3" href="/dashboard">Dashboard</a>
    </div>
</body>
</html>
