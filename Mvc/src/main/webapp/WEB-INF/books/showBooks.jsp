<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 08/06/2021
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><c:out value="${book.title}"/></h1>
    <p>Description: <c:out value="${book.description}"/></p>
    <p>Language: <c:out value="${book.language}"/></p>
    <p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
    <a href="/books/${book.id}/edit">Edit Book</a>
    <form action="/books/${book.id}" method="POST">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form>
</body>
</html>
