<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:pagetemplate pageTitle="List of teams for managing">
    <jsp:attribute name="content">


        <h2>Player is assign in teams</h2>

        <table class="table vertical-align-table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Age group</th>
                <th>Team manager</th>
                <th>Jersey number</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${memberships}" var="membership">
                <tr>
                    <td class="vertical-align"><c:out value="${membership.team.name}"/></td>
                    <td class="vertical-align"><c:out value="${membership.team.ageGroupLabel}"/></td>
                    <td class="vertical-align"><c:out value="${membership.team.teamManager.name}"/></td>
                    <td><c:out value="${membership.jerseyNumber}"/></td>
                    <td>
                        <form data="get"
                              action="${pageContext.request.contextPath}/player/${player.id}/membership/remove/${membership.id}"
                              style="display: inline-block">
                            <t:delete-button></t:delete-button>
                        </form>
                        <a href="${pageContext.request.contextPath}/player/${player.id}/membership/update/${membership.id}"
                           class="btn btn-primary">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h2>All teams</h2>

    <table class="table vertical-align-table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Age group</th>
            <th>Team manager</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teams}" var="team">
                <tr>
                    <td class="vertical-align"><c:out value="${team.name}"/></td>
                    <td class="vertical-align"><c:out value="${team.ageGroupLabel}"/></td>
                    <td class="vertical-align"><c:out value="${team.teamManager.name}"/></td>
                    <td>
                        <form data="get"
                              action="${pageContext.request.contextPath}/player/${player.id}/membership/assign/${team.id}">
                            <button type="submit" class="btn btn-primary">Assign to a team</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </jsp:attribute>
</t:pagetemplate>