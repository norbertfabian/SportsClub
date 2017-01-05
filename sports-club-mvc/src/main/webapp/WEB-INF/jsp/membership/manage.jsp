<%--
  Created by IntelliJ IDEA.
  User: jsmolar
  Date: 12/13/16
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pagetemplate pageTitle="List of teams for managing">
    <jsp:attribute name="content">

<html>
<head>
    <title>Manage players</title>
</head>
<body>

<h2>Players in team</h2>

</table>
<table class="table" border="1">
    <table class="table" border="1">
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Height</th>
            <th>Weight</th>
            <th>Date of birth</th>
        </tr>
                <c:forEach items="${memberships}" var="membership">
                    <tr>
                        <td><c:out value="${membership.player.firstName}"/></td>
                        <td><c:out value="${membership.player.lastName}"/></td>
                        <td><c:out value="${membership.player.height}"/></td>
                        <td><c:out value="${membership.player.weight}"/></td>
                        <td><fmt:formatDate value="${membership.player.dateOfBirth}" pattern="dd.MM.yyyy"/></td>
                        <td>
                            <form data="get"
                                  action="${pageContext.request.contextPath}/team/${team.id}/membership/delete/${membership.id}">
                                <button type="submit" class="btn btn-primary">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
    </table>
</table>

<h2>All players</h2>

</table>
<table class="table" border="1">
    <table class="table" border="1">
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Height</th>
            <th>Weight</th>
            <th>Date of birth</th>
        </tr>
                <c:forEach items="${players}" var="player">
                    <tr>
                        <td><c:out value="${player.firstName}"/></td>
                        <td><c:out value="${player.lastName}"/></td>
                        <td><c:out value="${player.height}"/></td>
                        <td><c:out value="${player.weight}"/></td>
                        <td><fmt:formatDate value="${player.dateOfBirth}" pattern="dd.MM.yyyy"/></td>
                        <td>
                            <form data="get"
                                  action="${pageContext.request.contextPath}/team/${team.id}/membership/add/${player.id}">
                                <button type="submit" class="btn btn-primary">Add</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
    </table>
</table>

</body>
</html>
</jsp:attribute>
</t:pagetemplate>
