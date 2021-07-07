<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 06/07/2021
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Welcome!</title>
</head>
<body>
    <div class="container">
        <h1>Welcome!</h1>
        <div class="row">
            <div class="col-5 mr-4 border border-1 rounded d-flex justify-content-center">
                <p><form:errors path="user.*"/></p>
                <form:form action="/register" method="POST"  modelAttribute="user">
                    <h1 class="mt-3">Registration</h1>
                    <div class="col mt-2">
                        <form:label path="firstName" cssClass="form-label">First Name</form:label>
                        <form:input path="firstName" cssClass="form-control"/>
                    </div>
                    <div class="col mt-2">
                        <form:label path="lastName" cssClass="form-label">Last Name</form:label>
                        <form:input path="lastName" cssClass="form-control"/>
                    </div>


                    <div class="col mt-2">
                        <form:label path="email" cssClass="form-label">Email</form:label>
                        <form:input path="email" cssClass="form-control"/>
                    </div>

                    <div class="col mt-2">
                        <form:label path="password" cssClass="form-label">Password</form:label>
                        <form:input path="password" type="password" cssClass="form-control"/>
                    </div>


                    <div class="col mt-2">
                        <form:label path="passwordConfirmation">PW Confirmation</form:label>
                        <form:input path="passwordConfirmation" type="password" cssClass="form-control"/>
                    </div>
                    <div class="col mt-2">
                        <form:select path="rol">
                            <form:option value="1">Host</form:option>
                            <form:option value="2">Guest</form:option>
                        </form:select>
                    </div>
                    <input class="btn btn-primary mt-4" type="submit" value="Register"/>
                </form:form>

            </div>
            <div class="col d-flex justify-content-center">
                <form action="/login" method="POST">
                    <h1>Login</h1>
                    <p><c:out value="${error}" /></p>
                    <div class="mb-3 row">
                        <label class="form-label">Email</label>
                        <div class="col">
                            <input type="email" class="form-control" name="email">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputPassword" class="form-label">Password</label>
                        <div class="col">
                            <input type="password" name="password" class="form-control" id="inputPassword">
                        </div>
                    </div>
                    <div class="col">
                        <input type="submit" class="btn btn-primary" value="Login">
                    </div>

                </form>
            </div>

        </div>

    </div>
</body>
</html>
