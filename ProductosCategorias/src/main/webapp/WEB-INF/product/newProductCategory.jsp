<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 20/06/2021
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Product Page</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-3"><c:out value="${product.name}"/></h1>
        <div class="row mt-3">
            <div class="col">
                <h2>Categories:</h2>
                <ul>
                    <c:forEach var="category" items="${product.categories}">
                        <li>${category.name}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col">
                <form:form action="/products/${product.id}" method="post" modelAttribute="categoryProduct">
                    <form:label path="category">Add Category:</form:label>
                    <form:select path="category">
                        <c:forEach var="categoria" items="${categories}">
                            <form:option value="${categoria.id}">${categoria.name}</form:option>
                        </c:forEach>
                    </form:select>
                    <input type="submit" class="btn btn-primary" value="Add">
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
