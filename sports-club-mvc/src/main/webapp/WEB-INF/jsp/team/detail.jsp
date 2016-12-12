<%--
  Created by IntelliJ IDEA.
  User: norbert
  Date: 11.12.16
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>

    <h2>Team</h2>

    <div class="row">
        <div class="col-xs-6">
            <table>
                <tr>
                    <td><h4>Name:</h4></td>
                    <td><h4><c:out value="${team.name}"/></h4></td>
                </tr>
                <tr>
                    <td><h4>AgeGroup:</h4></td>
                    <td><h4><c:out value="${team.ageGroupLabel}"/></h4></td>
                </tr>
            </table>
        </div>
        <br/>

        <h2>Team Manager</h2>

        <div class="col-xs-6">
            <div class="col-xs-6">
                <table>
                    <tr>
                        <td><h4>Name:</h4></td>
                        <td><h4><c:out value="${teamManager.name}"/></h4></td>
                    </tr>
                    <tr>
                        <td><h4>Address:</h4></td>
                        <td><h4><c:out value="${teamManager.address}"/></h4></td>
                    </tr>
                    <tr>
                        <td><h4>Contact:</h4></td>
                        <td><h4><c:out value="${teamManager.contact}"/></h4></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <br/>

    <h2>Players</h2>

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
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>