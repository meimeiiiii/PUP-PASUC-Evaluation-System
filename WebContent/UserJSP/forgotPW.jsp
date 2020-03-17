<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PUP PASUC Evaluation - Forgot Password</title>
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
	</head>
	
	<body>
    <div class="dashboard-main-wrapper">
	<!-- ============================================================== -->
    <!-- Header  -->
    <!-- ============================================================== -->    

       		<div class="dashboard-header">
       		<div class="fixed-top" style="max-height: 110px; background-color: #800000;" >
       		
	       			
	                <a href="index"><img src="assets/images/pasuc-logo.png" alt="logo" style="max-height: 90px; margin-left: 55px; margin-top: 10px;"></a>
		        
	        </div>
	        </div>
	<!-- ============================================================== -->
    <!-- End of header  -->
    <!-- ============================================================== -->
    
	<!-- ============================================================== -->
	<!-- TOP NAV  -->
	<!-- ============================================================== -->
		<div  id="top"></div>
		<div class="col-xl-12" style="margin-top: 100px;">
 				
 			<div class="tab-regular">
    			
 	<!-- ============================================================== -->
	<!-- END TOP NAV  -->
	<!-- ============================================================== -->
	
	
		<div class="col-xl-12">
		<br><br>
		<div class="splash-container-vemail">
		<div class="card p-2">
			<div class="card-header text-center"><span class="splash-description-credentials">Forgot Password</span></div>
				<div class="card-body">
					<form method=post action="account?process=forgotpw">
						<h4 style="text-align: center;">Please enter your e-mail for a password reset.</h4>
						<br>
						<div class="row">
							<div class="col-xl-3"></div>
							
							<div class="col-xl-6">
								<input class="form-control text-center" type="text" name="emailIn" id="emailIn" placeholder="E-mail" required>
							</div>
							
							<div class="col-xl-3"></div>
						</div>
						<br>
						<button class="btn btn-rounded btn-warning btn-block" type="submit" name="submitemail" id="submitemail" value="submitemail">Submit</button>
				    </form>       
				</div>
		</div>
		</div>
		</div>
	</div>
	</div>
</div> 	
    <!-- ============================================================== -->
    <!-- Java Script -->
    <!-- ============================================================== --> 
    <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src='assets/libs/js/main-js.js'></script>
   
</body>
</html>
	