<%-- 
    @author Marian Sulgan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pagetemplate pageTitle="List of teams">
    <jsp:attribute name="content">
        <div class="col-xs-12 col-sm-6 col-sm-offset-3">
          <form:form method="get" action="${pageContext.request.contextPath}/" modelAttribute="user" cssClass="form-horizontal">       
                <h2 class="form-signin-heading">Please login</h2>
                <input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" />
                <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
                <div class="checkbox">
                    <label>
                      <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
                    </label>
                </div>
                <!--<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>-->   
                <a href="${pageContext.request.contextPath}/" class="btn btn-lg btn-primary btn-block" type="submit">Login</a>   
          </form:form>
        </div>
    </jsp:attribute>
</t:pagetemplate>
