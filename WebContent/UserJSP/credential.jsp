<!-- CRED -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	
	request.getRequestDispatcher("account?process=getUser").include(request, response);
	request.getRequestDispatcher("account?process=getUser").include(request, response);
	if (session.getAttribute("faculty")==null && session.getAttribute("empId")==null && session.getAttribute("email")==null){
		System.out.println("[CRED] Direct to CRED, Redirect to INDEX");
		response.sendRedirect(request.getContextPath() + "/index");	
	}
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PUP PASUC Evaluation - Credential</title>
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
                            <a class="nav-link nav-user-img" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa-lg fas fa-bars pasuc-color-yellow"></i></a>
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
              			<a class="nav-link active"  href="credential?process=view">Upload Credentials</a>
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
                               	<h4 style="margin-top: 6px; color: #800000;">U P L O A D</h4>
                                    <li><a href="#educ">Qualification</a></li>
                                    <li><a href="#exprof">Experience</a></li>
                                    <li><a href="#profdev">Achievements</a></li>
                                    <li><a href="#top"><i class="fas fa-angle-double-up"></i>   Back to Top</a></li>
                                </ul>
                                <br><br>
                            </div>
                    	</div>
               		
               		<div style="margin-left: 20px; width: 88%;">
               		<h2 class="text-center" style="color: #800000;">Please review file details before saving.</h2>
               		
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
						            <%-- <c:set var="total" value="${0}"/>
									<c:forEach var="c_educ" items="${cred_educ}">
									    <c:if test="${c_educ.status == 'Approved'}">
									    	<c:set var="total" value="${total + c_educ.score}" />
									    </c:if>
									</c:forEach>
							            ${total}/85 --%>
							            <c:forEach var="f" items="${faculty}">
							          	  ${f.scoreEduc}/85
							            </c:forEach>
						            </div>
					            </div>
					            </span>
					           	</div>
					            <div class="card-body">
					                <form name="register" id="register" action="credential?process=add&class=educ" method="post" enctype='multipart/form-data' >
					                <div class="row form-group">
					                	<!-- <div style="width: 7%; margin: 2px;">
					                     	<input class="form-control" type="text" name="credID_educ" id="credID_educ" placeholder="Doc ID" disabled="">				                	
					                	</div> -->
					      				<div style="width: 15%; margin: 2px;">
					             			<select name="maintype_educ"  id="maintype_educ" class="form-control" required>
									    		<option value="Main Type">Main Type</option>
									    		<c:forEach var="cs" items="${ccescore}">
									    			<c:if test="${cs.category eq 'Educational Qualification'}">
									    				<option value="${cs.type}">${cs.type}</option>
									    			</c:if>
									    		</c:forEach>
											</select>
					             		</div>
					                  	<div style="width: 15%; margin: 2px;">
					                  		<select name="subtype_educ"  id="subtype_educ" class="form-control" required>
									    		<option value="Subtype">Subtype</option>
									    		<c:forEach var="cs" items="${ccescore}">
									    			<c:if test="${cs.category eq 'Educational Qualification'}">
									    				<%-- <c:if test="${cs.type}==maintype_educ"> --%>
									    					<option value="${cs.subType}">${cs.subType}</option>
									    				<%-- </c:if> --%>
									    			</c:if>
									    		</c:forEach>
											</select>
					                   </div>
					                   <div style="width: 17%; margin: 2px;">
					                     	<input class="form-control" type="text" name="credtitle_educ" id="credtitle_educ" placeholder="Title" maxlength="50" required>
					                 	</div>
					                   <div style="width: 20%; margin: 2px;">
					                     	<input  class="form-control" type="file" name="fileinput_educ" id="fileinput_educ" accept=".pdf" required>
					                   </div>
					                   <div style="width: 7%; margin: 2px;">
					                     	<input class="form-control" type="text" name="initialpts_educ" id="initialpts_educ" placeholder="Points" disabled="">
					                 	</div>
					                 	<div style="width: 10%; margin: 2px;">
					                     	<input class="form-control" type="text" name="lastupdate_educ" id="lastupdate_educ" placeholder="Last Update" disabled="">
					                 	</div>
					                   <div style="width: 5%; margin: 2px;">
					                     	<button class="btn btn-rounded btn-warning btn-sm" type="submit" name="savecred_educ" id="savecred_educ" value="savecred_educ"><i class="fas fa-save"></i> Save</button>
					                   </div>
					         		</div>         		
					                </form>
					                
					             	<table class="table table-bordered table-hover" style="width:100%">
					                <!-- INSERT VARIABLES -->
							            <c:forEach var="c_educ" items="${cred_educ}">
							                <tbody>
							                <tr>
							                	<%-- <td style="width: 7%;"><c:out value="${c_educ.credId}" /></td> --%>
							                	<td style="width: 15%;"><c:out value="${c_educ.type}" /></td>
												<td style="width: 15%;"><c:out value="${c_educ.subtype}" /></td>
												<td style="width: 17%;"><c:out value="${c_educ.title}" /></td>
												<td style="width: 20%;"><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c_educ.credId}" target="_blank">View Document</a></div></td>
							                	<td style="width: 7%;"><c:out value="${c_educ.score}" /></td>
												<td style="width: 10%;"><c:out value="${c_educ.timestamp}" /></td>
												
							                </tr>
							                </tbody>
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
					         <div class="splash-container-addcred" id="exp">
					         <br>
					        <div class="card">
					            <div class="card-header">
					            <span class="splash-description-credentials">
					            <div class="row">
					            <div style="width: 10%;"></div>
					            <div style="width: 80%;">Experience and Length of Service</div>
					           	<div style="width: 10%;">
						            <%-- <c:set var="total" value="${0}"/>
									<c:forEach var="c_exp" items="${cred_exp}">
									    <c:if test="${c_exp.status == 'Approved'}">
									    	<c:set var="total" value="${total + c_exp.score}" />
									    </c:if>
									</c:forEach>
							            ${total}/25 --%>
							            <c:forEach var="f" items="${faculty}">
							          	  ${f.scoreExp}/25
							            </c:forEach>
						            </div>
					            </div>
					            </span>
					           	</div>
					            <div class="card-body">
					                <form name="register" id="register" action="credential?process=add&class=exp" method="post" enctype='multipart/form-data' >
					                <div class="row form-group">
					                	<!-- <div style="width: 7%; margin: 2px;">
					                     	<input class="form-control" type="text" name="credID_exp" id="credID_exp" placeholder="Doc ID" disabled="">				                	
					                	</div> -->
					      				<div style="width: 15%; margin: 2px;">
					             			<select name="maintype_exp"  id="maintype_exp" class="form-control" required>
									    		<option value="Main Type">Main Type</option>
									    		<c:forEach var="cs" items="${ccescore}">
									    			<c:if test="${cs.category eq 'Experience and Length of Service'}">
									    				<option value="${cs.type}">${cs.type}</option>
									    			</c:if>
									    		</c:forEach>
											</select>
					             		</div>
					                  	<div style="width: 15%; margin: 2px;">
					                  		<select name="subtype_exp"  id="subtype_exp" class="form-control" required>
									    		<option value="Subtype">Subtype</option>
									    		<c:forEach var="cs" items="${ccescore}">
									    			<c:if test="${cs.category eq 'Experience and Length of Service'}">
									    				<%-- <c:if test="${cs.type}==maintype_educ"> --%>
									    					<option value="${cs.subType}">${cs.subType}</option>
									    				<%-- </c:if> --%>
									    			</c:if>
									    		</c:forEach>
											</select>
					                   </div>
					                   <div style="width: 17%; margin: 2px;">
					                     	<input class="form-control" type="text" name="credtitle_exp" id="credtitle_exp" placeholder="Title" maxlength="50" required>
					                 	</div>
					                   <div style="width: 20%; margin: 2px;">
					                     	<input  class="form-control" type="file" name="fileinput_exp" id="fileinput_exp" accept=".pdf" required>
					                   </div>
					                   <div style="width: 7%; margin: 2px;">
					                     	<input class="form-control" type="text" name="initialpts_exp" id="initialpts_exp" placeholder="Points" disabled="">
					                 	</div>
					                 	<div style="width: 10%; margin: 2px;">
					                     	<input class="form-control" type="text" name="lastupdate_exp" id="lastupdate_exp" placeholder="Last Update" disabled="">
					                 	</div>
					                   <div style="width: 5%; margin: 2px;">
					                     	<button class="btn btn-rounded btn-warning btn-sm" type="submit" name="savecred_exp" id="savecred_exp" value="savecred_exp"><i class="fas fa-save"></i> Save</button>
					                   </div>
					         		</div>         		
					                </form>
					                
					             	<table class="table table-bordered table-hover" style="width:100%">
					                <!-- INSERT VARIABLES -->
							            <c:forEach var="c_exp" items="${cred_exp}">
							                <tbody>
							                <tr>
							                	<%-- <td style="width: 7%;"><c:out value="${c_exp.credId}" /></td> --%>
							                	<td style="width: 15%;"><c:out value="${c_exp.type}" /></td>
												<td style="width: 15%;"><c:out value="${c_exp.subtype}" /></td>
												<td style="width: 17%;"><c:out value="${c_exp.title}" /></td>
												<td style="width: 20%;"><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c_exp.credId}" target="_blank">View Document</a></div></td>
							                	<td style="width: 7%;"><c:out value="${c_exp.score}" /></td>
												<td style="width: 10%;"><c:out value="${c_exp.timestamp}" /></td>
												
							                </tr>
							                </tbody>
							            </c:forEach>
					                </table>
					                
					            	</div>
					            	</div>
					            	</div>
					            	<br><br>
					    <!-- ============================================================== -->
					    <!-- End of Add a credential - exp -->
					    <!-- ============================================================== -->
					    
					    <!-- ============================================================== -->
					    <!-- Add a credential - PROFDEV -->
					    <!-- ============================================================== -->
					         <div class="splash-container-addcred" id="prof">
					         <br>
					        <div class="card">
					            <div class="card-header">
					            <span class="splash-description-credentials">
					            <div class="row">
					            <div style="width: 10%;"></div>
					            <div style="width: 80%;">Professional Development Achievements and Honors</div>
					         <div style="width: 10%;">
						            <%-- <c:set var="total" value="${0}"/>
									<c:forEach var="c_prof" items="${cred_prof}">
									    <c:if test="${c_prof.status == 'Approved'}">
									    	<c:set var="total" value="${total + c_prof.score}" />
									    </c:if>
									</c:forEach>
							            ${total}/90 --%>
							            <c:forEach var="f" items="${faculty}">
							          	  ${f.scoreProf}/90
							            </c:forEach>
						            </div>
					            </div>
					            </span>
					           	</div>
					           	<div class="card-body">

					                <form name="register" id="register" action="credential?process=add&class=prof" method="post" enctype='multipart/form-data' >
					                <div class="row form-group">
					                	<!-- <div style="width: 7%; margin: 2px;">
					                     	<input class="form-control" type="text" name="credID_prof" id="credID_prof" placeholder="Doc ID" disabled="">				                	
					                	</div> -->
					      				<div style="width: 15%; margin: 2px;">
					             			<select name="maintype_prof"  id="maintype_prof" class="form-control" required>
									    		<option value="Main Type">Main Type</option>
									    		<c:forEach var="cs" items="${ccescore}">
									    			<c:if test="${cs.category eq 'Professional Development Achievement and Honors'}">
									    				<option value="${cs.type}">${cs.type}</option>
									    			</c:if>
									    		</c:forEach>
											</select>
					             		</div>
					                  	<div style="width: 15%; margin: 2px;">
					                  		<select name="subtype_prof"  id="subtype_prof" class="form-control" required>
									    		<option value="Subtype">Subtype</option>
									    		<c:forEach var="cs" items="${ccescore}">
									    			<c:if test="${cs.category eq 'Professional Development Achievement and Honors'}">
									    				<%-- <c:if test="${cs.type}==maintype_educ"> --%>
									    					<option value="${cs.subType}">${cs.subType}</option>
									    				<%-- </c:if> --%>
									    			</c:if>
									    		</c:forEach>
											</select>
					                   </div>
					                   <div style="width: 17%; margin: 2px;">
					                     	<input class="form-control" type="text" name="credtitle_prof" id="credtitle_prof" placeholder="Title" maxlength="50" required>
					                 	</div>
					                   <div style="width: 20%; margin: 2px;">
					                     	<input  class="form-control" type="file" name="fileinput_prof" id="fileinput_prof" accept=".pdf" required>
					                   </div>
					                   <div style="width: 7%; margin: 2px;">
					                     	<input class="form-control" type="text" name="initialpts_prof" id="initialpts_prof" placeholder="Points" disabled="">
					                 	</div>
					                 	<div style="width: 10%; margin: 2px;">
					                     	<input class="form-control" type="text" name="lastupdate_prof" id="lastupdate_prof" placeholder="Last Update" disabled="">
					                 	</div>
					                   <div style="width: 5%; margin: 2px;">
					                     	<button class="btn btn-rounded btn-warning btn-sm" type="submit" name="savecred_prof" id="savecred_prof" value="savecred_prof"><i class="fas fa-save"></i> Save</button>
					                   </div>
					         		</div>         		
					                </form>
					                
					                	<table class="table table-bordered table-hover" style="width:100%">
					                <!-- INSERT VARIABLES -->
							            <c:forEach var="c_prof" items="${cred_prof}">
							                <tbody>
							                <tr>
							                	<%-- <td style="width: 7%;"><c:out value="${c_prof.credId}" /></td> --%>
							                	<td style="width: 15%;"><c:out value="${c_prof.type}" /></td>
												<td style="width: 15%;"><c:out value="${c_prof.subtype}" /></td>
												<td style="width: 17%;"><c:out value="${c_prof.title}" /></td>
												<td style="width: 20%;"><div class="text-center"><a class="btn btn-sm btn-credlink" href="credential?process=viewDocument&id=${c_prof.credId}" target="_blank">View Document</a></div></td>
							                	<td style="width: 7%;"><c:out value="${c_prof.score}" /></td>
												<td style="width: 10%;"><c:out value="${c_prof.timestamp}" /></td>
												
							                </tr>
							                </tbody>
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