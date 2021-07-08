<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 06/07/2021
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Edit Pool</title>
</head>
<body>
    <div class="container">
        <div class="d-flex justify-content-end mt-3">
            <a href="/" class="btn btn-primary mr-3">Home</a>
            <a href="/host/dashboard" class="btn btn-primary mr-3">Dashboard</a>
            <a href="/logout" class="btn btn-primary">Logout</a>
        </div>
            <form:form action="" modelAttribute="pool" method="post" cssClass="row mt-3">
                <input type="hidden" name="_method" value="put"/>
                <div class="col-6">
                    <p><c:out value="${poolEdit.address}"/></p>
                    <textarea name="description" css="form-control" cols="65" rows="10"><c:out value="${poolEdit.description}"/></textarea>
                </div>
                <div class="col-6">
                    <p>Email: <c:out value="${user.email}"/></p>
                    <p>Name: <c:out value="${user.firstName} ${user.lastName}"/></p>
                    <form:label cssClass="form-label" path="size">Size</form:label>

                    <form:select path="size" cssClass="form-control">
                        <form:option value="small">Small</form:option>
                        <form:option value="medium">Medium</form:option>
                        <form:option value="large">Large</form:option>
                    </form:select>
                    <form:label path="cost" cssClass="form-label">Cost</form:label>
                    <form:input path="cost" cssClass="form-control" value="${poolEdit.cost}"/>
                </div>
                <input type="submit" value="Save Changes" class="btn btn-primary mt-3 col-3">
            </form:form>
            <div class="row">
                <div class="col">
                <p>Reviews(<c:out value="${poolEdit.averageRating()}"/>): </p>
                    <div id="overflow" class="border">
                        <c:forEach var="review" items="${poolEdit.reviews}">
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
