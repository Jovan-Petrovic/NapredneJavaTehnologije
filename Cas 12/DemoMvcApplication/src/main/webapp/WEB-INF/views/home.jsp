<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Home</title>
    </head>
    <body>
        <form>
            <div>This is home page: home.jsp!</div>
            <div>
                <a href="<c:url value = "/city"/>"> Home city </a>
            </div>


        </form>

    </body>
</html>