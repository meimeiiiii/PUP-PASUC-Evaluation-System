<!-- PROFILE -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	

	if (session.getAttribute("faculty")==null && session.getAttribute("empId")==null && session.getAttribute("email")==null){
		if(request.getParameter("emailLog")!=null){
			request.getRequestDispatcher("account?process=login").include(request, response);
		}else{
			System.out.println("[CRED] Direct to CRED, Redirect to INDEX");
			response.sendRedirect(request.getContextPath() + "/index");	
		}
	}else{
		request.getRequestDispatcher("account?process=getUser").include(request, response);
	}
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PUP PASUC Evaluation - Home</title>
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
		        	
		 			<div style="float: right;">
		        	<ul class="navbar-nav navbar-right-top">
		        	<li class="nav-item dropdown nav-user" style="margin-top: 35px; margin-right: 35px;">
                            <a class="nav-link nav-user-img" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa-lg fas fa-bars pasuc-color-yellow"></i>
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
		<div class="col-xl-12" style="margin-top: 100px;">
		
			<!-- <div class="tab-regular">
    			 <ul class="nav nav-tabs nav-fill">
               		<div style="width: 24.5%;">
               		<li>
                    	<button class="nav-link active btn-block"  href="home-profile">Profile</button>
                 	</li>
                 	</div>
                 	<div style="width: 24.5%; margin-left: 6px;">
                 	<li>
              			<button class="nav-link btn-block"  href="home-credentials">Upload Credentials</button>
      	            </li>
      	            </div>
                 	<div style="width: 24.5%; margin-left: 6px;">
                 	<li>
                		<button class="nav-link btn-block"  href="home-application">Apply for Re-ranking</button>
     	            </li>
     	            </div>
                 	<div style="width: 24.5%; margin-left: 6px;">
                 	<li>
                		<button class="nav-link btn-block"  href="home-about">About PUP PASUC</button>
     	            </li>
     	            </div>
 				</ul> -->
		
 			<div class="tab-regular">
    			 <ul class="nav nav-tabs nav-fill" >
               		<li class="nav-item">
                    	<a class="nav-link active"  href="profile">Profile</a>
                 	</li>
	                <li class="nav-item">
              			<a class="nav-link"  href="credential?process=view">Upload Credentials</a>
      	            </li>
         	        <li class="nav-item">
                		<a class="nav-link"  href="application?process=view">Apply for Re-ranking</a>
     	            </li>
     	            <li class="nav-item">
                		<a class="nav-link"  href="about">About PUP PASUC</a>
     	            </li>
 				</ul>
 	<!-- ============================================================== -->
	<!-- END TOP NAV  -->
	<!-- ============================================================== -->
				<div class="tab-content" id="home-tabs">
			
				<!-- ============================================================== -->
				<!-- PROFILE TAB -->
				<!-- ============================================================== -->
       			<div class="tab-pane fade show active">
       				
       				<%-- <c:forEach var="faculty" items="${faculty}">
						<table id="accDetails">
								<tr>
									<td><label>Name</label></td>
									<td>${faculty.lastName}, ${faculty.firstName} ${faculty.middleName}</td> 
								</tr>
								<tr>
									<td><label>Employee ID</label></td>
									<td> ${faculty.empId} </td> 
								</tr>
								<tr>
									<td><label>Department</label></td>
									<td> ${faculty.department} </td> 
								</tr>
								<tr>
									<td><label>Rank:</label></td>
									<td> TENTATIVE </td> 
								</tr>
								<tr>
									<td><label>Gender</label></td>
									<td> ${faculty.gender} </td> 
								</tr>
								<tr>
									<td><label>Date of Birth</label></td>
									<td> ${faculty.birthDate} </td> 
								</tr>
								<tr>
									<td><label>Email Address</label></td>
									<td> ${faculty.email} </td> 
								</tr>
								<tr>
									<td><label>Contact Number</label></td>
									<td> ${faculty.contactNumber} </td> 
								</tr>
								<tr>
									<td><label>Address</label></td>
									<td> ${faculty.address} </td> 
								</tr>
						</table>
					</c:forEach> --%>
					
       			<c:forEach var="f" items="${faculty}">
	                <div class="row">
	                    <div class="col-xl-12">
	                        <div class="card influencer-profile-data">
	                            <div class="card-body">
	                                <div class="row">
	                                        <div class="col-xl-10 col-lg-8 col-md-8 col-sm-8 col-12">
	                                            <div class="user-avatar-info">
	                                                <div class="m-b-20">
	                                                    <div class="user-avatar-name">
	                                                        <h2 class="mb-1"><i class="m-r-10 mdi mdi-account pasuc-color-yellow"></i>${f.lastName}, ${f.firstName} ${f.middleName}</h2>
	                                                    </div>
	                                                    <div class="rating-star  d-inline-block">
	                                                        <i class="fa fa-star"></i>
	                                                        <p class="d-inline-block text-dark">${f.rank}</p>
	                                                    </div>
	                                                </div>
	                                                <div class="user-avatar-address">
	                                                    <p>
	                                                        <span class="d-xl-inline-block d-block mb-2"><i class="fas fa-hashtag pasuc-color-yellow"></i>  Employee ID: ${f.empId}</span>
	                                                        <span class="mb-2 ml-xl-4 d-xl-inline-block d-block"><i class="far fa-building pasuc-color-yellow"></i>  College/Department: ${f.department} </span>
	                                                    </p>
	                                                </div>
	                                           </div>
	                                        </div>
	                                    </div>
	                                    <div class="border-top border-bottom user-social-box">
	                                    	<div class="user-social-media d-xl-inline-block"><span class="mr-2 pasuc-color-red"><i class="fas fa-male"></i>/<i class="fas fa-female"></i></span><span>${f.gender}</span></div>
	                                    	<div class="user-social-media d-xl-inline-block"><span class="mr-2 pasuc-color-red"> <i class="fas fa-birthday-cake"></i></i></span><span>${f.birthDate}</span></div>
	                                    	<div class="user-social-media d-xl-inline-block"><span class="mr-2 pasuc-color-red"> <i class="mdi mdi-email"></i></span><span>${f.email}</span></div>
	                                    	<div class="user-social-media d-xl-inline-block"><span class="mr-2 pasuc-color-red"> <i class="fas fa-phone"></i></span><span>${f.contactNumber}</span></div>
	                                    	<div class="user-social-media d-xl-inline-block"><span class="mr-4 pasuc-color-red"> <i class="fas fa-home"></i></span><span>${f.address}</span></div>
	                                </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    </c:forEach>
	             <br><br>
             		<div class="row">
             		<!-- <div class="card" style="max-width: 60%;margin-left: 3.5%;">
					            <div class="card-header text-center"><span class="splash-description-credentials">Evaluation Summary (*DATE*)</span></div>
					            <div class="card-body">
					            
					            	<h4 style="margin-bottom: 2px;">Recommended Rank: *RANK*</h4>
					            
					            	<table class="table table-bordered table-striped-evalsum" style="width:100%">
					                HEADER
					                <thead>
					                <tr>
					                	<th style="width: 50%;">Major Components</th>
					                	<th style="width: 16%;">Previous Points as of: *DATE*</th>
					                	<th style="width: 17%;">Additional Points:</th>
					                	<th style="width: 16%;">Total Points</th>
					                </tr>
					                </thead>
					                
					                INSERT VARIABLES
					                <tbody>
					                <tr>
					                	<td>Educational Qualification</td>
					                	<td>*55*</td>
					                	<td>*25*</td>
					                	<td>*80*</td>
					                	
					                </tr>
					                <tr>
					                	<td>Experience and Professional Services</td>
					                	<td>*20*</td>
					                	<td>*5*</td>
					                	<td>*25*</td>
					                </tr>
					                <tr>
					                	<td>Professional Development Achievements and Awards</td>
					                	<td>*55*</td>
					                	<td>*20*</td>
					                	<td>*75*</td>
					                </tr>
					                </tbody>
					                </table>
					                
					                <br><br>
					            
					                <table class="table table-bordered table-striped-evalsum" style="width:100%">
					                HEADER
					                <thead>
					                <tr>
					                	<th style="width: 50%;">Local Evaluation Committee</th>
					                	<th style="width: 50%;">University Review Committee</th>
					                </tr>
					                </thead>
					                
					                INSERT VARIABLES
					                <tbody>
					                <tr>
					                	<td>*Evaluation Committee 1*</td>
					                	<td>*Review Committee 1*</td>
					                	
					                </tr>
					                <tr>
					                	<td>*Evaluation Committee 2*</td>
					                	<td>*Review Committee 2*</td>
					                	
					                </tr>
					                <tr>
					                	<td>*Evaluation Committee 3*</td>
					                	<td>*Review Committee 3*</td>
					                	
					                </tr>
					                </tbody>
					                </table>
					                
						        	</div>
					            	</div> -->
					            	<br><br>
					          <div class="splash-container-login">  	
					          <div class="card" style="max-width: 100%;">
					            <div class="card-header text-center"><span class="splash-description-credentials">Activity Log</span></div>
					            <div class="card-body">
					            
					            
					            
					            	<table class="table table-striped" style="width:100%">
					                <!-- HEADER -->
					                <thead>
					                <tr>
					                	<th style="width: 30%;">Timestamp</th>
					                	<th style="width: 70%;">Activity</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					                <c:forEach var="act" items="${act_log}">
					                <tbody>
					                <tr>
					                	<td style="width: 30%;"><c:out value="${act.timestamp}" /></td>
					                	<td style="width: 70%;"><c:out value="${act.activityName}" /></td>
					                </tr>
					                </tbody>
					            </c:forEach>
					                </table>
					                </div>
					                </div>
					                
					                <br><br>
					                    
						        	</div>
					            	</div>
       			</div>
         			
       			<!-- ============================================================== -->
				<!-- PROFILE TAB -->
				<!-- ============================================================== -->
				
				
				
				
       			
					</div>
				</div>
			</div>
		</div>
           		<!-- ============================================================== -->
             	<!-- END TOP NAV CODE-->
             	<!-- ============================================================== --> 
             	

	
    <!-- ============================================================== -->
    <!-- Java Script -->
    <!-- ============================================================== --> 
    <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    
   
</body>
</html>