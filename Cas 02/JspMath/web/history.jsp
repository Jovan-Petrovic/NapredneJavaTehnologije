<%-- 
    Document   : history
    Created on : Feb 26, 2020, 11:24:15 AM
    Author     : student1
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Math History</title>
    </head>
    <body>
        <h1>Math History</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>A</th>
                    <th>B</th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${data}" var="model">
                    <tr>
                        <td>${model.a}</td>
                        <td>${model.b}</td>
                        <td>${model.c}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
