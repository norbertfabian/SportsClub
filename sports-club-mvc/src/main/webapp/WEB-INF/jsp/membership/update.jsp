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

<t:pagetemplate pageTitle="Update membership">
    <jsp:attribute name="content">
        <form:form method="post" action="${pageContext.request.contextPath}${action}"
                   modelAttribute="membership" cssClass="form-horizontal">

            <h1>Update team</h1>
            <table class="table vertical-align-table">
                <tr>
                    <td>Jersey number:</td>
                    <td>
                        <div>
                            <form:label path="jerseyNumber" cssClass="col-xs-6 control-label"/>
                            <form:input path="jerseyNumber" cssClass="form-control"/>
                            <form:errors path="jerseyNumber" cssClass="help-block"/>
                        </div>
                    </td>
                </tr>
            </table>

            <button class="btn btn-primary" type="submit">Update membership</button>
            <a href="${pageContext.request.contextPath}${path}" class="btn btn-primary pull-right" role="button">Back to list</a>

        </form:form>
    </jsp:attribute>
</t:pagetemplate>
