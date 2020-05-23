<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>


    <form>
        <c:if test="${not empty message}">
            <div class="alert alert-info" role="alert mb-2">${message}</div>
        </c:if>

        <div class="container-fluid">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">City code</th>
                        <th scope="col">City name</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach
                        items="${cities}"
                        var="city"
                        varStatus="loop">
                        <tr>
                            <td>${loop.index+1}</td>
                            <td>${city.number}</td>
                            <td>${city.name}</td>
                            <td>
                                <ul class="navbar-nav mr-auto d-flex justify-content-end">
                                    <div class="dropdown">
                                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            action
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="<c:url value = "/city/${city.number}/delete/">

                                                </c:url>">Delete</a>

                                            <a class="dropdown-item" href="<c:url value = "/city/${city.number}/view/">

                                                </c:url>">View</a>
                                        </div>
                                    </div>
                                </ul>
                            </td>
                        </tr>
                    </c:forEach>


                </tbody>
            </table>
        </div>
    </form>
</div>