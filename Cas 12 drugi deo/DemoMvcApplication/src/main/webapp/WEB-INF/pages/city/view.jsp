<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>
    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert mb-2">${message}</div>
    </c:if>

    <div class="container-fluid">
        <form:form action="${pageContext.request.contextPath}/city/save" method="post" modelAttribute="cityDto">
            <div>City number:</div>
            <div><form:input type="text" id="number" path="number" readonly="true"/></div>
            <div class="text-danger">
                <form:errors path="number" cssClass="error" />
            </div>

            <div> City name:</div>
            <div><form:input type="text" id="name" path="name" readonly="true"/></div>
            <div class="text-danger">
                <form:errors path="name" cssClass="error" />
            </div>
            <p/>
        </form:form>
    </div>

</div>