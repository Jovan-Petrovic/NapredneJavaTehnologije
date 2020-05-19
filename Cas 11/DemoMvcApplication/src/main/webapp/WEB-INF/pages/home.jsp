<%-- 
    Document   : home
    Created on : May 15, 2020, 3:54:51 PM
    Author     : user
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
       This is home page...
       <div>
           <a href="<c:url value="/city"/>">Home city</a>
       </div>
    </body>
</html>
