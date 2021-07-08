<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Add Review</title>
</head>
<body>
    <div class="container">
        <div class="d-flex justify-content-end">
            <a href="/">Home</a>
            <span> | </span>
            <a href="/logout">Logout</a>
        </div>
        <form:form action="" method="post" modelAttribute="review" cssClass="row">
            <div class="col-2">
                <p>Review of <c:out value="${pool.reviews.size()} ${pool.address}"/></p>
                <form:textarea path="description" cols="60" rows="10"></form:textarea>
                <p class="form-label">Rating</p>
                <form:input path="rating" type="number" cssClass="form-control"/>
                <input type="submit" value="Submit Review" class="btn btn-primary mt-3"/>
            </div>
        </form:form>
    </div>
</body>
</html>