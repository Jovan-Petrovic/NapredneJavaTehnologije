<%-- 
    Document   : math_jstl
    Created on : Feb 26, 2020, 10:38:32 AM
    Author     : student1
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.MathModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Math</title>
    </head>
    <jsp:useBean id="model" scope="request" class="model.MathModel">
        <jsp:setProperty name="model" property="a" value="0" />
        <jsp:setProperty name="model" property="b" value="0" />
        <jsp:setProperty name="model" property="c" value="0" />
    </jsp:useBean>
    <body>
        <c:if test="${userOperation != null}">
            <h1>${userOperation}</h1>
        </c:if>
        
        <form action="/JspMath/math" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>A:</td>
                        <td><input type="text" name="a" value="<c:out value="${model.a}"/>" size="50" /></td>
                    </tr>
                    <tr>
                        <td>B:</td>
                        <td><input type="text" name="b" value="<%=model.getB()%>" size="50" /></td>
                    </tr>
                    <tr>
                       <td>C:</td>
                       <td><input type="text" name="c" value="${model.c}" readonly="true" size="50" /></td>
                     </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Addition" name="action" />
                            <input type="submit" value="Subtraction" name="action" />
                            <input type="submit" value="Multiplication" name="action" />
                            <input type="submit" value="Division" name="action" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
