<!-- ADMIN - APPLICATION -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	

	if (session.getAttribute("pec")==null && session.getAttribute("pecID")==null && session.getAttribute("pecEMAIL")==null){
			System.out.println("[APP] Direct to APP, Redirect to LOGIN");
			response.sendRedirect(request.getContextPath() + "/pec-login");	
	}
//	else{
//		request.getRequestDispatcher("pec-account?process=getUser").include(request, response);
//		request.getRequestDispatcher("pec-application?process=get").include(request, response);
//	}
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
                            <a class="nav-link nav-user-img" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa-lg fas fa-bars pasuc-yelloww"></i>
                            <div class="dropdown-menu dropdown-menu-right nav-user-dropdown">
                                <div class="nav-user-info">
                                    <c:forEach var="p" items="${pec}">
                                    <h5 class="text-white nav-user-name"><i class="m-r-10 mdi mdi-account pasuc-color-yellow"></i>${p.lastName}, ${p.firstName}</h5>
                                	</c:forEach>
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
		<div class="col-xl-12" style="margin-top: 100px;">

 	<!-- ============================================================== -->
	<!-- END TOP NAV  -->
	<!-- ============================================================== -->
				
			
				<!-- ============================================================== -->
				<!-- PROFILE TAB -->
				<!-- ============================================================== -->
				<div class="row">
				<div class="col-xl-1"></div>
				<div class="col-xl-10">
       			
	                
	                	<br>
	                    <c:forEach var="f" items="${fac}">
	                    	<div class="card">
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
	                                                        <span class=" mb-2 d-xl-inline-block d-block ml-xl-4"><i class="mdi mdi-calendar-clock pasuc-color-yellow"></i>  Last Rank Application: *DATE* </span>
	                                                    </p>
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="border-top border-bottom user-social-box">
	                                    	<div class="user-social-media d-xl-inline-block"><span class="pasuc-color-red"> <i class="fas fa-male"></i>/<i class="fas fa-female"></i></span><span> ${f.gender}</span></div>
	                                    	<div class="user-social-media d-xl-inline-block"><span class="pasuc-color-red"> <i class="fas fa-birthday-cake"></i></span><span> ${f.birthDate}</span></div>
	                                    	<div class="user-social-media d-xl-inline-block"><span class="pasuc-color-red"> <i class="mdi mdi-email"></i></span><span> ${f.email}</span></div>
	                                    	<div class="user-social-media d-xl-inline-block"><span class="pasuc-color-red"> <i class="fas fa-phone"></i></span><span> ${f.contactNumber}</span></div>
	                                    	<div class="user-social-media d-xl-inline-block"><span class="pasuc-color-red"> <i class="fas fa-home"></i></span><span> ${f.address}</span></div>
	                                </div>
	                                </div>
	                            </div>
	                        </div>
	                   </c:forEach>
	             
             		
             		<div class="card" style="width: 400px; margin: 0 auto;">
					            <div class="card-header text-center"><span class="splash-description-credentials">Applications</span></div>
					            <div class="card-body text-center">
					             <c:forEach var="app" items="${app}">
					            
					            <a href="#viewModalApplication" class="btn btn-rounded btn-outline-warning btn-block" data-toggle="modal">ID #${app.appId}</a>
					            <br>
					            
					            <!-- Modal - view Application -->
                                                <div class="modal modal-lg fade" id="viewModalApplication">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                        	
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">ID #${app.appId}</h4>
                                                                <a class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span></a>
                                                            </div>
                                                            <div class="modal-body">
																<br>                                                             
											               		<h3 style="text-align: center;"> ${app.newRank} </h3> <br>
					            
					            	<table class="table table-bordered" style="width: 100%">
					            	
					                <!-- HEADER -->
					                <thead>
					                <tr>
					                	<th style="width: 50%;">Major Components</th>
					                	<th style="width: 16%;">Total Points</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					                <tbody>
					                <tr>
					                	<td>Educational Qualification</td>
					                	<td>${app.scoreEduc}/85</td>
					                	
					                </tr>
					                <tr>
					                	<td>Experience and Professional Services</td>
					                	<td>${app.scoreExp}/25</td>
					                </tr>
					                <tr>
					                	<td>Professional Development Achievements and Awards</td>
					                	<td>${app.scoreProf}/90</td>
					                </tr>
					                <tr>
					                	<td><b>GRAND TOTAL POINTS</b></td>
					                	<td><b>${app.total}/200</b></td>
					                </tr>
					                </tbody>
					                </table>
					                
					                <br><br>
					                <h4 style="text-align: center;"> Credentials </h4> <br>
					                
					                <table class="table table-bordered" style="width:100%">
					                <!-- HEADER -->
					                <thead>
					                <tr>
					                	<th>Doc ID</th>
					                	<th>Type</th>
					                	<th>Subtype</th>
					                	<th>Title</th>
					                	<th>PDF File</th>
					                	<th>Points</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					                <tbody>
					                <c:forEach var="c" items="${cred_educ}">
					                	<tr style=" padding:0px"><td colspan=6><b>Educational Qualification</b></td></tr>
					                	
					                 <c:if test="${c.appId eq app.appId}">
						                <tr>
						                	<td>${c.credId}</td>
						                	<td>${c.type}</td>
						                	<td>${c.subtype}</td>
						                	<td>${c.title}</td>
						                	<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c.credId}" target="_blank">View Document</a></div></td>
						                	<td>${c.score}</td>
						                </tr>
					                 </c:if>
					                </c:forEach>
					                <c:forEach var="c" items="${cred_exp}">
					                	<tr><td colspan=6><b>Experience and Length of Service</b></td></tr>
					                 <c:if test="${app.appId eq c.appId}">
						                <tr>
						                	<td>${c.credId}</td>
						                	<td>${c.type}</td>
						                	<td>${c.subtype}</td>
						                	<td>${c.title}</td>
						                	<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c.credId}" target="_blank">View Document</a></div></td>
						                	<td>${c.score}</td>
						                </tr>
					                 </c:if>
					                </c:forEach>
					                <c:forEach var="c" items="${cred_prof}">
					                	<tr><td colspan=6><b>Professional Development / Achievements and Honors</b></td></tr>
					                 <c:if test="${c.appId eq app.appId}">
						                <tr>
						                	<td>${c.credId}</td>
						                	<td>${c.type}</td>
						                	<td>${c.subtype}</td>
						                	<td>${c.title}</td>
						                	<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c.credId}" target="_blank">View Document</a></div></td>
						                	<td>${c.score}</td>
						                </tr>
					                 </c:if>
					                </c:forEach>
					                </tbody>
					                </table>
																<br>
					  										</div>
                                                        </div>
                                                    </div>
                                                </div>
					                </c:forEach>
					                 </div>
						        	</div>
					            	<br><br>
					            	
					            	
					            
       			</div>
       			<div class="col-xl-1"></div>
         		</div>	
       			<!-- ============================================================== -->
				<!-- PROFILE TAB -->
				<!-- ============================================================== -->
				
       			
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
    <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src="assets/libs/js/main-js.js"></script>

    
   
</body>
</html>