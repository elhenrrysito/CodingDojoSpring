<%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 06/07/2021
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Edit Pool</title>
</head>
<body>
    <div class="container">

        <div class="row">
            <form:form action="" modelAttribute="pool" method="post">
                <input type="hidden" name="_method" value="put"/>
                <div class="col">
                    <p><c:out value="${poolEdit.address}"/></p>
                    <form:textarea path="description" value="${poolEdit.description}"/> <!-- Modificar -->

                </div>
                <div class="col">
                    <p><c:out value="${user.email}"/></p>
                    <p><c:out value="${user.firstName} ${user.lastName}"/></p>
                    <form:label path="size">Size</form:label>

                    <form:select path="size">
                        <form:option value="small">Small</form:option>
                        <form:option value="medium">Medium</form:option>
                        <form:option value="large">Large</form:option>
                    </form:select>
                    <form:label path="cost">Cost</form:label>
                    <form:input path="cost" value="${poolEdit.cost}"/>
                </div>
                <input type="submit" value="Save Changes">
            </form:form>
        </div>

    </div>
</body>
</html>
