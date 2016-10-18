<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Employee Management</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="<c:url value="css/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="css/bootstrap-theme.min.css" />">
    <link rel="stylesheet" href="<c:url value="css/jquery-ui.css" />">
    <link rel="stylesheet" href="<c:url value="css/main.css" />">
    <link rel="stylesheet" href="<c:url value="css/test.css" />">
    <link rel="stylesheet" href="<c:url value="css/jquery.dataTables.css" />">
    <!-- Latest compiled and minified JavaScript -->
    <script src="<c:url value="js/vendor/jquery-1.11.1.min.js"/>"></script>
    <script src="<c:url value="js/jquery.dataTables.min.js" />"></script>
    <script src="<c:url value="js/vendor/bootstrap.min.js"/>"></script>
    <script src="<c:url value="js/jquery-ui.js" />"></script>
    <script src="<c:url value="js/vendor/moment.js" />"></script>
    <script src="<c:url value="js/vendor/bootstrap-datetimepicker.min.js" />"></script>
    <script src="<c:url value="js/vendor/jquery.base64.min.js" />"></script>
    <script src="<c:url value="js/utils.js" />"></script>
    <script src="<c:url value="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"/>"></script>
    <script src="<c:url value="js/employee-management.js"/>"></script>
    <script src="<c:url value="js/site-management.js"/>"></script>
    <script src="<c:url value="js/department-management.js"/>"></script>
</head>
<body>
    <div id="site-wrapper">
        <!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    
        <!-- Header -->
        <header class="hidden-print">
            <div class="container">
            </div>
        </header>
         
        <!-- Fixed navbar -->
        <nav class="navbar navbar-inverse navbar-fixed-top navbar-md hidden-print" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav tab-pane-selector">
                        <li class="employee-selector active"><a href="employee" onclick="eta.activeTabPane('courier-config-tab-selector', 'employee-section');"><b>Employee</b></a></li>
                        <li class="site-selector"><a href="site"><b>Site</b></a></li>
                        <li class="department-selector"><a href="department"><b>Department</b></a></li>
                    </ul>

                </div><!--/.nav-collapse -->
            </div>
        </nav>
    
        <!-- Body - Decorated -->
        <sitemesh:write property='body' />
        <div id="auto-complete-container">
        </div>
    </div>

   
	<!-- Modal -->
    <div class="modal fade" id="warningMsgBoxLabel" tabindex="-1" role="dialog" aria-labelledby="warningMsgBoxLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myLoadingModalTitle">Processing</h4>
                </div>
                <section class="modal-body" id='myLoadingModalMessage'>
                    <c:url value="/images/loading.gif" var="imageLink" />
                    <img alt="Processing..." src="${imageLink}"/>
                </section>
            </div>
        </div>
    </div>
</body>
</html>
