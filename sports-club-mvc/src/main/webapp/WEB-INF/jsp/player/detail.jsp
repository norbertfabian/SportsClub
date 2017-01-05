<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 15/12/2016
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pagetemplate pageTitle="List of players">
    <jsp:attribute name="content">

        <div class="row">
            <div class="col-xs-6">
                <h2>Player</h2>
                <table class="table">
                    <tr>
                        <td><h4><b>First name:</b></h4></td>
                        <td><h4><c:out value="${player.firstName}"/></h4></td>
                    </tr>
                    <tr>
                        <td><h4><b>Last name:</b></h4></td>
                        <td><h4><c:out value="${player.lastName}"/></h4></td>
                    </tr>
                    <tr>
                        <td><h4><b>Height:</b></h4></td>
                        <td><h4><c:out value="${player.height}"/></h4></td>
                    </tr>
                    <tr>
                        <td><h4><b>Weight:</b></h4></td>
                        <td><h4><c:out value="${player.weight}"/></h4></td>
                    </tr>
                    <tr>
                        <td><h4><b>Date of birth:</b></h4></td>
                        <td><h4><fmt:formatDate value="${player.dateOfBirth}" pattern="dd.MM.yyyy" /></h4></td>
                    </tr>
                </table>
            </div>
        </div>
        <br/>

        <h2>Teams</h2>

        <div class="row">
            <div class="col-xs-12">
                <table class="table">
                    <tr>
                        <th>Name</th>
                        <th>Age group</th>
                    </tr>
                    <c:forEach items="${memberships}" var="membership">
                        <tr>
                            <td><c:out value="${membership.team.name}"/></td>
                            <td><c:out value="${membership.team.ageGroupLabel}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <a href="${pageContext.request.contextPath}/player" class="btn btn-primary pull-right" role="button">Back to list</a>
    </jsp:attribute>
</t:pagetemplate>