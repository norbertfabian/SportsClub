<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 15/12/2016
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:pagetemplate pageTitle="List of players">
    <jsp:attribute name="content">
        <form:form method="post" action="${pageContext.request.contextPath}/player/create"
                   modelAttribute="player" cssClass="form-horizontal">


            <table class="table">
                <tr>
                    <td>First Name:</td>
                    <td>
                        <div>
                            <form:label path="firstName" cssClass="col-xs-6 control-label"/>
                            <form:input path="firstName" cssClass="form-control"/>
                            <form:errors path="firstName" cssClass="help-block"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td>
                        <div>
                            <form:label path="lastName" cssClass="col-xs-6 control-label"/>
                            <form:input path="lastName" cssClass="form-control"/>
                            <form:errors path="lastName" cssClass="help-block"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Height:</td>
                    <td>
                        <div>
                            <form:label path="height" cssClass="col-xs-6 control-label"/>
                            <form:input path="height" cssClass="form-control"/>
                            <form:errors path="height" cssClass="help-block"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Weight:</td>
                    <td>
                        <div>
                            <form:label path="weight" cssClass="col-xs-6 control-label"/>
                            <form:input path="weight" cssClass="form-control"/>
                            <form:errors path="weight" cssClass="help-block"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td>
                        <div>
                            <form:label path="dateOfBirth" cssClass="col-xs-6 control-label"/>
                            <form:input path="dateOfBirth" cssClass="form-control"/>
                            <form:errors path="dateOfBirth" cssClass="help-block"/>
                        </div>
                    </td>
                </tr>
            </table>

            <button class="btn btn-primary" type="submit">Create player</button>
            <a href="${pageContext.request.contextPath}/player" class="btn btn-primary pull-right" role="button">Back to list</a>

        </form:form>
    </jsp:attribute>
</t:pagetemplate>

