<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 23/06/2021
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Question Dashboard</title>
</head>
<body>
<div class="container">
    <h1>Questions Dashboard</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Question</th>
            <th>Tags</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="question" items="${questions}">
            <tr>
                <th><a href="questions/${question.id}"><c:out value="${question.question}"/></a></th>
                <th>
                    <c:forEach var="tag" items="${question.tags}">
                        <c:out value="${tag.subject}, "/>
                    </c:forEach>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="questions/new" class="btn btn-primary">New Question</a>
</div>
</body>
</html>
