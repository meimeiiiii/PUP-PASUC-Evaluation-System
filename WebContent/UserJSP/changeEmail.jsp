<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	
	if (session.getAttribute("faculty") == null && session.getAttribute("empId") == null){
		System.out.println("[CH EMAIL] Direct to CH PW w/o login");
		response.sendRedirect(request.getContextPath() + "/index");	
	}
	else if(request.getParameter("process")==null){
			System.out.println("[EDIT] Direct to EDIT");
		request.getRequestDispatcher("/settings?process=changePassword").forward(request, response);
	}
	//session.setAttribute("saveButton",null);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PUP PASUC Evaluation - Change Email</title>
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
	
	<body>
    <div class="dashboard-main-wrapper">
	<!-- ============================================================== -->
    <!-- Header  -->
    <!-- ============================================================== -->    

       		<div class="dashboard-header">
       		<div class="fixed-top" style="max-height: 110px; background-color: #800000;" >
       		
	       			
	                <a href="index"><img src="assets/images/pasuc-logo.png" alt="logo" style="max-height: 90px; margin-left: 55px; margin-top: 10px;"></a>
		        	
		 			<div style="float: right;">
		        	<ul class="navbar-nav navbar-right-top">
		        	<li class="nav-item dropdown nav-user" style="margin-top: 35px; margin-right: 35px;">
                            <a class="nav-link nav-user-img" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa-lg fas fa-bars pasuc-yelloww"></i>
                            <div class="dropdown-menu dropdown-menu-right nav-user-dropdown">
                                <div class="nav-user-info">
                                     <c:forEach var="f" items="${faculty}">
	                                    <h5 class="text-white nav-user-name"><i class="m-r-10 mdi mdi-account pasuc-color-yellow"></i>${f.firstName} ${f.lastName}</h5>
                                	</c:forEach>
                                </div>
                                <a class="dropdown-item" href="settings?process=editAccount"><i class="fas fa-user mr-2"></i>Edit Account</a>
                                <a class="dropdown-item" href="settings?process=changeEmail"><i class="fas fa-envelope mr-2"></i>Change Email</a>
                                <a class="dropdown-item" href="settings?process=changePassword"><i class="fas fa-asterisk mr-2"></i>Change Password</a>
                                <a class="dropdown-item" href="account?process=logout"><i class="fas fa-power-off mr-2"></i>Logout</a>
                           </div>
                        </li>
		        	</ul>
		        	</div>
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
		<br>
		<a class="btn btn-sm btn-warning" href="javascript:history.back()"><i class="fas fa-angle-double-left"></i>   Back to previous page</a>
		<br><br>
		<div class="splash-container-vemail">
		<div class="card p-2">
			<div class="card-header text-center"><span class="splash-description-credentials">Change Email</span></div>
				<div class="card-body">
					
						<form name="changeEmail" id="chEmail" action="settings?process=changeEmail" method="post" onsubmit="return checkEmail(newEmail)">
						<%-- <div style="color: #FF0000;">${errorMessageEmail}</div> --%>
						
						<div class="form-group row">
						<input class="form-control text-center email-inputmask" style="width: 350px;" type="text" name="newEmail" id="newEmail" placeholder="New Email Address" value="${f.email}" pattern=".+@pup.edu.ph" required oninput="checkEmail(this)">
						</div>
						
						<div class="form-group row">
						<input class="form-control text-center" style="width: 350px;" type="password" name = "password" id="password" placeholder="Enter Password" maxlength="20" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}" title="Must contain at least one number and one uppercase and lowercase letter, and 8-20 characters">
						</div>
							<br>
							<button class="btn btn-warning btn-rounded btn-block" type="submit" name="changeEmailBtn" id="changeEmailBtn" value="Change Email">Save</button>
						</form>
						</div>
						<script language='javascript' type='text/javascript'>
							function checkEmail(email) {
									if(email.value == document.getElementById("newEmail").defaultValue){
										email.setCustomValidity('Email must not be the same with your old one.');
										return false;
									}else{
										email.setCustomValidity('');
										return true;
									}
							}
						</script>
					
	
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
	