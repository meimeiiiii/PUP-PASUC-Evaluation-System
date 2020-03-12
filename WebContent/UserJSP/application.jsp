<!-- APP -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	
	request.getRequestDispatcher("account?process=getUser").include(request, response);
//	request.getRequestDispatcher("account?process=getCred").include(request, response);
	if (session.getAttribute("faculty")==null && session.getAttribute("empId")==null && session.getAttribute("email")==null){
		System.out.println("[APP] Direct to APP, Redirect to INDEX");
		response.sendRedirect(request.getContextPath() + "/index");	
	}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PUP PASUC Evaluation - Application</title>
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
		<div  id="top"></div>
		<div class="col-xl-12" style="margin-top: 100px;">
			
 				
 			<div class="tab-regular">
    			 <ul class="nav nav-tabs nav-fill" role="tablist">
               		<li class="nav-item">
                    	<a class="nav-link"  href="profile">Profile</a>
                 	</li>
	                <li class="nav-item">
              			<a class="nav-link"  href="credential?process=view">Upload Credentials</a>
      	            </li>
         	        <li class="nav-item">
                		<a class="nav-link active"  href="application?process=view">Apply for Re-ranking</a>
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
				<!-- APPLICATION TAB -->
				<!-- ============================================================== -->
				
               		<div class="tab-pane fade  show active">
               			<div class="row">
               			<div class="col-xl-2" >
                            <div class="sidebar-nav-fixed border-right">
                            	<div class="text-center">
                            	<br><br>
                            	</div>
                                <ul class="list-unstyled">
                                <h4 style="margin-top: 6px; color: #800000;">A P P L Y</h4>
                                    <li><a href="#educ">Qualification</a></li>
                                    <li><a href="#exprof">Experience</a></li>
                                    <li><a href="#profdev">Achievements</a></li>
                                    <li><a href="#top"><i class="fas fa-angle-double-up"></i>   Back to Top</a></li>
                                </ul>
                               <!-- Button trigger modal -->
                                                <button href="#" class="btn btn-rounded btn-outline-warning" data-toggle="modal" data-target="#applyModal" <% if(session.getAttribute("pendingApp")!=null){%> disabled <%}%>>
                                                        <i class="fas fa-plus-circle"></i>   New Application</button>
                                                
							<br><br><br>
                            </div>
                    	</div>
                    	
                    	<!-- Modal -->
                    	
                    	<form name="submitAppForm" id="submitAppForm" method="post" action="application?process=submit" enctype='multipart/form-data' >
                                                <div class="modal modal-lg fade" id="applyModal">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">New Application</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                                            <div class="modal-body">
                                                             
                                                             
               		<h5>Upload Application Letter</h5>
					<div style="width: 40%; margin-left:30px;margin-top:5px;">
							<input  class="form-control" type="file" name="fileinput_letter" id="fileinput_letter" accept=".pdf" required>
					</div>    				
					<br>
					
					<table class="table table-striped" style="width:100%;">
					                <!-- HEADER -->
					                <thead style="background-color: #ffc108">
					                <tr>
					                	<th style="width: 30%;">Major Components</th>
					                	<th style="width: 16%;">Points as of: 
					                		<c:forEach var="a" items="${latestApp}">
					                			<c:choose>
					                				<c:when test="${a.appId != 0}"> ${a.dtApproved}</c:when>
					                				<c:otherwise> now </c:otherwise>
					                			</c:choose>
					                		</c:forEach>
					                	</th>
					                	<th style="width: 17%;">Additional Points:
					                	</th>
					                	<th style="width: 16%;">Total Points</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					                <tbody>
					                 <tbody>
					                <tr>
					                	<td>Educational Qualification</td>
					                	<td>
					                	<c:set var="currentTotal1" value="${0}"/>
					                		<c:forEach var="a" items="${latestApp}">
					                			<c:choose>
					                				<c:when test="${a.appId == 0}"> <c:set var="currentTotal1" value="${a.scoreEduc}" /></c:when>
					                				<c:otherwise> <c:set var="currentTotal1" value="${0}" /> </c:otherwise>
					                			</c:choose>
					                		</c:forEach>
					                		 ${currentTotal1}
					                	</td>
					                	<td>
					                	<c:set var="additional" value="${0}"/>
											<c:forEach var="c_educ" items="${cred_educ}">
											   <c:set var="additional1" value="${additional1 + c_educ.score}" />
											</c:forEach>
											
									        ${additional1}
					                	</td>
					                	<td>
					                		<c:set var="newTotal1" value="${currentTotal1+additional1}"/>
					                		<c:if test="${newTotal1 > 85}">
												<c:set var="newTotal" value="85" />
											</c:if>
					                		${newTotal1}
					                	</td>
					                	
					                </tr>
					                <tr>
					                	<td>Experience and Length of Service</td>
					                	<td>
					                		<c:forEach var="a" items="${latestApp}">
					                			<c:choose>
					                				<c:when test="${a.appId == 0}"> ${a.scoreExp}</c:when>
					                				<c:otherwise> 0 </c:otherwise>
					                			</c:choose>
					                		</c:forEach>
					                	</td>
					                	<td>
						                	<c:set var="additional2" value="${0}"/>
												<c:forEach var="c_exp" items="${cred_exp}">
												   <c:set var="additional2" value="${additional2 + c_exp.score}" />
												</c:forEach>
												
										        ${additional2}
						                	</td>
					                	<td>
					                		<c:set var="newTotal2" value="${currentTotal2+additional2}"/>
					                		<c:if test="${newTotal2 > 25}">
												<c:set var="newTotal2" value="25" />
											</c:if>
					                			${newTotal2}
					                	</td>
					                </tr>
					                <tr>
					                	<td>Professional Development Achievements and Awards</td>
					                	<td>
					                		<c:forEach var="a" items="${latestApp}">
					                			<c:choose>
					                				<c:when test="${a.appId == 0}"> ${a.scoreProf}</c:when>
					                				<c:otherwise> 0 </c:otherwise>
					                			</c:choose>
					                		</c:forEach>
					                	</td>
					                	<td>
						                	<c:set var="additional3" value="${0}"/>
												<c:forEach var="c_prof" items="${cred_prof}">
												   <c:set var="additional3" value="${additional3 + c_prof.score}" />
												</c:forEach>
												
										        ${additional3}
						                	</td>
					                	<td>
					                		<c:set var="newTotal3" value="${currentTotal3+additional3}"/>
					                		<c:if test="${newTotal3 > 90}">
												<c:set var="newTotal3" value="90" />
											</c:if>
					                			${newTotal3}
					                	</td>
					                </tr>
					                </tbody>
					                </tbody>
					                </table>
					                <br>
					                
					                <h4 style="text-align: center;">
					                <table  align="center">
					                <thead>
					                <tr>
					                <th style="width: 37%;">
					                	 <c:forEach var="f" items="${faculty}">
					                	 	${f.scoreEduc+f.scoreExp+f.scoreProf}
					                		<br>
					                		${f.rank}
					                	</c:forEach>
					                </th>
					                <th style="width: 25%;"><i class="fas fa-arrow-right pasuc-color-red"></i></th>
					                <th style="width: 37%;">
					                	<c:set var="newOverallTotal" value="${newTotal1+newTotal2+newTotal3}"/>	
						               ${newOverallTotal}
						               <br>
						                <c:forEach var="cr" items="${cr}">
						                
						                	<c:if test="${(cr.ptsMax > newOverallTotal) and (cr.ptsMin < newOverallTotal)}">
						                		${cr.rankName}
						                	</c:if>
						                </c:forEach>
						            </th>
					                </tr>
					                </thead>
					                </table>
					                </h4>
					                
                                                            </div>
                                                            <div class="modal-footer">
                                                            <p>By clicking Submit, you are confirming that your files are final and true. Applications can't be cancelled once submitted.</p>
                                                              <button class="btn btn-rounded btn-warning btn-sm" type="submit" name="submitAppBtn" id="submitAppBtn" value="Submit Application">Submit</button>
					                   </div>
                                                            
                                                            </form>
                                                            
                                                        </div>
                                                    </div>
                                                </div>
               		
               		<div class="col-xl-10">
               		
               		<table class="table table-striped" style="width:100%;">
					                <!-- HEADER -->
<!-- 					                <thead style="background-color: #ffe79d">
					                <tr class="text-center">
					                	<th style="width: 8%;">ID</th>
					                	<th style="width: 10%;">Date Submitted</th>
					                	<th style="width: 10%;">Current Score</th>
					                	<th style="width: 10%;">Recommended Score</th>
					                	<th style="width: 10%;">New Score</th>
					                	<th style="width: 25%;">Application Status</th>
					                	
					                </tr>
					                </thead> -->
					                
					               <c:forEach var="app" items="${pendingApp}">
						                
						                <tr class="text-left">
						                	<td>ID</td>
						                	<td>${app.appId}</td>
						                	<td>Date Submitted</td>
						                	<td>${app.dtSubmitted}</td>
						                </tr>
						                <tr class="text-left">
						                	<td>Current Score</td>
						                	 	<c:forEach var="f" items="${faculty}">
						                	<td>${f.scoreEduc+f.scoreExp+f.scoreProf}</td>
						                		</c:forEach>
						                	<td>Current Rank</td>
						                	<td>${app.curRank}</td>
						                </tr>
						                <tr class="text-left">
						                	<td>Initial Score</td>
						                	<td>${app.total}</td>
						                	<td>Recommended Rank</td>
						                	<td>${app.newRank}</td>
						                </tr>
						                <tr class="text-left">
						                	<td>Status</td>
						                	<td>${app.status}</td>
						                	<td>Remarks</td>
						                	<td>${app.remarks}</td>
						                </tr>
						                <tr class="text-left">
						                	<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="application?process=viewDocument&id=${app.appId}" target="_blank">View Letter</a></div></td>
					                	</tr>
						                
					                </c:forEach>
					                
<%-- 					                <!-- INSERT VARIABLES -->
					                <c:forEach var="app" items="${app}">
					                <tbody>
					                <tr class="text-center">
					                	<td>${app.total}</td>
					                	<td>${app.newRank}</td>
					                	<td>${app.status}</td>
					                	<td>${app.dtSubmitted}</td>
					                </tr>
					                </tbody>
					                </c:forEach> --%>
					                </table>
					                <br>
               		
               		<h2 class="text-center" style="color: #800000;" <% if(session.getAttribute("pendingApp")!=null){%> hidden <%}%>>Please review files before submitting your application.</h2>
               		
               	<!-- ============================================================== -->
				<!-- Credentials - EDUC -->
				<!-- ============================================================== -->
					         <div class="splash-container-addcred" id="educ">
					         <br>
					         <div class="card">
					            <div class="card-header">
					            <span class="splash-description-credentials">
					            <div class="row">
					            <div style="width: 10%;"></div>
					            <div style="width: 80%;">Educational Qualification</div>
						            <div style="width: 10%;">
						            <c:set var="total" value="${0}"/>
									<c:forEach var="c_educ" items="${cred_educ}">
									    <c:if test="${c_educ.status == 'Approved'}">
									    	<c:set var="total" value="${total + c_educ.score}" />
									    </c:if>
									</c:forEach>
							            ${total}/85
						            </div>
					            </div>
					            </span>
					           	</div>
					         <div class="card-body">
					            
					                <table class="table table-bordered table-hover" style="width:100%">
					                <!-- HEADER -->
					                <thead>
					                <tr>
					                	<!-- <th>Doc ID</th> -->
					                	<th>Type</th>
					                	<th>Subtype</th>
					                	<th>Title</th>
					                	<th>PDF File</th>
					                	<th>Points</th>
					                	<th>Status</th>
					                	<th>Remarks</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					            <c:forEach var="c_educ" items="${cred_educ}">
					                <tbody>
					                <tr>
					                	<%-- <td><c:out value="${c_educ.credId}" /></td> --%>
					                	<td><c:out value="${c_educ.type}" /></td>
										<td><c:out value="${c_educ.subtype}" /></td>
										<td><c:out value="${c_educ.title}" /></td>
										<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c_educ.credId}" target="_blank">View Document</a></div></td>
					                	<td><c:out value="${c_educ.score}" /></td>
										<td><c:out value="${c_educ.status}" /></td>
										<td><c:out value="${c_educ.remarks}" /></td>
					                </tr>
					                </tbody>
					            </c:forEach>
					                </table>
					                
						        	</div>
					            	</div>
					            	</div>
					            	<br><br>
					    <!-- ============================================================== -->
					    <!-- Credentials - EDUC -->
					    <!-- ============================================================== -->  
					    
					   	<!-- ============================================================== -->
						<!-- Credentials - EXPROF -->
						<!-- ============================================================== -->
					         <div class="splash-container-addcred" id="exprof">
					         <br>
					        <div class="card">
					            <div class="card-header">
					            <span class="splash-description-credentials">
					            <div class="row">
					            <div style="width: 10%;"></div>
					            <div style="width: 80%;">Experience and Length of Service</div>
					            	<div style="width: 10%;">
						            <c:set var="total" value="${0}"/>
									<c:forEach var="c_exp" items="${cred_exp}">
									    <c:if test="${c_exp.status == 'Approved'}">
									    	<c:set var="total" value="${total + c_exp.score}" />
									    </c:if>
									</c:forEach>
							            ${total}/25
						            </div>
					            </div>
					            </span>
					           	</div>
					         <div class="card-body">
					            
					                <table class="table table-bordered table-hover" style="width:100%">
					                <!-- HEADER -->
					                <thead>
					               <tr>
					                	<!-- <th>Doc ID</th> -->
					                	<th>Type</th>
					                	<th>Subtype</th>
					                	<th>Title</th>
					                	<th>PDF File</th>
					                	<th>Points</th>
					                	<th>Status</th>
					                	<th>Remarks</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					                <c:forEach var="c_exp" items="${cred_exp}">
					                <tbody>
					                <tr>
					                	<%-- <td><c:out value="${c_exp.credId}" /></td> --%>
					                	<td><c:out value="${c_exp.type}" /></td>
										<td><c:out value="${c_exp.subtype}" /></td>
										<td><c:out value="${c_exp.title}" /></td>
										<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c_exp.credId}" target="_blank">View Document</a></div></td>
					                	<td><c:out value="${c_exp.score}" /></td>
										<td><c:out value="${c_exp.status}" /></td>
										<td><c:out value="${c_exp.remarks}" /></td>
					                </tr>
					                </tbody>
					            </c:forEach>
					                </table>
					                
						        	</div>
					            	</div>
					            	</div>
					            	<br><br>
					    <!-- ============================================================== -->
					    <!-- Credentials - EXPROF -->
					    <!-- ============================================================== --> 
					   
					    <!-- ============================================================== -->
						<!-- Credentials - PROFDEV -->
						<!-- ============================================================== -->
					         <div class="splash-container-addcred" id="profdev">
					         <br>
					         <div class="card">
					            <div class="card-header">
					            <span class="splash-description-credentials">
					            <div class="row">
					            <div style="width: 10%;"></div>
					            <div style="width: 80%;">Professional Development / Achievements and Honors</div>
					            	<div style="width: 10%;">
						            <c:set var="total" value="${0}"/>
									<c:forEach var="c_prof" items="${cred_prof}">
									    <c:if test="${c_prof.status == 'Approved'}">
									    	<c:set var="total" value="${total + c_prof.score}" />
									    </c:if>
									</c:forEach>
							            ${total}/90
						            </div>
					            </div>
					            </span>
					           	</div>
					         <div class="card-body">
					            
					                <table class="table table-bordered table-hover" style="width:100%">
					                <!-- HEADER -->
					                <thead>
					                <tr>
					                	<!-- <th>Doc ID</th> -->
					                	<th>Type</th>
					                	<th>Subtype</th>
					                	<th>Title</th>
					                	<th>PDF File</th>
					                	<th>Points</th>
					                	<th>Status</th>
					                	<th>Remarks</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					               <c:forEach var="c_prof" items="${cred_prof}">
					                <tbody>
					                <tr>
					                	<%-- <td><c:out value="${c_prof.credId}" /></td> --%>
					                	<td><c:out value="${c_prof.type}" /></td>
										<td><c:out value="${c_prof.subtype}" /></td>
										<td><c:out value="${c_prof.title}" /></td>
										<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c_prof.credId}" target="_blank">View Document</a></div></td>
					                	<td><c:out value="${c_prof.score}" /></td>
										<td><c:out value="${c_prof.status}" /></td>
										<td><c:out value="${c_prof.remarks}" /></td>
					                </tr>
					                </tbody>
					            </c:forEach>
					                </table>
					                
						        	</div>
					            	</div>
					            	</div>
					    <!-- ============================================================== -->
					    <!-- Credentials - PROFDEV -->
					    <!-- ============================================================== -->
					    </div>
					    </div>
					    
					    Previous Applications
					     <table class="table table-bordered table-hover" style="width:100%">
					                <!-- HEADER -->
					                <thead>
					                <tr>
					                	<!-- <th>Application ID</th> -->
					                	<th>Letter</th>
					                	<th>Educational Qualifications</th>
					                	<th>Experience and Length of Service</th>
					                	<th>Professional Development / Achievement and Honors</th>
					                	<th>Total Score</th>
					                	<th>Former Rank</th>
					                	<th>New Rank</th>
					                	<th>Submitted</th>
					                	<th>Approved</th>
					                	
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					               <c:forEach var="prevA" items="${prevApp}">
					                <tbody>
					                <tr>
					                	<%-- <td><c:out value="${prevA.appId}" /></td> --%>
					                	<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="application?process=viewDocument&id=${prevA.appId}" target="_blank">View Document</a></div></td>
					                	<td><c:out value="${prevA.scoreEduc}" /></td>
										<td><c:out value="${prevA.scoreExp}" /></td>
										<td><c:out value="${prevA.scoreProf}" /></td>
										<td><c:out value="${prevA.total}" /></td>
										<td><c:out value="${prevA.curRank}" /></td>
										<td><c:out value="${prevA.newRank}" /></td>
										<td><c:out value="${prevA.dtSubmitted}" /></td>
										<td><c:out value="${prevA.dtApproved}" /></td>
					                </tr>
					                </tbody>
					            </c:forEach>
					                </table>
					    
				<!-- ============================================================== -->
				<!-- END OF APPLICATION TAB -->
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