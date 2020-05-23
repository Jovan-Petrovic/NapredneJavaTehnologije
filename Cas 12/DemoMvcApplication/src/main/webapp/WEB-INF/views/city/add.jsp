<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


This is add page for city!
<div>
    <a href="<c:url value="/city"/>"> Back to city home </a>
</div>

<div>
    Message: ${message}
</div>

<c:if test="${not empty invalid}">
    Invalid message: <div>${invalid}</div>
</c:if>

<form:form action="${pageContext.request.contextPath}/city/save" method="post" modelAttribute="cityDto">
    <div>City number:</div>
    <div><form:input type="text" id="number" path="number"/></div>
    <div class="text-danger">
        <form:errors path="number" cssClass="error" />
    </div>

    <div> City name:</div>
    <div><form:input type="text" id="name" path="name"/></div>
    <div class="text-danger">
        <form:errors path="name" cssClass="error" />
    </div>
    <p/>
    <div><button id="save">Save</button> </div>
</form:form>
