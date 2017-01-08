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
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pagetemplate pageTitle="List of teams">
    <jsp:attribute name="content">
        <form:form method="post" action="${pageContext.request.contextPath}/team/update/${team.id}"
                   modelAttribute="team" cssClass="form-horizontal">

            <h1>Update team</h1>
            <table class="table vertical-align-table">
                <tr>
                    <td>Name:</td>
                    <td>
                        <div>
                            <form:label path="name" cssClass="col-xs-6 control-label"/>
                            <form:input path="name" cssClass="form-control"/>
                            <form:errors path="name" cssClass="help-block"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Age group:</td>
                    <td>
                        <div>
                            <form:select path="ageGroupLabel" cssClass="col-xs-6 form-control">
                                <form:options items="${ageGroups}"/>
                            </form:select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>TeamManager:</td>
                    <td>
                        <div>
                            <form:select path="teamManagerId" cssClass="col-xs-6 form-control">
                                <form:options items="${teamManagers}" itemValue="id" itemLabel="name"/>
                            </form:select>
                        </div>
                    </td>
                </tr>
            </table>

            <button class="btn btn-primary" type="submit">Update team</button>
            <a href="${pageContext.request.contextPath}/team" class="btn btn-primary pull-right" role="button">Back to list</a>

        </form:form>
    </jsp:attribute>
</t:pagetemplate>
