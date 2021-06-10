<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 08/06/2021
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/books" method="post" modelAttribute="book">
         <p>
             <form:label path="title">Title</form:label>
             <form:errors path="title"/>
             <form:input path="title"/>
         </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:errors path="description"/>
            <form:textarea path="description"/>
        </p>
        <p>
            <form:label path="language">Language</form:label>
            <form:errors path="language"/>
            <form:input path="language"/>
        </p>
        <p>
            <form:label path="numberOfPages">Pages</form:label>
            <form:errors path="numberOfPages"/>
            <form:input type="number" path="numberOfPages"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
