<%-- 
    Document   : home
    Created on : May 19, 2020, 12:53:27 AM
    Author     : KORISNIK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <a href="<c:url value="/home"/>">Back to home page</a>
        </div>
        This is home page for city...
        <div>
            <a href="<c:url value="/city/add"/>">Add city</a>
        </div>
    </body>
</html>
