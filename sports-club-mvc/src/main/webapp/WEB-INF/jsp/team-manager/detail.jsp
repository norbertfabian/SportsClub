<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pagetemplate pageTitle="Team manager detail">
    <jsp:attribute name="content">
      
        <h1>Detail: ${teamManager.name}</h1>
        
        <div class="row">
            <div class="col-xs-12">
                <table class="table">
                    <tr>
                        <td>Address:</td>
                        <td><c:out value="${teamManager.address}"/></td>
                    </tr>
                    <tr>
                        <td>Contact</td>
                        <td><c:out value="${teamManager.contact}"/></td>
                    </tr>
                </table>
            </div>
        </div>

        <h2>Managed teams:</h2>

        <div class="row">
            <div class="col-xs-12">
                <table class="table">
                    <tr>
                        <th>Team name</th>
                        <th>Age group</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach items="${teamManager.teams}" var="team">
                        <tr>
                            <td><c:out value="${team.name}"/></td>
                            <td><c:out value="${team.ageGroupLabel}"/></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/team/${team.id}" class="btn btn-default">Detail</a>
                                <a href="${pageContext.request.contextPath}/team/update/${team.id}" class="btn btn-default">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        
    </jsp:attribute>
</t:pagetemplate>
