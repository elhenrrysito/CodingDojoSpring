<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 20/06/2021
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Welcome!</title>
</head>
<body>
    <div class="container text-center d-flex justify-content-center">
        <div class="row">
            <h1 class="mt-4 mb-5">Welcome! You can:</h1>
            <div class="col">
                <a href="/products/new" class="btn btn-primary">Add a new Product</a>
            </div>
            <div class="col">
                <a href="/categories/new" class="btn btn-primary">Add a new Category</a>
            </div>
        </div>
    </div>
</body>
</html>
