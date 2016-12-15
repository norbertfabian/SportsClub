<%--
@author: MarianSulgan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pagetemplate pageTitle="List of team managers">
    <jsp:attribute name="content">
        
    <a href="${pageContext.request.contextPath}/team-manager/create" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        Create Team Manager
    </a>

    <table class="table vertical-align-table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Address</th>
                <th>Contact</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${teamManagers}" var="teamManager">
                <tr>
                    <!-- basic information -->
                    <td><c:out value="${teamManager.name}"/></td>
                    <td><c:out value="${teamManager.address}"/></td>
                    <td><c:out value="${teamManager.contact}"/></td>
    
                    <!-- actions to perform -->
                    <td>
                        <a href="/pa165/team-manager/${teamManager.id}" class="btn btn-primary">Detail</a>
                        <a href="${pageContext.request.contextPath}/team-manager/update/${teamManager.id}" class="btn btn-primary">Edit</a>
                        <form data="get" action="${pageContext.request.contextPath}/team-manager/delete/${teamManager.id}" style="display: inline-block">
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </form>
                    </td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
                            
    </jsp:attribute>
</t:pagetemplate>
