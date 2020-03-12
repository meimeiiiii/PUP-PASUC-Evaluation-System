<!-- ADMIN - APPLICATION -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	
	
	if (session.getAttribute("pec")==null && session.getAttribute("pecID")==null && session.getAttribute("pecEMAIL")==null){
			System.out.println("[ABT] Direct to ABT, Redirect to LOGIN");
			response.sendRedirect(request.getContextPath() + "/pec-login");	
	}
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PUP PASUC Evaluation - About</title>
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
                                 <a class="dropdown-item" href="pec-account?process=edit"><i class="fas fa-user mr-2"></i>Edit Account</a>
                                <a class="dropdown-item" href="pec-account?process=changeEmail"><i class="fas fa-envelope mr-2"></i>Change Email</a>
                                <a class="dropdown-item" href="pec-account?process=changePassword"><i class="fas fa-asterisk mr-2"></i>Change Password</a>
                                <a class="dropdown-item" href="pec-account?process=logout"><i class="fas fa-power-off mr-2"></i>Logout</a>
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
    			 <ul class="nav nav-tabs nav-fill" role="tablist">
               		<li class="nav-item">
                    	<a class="nav-link"  href="pec-application?process=view">Application Entries</a>
                 	</li>
	                <li class="nav-item">
              			<a class="nav-link"  href="pec-faculty?process=view">Faculty Members</a>
      	            </li>
      	             <li class="nav-item <%if(session.getAttribute("rights").equals("B")){%> link-hide <%}%>" id="evaltab">
                		<a class="nav-link" href="pec-members?process=view">PEC Members</a>
     	            </li>
     	            <li class="nav-item">
                		<a class="nav-link active"  href="pec-about?process=view">About PUP PASUC</a>
     	            </li>
 				</ul>
 	<!-- ============================================================== -->
	<!-- END TOP NAV  -->
	<!-- ============================================================== -->
	
	<div class="tab-content" id="home-tabs">

				
				<!-- ============================================================== -->
				<!-- ABOUT TAB -->
				<!-- ============================================================== -->
				
       			 <div class="tab-pane fade show active">
       			
             		<div class="row">
             		<div class="col-xl-2" >
                            <div class="sidebar-nav-fixed border-right">
                            <br><br>	
                            	<h4 style="margin-top: 6px; color: #800000;"> A B O U T</h4>
                                <ul class="list-unstyled">
                                    <li><a href="#mission">Mission</a></li>
                                    <li><a href="#vision">Vision</a></li>
                                    <li><a href="#orgchart">Organizational Chart</a></li>
                                    <li><a href="#goals">Goals</a></li>
                                    <li><a href="#objectives">Objectives</a></li>
                                    <li><a href="#committee">Committee</a></li>
                                    <li><a href="#evalnbc461">Evaluation</a></li>
                                    <li><a href="#ratescalenbc461">Rating Scale</a></li>
                                    <li><a href="#salarynbc461">Salary Schedule</a></li>
                                    <li><a href="#contactinfo">Contact Info</a></li>
                                    <li><a href="#top"><i class="fas fa-angle-double-up"></i>   Back to Top</a></li>
                                </ul>
                                <br><br>
                            </div>
                    </div>
             		
             		<div class="col-xl-10">
             		<h2 style="text-align: center; color: #800000;">Polytechnic University of the Philippines <br> Philippine Association of State Universities and Colleges</h2>
             		
             		<div class="page-section" id="mission">
             		<br><br>
             		<h3 style="text-align: center; color: #d39f03;" >Mission</h3>
					<div style="display: flex; justify-content: center;">
					<ul>
					<li>Upgrade the quality or standard of PUP Faculty through regular evaluation of their qualifications.</li>
					<li>Provision of opportunities for a more rational and credible promotion scheme of PUP Faculty.</li>
					<li>Implementation of National Budget Circular No. 461 for a judicious compensation and position classification class for PUP Faculty.</li>
					</ul>
					</div>
					<br><br>
					</div>
					
					<div class="page-section" id="vision">
					<br><br>
					<h3 style="text-align: center; color: #d39f03;">Vision</h3>
					<p style="text-align: center;">Updating the level of professionalism while implementing the objective and efficient promotion criteria <br> for the continuous improvement of Faculty quality or standards.</p>
					<br><br>
					</div>
					
					<div class="page-section" id="orgchart">
					<br><br>
					<h3 style="text-align: center; color: #d39f03;">Organizational Chart</h3>
              		<div style="display: flex; justify-content: center;">
              		<img src="assets/images/org-chart.JPG" alt="PUP PASUC Organizational Chart"  text-align="center">
              		</div>
              		<br><br>
              		</div>
              		
              		<div class="page-section" id="goals">
              		<br><br>
              		<h3 style="text-align: center; color: #d39f03;">Goals</h3>
					<div style="display: flex; justify-content: center;">
					<ul>
					<li>To standardize faculty ranks and compensations that will reflect the quality of PUP as a state institution.</li>
					<li>To improve the desirable quantities and level of professionalism of the PUP Faculty.</li>
					</ul>
					</div>
					<br><br>
					</div>
					
					<div class="page-section" id="objectives">
					<br><br>
					<h3 style="text-align: center; color: #d39f03;">Objectives</h3>
					<div style="display: flex; justify-content: center;">
					<ul>
					<li>To conduct regular evaluation of faculty qualifications in terms of academic, experience and length of service, and professional development</li>
					<li>To provide a rational and credible promotion scheme adhering to the standardized guidelines of Common Criteria of Evaluation (CCE) and Qualitative Contribution Evaluation (QCE).</li>
					<li>To harmonize with the implementation of NBC 461 for proper and appropriate ranking and just compensation of promotable PUP Faculty.</li>
					<li>To assist the PUP administration by performing tasks that may be assigned as an office with core functions and support functions.</li>
					</ul>
					</div>
					<br><br>
					</div>
             		
             		<div class="page-section" id="committee">
             		<br><br>
             		<h3 style="text-align: center; color: #d39f03;">PUP PASUC Evaluation Committee</h3>
             		<p style="text-align: center;"> The PUP PASUC Evaluation Committee is the one responsible for assessing all the faculty in the university <br> in terms of their educational qualification, experiences and professional services, professional development, and achievements/honors. <br> The evaluation is guided by a pointing system and all documents that serve as proof are verified by the committee which will then determine the rank of a faculty.</p>
              		<br><br>
              		</div>
					
					<div class="page-section" id="evalnbc461">
					<br><br>
					<h3 style="text-align: center; color: #d39f03;">PASUC Common Criteria for Evaluation of Faculty (NBC 461)</h3>
					<iframe style="margin: 0 auto; display: block;" src="https://drive.google.com/file/d/1twGf0isOkjhqbjlgGMpFUz4PueOkUTm3/preview" width="70%" height="700"></iframe>
					<br><br>
					</div>
					
					<div class="page-section" id="ratescalenbc461">
					<br><br>
					<h3 style="text-align: center; color: #d39f03;">Rating Scale for NBC 461 - 7th Cycle</h3>
					<!-- <iframe style="margin: 0 auto; display: block;" src="https://drive.google.com/file/d/1twGf0isOkjhqbjlgGMpFUz4PueOkUTm3/preview" width="70%" height="700"></iframe> -->
					  		<table class="table table-bordered table-hover" style="width:100%">
					             <!-- HEADER -->
					               <thead>
						               <tr>
						               		<th>Minimum Points</th>
							               	<th>Maximum Points</th>
							               	<th>Name</th>
							               	<th>Rank ID</th>
						               </tr>
					               </thead>
					               
					               <!-- INSERT VARIABLES -->
					               <c:forEach var="cr" items="${cce_rank}">
						               <tbody>
						               <tr>
							               	<td style="width: 15%;"><c:out value="${cr.ptsMin}" /></td>
											<td style="width: 15%;"><c:out value="${cr.ptsMax}" /></td>
							               	<td style="width: 7%;"><c:out value="${cr.rankName}" /></td>
						               		<td style="width: 7%;"><c:out value="${cr.rankId}" /></td>
						               </tr>
						               </tbody>
					        	 	</c:forEach>
					         </table>
					 
					<br><br>
					</div>
				
					<div class="page-section" id="salarynbc461">	
					<br><br>		
					<h3 style="text-align: center; color: #d39f03;">Fourth Tranche Salary Schedule of Promoted Faculty</h3>
					<iframe style="margin: 0 auto; display: block;" src="https://drive.google.com/file/d/1twGf0isOkjhqbjlgGMpFUz4PueOkUTm3/preview" width="70%" height="700"></iframe>
					<br><br>
					</div>
					
					<div class="page-section" id="contactinfo">
					<br><br>
					<h3 style="text-align: center; color: #d39f03;">Contact Information</h3>
					<div style="display: flex; justify-content: center;">
					<p>
					<i class="fas fa-building"></i>   2nd Floor Cafe Hasmin, Hasmin Building, PUP Marcelo H. Del Pilar Campus<br>
					<i class="fas fa-envelope"></i>   *insert email*<br>
					<i class="fas fa-phone-square"></i>   *insert contact number*<br>
					</p>
					</div>
					</div>
              	</div>
              	</div>
              	</div>
      
      
       			<!-- ============================================================== -->
				<!-- END OF ABOUT TAB -->
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
    <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src='assets/libs/js/main-js.js'></script>
   
</body>
</html>