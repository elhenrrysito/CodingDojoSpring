<%-- Created by IntelliJ IDEA. User: henrr Date: 10/06/2021 Time: 17:03 To change this template use File | Settings |
  File Templates. --%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
   <title>Dashboard</title>
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
              <a class="nav-link active" aria-current="page" href="/dashboard">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/song/new">Add new</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/song/search/topten">Top Ten</a>
            </li>
          </ul>
          <form class="d-flex" method="POST" action="/search/">
            <input class="form-control me-2" type="search" name="artist" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>
    <div class="container mt-3">
      <table class="table">
        <thead class="table-dark">
        <tr>
          <th scope="col">Title</th>
          <th scope="col">Rating</th>
          <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${songs}" var="song">
          <tr>
            <td><a href="song/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/song/delete/<c:out value="${song.id}"/>">Delete</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>

</body>

</html>