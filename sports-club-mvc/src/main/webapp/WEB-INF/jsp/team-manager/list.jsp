<%--
@author: MarianSulgan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:pagetemplate pageTitle="List of team managers">
    <jsp:attribute name="content">
    
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/team-manager/create" class="btn btn-primary">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            Create Team Manager
        </a>
    </sec:authorize>

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
                        <t:detail-button link="${pageContext.request.contextPath}/team-manager/${teamManager.id}"></t:detail-button>
                        
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <a href="${pageContext.request.contextPath}/team-manager/update/${teamManager.id}" class="btn btn-primary">Edit</a>
                        </sec:authorize>
                        
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <form data="get" action="${pageContext.request.contextPath}/team-manager/delete/${teamManager.id}" style="display: inline-block">
                                <t:delete-button></t:delete-button>
                            </form>
                        </sec:authorize>
                    </td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
                            
    </jsp:attribute>
</t:pagetemplate>
