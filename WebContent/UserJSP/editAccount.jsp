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
			System.out.println("[EDIT ACC] Direct to EDIT ACC, Redirect to INDEX");
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
		<title>PUP PASUC Evaluation - Edit Account</title>
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
	
	
<c:forEach var="f" items="${faculty}">
	
		<div class="col-xl-12">
		<br>
		<a class="btn btn-sm btn-warning" href="javascript:history.back()"><i class="fas fa-angle-double-left"></i>   Back to previous page</a>
		<br><br>
		<div class="splash-container-settings">
		<div class="card p-2">
			<div class="card-header text-center"><span class="splash-description-credentials">Edit Account</span></div>
				<div class="card-body">
					
	
<%-- 					<c:forEach var="f" items="${faculty}"> --%>						
							<form name="editAccInput" id="editAccInput" action="settings?process=editAccount&save=yes" method="post" onsubmit="return saveEdit()">
<%-- 							<div style="color: #FF0000;">${errorMessageEdit}</div>--%>							
							<table id="regTable">
								<tr>
									<td><input type="text" name="fName" id="fName" placeholder="First Name" value="${f.firstName}" maxlength="50" required></td>
									<td><input type="text" name="mName" id="mName" placeholder="Middle Name" value="${f.middleName}" maxlength="50"></td>
									<td><input type="text" name="lName" id="lName" placeholder="Last Name" value="${f.lastName}" maxlength="50" required></td>
								</tr>
								<tr>
									<td><input type="text" name="cNumber" id="cNumber" placeholder="Contact Number" value="${f.contactNumber}"maxlength=11 pattern="[0-9]{11}" title="09XXXXXXXXX" required></td>
								</tr>
								<tr>
									<td><input type="date" name="bDate" id="bDate" placeholder="Date of Birth" value="${f.birthDate}" required></td>
									<td><select name="gender" id="gender">
										    <option value="Female" id="f" <%if(session.getAttribute("selectedGen").equals("Female")){%> selected <%}%>>Female</option>
										    <option value="Male" id="m" <%if(session.getAttribute("selectedGen").equals("Male")){%> selected <%}%>>Male</option>
									</select></td>
									<td><input type="text" name="address" id="address" placeholder="Address" value="${f.address}" maxlength="100" required></td>
								</tr>
								<tr>
									<td><select name="dept" id="dept" required>
									    <option value="CE - Civil Engineering" <%if(session.getAttribute("selectedDept").equals("CE - Civil Engineering")){%> selected <%}%> >CE - Civil Engineering</option>
									    <option value="CE - Computer Engineering" <%if(session.getAttribute("selectedDept").equals("CE - Computer Engineering")){%> selected <%}%>>CE - Computer Engineering</option>
									</select></td>
								</tr>
								<tr>
									<td><button type="submit" name="saveBtn" id="saveBtn" value="Save" >Save</button></td>
								</tr>
							</table>
						</form>
						
						
						
								<script language='javascript' type='text/javascript'>
								    
									function saveEdit() {
					
								    	var fN = document.getElementById("fName");
								    	var mN = document.getElementById("mName");
								    	var lN = document.getElementById("lName");
								    	var cN = document.getElementById("cNumber");
								    	var bD = document.getElementById("bDate");
								    	var gen = document.getElementById("gender");
								    	var add = document.getElementById("address");
								    	var dept = document.getElementById("dept");
								    	
								    	if (fN.value == fN.defaultValue && mN.value == mN.defaultValue && 
								    		lN.value == lN.defaultValue && cN.value == cN.defaultValue && 
								    		bD.value == bD.defaultValue && gen.value == '${f.gender}'&& 
								    		add.value == add.defaultValue && dept.value == '${f.department}'){
								    		alert("There are no changes in any field");
								    		return false;
								    	} else{
								    		input.setCustomValidity('');
								    	 	return true;
								    	}
								    }
								</script>
			    
	</c:forEach>
					            	</div>
					           </div>
					</div>
	

	
    <!-- ============================================================== -->
    <!-- Java Script -->
    <!-- ============================================================== --> 
    <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src='assets/libs/js/main-js.js'></script>
   
</body>
</html>
	