<%--
    @author Norbert Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pagetemplate pageTitle="Log in">
    <jsp:attribute name="content">
        <div align="center">
            <h1>Log in</h1>
        </div>

        <div class="col-xs-12 col-sm-6 col-sm-offset-3">
            <c:url var="loginUrl" value="/login" />
            <form action="${loginUrl}" method="post" class="form-horizontal">


                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                </c:if>

                <div class="input-group input-sm">
                    <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
                </div>
                <div class="input-group input-sm">
                    <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                </div>
                <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />

                <div class="form-actions">
                    <input type="submit"
                           class="btn btn-block btn-primary btn-default" value="Log in">
                </div>
            </form>
        </div>
    </jsp:attribute>
</t:pagetemplate>
