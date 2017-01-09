<%--
    @author Norbert Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:pagetemplate pageTitle="Log in">
    <jsp:attribute name="content">
        
        <div class="row">
            <c:if test="${not empty error}">
                <div class="error alert alert-danger">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg alert alert-success">${msg}</div>
            </c:if>
        </div>
        
        <sec:authorize access="isAuthenticated()">
            <div class="row text-center">
                <div class="col-sm-6 col-sm-offset-3 col-xs-12 login-vertical-align">
                    <i class="fa fa-user-circle-o fa-4" aria-hidden="true"></i>
                    <p>You are currently logged in as user <b><sec:authentication property="principal.username" /></b>.</p>
                    <p>To log out, use the button.</p>
                    <form action="${pageContext.request.contextPath}/logout" method="get">
                        <button type="submit" class="btn btn-default navbar-btn">
                            <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                            Log out
                        </button>
                    </form>
                </div>
            </div>
        </sec:authorize>
        
        <sec:authorize access="isAnonymous()">
            <div class="row">
                <div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 login-container">
                    <c:url var="loginUrl" value="/login" />
                    <form action="${loginUrl}" method="post" class="form-horizontal">


                        <div class="row">
                            <div class="col-xs-12 text-center login-header">
                                <h1>Log in to your account</h1>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label semantic" for="username" style=""></label>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label semantic" for="password"></label>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="fa fa-lock" aria-hidden="true"></i>
                                </span>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                            </div>
                        </div>

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                        <div class="form-group">
                            <div class="form-actions">
                                <input type="submit"
                                       class="btn btn-block btn-primary" value="Log in">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </sec:authorize>
        
        
    </jsp:attribute>
</t:pagetemplate>
