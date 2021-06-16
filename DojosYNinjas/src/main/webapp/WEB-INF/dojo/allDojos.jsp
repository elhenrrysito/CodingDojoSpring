<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 16/06/2021
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Dojos</title>
</head>
<body>
    <div class="container text-center">
        <h1>Person Information</h1>
        <h2><c:out value="${dojo.}"/> <c:out value="${person.lastName}"/></h2>
        <table class="table">
            <tr>
                <td>License Number:</td>
                <td><c:out value="${person.license.number}"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><c:out value="${person.license.state}"/></td>
            </tr>
            <tr>
                <td>Expiration Date:</td>
                <td><c:out value="${person.license.expirationDate}"/></td>
            </tr>
        </table>
    </div>
</body>
</html>
