<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <a href="${pageContext.request.contextPath}/team/create" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        Create Team
    </a>

    <table class="table" border="1">
        <tr>
            <th>name</th>
            <th>age group</th>
            <th>team manager</th>
        </tr>
        <c:forEach items="${teams}" var="team">
            <tr>
                <td><c:out value="${team.name}"/></td>
                <td><c:out value="${team.ageGroupLabel}"/></td>
                <td><c:out value="${team.teamManager.name}"/></td>
                <td>
                    <a href="/pa165/team/${team.id}" class="btn btn-primary">Detail</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/team/update/${team.id}" class="btn btn-primary">Update</a>
                </td>
                <td>
                    <form data="get" action="${pageContext.request.contextPath}/team/delete/${team.id}">
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>