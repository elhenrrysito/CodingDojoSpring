<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 06/07/2021
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Dashboard</title>
</head>
<body>
    <div class="container">
        <div class="d-flex justify-content-end">
            <a href="/logout" class="btn btn-primary mt-3">Logout</a>
        </div>
        <div class="row">
            <h1>Current Listings</h1>
            <table class="table mt-3">
                <thead class="table-dark">
                    <th>Address</th>
                    <th>Pool Size</th>
                    <th>Cost per Night</th>
                    <th>Details</th>
                </thead>
                <tbody>
                    <c:forEach var="poolbnb" items="${user.pools}">
                        <tr>
                            <td><c:out value="${poolbnb.address}"/></td>
                            <td><c:out value="${poolbnb.size}"/></td>
                            <td><c:out value="${poolbnb.cost}"/></td>
                            <td><a href="/host/pools/${poolbnb.id}"><c:out value="${poolbnb.averageRating()}"/>/5 - Edit</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row mt-3">
            <h1>New Listing</h1>
            <form:form action="" method="post" modelAttribute="pool">
                <div class="col-3">
                    <form:label cssClass="form-label" path="address">Address:</form:label>
                    <form:input cssClass="form-control" path="address"/>
                    <form:errors path="address"/>
                </div>
                <div class="col-3">
                    <form:label cssClass="form-label" path="description">Description:</form:label>
                    <form:input cssClass="form-control" path="description"/>
                    <form:errors path="description"/>
                </div>
                <div class="col-3">
                    <form:label cssClass="form-label" path="cost">Cost:</form:label>
                    <form:input cssClass="form-control" type="number" path="cost"/>
                    <form:errors path="cost"/>
                </div>
                <div class="col-3">
                    <form:select path="size" cssClass="form-select mt-3">
                        <form:option value="small">Small</form:option>
                        <form:option value="medium">Medium</form:option>
                        <form:option value="large">Large</form:option>
                    </form:select>
                </div>
                <div class="col-3 mt-4">
                    <input class="btn btn-primary" type="submit" value="Add Listing"/>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>
