<!-- ADMIN - DATABASE -->
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
		<title>PUP PASUC Evaluation - Database</title>
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
                                            <h5 class="text-white nav-user-name"><i class="m-r-10 mdi mdi-account pasuc-color-yellow"></i>ADMIN</h5>
                                </div>
                                <a class="dropdown-item" href="changepw"><i class="fas fa-asterisk mr-2"></i>Change Password</a>
                                <a class="dropdown-item" href="admin-home?process=login"><i class="fas fa-power-off mr-2"></i>Logout</a>
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
                		<a class="nav-link active"  href="admin-home?process=view">Admin Database</a>
     	            </li>
     	            <li class="nav-item">
                		<a class="nav-link"  href="admin-content-management?process=view">Content Management</a>
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
                            	<h4 style="margin-top: 6px; color: #800000;"> D A T A B A S E</h4>
                                <ul class="list-unstyled">
                               		<li><a href="#faculty">Faculty</a></li>
                                    <li><a href="#credentials">Credentials</a></li>
                                    <li><a href="#application">Application</a></li>
                                    <li><a href="#evaluators">Evaluators</a></li>
                                    <li><a href="#top"><i class="fas fa-angle-double-up"></i>   Back to Top</a></li>
                                </ul>
                                <br><br>
                            </div>
                    </div>
             		
             		<div class="col-xl-10">
             		<h2 style="text-align: center; color: #800000;">Administrator Database</h2>
             		
             		
             					<div class="page-section" id="faculty">
									<br>
									<br>
									<h2 style="color: #d39f03;">Faculty</h2>
									<br>
									<div class="card">
										<div class="card-header text-center" style="min-height: 60px;">
											<div class="input-group text-center">
												<div class="row" style="margin: 0 auto;">
													<span class="input-group-text"><i
														class="fas fa-search pasuc-color-red"></i></span> <input class=""
														style="width: 400px; text-align: center;" id="fac"
														placeholder="Search" onkeyup="searchfac()">
												</div>
											</div>
										</div>
										<div class="card-body">

											<table class="table table-bordered table-hover"
												 style="width: 6.6%"style="width: 100%" id="factable">
												<!-- HEADER -->
												<thead>
													<tr>
														<th>employee_id</th>
														<th>f_name</th>
														<th>m_name</th>
														<th>l_name</th>
														<th>c_number</th>
														<th>email_add</th>
														<th>b_date</th>
														<th>gender</th>
														<th>address</th>
														<th>department</th>
														<th>rank</th>
														<th>psw</th>
														<th>score_educ</th>
														<th>score_exp</th>
														<th>score_prof</th>
													</tr>
												</thead>

												<!-- INSERT VARIABLES -->
												<c:forEach var="f" items="${fac}">
												<tbody>
													<tr>
														<td>${f.empId}</td>
														<td>${f.firstName}</td>
														<td>${f.middleName}</td>
														<td>${f.lastName}</td>
														<td>${f.contactNumber}</td>
														<td>${f.email}</td>
														<td>${f.birthDate}</td>
														<td>${f.gender}</td>
														<td>${f.address}</td>
														<td>${f.department}</td>
														<td>${f.rank}</td>
														<td>${f.password}</td>
														<td>${f.scoreEduc}</td>
														<td>${f.scoreExp}</td>
														<td>${f.scoreProf}</td>
													</tr>
												</tbody>
												</c:forEach>
											</table>

										</div>
									</div>
								</div>
								<br><br>
             					

								<div class="page-section" id="credentials">
									<br>
									<br>
									<h2 style="color: #d39f03;">Credentials</h2>
									<br>
									<div class="card">
										<div class="card-header text-center" style="min-height: 60px;">
											<div class="input-group text-center">
												<div class="row" style="margin: 0 auto;">
													<span class="input-group-text"><i
														class="fas fa-search pasuc-color-red"></i></span> <input class=""
														style="width: 400px; text-align: center;" id="cred"
														placeholder="Search" onkeyup="searchcred()">
												</div>
											</div>
										</div>
										<div class="card-body">

											<table class="table table-bordered table-hover"
												style="width: 100%" id="credtable">
												<!-- HEADER -->
												<thead>
													<tr>
														<th >cred_id</th>
														<th >timestamp</th>
														<th >employee_id</th>
														<th >type</th>
														<th >subtype</th>
														<th >title</th>
														<th >document</th>
														<th >score</th>
														<th >status</th>
														<th >evaluator_id</th>
														<th >remarks</th>
														<th >category</th>
														<th >application_id</th>
													</tr>
												</thead>

												<!-- INSERT VARIABLES -->
												 <c:forEach var="c" items="${cred}">
												<tbody>
													<tr>
														<td>${c.credId}</td>
														<td>${c.timestamp}</td>
														<td>${c.empId}</td>
														<td>${c.type}</td>
														<td>${c.subtype}</td>
														<td>${c.title}</td>
														<td>${c.documentB}</td>
														<td>${c.score}</td>
														<td>${c.status}</td>
														<td>${c.evaluatorId}</td>
														<td>${c.remarks}</td>
														<td>${c.category}</td>
														<td>${c.appId}</td>
													</tr>
												</tbody>
												</c:forEach>
											</table>

										</div>
									</div>
								</div>
								<br><br>
				
								<div class="page-section" id="application">
									<br>
									<br>
									<h2 style="color: #d39f03;">Application</h2>
									<br>
									<div class="card">
										<div class="card-header text-center" style="min-height: 60px;">
											<div class="input-group text-center">
												<div class="row" style="margin: 0 auto;">
													<span class="input-group-text"><i
														class="fas fa-search pasuc-color-red"></i></span> <input class=""
														style="width: 400px; text-align: center;" id="appl"
														placeholder="Search" onkeyup="searchappl()">
												</div>
											</div>
										</div>
										<div class="card-body">

											<table class="table table-bordered table-hover"
												style="width: 100%" id="appltable">
												<!-- HEADER -->
												<thead>
													<tr>
														<th>application_id</th>
														<th>datetime_submitted</th>
														<th>score_educ</th>
														<th>score_exp</th>
														<th>score_prof</th>
														<th>total</th>
														<th>cur_rank</th>
														<th>new_rank</th>
														<th>evaluator_id</th>
														<th>datetime_approved</th>
														<th>status</th>
														<th>remarks</th>
														<th>employee_id</th>
														<th>letter</th>
													</tr>
												</thead>

												<!-- INSERT VARIABLES -->
												<c:forEach var="a" items="${app}">
												<tbody>
													<tr>
														<td>${a.appId}</td>
														<td>${a.dtSubmitted}</td>
														<td>${a.scoreEduc}</td>
														<td>${a.scoreExp}</td>
														<td>${a.scoreProf}</td>
														<td>${a.total}</td>
														<td>${a.curRank}</td>
														<td>${a.newRank}</td>
														<td>${a.evaluatorId}</td>
														<td>${a.dtApproved}</td>
														<td>${a.status}</td>
														<td>${a.remarks}</td>
														<td>${a.empId}</td>
														<td>${a.documentB}</td>
													</tr>
												</tbody>
												</c:forEach>
											</table>

										</div>
									</div>
								</div>
								<br><br>
								
																
								<div class="page-section" id="evaluators">
									<br>
									<br>
									<h2 style="color: #d39f03;">Evaluators</h2>
									<br>
									<div class="card">
										<div class="card-header text-center" style="min-height: 60px;">
											<div class="input-group text-center">
												<div class="row" style="margin: 0 auto;">
													<span class="input-group-text"><i
														class="fas fa-search pasuc-color-red"></i></span> <input class=""
														style="width: 400px; text-align: center;" id="evalu"
														placeholder="Search" onkeyup="searchevalu()">
												</div>
											</div>
										</div>
										<div class="card-body">

											<table class="table table-bordered table-hover"
												style="width: 100%" id="evalutable">
												<!-- HEADER -->
												<thead>
													<tr>
														<th>pec_id</th>
														<th>email_add</th>
														<th>f_name</th>
														<th>m_name</th>
														<th>l_name</th>
														<th>position</th>
														<th>psw</th>
														<th>rights</th>
														
													</tr>
												</thead>

												<!-- INSERT VARIABLES -->
												<c:forEach var="p" items="${pec}">
												<tbody>
													<tr>
														<td>${p.pecId}</td>
														<td>${p.email}</td>
														<td>${p.firstName}</td>
														<td>${p.middleName}</td>
														<td>${p.lastName}</td>
														<td>${p.position}</td>
														<td>${p.password}</td>
														<td>${p.rights}</td>
													</tr>
												</tbody>
												</c:forEach>
											</table>

										</div>
									</div>
								</div>
								<br><br>
					
					

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
<script>
function searchevalu() {
	var input, filter, found, table, tr, td, i, j;
	input = document.getElementById("evalu");
	filter = input.value.toUpperCase();
	table = document.getElementById("evalutable");
	tr = table.getElementsByTagName("tr");
	
	for (i=1; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td");
		
		for (j=0; j < td.length; j++) {
			if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
				found = true;}}
		if (found) {tr[i].style.display = "";
			found = false;}
		else {tr[i].style.display = "none";}}}
</script>

<script>
function searchcred() {
	var input, filter, found, table, tr, td, i, j;
	input = document.getElementById("cred");
	filter = input.value.toUpperCase();
	table = document.getElementById("credtable");
	tr = table.getElementsByTagName("tr");
	
	for (i=1; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td");
		
		for (j=0; j < td.length; j++) {
			if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
				found = true;}}
		if (found) {tr[i].style.display = "";
			found = false;}
		else {tr[i].style.display = "none";}}}
</script>

<script>
function searchfac() {
	var input, filter, found, table, tr, td, i, j;
	input = document.getElementById("fac");
	filter = input.value.toUpperCase();
	table = document.getElementById("factable");
	tr = table.getElementsByTagName("tr");
	
	for (i=1; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td");
		
		for (j=0; j < td.length; j++) {
			if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
				found = true;}}
		if (found) {tr[i].style.display = "";
			found = false;}
		else {tr[i].style.display = "none";}}}
</script>

<script>
function searchappl() {
	var input, filter, found, table, tr, td, i, j;
	input = document.getElementById("appl");
	filter = input.value.toUpperCase();
	table = document.getElementById("appltable");
	tr = table.getElementsByTagName("tr");
	
	for (i=1; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td");
		
		for (j=0; j < td.length; j++) {
			if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
				found = true;}}
		if (found) {tr[i].style.display = "";
			found = false;}
		else {tr[i].style.display = "none";}}}
</script>
   
   
</body>
</html>