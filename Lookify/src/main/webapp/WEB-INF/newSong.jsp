<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 10/06/2021
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>New Song</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Lookify</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/dashboard">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/song/new">Add new</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/song/search/topten">Top Ten</a>
                    </li>
                </ul>
                <form class="d-flex" method="POST" action="/search">
                    <input class="form-control me-2" type="search" name="artist" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

    <div class="container">
        <form:form cssClass="row g-3" action="/song/new" method="post" modelAttribute="song">
            <div class="col-mb-3">
                <form:label cssClass="form-label" path="title">Title</form:label>
                <form:input cssClass="form-control" path="title"/>
                <form:errors path="title"/>
            </div>

            <div class="col-mb-3">
                <form:label cssClass="form-label" path="artist">Artist</form:label>
                <form:errors path="artist"/>
                <form:input cssClass="form-control" path="artist"/>
            </div>

            <div class="col-mb-3">
                <form:label cssClass="form-label" path="rating">Rating</form:label>
                <form:errors path="rating"/>
                <form:input cssClass="form-control" path="rating"/>
            </div>
            <input type="submit" class="btn btn-primary mt-3" value="Submit"/>
        </form:form>
    </div>
</body>
</html>
