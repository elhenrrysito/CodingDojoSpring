<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 16/06/2021
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>New Ninja</title>
</head>
<body>
    <div class="container d-flex justify-content-center">

        <form:form action="" method="POST" modelAttribute="ninja">
            <h1>New Ninja</h1>
            <div class="mb-3 ">
                <form:label cssClass="form-label" path="dojo">Dojo</form:label>
                <form:select cssClass="form-select" path="dojo">
                    <option selected>Select person</option>
                    <c:forEach var="dojo" items="${dojos}">
                        <form:option value="${dojo.id}">${dojo.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="mb-3">
                <form:label cssClass="form-label" path="firstName">First Name</form:label>
                <form:input type="text" class="form-control" path="firstName"/>
                <form:errors path="firstName"/>
            </div>
            <div class="mb-3">
                <form:label cssClass="form-label" path="lastName">Last Name</form:label>
                <form:input type="text" class="form-control" path="lastName"/>
                <form:errors path="lastName"/>
            </div>
            <div class="mb-3">
                <form:label cssClass="form-label" path="age">age</form:label>
                <form:input type="number" class="form-control" path="age"/>
                <form:errors path="age"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</body>
</html>
