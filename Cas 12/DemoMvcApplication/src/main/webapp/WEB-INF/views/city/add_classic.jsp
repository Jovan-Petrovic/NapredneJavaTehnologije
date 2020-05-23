<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Add:city</title>
    </head>
    <body>
        This is add page for city!
        <div>
            <a href="<c:url value="/city"/>"> Back to city home </a>
        </div>

        <div>
            Message: ${message}
        </div>

        <form action="${pageContext.request.contextPath}/city/save" method="post">
            <div>City number:</div>
            <div><input type="text" id="number" name="number" value="${cityDto.number}"/></div>

            <div> City name:</div>
            <div><input type="text" id="name" name="name" value="${requestScope.cityDto.name}"/></div>

            <p/>
            <div><button id="save">Save</button> </div>
        </form>


    </body>
</html>