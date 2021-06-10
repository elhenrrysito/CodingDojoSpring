<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: henrr
  Date: 06/06/2021
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Bienvenido</title>
</head>
<body>
    <div class="container">
        <form action="/reset" method="POST">
            <h2 class="mt-3">Your Gold: <input class="col-1"type="number" name="gold" value="<c:out value="${gold}"/>" disabled> </h2>
            <input class="btn btn-primary" type="submit" value="Reset">
        </form>
            <div class="row text-center mb-5 mt-5">.

                <div class="col border p-3">
                    <form action="/gold" method="POST">
                        <h3>Farm</h3>
                        <p>Gana 10-20 de oro</p>
                        <input type="hidden" name="option" value="farm">
                        <button class="btn btn-primary">Find Gold!</button>
                    </form>
                </div>

                <div class="col border p-3">
                     <form action="/gold" method="POST">
                         <h3>Cave</h3>
                         <p>Gana 5-10 de oro</p>

                          <input type="hidden" name="option" value="cave">
                         <button class="btn btn-primary">Find Gold!</button>
                     </form>
                </div>


                <div class="col border p-3">
                      <form action="/gold" method="POST">
                            <h3>House</h3>
                            <p>Gana 2-5 de oro</p>
                          <input type="hidden" name="option" value="house">
                            <button class="btn btn-primary">Find Gold!</button>
                      </form>
               </div>

               <div class="col border p-3">
                     <form action="/gold" method="POST">
                         <h3>Casino</h3>
                          <p>Gana o pierde 0-50 de oro</p>
                         <input type="hidden" name="option" value="casino">
                         <button class="btn btn-primary">Find Gold!</button>
                     </form>
               </div>

                <div class="col border p-3">
                    <form action="/gold" method="POST">
                        <h3>Spa</h3>
                        <p>Gaste 5-20 de oro</p>
                        <input type="hidden" name="option" value="spa">
                        <button class="btn btn-primary">Go Spa!</button>
                    </form>
                </div>

              <h3 class="mt-3">Activities</h3>
                <div>
                    <textarea class="col-12 mt-2" name="money_control" id="" cols="30" rows="10" disabled>
                        <%
                            if(session.getAttribute("activities") != null) {
                                ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
                                out.println("");
                                for(String actividad : activities) {
                                    out.println(actividad);
                                }
                            }
                        %>
                    </textarea>
                </div>

             </div>
    </div>
</body>

</html>
