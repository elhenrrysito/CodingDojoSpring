<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 06/06/2021
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Resultado Encuesta</title>
</head>
<body>
    <h1>Información enviada</h1>
    <p>Nombre: </p> <c:out value="${name}"/>
    <p>Ubicación Dojo: </p> <c:out value="${dojo_location}"/>
    <p>Lenguaje Favorito: </p> <c:out value="${favorite_language}"/>
    <p>Comentario: </p> <c:out value="${comment}"/>
</body>
</html>
