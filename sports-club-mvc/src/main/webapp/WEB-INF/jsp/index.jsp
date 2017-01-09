<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pagetemplate pageTitle="Sports Club management system">
    <jsp:attribute name="content">
        <h2 class="tiles-header">Choose the field to manage:</h2>
        <div class="row tiles">
            <div class="col-xs-4 tile col-md-3">
                <a href="team/" class="btn btn-primary btn-lg">Teams</a>
            </div>
            <div class="col-xs-4 tile col-md-3">
                <a href="player/" class="btn btn-primary btn-lg">Players</a>
            </div>
            <div class="col-xs-4 tile col-md-3">
                <a href="team-manager/" class="btn btn-primary btn-lg">Team managers</a>
            </div>
        </div>
        
<!--        <div class="left-block" style="max-width:400px"> 
            <a href="team/" class="btn btn-primary btn-lg btn-block">Teams</a>
            <a href="player/" class="btn btn-primary btn-lg btn-block">Players</a>
            <a href="team-manager/" class="btn btn-primary btn-lg btn-block">Team managers</a>
        </div>-->
    </jsp:attribute>
</t:pagetemplate>
