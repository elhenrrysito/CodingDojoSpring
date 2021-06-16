<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 16/06/2021
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Dojos</title>
</head>
<body>
<div class="container mt-3">
    <h1 class="text-center"><c:out value="${dojo.name} Location Ninjas"/></h1>
    <table class="table">
        <thead class="table-dark">
        <tr>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Age</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dojo.ninjas}" var="ninja">
            <tr>
                <td><c:out value="${ninja.firstName}"/></td>
                <td><c:out value="${ninja.lastName}"/></td>
                <td><c:out value="${ninja.age}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
