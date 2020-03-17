<!-- INDEX: LOGIN REGISTER -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	
//	request.getRequestDispatcher("/account?process=getExistingEmailandId").include(request, response);
	if (session.getAttribute("faculty")!= null && session.getAttribute("empId")!=null && session.getAttribute("email")!=null){
		System.out.println("[INDEX] REDIRECT TO PROFILE from INDEX");
		response.sendRedirect(request.getContextPath() + "/profile");	
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
        <div class="card-header text-center"><span class="splash-description-createacc">Faculty Login</span></div>
            <div class="card-body">
            <span class="splash-description">Please enter your user information.</span>
                <form name="login" id="login" action="profile" method="post">
                    <div class="form-group">
                        <input class="form-control form-control-lg email-inputmask" type="text" name="emailLog" id="emailLog" placeholder="Email Address" required>
                    </div>
                    <div class="form-group">
                        <input class="form-control form-control-lg" type="password" name = "pswLog" id="pswLog" placeholder="Password" maxlength="20" required>
                    </div>
                    <button class="btn btn-rounded btn-warning btn-lg btn-block" type="submit" name = "login" id="login" value="Login" style="margin-right: 125px;">Sign in</button>
                	<div class="text-center">
                                        <div class="card-footer-item">
                                            <a href="forgotpassword" class="card-link" >Forgot Password?</a>
                                        </div>
                                    </div>
                </form>
                </div>

        </div>
        <h5 style="text-align: center;"><a href="pec-login" class="card-link" >Login as PEC</a></h5>
        <h5 style="text-align: center;"><a href="admin" class="card-link" >Login as Admin</a></h5>
    </div>
    
    <!-- ============================================================== -->
    <!-- End of login  -->
    <!-- ============================================================== -->
    	
	<!-- ============================================================== -->
    <!-- create an account  -->
    <!-- ============================================================== -->
         <div class="splash-container-createacc">
        <div class="card">
            <div class="card-header text-center"><span class="splash-description-createacc">Create an Account</span></div>
            <div class="card-body">
            <span class="splash-description">Please fill with your information below.</span>
                <form name="register" id="register" action="account?process=register" method="post">
               <div class="form-group row">
      				<div class="col-lg-4">
             			<input class="form-control EmployeeID-inputmask" type="text" name="empId" id="empId" placeholder="Employee ID Number" maxlength="15" required>
             		</div>
                   	<div class="col-lg-4">
                   	<select name="dept" id="dept" class="form-control" required>
				    	<option value="CE - CIVIL ENGINEERING" id="CE - CIVIL ENGINEERING">CE - CIVIL ENGINEERING</option>
				    	<option value="CE - COMPUTER ENGINEERING" id="CE - COMPUTER ENGINEERING">CE - COMPUTER ENGINEERING</option>
					</select>
                 	</div>
         		</div>
                <div class="form-group row">
      				<div class="col-lg-4">
             			<input class="form-control name-inputmask" type="text" name="fName" id="fName" placeholder="First Name" maxlength="50" required>
             		</div>
                   	<div class="col-lg-4">
                  		<input class="form-control name-inputmask" type="text" name="mName" id="mName" placeholder="Middle Name" maxlength="50">
                 	</div>
                  	<div class="col-lg-4">
                     	<input class="form-control name-inputmask" type="text" name="lName" id="lName" placeholder="Last Name" maxlength="50" required>
                   </div>
         		</div>
         		<div class="form-group row">
      				<div class="col-sm-4">
                  		<input class="form-control address-inputmask" type="text" name="address" id="address" placeholder="Address" maxlength="100" required>
                 	</div>
      				<div class="col-sm-4 ">
             			<input class="form-control phone-inputmask" type="text" name="cNumber" id="cNumber" placeholder="Contact Number" required>
             		</div>
                   	<div class="col-sm-4">
                  		<input type="text" class="form-control email-inputmask" id="email-inputmask" name="email" placeholder="Email Address" required>       
                 	</div>
         		</div>
         		<div class="form-group row">
      				<div class="col-lg-4">
             			<input class="form-control" type="date" name="bDate" id="bDate" placeholder="Date of Birth" required>
             		</div>
                   	<div class="col-lg-4">
                   		<select name="gender" id="gender" required class="form-control">
					    	<option value="FEMALE" id="f">FEMALE</option>
					    	<option value="MALE" id="m">MALE</option>
						</select>
                 	</div>
                 	<div class="col-lg-4">
                 		<h5>Current Accumulated Points:</h5>
                 	</div>
         		</div>
         		<div class="form-group row">
      				<div class="col-lg-4">
             			<input class="form-control"  type="password" name = "password" id="password" placeholder="Password" maxlength="20" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}" title="Must contain at least one number and one uppercase and lowercase letter, and 8-20 characters">
             		</div>
             		<div class="col-lg-4">
             			<input class="form-control" type="password" name = "cPassword" id="cPassword" placeholder="Confirm Password" maxlength="20" required oninput="check(this)">
             		</div>
             		<div class="col-lg-4">
                 		<div class="row">
                 			<div style="width:30%">
             					<input class="form-control points-inputmask" type="number" name="scoreEduc" id="scoreEduc" placeholder="Educ" min="0" max="85" required>
	             			</div>
	             			<div style="width:30%">
	             				<input class="form-control points-inputmask" type="number" name="scoreExp" id="scoreExp" placeholder="Exp" max="25" required>
	             			</div>
	             			<div style="width:30%">
	             				<input class="form-control points-inputmask" type="number" name="scoreProf" id="scoreProf" placeholder="Prof" max="90" required>
	             			</div>
                 		</div>
             		</div>
         		</div>
         		
         		<label class="custom-control custom-checkbox">
        	 		<input type="checkbox" class="custom-control-input" required><span class="custom-control-label">I agree to the Terms and Conditions. (<a target="_blank" class="card-link" href="https://www.privacy.gov.ph/data-privacy-act/"><u>Data Privacy Act</u></a>)</span>
        		</label>    
        		
                    <button class="btn btn-rounded btn-warning btn-lg btn-block" type="submit" name="register" id="register" value="Register">Register</button>
                <script language='javascript' type='text/javascript'>
					    function check(input) {
					        if (input.value != document.getElementById('password').value) {
					            input.setCustomValidity('Passwords did not match.');
					        } else {
					            input.setCustomValidity('');
					        }
					    }
				</script>
                </form>
            </div>
        </div>
    </div>
 	<!-- ============================================================== -->
    <!-- End of create an account  -->
    <!-- ============================================================== -->   
    
    </div>
    </div>
   
    <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="assets/vendor/inputmask/js/jquery.inputmask.bundle.js"></script>
    
    <script>
    $(function(e) {
        "use strict";
        	$(".EmployeeID-inputmask").inputmask("99999"),
            $(".phone-inputmask").inputmask("9999-999-9999"),
            $(".address-inputmask").inputmask({
            	mask: "*{1,100}",
                greedy: !1,
                onBeforePaste: function(n, a) {
                    return (e = e.toLowerCase()).replace("mailto:", "")
                },
                definitions: {
                    "*": {
                        validator: "[0-9A-Za-z#,-. ]",
                        cardinality: 1,
                        casing: "upper"
                    }
                }
            })
            $(".email-inputmask").inputmask({
                mask: "*{1,20}[.*{1,20}][.*{1,20}][.*{1,20}]@gmail.com",
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
            $(".name-inputmask").inputmask({
            	mask: "*{1,50}",
                greedy: !1,
                onBeforePaste: function(n, a) {
                    return (e = e.toLowerCase()).replace("mailto:", "")
                },
                definitions: {
                    "*": {
                        validator: "[A-Za-z ]",
                        cardinality: 1,
                        casing: "upper"
                    }
                }
            })
            $(".points-inputmask").inputmask({
            	mask: "*{1,3}",
                greedy: !1,
                onBeforePaste: function(n, a) {
                    return (e = e.toLowerCase()).replace("mailto:", "")
                },
                definitions: {
                    "*": {
                        validator: "[0-9]",
                        cardinality: 1,
                        
                    }
                }
            })
    });
    </script>
</body>
</html>