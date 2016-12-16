<%@tag description="Page template" pageEncoding="UTF-8"%>
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
        <style>
            body {
                padding-top: 50px;
                padding-bottom: 20px;
            }
        </style>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/main.css">

        <script src="${pageContext.request.contextPath}/web/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    
    <body>
        
        <div class="container">
            
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}">
                            <img alt="Brand" src="${pageContext.request.contextPath}/web/img/Football.png" width="20" height="20">
                        </a>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}">Sports club management</a>
                    </div>
                    <div class="collapse navbar-collapse">
                        <ul class="navbar-nav nav navbar-right">
                            <li>
                                <a href="${pageContext.request.contextPath}/team" >Teams</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/player" >Players</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/team-manager" >Team managers</a>
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.8/validator.js"></script>
        <script src="${pageContext.request.contextPath}/web/js/main.js"></script>      
    </body>
    
</html>




