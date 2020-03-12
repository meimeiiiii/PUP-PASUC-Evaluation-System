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
    
    <c:forEach var="a" items="${app}">
    <c:forEach var="f" items="${fac}">
	<!-- ============================================================== -->
	<!-- TOP NAV  -->
	<!-- ============================================================== -->
		<div  id="top"></div>
		<div class="col-xl-12" style="margin-top: 100px;">
			
		
 			<div class="tab-regular">
    			 <ul class="nav nav-tabs nav-fill" role="tablist">
               		<li class="nav-item">
                    	<h3 class="nav-link">Application Entry: ${a.appId}</h3>
                 	</li>
                 	</ul>
 	<!-- ============================================================== -->
	<!-- END TOP NAV  -->
	<!-- ============================================================== -->
				<div class="tab-content" id="home-tabs">


       			<!-- ============================================================== -->
				<!-- ADD CREDENTIAL TAB -->
				<!-- ============================================================== -->
				
               		<div class="tab-pane fade  show active">
               		
               		<div class="row">
               			<div class="col-xl-1.5" style="margin-left: 12px;">
                            <div class="sidebar-nav-fixed border-right">
                            	<div class="text-center">
                            	<br><br>
                            	</div>
                                <ul class="list-unstyled">
                               	<h4 style="margin-top: 6px; color: #800000;">E N T R Y</h4>
                                    <li><a href="#educ">Qualification</a></li>
                                    <li><a href="#exprof">Experience</a></li>
                                    <li><a href="#profdev">Achievements</a></li>
                                    <li><a href="#top"><i class="fas fa-angle-double-up"></i>   Back to Top</a></li>
                                </ul>
                                <!-- Button trigger modal -->
                                                <button href="#" class="btn btn-rounded btn-outline-warning" data-toggle="modal" data-target="#confirmationModal" >
                                                        <i class="fas fa-plus-circle"></i>   Submit</button>
                                 					                <!-- Modal - approve -->
                                 					                
                                                          
                                
                                <br><br>
                            </div>
                            
                            <div class="modal modal-sm fade" id="confirmationModal">
                                                    <div class="modal-dialog" >
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Application</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                                            <form name="submitForApproval" id="submitForApproval" method=post action="pec-application?process=changeStatus&appId=${a.appId}">
												  			
                                                            <div class="modal-body">
                                                            	
																<br>                                                             
											               		<h5 class="text-center">Are you sure you want are done evaluating this application?</h5>
																<br>
																<br>                                                             
											               		<select name="newAppStatus" id="newAppStatus">
																	    <option value="Evaluated" id="a">Approve</option>
																	    <option value="Rejected" id="r">Reject</option>
																</select>
																<br>
																<input class="form-control" type="text" name="remarks" id="remarks" placeholder="Remarks" maxlength="100">
					                							<br>
																
					  										</div>
											  				<div class="modal-footer">
												  				<p class="text-center">By clicking Yes, you are confirming that this is final and decision can't be undone. </p>
												  				
												  					<button class="b"sn btn-warning btn-sm" name="credStatus" id="credStatus" value="submit">Yes</button>
												  				
												  			</div> 
												  			</form>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                
                    	</div>
                    	
                    	
               		
               		<div style="margin-left: 20px; width: 88%;">
               		
               		<table class="table table-striped" style="width:100%;">
					              			               	  
					              
						                <tr class="text-left">
						                	<td>ID</td>
						                	<td>${a.appId}</td>
						                	<td>Date Submitted</td>
						                	<td>${a.dtSubmitted}</td>
						                </tr>
						                <tr class="text-left">
						                	<td>Name</td>
						                	<td>${f.lastName}, ${f.firstName} ${f.middleName} </td>
						                	<td>College and Department</td>
						                	<td>${f.department}</td>
						                </tr>
						                <tr class="text-left">
						                	<td>Current Score</td>
						                	 <td>
						                		${f.scoreEduc+f.scoreExp+f.scoreProf}
						                	</td>
						                	<td>Current Rank</td>
						                	<td>${a.curRank}</td>
						                </tr>
						                <tr class="text-left">
						                	<td>Initial Score</td>
						                	<td>${a.total}</td>
						                	<td>Recommended Rank</td>
						                	<td>${a.newRank}</td>
						                </tr>
						                <tr class="text-left">
						                	<td>Status</td>
						                	<td>${a.status}</td>
						                	<td>Remarks</td>
						                	<td>${a.remarks}</td>
						                </tr>
						                <tr>
						               		<td>Last Modified</td>
						                	<td>${a.dtApproved}</td>
						                </tr>
						                <tr class="text-left">
						                	<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="application?process=viewDocument&id=${a.appId}" target="_blank">View Letter</a></div></td>
					                	</tr>
						                
					                </table>
               		
               		<div class="row">
               		<div class="col-2"></div>
               		<div class="col-8"><h2 class="text-center" style="color: #800000;">Please review credential details before submitting.</h2></div>
               		<div class="col-2"></div>
               		</div>
               		
               			
               		
               	<!-- ============================================================== -->
				<!-- Add a credential - EDUC -->
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
												<c:if test="${total > 85}">
											    	<c:set var="total" value="${85}" />
											    </c:if>
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
					                	<th style="width:5%;">Doc ID</th>
					                	<th style="width:12%;">Type</th>
					                	<th style="width:12%;">Subtype</th>
					                	<th style="width:15%;">Title</th>
					                	<th style="width:7%;">PDF File</th>
					                	<th style="width:5%;">Points</th>
					                	<th style="width:5%;">Status</th>
					                	<th style="width:28%;">Remarks</th>
					                	<th style="width:7%;">Approval</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					                <c:forEach var="c_educ" items="${cred_educ}">
					                <form method="post" action="pec-application?process=changeCredStatus&appId=${a.appId}&credId=${c_educ.credId}">
					                <tbody>
					                <tr>
					                
					                	<td><c:out value="${c_educ.credId}" /></td>
					                	<td><c:out value="${c_educ.type}" /></td>
										<td><c:out value="${c_educ.subtype}" /></td>
										<td><c:out value="${c_educ.title}" /></td>
					                	<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c_educ.credId}" target="_blank">View</a></div></td>
					                	<td><input class="form-control" type="text" name="points" id="points" placeholder="Points" value="${c_educ.score}" maxlength="100"></td>
					                	<td><c:out value="${c_educ.status}" /></td>
					                	<td>
					                		<div style="position:relative;">
											<select class="form-control" style="position:absolute;" onchange="document.getElementById('displayValues').value=this.options[this.selectedIndex].text;">
										    <option></option>
										    <option value="one">Submit original copy</option>
										    <option value="two">Submit clearer copy</option>
										 	</select>
										 	<input class="form-control" style="position:absolute; width: 90%;" type="text" name="displayValues" id="displayValues" value="${c_educ.remarks}" placeholder="Remarks" onfocus="this.select()">
      										</div>
					                	
					                	</td>
					                	<td>
					                	<div class="text-center">
					                	<a class="btn btn-rounded btn-outline-success btn-sm" href="#approveModalEduc" class="btn btn-rounded btn-outline-warning" data-toggle="modal"><i class="fas fa-check"></i></a>
					                	<a class="btn btn-rounded btn-outline-danger btn-sm" href="#disapproveModalEduc" class="btn btn-rounded btn-outline-warning" data-toggle="modal"><i class="fas fa-times"></i></a>
					                	</div>
					                	</td>
					                	
					                </tr>
					                </tbody>
					                
					                <!-- Modal - approve -->
                                                <div class="modal modal-lg fade" id="approveModalEduc">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Document Approval: Educational Background</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                                            <div class="modal-body">
																<br>                                                             
											               		<h5 class="text-center">Are you sure you are approving Document ID?</h5>
																<br>
					  										</div>
											  				<div class="modal-footer">
												  				<p class="text-center">By clicking Yes, you are confirming that the credential is up for evaluation. </p>
												  				<button class="btn btn-warning btn-sm" name="credStatus" id="credStatus" value="Approved">Yes</button>
												  			</div> 
                                                        </div>
                                                    </div>
                                                </div>
					                
                                     <!-- Modal - disapprove -->
                                                <div class="modal modal-lg fade" id="disapproveModalEduc">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Document Disapproval: Educational Background</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                                            <div class="modal-body">
																<br>                                                             
											               		<h5 class="text-center">Are you sure you are disapproving document?</h5>
																<br>
					  										</div>
											  				<div class="modal-footer">
												  				<p class="text-center">By clicking Yes, you are confirming that the credential is not fit for evaluation. Decision can't be undone once confirmed.</p>
												  				<button class="btn btn-warning btn-sm" name="credStatus" id="credStatus" value="Disapproved">Yes</button>
												  			</div> 
                                                        </div>
                                                    </div>
                                                </div>
                                    </form>   
                                    </c:forEach>         
					                </table>
							       	</div>  
							   	</div>
		                        </div>   
					            	<br><br>
					    <!-- ============================================================== -->
					    <!-- End of Add a credential - EDUC -->
					    <!-- ============================================================== -->  
					    
					   	<!-- ============================================================== -->
					    <!-- Add a credential - EXPROF -->
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
											<c:if test="${total > 25}">
										    	<c:set var="total" value="${25}" />
										    </c:if>
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
					                	<th style="width:5%;">Doc ID</th>
					                	<th style="width:12%;">Type</th>
					                	<th style="width:12%;">Subtype</th>
					                	<th style="width:15%;">Title</th>
					                	<th style="width:7%;">PDF File</th>
					                	<th style="width:5%;">Points</th>
					                	<th style="width:5%;">Status</th>
					                	<th style="width:28%;">Remarks</th>
					                	<th style="width:7%;">Approval</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					                <c:forEach var="c_exp" items="${cred_exp}">
					                <form method="post" action="pec-application?process=changeCredStatus&appId=${a.appId}&credId=${c_exp.credId}">
					                <tbody>
					                <tr>
					                
					                	<td><c:out value="${c_exp.credId}" /></td>
					                	<td><c:out value="${c_exp.type}" /></td>
										<td><c:out value="${c_exp.subtype}" /></td>
										<td><c:out value="${c_exp.title}" /></td>
					                	<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c_exp.credId}" target="_blank">View</a></div></td>
					                	<td><input class="form-control" type="text" name="points" id="points" placeholder="Points" value="${c_exp.score}" maxlength="100"></td>
					                	<td><c:out value="${c_exp.status}" /></td>
					                	<td>
					                		<div style="position:relative;">
												<select class="form-control" style="position:absolute;" onchange="document.getElementById('remarks2').value=this.options[this.selectedIndex].text;">
											    <option></option>
											    <option value="one">Submit original copy</option>
											    <option value="two">Submit clearer copy</option>
											 	</select>
											 	<input class="form-control" style="position:absolute; width: 90%;" type="text" name="remarks2" id="remarks2" value="${c_exp.remarks}" placeholder="Remarks" onfocus="this.select()">
      										</div>
					                	</td>
										<td>
					                	<div class="text-center">
					                	<a class="btn btn-rounded btn-outline-success btn-sm" href="#approveModalExp" class="btn btn-rounded btn-outline-warning" data-toggle="modal"><i class="fas fa-check"></i></a>
					                	<a class="btn btn-rounded btn-outline-danger btn-sm" href="#disapproveModalExp" class="btn btn-rounded btn-outline-warning" data-toggle="modal"><i class="fas fa-times"></i></a>
					                	</div>
					                	</td>
					                	
					                </tr>
					                </tbody>
					                
					                <!-- Modal - approve -->
                                                <div class="modal modal-lg fade" id="approveModalExp">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Document Approval: Experience and Length of Service</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                                            <div class="modal-body">
																<br>                                                             
											               		<h5 class="text-center">Are you sure you are approving Document?</h5>
																<br>
					  										</div>
											  				<div class="modal-footer">
												  				<p class="text-center">By clicking Yes, you are confirming that the credential is up for evaluation. Decision can't be undone once confirmed.</p>
												  				<button class="btn btn-warning btn-sm" name="credStatus" id="credStatus" value="Approved">Yes</button>
												  			</div> 
                                                        </div>
                                                    </div>
                                                </div>
					                
                                     <!-- Modal - disapprove -->
                                                <div class="modal modal-lg fade" id="disapproveModalExp">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Document Disapproval: Experience and Length of Service</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                                            <div class="modal-body">
																<br>                                                             
											               		<h5 class="text-center">Are you sure you are disapproving document?</h5>
																<br>
					  										</div>
											  				<div class="modal-footer">
												  				<p class="text-center">By clicking Yes, you are confirming that the credential is not fit for evaluation. Decision can't be undone once confirmed.</p>
												  				<button class="btn btn-warning btn-sm" name="credStatus" id="credStatus" value="Disapproved">Yes</button>
												  			</div> 
                                                        </div>
                                                    </div>
                                                </div>
                                    </form>   
                                    </c:forEach>         
					                </table>
							       	</div>  
							   	</div>
		                        </div>   
					            	<br><br>
					    <!-- ============================================================== -->
					    <!-- End of Add a credential - EXPROF -->
					    <!-- ============================================================== -->
					    
					    <!-- ============================================================== -->
					    <!-- Add a credential - PROFDEV -->
					    <!-- ============================================================== -->
					         <div class="splash-container-addcred" id="profdev">
					         <br>
					        <div class="card">
					            <div class="card-header">
					            <span class="splash-description-credentials">
					            <div class="row">
					            <div style="width: 10%;"></div>
					            <div style="width: 80%;">Professional Development Achievements and Honors</div>
						           <div style="width: 10%;">
							            <c:set var="total" value="${0}"/>
										<c:forEach var="c_prof" items="${cred_prof}">
										    <c:if test="${c_prof.status == 'Approved'}">
										    	<c:set var="total" value="${total + c_prof.score}" />
										    </c:if>
										</c:forEach>
											<c:if test="${total > 90}">
										    	<c:set var="total" value="${90}" />
										    </c:if>
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
					                	<th style="width:5%;">Doc ID</th>
					                	<th style="width:12%;">Type</th>
					                	<th style="width:12%;">Subtype</th>
					                	<th style="width:15%;">Title</th>
					                	<th style="width:7%;">PDF File</th>
					                	<th style="width:5%;">Points</th>
					                	<th style="width:5%;">Status</th>
					                	<th style="width:28%;">Remarks</th>
					                	<th style="width:7%;">Approval</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					                <c:forEach var="c_prof" items="${cred_prof}">
					               <form method="post" action="pec-application?process=changeCredStatus&appId=${a.appId}&credId=${c_prof.credId}">
					                 <tbody>
					                <tr>
					                
					                	<td><c:out value="${c_prof.credId}" /></td>
					                	<td><c:out value="${c_prof.type}" /></td>
										<td><c:out value="${c_prof.subtype}" /></td>
										<td><c:out value="${c_prof.title}" /></td>
					                	<td><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c_prof.credId}" target="_blank">View</a></div></td>
					                	<td><input class="form-control" type="text" name="points" id="points" placeholder="Points" value="${c_prof.score}" maxlength="100"></td>
					                	<td><c:out value="${c_prof.status}" /></td>
					                	<td>
					                		<div style="position:relative;">
												<select class="form-control" style="position:absolute;" onchange="document.getElementById('remarks3').value=this.options[this.selectedIndex].text;">
											    <option></option>
											    <option value="one">Submit original copy</option>
											    <option value="two">Submit clearer copy</option>
											 	</select>
											 	<input class="form-control" style="position:absolute; width: 90%;" type="text" name="remarks3" id="remarks3" value="${c_prof.remarks}" placeholder="Remarks" onfocus="this.select()">
      										</div>
										</td>					                	
					                	<td>
					                	<div class="text-center">
					                	<a class="btn btn-rounded btn-outline-success btn-sm" href="#approveModalProf" class="btn btn-rounded btn-outline-warning" data-toggle="modal"><i class="fas fa-check"></i></a>
					                	<a class="btn btn-rounded btn-outline-danger btn-sm" href="#disapproveModalProf" class="btn btn-rounded btn-outline-warning" data-toggle="modal"><i class="fas fa-times"></i></a>
					                	</div>
					                	</td>
					                	
					                </tr>
					                </tbody>
					                
					                <!-- Modal - approve -->
                                                <div class="modal modal-lg fade" id="approveModalProf">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Document Approval: Professional Development / Achievements and Honors</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                                            <div class="modal-body">
																<br>                                                             
											               		<h5 class="text-center">Are you sure you are approving this document?</h5>
																<br>
					  										</div>
											  				<div class="modal-footer">
												  				<p class="text-center">By clicking Yes, you are confirming that the credential is up for evaluation. Decision can't be undone once confirmed.</p>
												  				<button class="btn btn-warning btn-sm" name="credStatus" id="credStatus" value="Approved">Yes</button>
												  			</div> 
                                                        </div>
                                                    </div>
                                                </div>
					                
                                     <!-- Modal - disapprove -->
                                                <div class="modal modal-lg fade" id="disapproveModalProf">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Document Disapproval: Professional Development / Achievements and Honors</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                                            <div class="modal-body">
																<br>                                                             
											               		<h5 class="text-center">Are you sure you are disapproving Document?</h5>
																<br>
					  										</div>
											  				<div class="modal-footer">
												  				<p class="text-center">By clicking Yes, you are confirming that the credential is not fit for evaluation. Decision can't be undone once confirmed.</p>
												  				<button class="btn btn-warning btn-sm" name="credStatus" id="credStatus" value="Disapproved">Yes</button>
												  			</div> 
                                                        </div>
                                                    </div>
                                                </div>
                                    </form>   
                                    </c:forEach>         
					                </table>
							       	</div>  
							   	</div>
		                        </div> 		
					    <!-- ============================================================== -->
					    <!-- End of Add a credential - PROFDEV -->
					    <!-- ============================================================== -->  
				<!-- ============================================================== -->
				<!-- END OF ADD CREDENTIAL TAB -->
				<!-- ============================================================== -->	
							</div>
						</div>
				
				
					</div>
				</div>
			</div>
		</div>
           		<!-- ============================================================== -->
             	<!-- END TOP NAV CODE-->
             	<!-- ============================================================== --> 
             	
	</c:forEach>
	</c:forEach>
    <!-- ============================================================== -->
    <!-- Java Script -->
    <!-- ============================================================== --> 
    <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src='assets/libs/js/main-js.js'></script>
    
    
    
   
</body>
</html>