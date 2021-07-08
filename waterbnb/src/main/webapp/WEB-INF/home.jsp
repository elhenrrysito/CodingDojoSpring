<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Home</title>
</head>
<body>
    <div class="container">
        <div class="d-flex justify-content-end">
            <a href="/guest/sigin">Siging/Singup</a>
        </div>
        <h1 class="title">Find places to swim and sleep on waterbnb</h1>
        <form action="/search" method="GET">
            <input class="form-control" type="text" name="location"/>
            <input type="submit" value="Search"/>
        </form>

    </div>
</body>
</html>