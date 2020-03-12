<!-- LOGIN -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	
	if (session.getAttribute("pec")!= null && session.getAttribute("pecId")!=null && session.getAttribute("pecEMAIL")!=null){
		System.out.println("[LOGIN] REDIRECT TO APPLICATIONS from INDEX");
		response.sendRedirect(request.getContextPath() + "/pec-application");	
}
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PUP PASUC Evaluation</title>
		
		<!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="assets/vendor/fonts/circular-std/style.css">
	    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
	    <link rel="stylesheet" href="assets/vendor/charts/chartist-bundle/chartist.css">
	    <link rel="stylesheet" href="assets/vendor/charts/morris-bundle/morris.css">
	    <link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
	    <link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">
	    <link rel="stylesheet" href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
	    <link rel="stylesheet" href="assets/libs/css/style.css">
	    <link rel="stylesheet" href="assets/vendor/inputmask/css/inputmask.css">
	</head>
	
	<body class="animsition">
    <div class="dashboard-main-wrapper">
	<!-- ============================================================== -->
    <!-- Header  -->
    <!-- ============================================================== -->    
           <div style="text-align: left; margin-left: 55px; min-height: 120px;">
                <a href="index"><img src="assets/images/pasuc-logo.png" alt="logo" style="max-height: 90px;"></a>
	        </div>
	<!-- ============================================================== -->
    <!-- End of header  -->
    <!-- ============================================================== -->
	    
    <div class="row">
    <!-- ============================================================== -->
    <!-- login  -->
    <!-- ============================================================== -->
    
    <div class="splash-container-login">
        <div class="card">
        <div class="card-header text-center"><span class="splash-description-createacc">Login as PEC</span></div>
            <div class="card-body">
            <span class="splash-description">Please enter your user information.</span>
                <form name="login" id="login" action="pec-application?process=view" method="post">
                    <div class="form-group">
                        <input class="form-control form-control-lg email-inputmask" type="text" name="emailLogPEC" id="emailLogPEC" placeholder="Email Address" required>
                    </div>
                    <div class="form-group">
                        <input class="form-control form-control-lg" type="password" name = "pswLogPEC" id="pswLogPEC" placeholder="Password" maxlength="20" required>
                    </div>
                    <button class="btn btn-rounded btn-warning btn-lg btn-block" type="submit" name = "login" id="login" value="Login" style="margin-right: 125px;">Sign in</button>
                	<div class="text-center">
                                        <div class="card-footer-item">
                                            <a href="#" class="card-link" >Forgot Password?</a>
                                        </div>
                                    </div>
                	
                </form>
            </div>

        </div>
                <h5 style="text-align: center;"><a href="index" class="card-link" >Login as Faculty</a></h5>
        
    </div>
    
    <!-- ============================================================== -->
    <!-- End of login  -->
    <!-- ============================================================== -->
    	
 
    
    </div>
    </div>
   
    <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="assets/vendor/inputmask/js/jquery.inputmask.bundle.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="assets/libs/js/main-js.js"></script>
    
    <script>
    $(function(e) {
        "use strict";
        	$(".EmployeeID-inputmask").inputmask("99999"),
            $(".phone-inputmask").inputmask("9999-999-9999"),
            $(".email-inputmask").inputmask({
                mask: "*{1,20}[.*{1,20}][.*{1,20}][.*{1,20}]@pup.edu.ph",
                greedy: !1,
                onBeforePaste: function(n, a) {
                    return (e = e.toLowerCase()).replace("mailto:", "")
                },
                definitions: {
                    "*": {
                        validator: "[0-9A-Za-z!#$%&'*+/=?^_`{|}~/-]",
                        cardinality: 1,
                        casing: "lower"
                    }
                }
            })
    });
    </script>
</body>
</html>