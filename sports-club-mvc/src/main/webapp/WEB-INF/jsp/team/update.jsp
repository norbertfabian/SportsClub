<%--
  Created by IntelliJ IDEA.
  User: norbert
  Date: 11.12.16
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
    <form:form method="post" action="${pageContext.request.contextPath}/team/update/${team.id}"
               modelAttribute="team" cssClass="form-horizontal">

        Name:
        <form:label path="name" cssClass="col-sm-2 control-label"/>
        <div class="col-sm-10">
            <form:input path="name" cssClass="form-control"/>
            <form:errors path="name" cssClass="help-block"/>
        </div>
        Age group:
        <div class="col-sm-10">
            <form:select path="ageGroupLabel" cssClass="col-sm-2 control-label">
                <form:options items="${ageGroups}"/>
            </form:select>
        </div>

        Team manager:
        <div class="col-sm-10">

            <form:select path="teamManagerId" cssClass="col-sm-2 control-label">
                <form:options items="${teamManagers}" itemValue="id" itemLabel="name"/>
            </form:select>
        </div>

        <br/>
        <button class="btn btn-primary" type="submit">Update team</button>
    </form:form>
</body>
</html>
