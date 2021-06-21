<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 20/06/2021
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Category Page</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-3"><c:out value="${category.name}"/></h1>
        <div class="row mt-3">
            <div class="col">
                <h2>Products:</h2>
                <ul>
                    <c:forEach var="product" items="${category.products}">
                        <li>${product.name}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col">
                <form:form action="/categories/${category.id}" method="post" modelAttribute="categoryProduct">
                    <form:label path="product">Add Product:</form:label>
                    <form:select path="product">
                        <c:forEach var="products" items="${products}">
                            <form:option value="${products.id}">${products.name}</form:option>
                        </c:forEach>
                    </form:select>
                    <input type="submit" class="btn btn-primary" value="Add">
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
