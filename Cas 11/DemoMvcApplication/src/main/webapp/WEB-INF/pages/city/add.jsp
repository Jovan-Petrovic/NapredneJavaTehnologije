<%-- 
    Document   : home
    Created on : May 19, 2020, 12:53:27 AM
    Author     : KORISNIK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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

        <form:form action="${pageContext.request.contextPath}/city/save" method="post" modelAttribute="cityDto">
            <c:if test="${not empty invalid}">
                <div>
                    Invalid message: ${invalid}
                </div>
            </c:if>           
            <div>
                ${message}
            </div>

            <div>City number: </div>
            <div>
                <form:input type="text" path="number" id="number"/>
            </div>
            <div>
                <form:errors path="number"></form:errors>
                </div>

                <div>City name </div>
                <div>
                <form:input type="text" path="name" id="name"/>
            </div>
            <div>
                <form:errors path="name"></form:errors>
                </div>

                <p/>
                <button id="save">Save</button>
        </form:form>
    </body>
</html>
