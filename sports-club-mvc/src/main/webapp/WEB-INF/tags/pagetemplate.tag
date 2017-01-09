<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@attribute name="pageTitle" required="true"%>
<%@attribute name="content" fragment="true" %>


<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js" lang="en"> 
<!--<![endif]-->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>${pageTitle}</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/web/apple-touch-icon.png">
        <link rel="icon" href="${pageContext.request.contextPath}/web/favicon.ico" type="image/x-icon"/>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/bootstrap.min.css">
        <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/bootstrap-theme.min.css">-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/main.css">
        <style>
            body {
                padding-top: 70px;
                padding-bottom: 40px;
            }
        </style>

        <script src="${pageContext.request.contextPath}/web/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    
    <body>
        
        <div class="container">

            <div class="row">
                <div class="pull-right">
                    <sec:authorize access="isAuthenticated()">
                        <p style="margin: 0 10px 0 0">You are logged in as <b><sec:authentication property="principal.username" /></b></p>
                    </sec:authorize>
                </div>
            </div>

            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="collapsed navbar-toggle" data-toggle="collapse" data-target="#main-navbar-collapse" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}">
                            <span> <img alt="Brand" src="${pageContext.request.contextPath}/web/img/Football.png" width="20" height="20">
                            Sports club management</span>
                        </a>
                    </div>
                    <div class="collapse navbar-collapse" id="main-navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="${pageContext.request.contextPath}/team" >Teams</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/player" >Players</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/team-manager" >Team managers</a>
                            </li>
                            <li>
                                <sec:authorize access="isAuthenticated()">
                                    <form action="${pageContext.request.contextPath}/logout" method="get">
                                        <button type="submit" class="btn btn-default navbar-btn">
                                            <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                                            Log out
                                        </button>
                                    </form>
                                </sec:authorize>
                                <sec:authorize access="isAnonymous()">
                                    <form action="${pageContext.request.contextPath}/login" method="get">
                                        <button type="submit" class="btn btn-default navbar-btn">
                                            <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                                            Log in
                                        </button>
                                    </form>
                                </sec:authorize>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            
            <jsp:invoke fragment="content" />

            <footer>
              <p>&copy; SportsClub 2015</p>
            </footer>

        </div> <!-- /container -->    

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>
        <script src="${pageContext.request.contextPath}/web/js/vendor/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/3374d8c062.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.8/validator.js"></script>
        <script src="${pageContext.request.contextPath}/web/js/main.js"></script>      
    </body>
    
</html>




