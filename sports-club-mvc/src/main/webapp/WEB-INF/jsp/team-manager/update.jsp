<%--
  @author Marian Sulgan
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:pagetemplate pageTitle="Update Team manager">
    <jsp:attribute name="content">
        <h1>Update Team manager</h1>
        
        <form:form method="post" action="${pageContext.request.contextPath}/team-manager/update/${teamManager.id}" modelAttribute="teamManager" cssClass="form-horizontal">

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
                    <td>Address:</td>
                    <td>
                        <div>
                            <form:label path="address" cssClass="col-xs-6 control-label"/>
                            <form:input path="address" cssClass="form-control"/>
                            <form:errors path="address" cssClass="help-block"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Contact:</td>
                    <td>
                        <div>
                            <form:label path="contact" cssClass="col-xs-6 control-label"/>
                            <form:input path="contact" cssClass="form-control"/>
                            <form:errors path="contact" cssClass="help-block"/>
                        </div>
                    </td>
                </tr>
            </table>

            <button class="btn btn-primary" type="submit">Update team manager</button>
            <a href="${pageContext.request.contextPath}/team-manager" class="btn btn-primary pull-right" role="button">Back to list</a>

        </form:form>
    </jsp:attribute>
</t:pagetemplate>
