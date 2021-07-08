<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Search</title>
</head>
<body>
    <div class="container">
        <div class="d-flex justify-content-end mt-3">
            <a href="/" class="btn btn-primary mr-3">Home</a>
            <c:if test="${user == null}">
                <a href="/guest/sigin">Siging/Singup</a>
            </c:if>
            <c:if test="${user != null}">
                <a href="/logout" class="btn btn-primary">Logout</a>
            </c:if>
        </div>
        <table class="table mt-3">
            <thead class="table-dark">
                <th>Address</th>
                <th>Pool Size</th>
                <th>Cost per Night</th>
                <th>Details</th>
            </thead>
            <tbody>
                <c:forEach var="pool" items="${poolsLocation}">
                    <td><c:out value="${pool.address}"/></td>
                    <td><c:out value="${pool.size}"/></td>
                    <td>$<c:out value="${pool.cost}"/></td>
                    <td><a href="/pools/${pool.id}">(<c:out value="${pool.averageRating()}"/>/5) See More</a></td>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>