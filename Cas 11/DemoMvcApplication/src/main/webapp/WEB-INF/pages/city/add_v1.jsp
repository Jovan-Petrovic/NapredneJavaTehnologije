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
            <a href="<c:url value="/city"/>">Back to city home</a>
        </div>
        This is city page for adding new object...
        
        <form action="${pageContext.request.contextPath}/city/save" method="post">
            <div>
                ${message}
            </div>
            
            <div>City number: </div>
            <div>
                <input type="text" name="number" id="number"/>
            </div>
            
            <div>City name </div>
            <div>
                <input type="text" name="name" id="name"/>
            </div>
            
            <p/>
            <button id="save">Save</button>
        </form>
    </body>
</html>
