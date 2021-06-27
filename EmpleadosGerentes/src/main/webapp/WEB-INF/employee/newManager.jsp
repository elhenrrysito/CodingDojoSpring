<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 25/06/2021
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>New Manager</title>
</head>
<body>
    <div class="container">
        <form:form action="" method="post" modelAttribute="manager">
            <div class="row">
                <h1>New Manager</h1>
                <div class="col">
                    <form:input cssClass="form-control" path="firstName" placeholder="First name" aria-label="First name"/>
                </div>
                <div class="col">
                    <form:input cssClass="form-control" path="lastName" placeholder="Last name" aria-label="Last name"/>
                </div>
            </div>
            <input type="submit" value="Add" class="btn btn-primary"/>
        </form:form>
    </div>
</body>
</html>
