<!-- ADMIN - CONTENT MANAGEMENT -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	
//	request.getRequestDispatcher("account?process=viewHome").include(request, response);
//	if (session.getAttribute("faculty")==null && session.getAttribute("empId")==null && session.getAttribute("email")==null){
//		System.out.println("[CRED] Direct to CRED, Redirect to INDEX");
//		response.sendRedirect(request.getContextPath() + "/index");	
//	}
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PUP PASUC Evaluation - Settings</title>
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
	    <link rel="stylesheet" href="assets/vendor/bootstrap-colorpicker/%40claviska/jquery-minicolors/jquery.minicolors.css">
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
                                    <h5 class="text-white nav-user-name"><i class="m-r-10 mdi mdi-account pasuc-color-yellow"></i>*NAME*</h5>
                                </div>
                                <a class="dropdown-item" href="editacct"><i class="fas fa-user mr-2"></i>Edit Account</a>
                                <a class="dropdown-item" href="changeemail"><i class="fas fa-envelope mr-2"></i>Change Email</a>
                                <a class="dropdown-item" href="changepw"><i class="fas fa-asterisk mr-2"></i>Change Password</a>
                                <a class="dropdown-item" href="loginregisterholder"><i class="fas fa-power-off mr-2"></i>Logout</a>
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
		<a class="btn btn-sm btn-warning" href="dir-about"><i class="fas fa-angle-double-left"></i>   Back to Application Entries</a>
		<br><br>
		
		<div class="row">
             		<div class="col-xl-2" >
                            <div class="sidebar-nav-fixed border-right">
                            <br>
                            	<h4 style="margin-top: 6px; color: #800000;"> A B O U T</h4>
                                <ul class="list-unstyled">
                                    <li><a href="#appearance">Appearance</a></li>
                                    <li><a href="#about">About</a></li>
                                    <li><a href="#advanced">Advanced</a></li>
                                    <li><a href="#top"><i class="fas fa-angle-double-up"></i>   Back to Top</a></li>
                                </ul>
                                <br><br>
                            </div>
                    </div>
             		
             		<div class="col-xl-10">
             		
             	<div class="splash-container-contentmgmt">
		<div class="card p-2">
			<div class="card-header text-center"><span class="splash-description-credentials">Content Management</span></div>
				<form name="fAppearance" id="fAppearance" action="admin-content-management?process=saveAppearance" method="post">	
				<div class="card-body">
				<h2 id="appearance">Appearance</h2><br>
					<div class="row">
						<div class="col-xl-4 form-group">
        	                <label for="fcolor">Font Color</label>
            	            <input type="text" name="fcolor" id="fcolor" class="form-control demo" data-position="bottom right" value=<c:out value="${s.fontColor}"/>>
       	                </div>
       	                
       	                <div class="col-xl-4 form-group">
        	                <label for="color1">Color #1</label>
            	            <input type="text" name="color1" id="color1" class="form-control demo" data-position="bottom right" value="<c:out value="${s.color1}"/>">
       	                </div>
       	                
       	                <div class="col-xl-4 form-group">
        	                <label for="color2">Color #2</label>
            	            <input type="text" name="color2"  id="color2" class="form-control demo" data-position="bottom right" value="<c:out value="${s.color2}"/>">
       	                </div>
       	           	</div>     
							<br>
							<button class="btn btn-md btn-warning btn-rounded center" type="submit" name="saveAppearanceBtn" id="saveAppearanceBtn" value="appearance">Save Appearance Changes</button>						
				</div>
				</form>
						
			<form name="fAbout" id="fAbout" action="admin-content-management?process=saveAbout" method="post">				
			<div class="card-body">
				<h2 id="about">About</h2><br>
					<div class="row">
						<div class="col-xl-6 form-group">
        	                <label for="mission">Mission</label>
        	                <textarea class="form-control" name="mission" id="mission" rows="3"><c:out value="${s.mission}"/></textarea>
       	                </div>
       	                
       	           		<div class="col-xl-6 form-group">
        	                <label for="vision">Vision</label>
        	                <textarea class="form-control" name="vision"  id="vision" rows="3"><c:out value="${s.vision}"/></textarea>
       	                </div>
       	           	</div> 
       	           	
       	           	<div class="row">
						<div class="col-xl-6 form-group">
        	                <label for="goals">Goals</label>
        	                <textarea class="form-control" name="goals" id="goals" rows="3"><c:out value="${s.goals}"/></textarea>
       	                </div>
       	                
       	           		<div class="col-xl-6 form-group">
        	                <label for="objectives">Objectives</label>
        	                <textarea class="form-control" name="objectives" id="objectives" rows="3"><c:out value="${s.objectives}"/></textarea>
       	                </div>
       	           	</div> 
       	           	
       	           	<div class="row">
						<div class="col-xl-4 form-group">
        	                <label for="evaluation">Evaluation</label>
                  		<input class="form-control" type="text" name="evaluation"  id="Evaluation" placeholder="Google Drive link" value="<c:out value="${s.evaluation}"/>" maxlength="100">
       	                </div>
       	                
       	           		<div class="col-xl-4 form-group">
        	                <label for="ratescale">Rating Scale</label>
                  		<input class="form-control" type="text" name="ratingScale"  id="ratingScale" placeholder="Google Drive link" value="<c:out value="${s.ratingScale}"/>" maxlength="100">
       	                </div>
       	                
       	                <div class="col-xl-4 form-group">
        	                <label for="salarysched">Salary Schedule</label>
                  		<input class="form-control" type="text" name="salarySchedule" id="salarySchedule" placeholder="Google Drive link" value="<c:out value="${s.salarySchedule}"/>" maxlength="100">
       	                </div>
       	           	</div> 
       	           	
       	           	<div class="row">
						<div class="col-xl-4 form-group">
        	                <label for="address">Office Address</label>
                  		<input class="form-control" type="text" name="officeAddress" id="officeAddress" value="<c:out value="${s.officeAddress}"/>" maxlength="100">
       	                </div>
       	                
       	           		<div class="col-xl-4 form-group">
        	                <label for="email">Email Address</label>
                  		<input class="form-control" type="text" name="emailAddress" id="emailAddress" value="<c:out value="${s.emailAddress}"/>" maxlength="50">
       	                </div>
       	                
       	                <div class="col-xl-4 form-group">
        	                <label for="contact">Contact Number</label>
                  		<input class="form-control" type="text" name="contactNumber" id="contactNumber" value="<c:out value="${s.contactNumber}"/>" maxlength="50">
       	                </div>
       	           	</div> 
       	           	           	    
							<br>
							<button class="btn btn-md btn-warning btn-rounded center" type="submit" name="saveAboutBtn" id="saveAboutBtn" value="Change Email">Save About Changes</button>						
			</div>
			</form>	
				<div class="card-body">
				<h2 id="advanced">Advanced</h2><br>
					<div class="row">
						<div class="col-xl-4 form-group">
        	                <label for="school">School Name</label>
                  		<input class="form-control" type="text" name="schoolName" id="schoolName" value="<c:out value="${s.schoolName}"/>" maxlength="50">
       	                </div>
       	                
       	           		<div class="col-xl-4 form-group">
        	                <label for="emaildomain">Email Domain Address</label>
                  		<input class="form-control emaildomain-inputmask" type="text" name="emailDomain" id="emailDomain" value="<c:out value="${s.emailDomain}"/>" maxlength="50">
       	                </div>
       	                
       	                <div class="col-xl-4 form-group">
        	                <label for="logo">Logo</label>
                  		<input  class="form-control" type="file" name="imagelogo" id="imagelogo" accept=".png">
       	                </div>
       	           	</div>      
							<br>
							<button class="btn btn-md btn-warning btn-rounded center" type="submit" name="saveAdvancedBtn" id="saveAdvancedBtn" value="Change Email">Save Advanced Changes</button>						
				</div>
				
					            	</div>
					            	
					            	</div>
             		
             		
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
            $(".emaildomain-inputmask").inputmask({
                mask: "@*{1,20}[.*{1,20}][.*{1,20}][.*{1,20}]",
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
    
    <script src="assets/vendor/bootstrap-colorpicker/jquery-asColor/dist/jquery-asColor.min.js"></script>
    <script src="assets/vendor/bootstrap-colorpicker/jquery-asGradient/dist/jquery-asGradient.js"></script>
    <script src="assets/vendor/bootstrap-colorpicker/jquery-asColorPicker/dist/jquery-asColorPicker.min.js"></script>
    <script src="assets/vendor/bootstrap-colorpicker/%40claviska/jquery-minicolors/jquery.minicolors.min.js"></script>
    <script>
    $('.demo').each(function() {
        //
        // Dear reader, it's actually very easy to initialize MiniColors. For example:
        //
        //  $(selector).minicolors();
        //
        // The way I've done it below is just for the demo, so don't get confused
        // by it. Also, data- attributes aren't supported at this time...they're
        // only used for this demo.
        //
        $(this).minicolors({
            control: $(this).attr('data-control') || 'hue',
            defaultValue: $(this).attr('data-defaultValue') || '',
            format: $(this).attr('data-format') || 'hex',
            keywords: $(this).attr('data-keywords') || '',
            inline: $(this).attr('data-inline') === 'true',
            letterCase: $(this).attr('data-letterCase') || 'lowercase',
            opacity: $(this).attr('data-opacity'),
            position: $(this).attr('data-position') || 'bottom left',
            swatches: $(this).attr('data-swatches') ? $(this).attr('data-swatches').split('|') : [],
            change: function(value, opacity) {
                if (!value) return;
                if (opacity) value += ', ' + opacity;
                if (typeof console === 'object') {
                    console.log(value);
                }
            },
            theme: 'bootstrap'
        });

    });
    </script>
    
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
    
</body>
</html>
	