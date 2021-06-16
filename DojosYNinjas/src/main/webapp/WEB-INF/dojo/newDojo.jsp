<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 16/06/2021
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>New Dojo</title>
</head>
<body>
    <div class="container text-center">
        <h1>New Dojo</h1>
        <form:form action="" method="POST" >
            <div class="mb-3">
                <form:label cssClass="form-label" path="person">Person</form:label>
                <form:select cssClass="form-select" path="person">
                    <option selected>Select person</option>
                    <c:forEach items="${persons}" var="person">
                        <form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="mb-3">
                <form:label cssClass="form-label" path="state">State</form:label>
                <form:input type="text" class="form-control" path="state"/>
            </div>
            <div class="mb-3">
                <form:label cssClass="form-label" path="expirationDate">Expiration Date</form:label>
                <form:input type="date" cssClass="form-control" path="expirationDate"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</body>
</html>
