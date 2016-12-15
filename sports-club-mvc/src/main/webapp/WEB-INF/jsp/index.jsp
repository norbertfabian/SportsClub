<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pagetemplate pageTitle="Sports Club management system">
    <jsp:attribute name="content">
        <h1>Sport Club Management</h1>
        <hr>
        <p>Choose the field to manage:</p>
        <div class="left-block" style="max-width:400px"> 
            <a href="team/" class="btn btn-primary btn-lg btn-block">Teams</a>
            <a href="player/" class="btn btn-primary btn-lg btn-block">Players</a>
            <a href="team-manager/" class="btn btn-primary btn-lg btn-block">Team managers</a>
        </div>
    </jsp:attribute>
</t:pagetemplate>
