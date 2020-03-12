<!-- ADMIN - APPLICATION -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	
	
	if (session.getAttribute("pec")==null && session.getAttribute("pecID")==null && session.getAttribute("pecEMAIL")==null){
			System.out.println("[PEC MEMBERS] Direct to PEC, Redirect to LOGIN");
			response.sendRedirect(request.getContextPath() + "/pec-login");	
	}
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PUP PASUC Evaluation - PEC Members</title>
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
     	             <li class="nav-item">
                		<a class="nav-link active"  href="pec-members?process=view">PEC Members</a>
     	            </li>
     	            <li class="nav-item">
                		<a class="nav-link"  href="pec-about?process=view">About PUP PASUC</a>
     	            </li>
     	           
 				</ul>
 	<!-- ============================================================== -->
	<!-- END TOP NAV  -->
	<!-- ============================================================== -->
	
	<div class="tab-content" id="home-tabs">

				
				<!-- ============================================================== -->
				<!-- DIR - EVALUATOR TAB -->
				<!-- ============================================================== -->
				
       			 <div class="tab-pane fade show active">
       			
             		<div class="col-xl-12">
             		<div class="row">
             		<div class="col-2"></div>
             		<div class="col-8"><h2 style="text-align: center; color: #800000;">List of PASUC Evaluation Committee Members</h2></div>
             		<div class="col-2"><a class="btn btn-rounded btn-outline-warning btn-sm" href="#addEvalModal" data-toggle="modal">Create Evaluator Account</a></div>
             		</div>
             		
             		<!-- Modal - Add Evaluator -->
                                                <div class="modal modal-sm fade" style="max-width: 500px;" id="addEvalModal">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Create Account</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                         		 		<form method="post" action="pec-account?process=register">
                                                            <div class="modal-body">
                                                            <h4> Name </h4>
															<div class="form-group">
											             			<input class="form-control name-inputmask" type="text" name="fName" id="fName" placeholder="First Name" maxlength="50" required>
											             	</div>
											             	<div class="form-group">
											                  		<input class="form-control name-inputmask" type="text" name="mName" id="mName" placeholder="Middle Name" maxlength="50">
											                </div>
											             	<div class="form-group">	
											                     	<input class="form-control name-inputmask" type="text" name="lName" id="lName" placeholder="Last Name" maxlength="50" required>
											         		</div>
											         		<h4> Position </h4>
											         		<div class="form-group">
											         		
											         			<select name="position" id="position" required class="form-control">
															    	<option value="DIRECTOR" id="Director">DIRECTOR</option>
															    	<option value="EVALUATOR" id="Evaluator">EVALUATOR</option>
															    	<option value="ADMINISTRATIVE STAFF" id="AdminStaff">ADMINISTRATIVE STAFF</option>
																</select>
															</div>
															<h4> Rights </h4>
											         		<div class="form-group">
											         			<select name="rights" id="rights" required class="form-control">
															    	<option value="A" id="A">A</option>
															    	<option value="B" id="B">B</option>
																</select>
															</div>
															<h4> Email </h4>
															<div class="form-group">
											             			<input class="form-control email-inputmask" type="text" name="emailIn" id="emailIn" placeholder="Email Address" maxlength="50" required>
											             	</div>
															</div>
											  				<div class="modal-footer">
												  				<p class="text-center">By clicking Create, you are confirming that the Evaluator details above are true. You may always make changes by clicking the <i class="fas fa-pencil-alt"></i> icon once the account is created.</p>
												  				<button class="btn btn-warning btn-sm" type="submit">Create</button>
												  			</div> 
												  		</form>
                                                        </div>
                                                    </div>
                                                </div>
             	<!-- ============================================================== -->
				<!-- CARD -->
				<!-- ============================================================== -->
					         <div class="splash-container-addcred" id="educ">
					         <br>
					        <div class="card">
					            <div class="card-header text-center" style="min-height: 60px;">
					            <div class="input-group text-center">
					            	<div class="row" style="margin: 0 auto;">
								 	<span class="input-group-text" ><i class="fas fa-search pasuc-color-red"></i></span>
									<input class="" style="width: 400px; text-align: center;"  id="input" placeholder="Search" onkeyup="search()">								
								</div>
								</div>
								</div>
					            <div class="card-body">
					            
					                <table class="table table-bordered table-hover" style="width:100%" id="memTable">
					                <!-- HEADER -->
					                <thead>
					                <tr>
					                	<th style="width: 15%">PEC ID</th>
					                	<th style="width: 25%">Name</th>
					                	<th style="width: 25%">Position</th>
					                	<th style="width: 25%">Email</th>
					                	<th style="width: 10%">Rights</th>
					                	<th style="width: 10%">Action</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					                <c:forEach var="p" items="${pec_members}">
						                <tbody>
						                <tr>
						   				    <td style="width: 15%;"><c:out value="${p.pecId}" /></td>
						                	<td style="width: 7%;"><c:out value="${p.lastName}, ${p.firstName} ${f.middleName}" /></td>
						      				<td style="width: 15%;"><c:out value="${p.position}" /></td>
											<td style="width: 15%;"><c:out value="${p.email}" /></td>
											<td style="width: 15%;"><c:out value="${p.rights}" /></td>
											<td>
							                	<div class="text-center">
							                	<a class="btn btn-rounded btn-outline-warning btn-sm" href="#editModal" data-toggle="modal"><i class="fas fa-pencil-alt"></i></a>
							                	</div>
							                </td>
						                </tr>
						                </tbody>
					            
					                
					                
					                <!-- Modal - Edit -->
                                                <div class="modal modal-sm fade" id="editModal">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Edit Account</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                         		 		<form method="post">
                                                            <div class="modal-body">
                                                            <h4> Name </h4>
															<div class="form-group">
											             			<input class="form-control name-inputmask" type="text" name="fName" id="fName" value="${p.firstName}" placeholder="First Name" maxlength="50" required>
											             	</div>
											             	<div class="form-group">
											                  		<input class="form-control name-inputmask" type="text" name="mName" id="mName" value="${p.middleName}" placeholder="Middle Name" maxlength="50">
											                </div>
											             	<div class="form-group">	
											                     	<input class="form-control name-inputmask" type="text" name="lName" id="lName" value="${p.lastName}" placeholder="Last Name" maxlength="50" required>
											         		</div>
											         		<h4> Position </h4>
											         		<div class="form-group">
											         		
											         			<select name="position" id="position" required class="form-control">
															    	<option value="DIRECTOR" id="Director" <c:if test="${p.position eq 'DIRECTOR'}"> selected </c:if> >DIRECTOR</option>
															    	<option value="EVALUATOR" id="Evaluator" <c:if test="${p.position eq 'EVALUATOR'}"> selected </c:if> >EVALUATOR</option>
															    	<option value="ADMINISTRATIVE STAFF" id="AdminStaff" <c:if test="${p.position eq 'ADMINISTRATIVE STAFF'}"> selected </c:if> >ADMINISTRATIVE STAFF</option>
																</select>
															</div>
															<h4> Rights </h4>
											         		<div class="form-group">
											         			<select name="rights" id="rights" required class="form-control">
															    	<option value="A" id="A">A</option>
															    	<option value="B" id="B">B</option>
																</select>
															</div>
															</div>
											  				<div class="modal-footer">
												  				<p class="text-center">By clicking Yes, you are confirming that the changes above are true and final. You may always make changes by clicking the <i class="fas fa-pencil-alt"></i> icon.</p>
												  				<button class="btn btn-warning btn-sm" type="submit">Yes</button>
												  			</div> 
												  		</form>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                    <!-- Modal - Delete -->
                                                <div class="modal modal-sm fade" id="deleteModal">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Delete Account</h4>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </a>
                                                            </div>
                                                            <form method="post" id="deleteAccForm">
                                                            <div class="modal-body">
                                                            <h4 style="text-align: center;"> Enter your password to delete ${p.firstName}'s Account. </h4> <br>
															<div class="form-group">
                        										<input class="form-control form-control-lg" type="password" name = "pswLog" id="pswLog" placeholder="Password" maxlength="20" required>
											             	</div>
											             	</div>
											  				<div class="modal-footer">
												  				<p class="text-center">By clicking Delete, you are confirming that you will delete this account. Account can't retrieved once deleted </p>
												  				<button class="btn btn-warning btn-sm" type="submit">Delete</button>
												  			</div> 
												  			</form>
                                                        </div>
                                                    </div>
                                                </div>            

									</c:forEach>
					                </table>
					                
						        	</div>
					            	</div>
					            	</div>
					            	<br><br>
					            		
					    <!-- ============================================================== -->
					    <!-- CARD -->
					    <!-- ============================================================== --> 
             		
              	</div>
              	</div>
      
      
       			<!-- ============================================================== -->
				<!-- END OF DIR - EVALUATOR TAB -->
				<!-- ============================================================== -->
					</div>
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
    <script>
    function search() {
		var input, filter, found, table, tr, td, i, j;
		
		input = document.getElementById("input");
		filter = input.value.toUpperCase();
		table = document.getElementById("memTable");
		tr = table.getElementsByTagName("tr");
		
		for (i=1; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td");
			
			for (j=0; j < td.length; j++) {
				if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
					found = true;
				}
			}
			
			if (found) {
				tr[i].style.display = "";
				found = false;
			}
			
			else {
				tr[i].style.display = "none";
			}
		}
	}
   		
    $('#deleteModal').on('show.bs.modal', function (e) {
    	  // get information to update quickly to modal view as loading begins
    	  var opener=e.relatedTarget;//this holds the element who called the modal
    	   
    	   //we get details from attributes
    	  var firstname=$(opener).attr('firstName');

    	//set what we got to our form
    	  $('#deleteAccForm').find('[name="firstname"]').val(firstname);
    	   
    	});
   
    $(function(e) {
        "use strict";
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
    });
    </script>
   
</body>
</html>
	