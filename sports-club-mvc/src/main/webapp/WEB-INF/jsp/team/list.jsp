<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pagetemplate pageTitle="List of teams">
    <jsp:attribute name="content">
    <a href="${pageContext.request.contextPath}/team/create" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        Create Team
    </a>

    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Age group</th>
            <th>Team manager</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teams}" var="team">
                <tr>
                    <td class="vertical-align"><c:out value="${team.name}"/></td>
                    <td class="vertical-align"><c:out value="${team.ageGroupLabel}"/></td>
                    <td class="vertical-align"><c:out value="${team.teamManager.name}"/></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/team/${team.id}" class="btn btn-primary">Detail</a>

                        <a href="${pageContext.request.contextPath}/team/update/${team.id}" class="btn btn-primary">Edit</a>

                        <form data="get" action="${pageContext.request.contextPath}/team/delete/${team.id}" style="display: inline-block">
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </form>
                    </td>
                    <td>
                        <form data="get" action="${pageContext.request.contextPath}/team/${team.id}/membership">
                            <button type="submit" class="btn btn-primary">Manage players</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </jsp:attribute>
</t:pagetemplate>