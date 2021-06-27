<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 22/06/2021
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <title>New Question</title>
</head>
<body>
  <div class="container">
    <h1>What is your Question?</h1>
    <form:form action="/questions/new" method="post" modelAttribute="newQuestion">
      <form:label path="question">Question:</form:label>
      <form:textarea path="question"/>
      <form:errors path="question"/>

      <label>Tags</label>
      <input type="text" name="tags"/>
      <input type="submit" value="submit" class="btn btn-primary"/>
    </form:form>

  </div>
</body>
</html>
