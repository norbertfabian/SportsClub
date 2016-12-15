<%--
  Created by IntelliJ IDEA.
  User: jsmolar
  Date: 12/13/16
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Manage players</title>
</head>
<body>

<h2>Players in team</h2>

</table>
<table class="table" border="1">
    <div class="row">
        <div class="col-xs-12">
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
                        <td><fmt:formatDate value="${membership.player.dateOfBirth}" pattern="dd.MM.yyyy" /></td>
                        <td>
                            <form data="get" action="${pageContext.request.contextPath}/team/${team.id}/membership/delete/${membership.id}">
                                <button type="submit" class="btn btn-primary">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</table>

<h2>Free players</h2>

</table>
<table class="table" border="1">
    <div class="row">
        <div class="col-xs-12">
            <table class="table" border="1">
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Height</th>
                    <th>Weight</th>
                    <th>Date of birth</th>
                </tr>
                <c:forEach items="${freePlayers}" var="freePlayer">
                    <tr>
                        <td><c:out value="${freePlayer.firstName}"/></td>
                        <td><c:out value="${freePlayer.lastName}"/></td>
                        <td><c:out value="${freePlayer.height}"/></td>
                        <td><c:out value="${freePlayer.weight}"/></td>
                        <td><fmt:formatDate value="${freePlayer.dateOfBirth}" pattern="dd.MM.yyyy" /></td>
                        <td>
                            <form data="get" action="${pageContext.request.contextPath}/team/${team.id}/membership/add/${freePlayer.id}">
                                <button type="submit" class="btn btn-primary">Add</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</table>

</body>
</html>
