<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 27/06/2021
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome</title>
</head>
<body>
    <h1>Welcome, <c:out value="${user.email}" /></h1>
    <a href="/logout">Logout</a>
</body>
</html>