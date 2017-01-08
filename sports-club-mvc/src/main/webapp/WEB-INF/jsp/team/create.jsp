<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:pagetemplate pageTitle="List of teams">
    <jsp:attribute name="content">
        <h1>New team</h1>
        
        <form:form method="post" action="${pageContext.request.contextPath}/team/create" 
                   modelAttribute="team" cssClass="form-horizontal" data-toggle="validator">
            
            <div class="form-group">
                <label for="team-create-form-name" class="control-label">Team name</label>
                <form:input path="name" type="text" cssClass="form-control" id="team-create-form-name" 
                       placeholder="New team name" data-error="Choose team name, at least 3 characters long." 
                       data-minlength="3" required="required" />
                <div class="help-block with-errors"></div>
            </div>
            
            <div class="form-group">
                <label for="team-create-form-group" class="control-label">Age group</label>
                <form:select path="ageGroupLabel" cssClass="form-control" id="team-create-form-group"
                             data-error="Select age group." required="required">
                    <form:options items="${ageGroups}" />
                </form:select>
                <div class="help-block with-errors"></div>
            </div>
                
            <div class="form-group">
                <label for="team-create-form-manager" class="control-label">Team manager</label>
                <form:select path="teamManagerId" cssClass="form-control" id="team-create-form-manager"
                             data-error="Select team manager." required="required">
                    <form:options items="${teamManagers}" itemValue="id" itemLabel="name" />
                </form:select>
                <div class="help-block with-errors"></div>
            </div>
            
            <div class="form-group">
                <button class="btn btn-success" type="submit">Create team</button>
                <a href="${pageContext.request.contextPath}/team" class="btn btn-default pull-right" role="button">
                    <span class="glyphicon glyphicon-arrow-left"></span>
                    Back to list
                </a>
            </div>
            
            

        </form:form>
            
    </jsp:attribute>
</t:pagetemplate>

