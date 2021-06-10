<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 06/06/2021
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bievenido</title>
</head>
<body>
    <h1>Por favor llena este formulario</h1>
    <form method="POST" action="/result">
        <table>
            <tr>
                <td><label>Tu nombre:</label</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td><label>Ubicación Dojo:</label></td>
                <td>
                    <select name="dojo_location">
                        <option value="San Jose">San Jose</option>
                        <option value="Burbank">Burbank</option>
                        <option value="New York">New York</option>
                        <option value="Los Angeles">Los Angeles</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Lenguaje favorito:</label></td>
                <td>
                    <select name="favorite_language">
                        <option value="Python">Python</option>
                        <option value="Java">Java</option>
                        <option value="Javascript">Javascript</option>
                        <option value="C++">C++</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Comentario (optional)</td>
                <td><textarea name="comment" rows="4" cols="50"></textarea></td>
            </tr>
            <tr>
                <td><input type="submit" value="Enviar"></td>
            </tr>
        </table>
    </form>
</body>
</html>
