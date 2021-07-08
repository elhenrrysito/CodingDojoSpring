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
    <link rel="stylesheet" href="/css/style.css">
    <title>Show Pool</title>
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
        <div class="row mt-3">
            <div class="col">
                <p><c:out value="${pool.address}"/></p>
                <textarea name="description" id="" cols="65" rows="10">${pool.description}</textarea>
            </div>
            <div class="col border">
                <p>Email: <c:out value="${pool.host.email}"/></p>
                <p>Name: <c:out value="${pool.host.firstName} ${pool.host.lastName}"/></p>
                <p>Pool Size: <c:out value="${pool.size}"/></p>
                <p>Cost: <c:out value="${pool.cost}"/></p>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col">
                <div class="d-flex justify-content-between">
                    <p>Reviews (<c:out value="${pool.averageRating()}"/>):</p>
                    <p><a href="/pools/${pool.id}/review">Leave a review</a></p>
                </div>
                <div id="overflow" class="border">
                    <c:forEach var="review" items="${pool.reviews}">
                        <div class="border-bottom">
                            <p><strong>Nombre: </strong><c:out value="${review.user.firstName}"/></p>
                            <p><strong>Rating: </strong><c:out value="${review.rating}/5"/></p> 
                            <p><c:out value="${review.description}"/></p>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <script src="/js/script.js"></script>
</body>
</html>