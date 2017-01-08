<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 15/12/2016
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:pagetemplate pageTitle="List of players">
    <jsp:attribute name="content">
    <a href="${pageContext.request.contextPath}/player/create" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        Create Player
    </a>

    <table class="table vertical-align-table">
        <thead>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Height</th>
            <th>Weight</th>
            <th>Date of birth</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${players}" var="player">
                <tr>
                    <td><c:out value="${player.firstName}"/></td>
                    <td><c:out value="${player.lastName}"/></td>
                    <td><c:out value="${player.height}"/></td>
                    <td><c:out value="${player.weight}"/></td>
                    <td><fmt:formatDate value="${player.dateOfBirth}" pattern="dd.MM.yyyy" /></td>
                    <td>
                        <a href="/pa165/player/${player.id}" class="btn btn-primary">Detail</a>

                        <a href="${pageContext.request.contextPath}/player/update/${player.id}" class="btn btn-primary">Edit</a>

                        <form data="get" action="${pageContext.request.contextPath}/player/delete/${player.id}" style="display: inline-block">
                            <!--<button type="submit" class="btn btn-primary">Delete</button>-->
                            <t:delete-button></t:delete-button>
                        </form>
                    <td>
                        <form data="get" action="${pageContext.request.contextPath}/player/${player.id}/membership">
                            <button type="submit" class="btn btn-primary">Assign player</button>
                        </form>
                    </td>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </jsp:attribute>
</t:pagetemplate>