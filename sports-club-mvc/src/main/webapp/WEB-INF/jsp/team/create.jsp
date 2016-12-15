<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:pagetemplate pageTitle="List of teams">
    <jsp:attribute name="content">
        <h1>New team</h1>
        <form:form method="post" action="${pageContext.request.contextPath}/team/create"
                   modelAttribute="team" cssClass="form-horizontal" data-toggle="validator">

            <table class="table vertical-align-table">
                <tr>
                    <td>Name:</td>
                    <td>
                        <div>
                            <form:label path="name" cssClass="col-xs-6 control-label"/>
                            <form:input path="name" cssClass="form-control" required="required"/>
                            <form:errors path="name" cssClass="help-block"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Age group:</td>
                    <td>
                        <div>
                            <form:select path="ageGroupLabel" cssClass="col-xs-6 form-control" required="required">
                                <form:options items="${ageGroups}"/>
                            </form:select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Team manager:</td>
                    <td>
                        <div>
                            <form:select path="teamManagerId" cssClass="col-xs-6 form-control" required="required">
                                <form:options items="${teamManagers}" itemValue="id" itemLabel="name"/>
                            </form:select>
                        </div>
                    </td>
                </tr>
            </table>

            <button class="btn btn-primary" type="submit">Create team</button>
            <a href="${pageContext.request.contextPath}/team" class="btn btn-primary pull-right" role="button">Back to list</a>

        </form:form>
    </jsp:attribute>
</t:pagetemplate>

