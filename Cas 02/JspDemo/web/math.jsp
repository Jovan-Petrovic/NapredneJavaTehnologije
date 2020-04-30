<%-- 
    Document   : math
    Created on : Feb 26, 2020, 9:06:49 AM
    Author     : student1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Math</title>
    </head>
    <body>
        <h1>Math</h1>
        <% 
            int a = 0, b = 0, c = 0;
            Object objA = request.getAttribute("a");
            Object objB = request.getAttribute("b");
            Object objC = request.getAttribute("c");
            if (objA != null && objB != null && objC != null) {
                a = Integer.parseInt(objA.toString());
                b = Integer.parseInt(objB.toString());
                c = Integer.parseInt(objC.toString());
            }

        %>
        <form action="/JspDemo/math" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>A:</td>
                        <td><input type="text" name="a" value="<%=a%>" size="50" /></td>
                    </tr>
                    <tr>
                        <td>B:</td>
                        <td><input type="text" name="b" value="<%=b%>" size="50" /></td>
                    </tr>
                    <tr>
                        <td>C:</td>
                        <td><input type="text" name="c" value="<%=c%>" size="50" readonly="true" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Addition" name="Addition" /></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
