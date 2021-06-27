<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 22/06/2021
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Add Answer</title>
</head>
<body>
    <div class="container">
        <h1>What is the best programming language?</h1>
        <p>Tags:
            <c:forEach var="tag" items="${tags}">
                <c:out value="${tag}"/>
            </c:forEach>
        </p>
        <div class="row">
            <div class="col">
                <table class="table">
                    <thead>
                        <th>Answer</th>
                    </thead>
                    <tbody>
                        <c:forEach var="ans" items="${answers}">
                            <td><c:out value="${ans}"/></td>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col">
                <h1>Add your answer</h1>
                <form:form method="post" action="" modelAttribute="answer">
                    <form:label path="answer">Answer:</form:label>
                    <form:textarea path="answer"/>
                    <form:errors path="answer"/>
                    <input type="submit" value="Send"/>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
