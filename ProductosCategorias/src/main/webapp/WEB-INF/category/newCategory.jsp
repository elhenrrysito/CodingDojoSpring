<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 20/06/2021
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>New Category</title>
</head>
<body>
    <div class="container d-flex justify-content-center">
        <div class="row">
            <h1 class="text-center">New Category</h1>
            <form:form cssClass="row g-3" action="/categories/new" method="post" modelAttribute="category">
                <div class="col-mb-3">
                    <form:label cssClass="form-label" path="name">Name</form:label>
                    <form:input cssClass="form-control" path="name"/>
                    <form:errors path="name"/>
                    <input type="submit" class="btn btn-primary mt-3" value="Submit"/>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>
