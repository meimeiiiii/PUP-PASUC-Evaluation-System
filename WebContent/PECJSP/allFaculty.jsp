<!-- ADMIN - APPLICATION -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	
	
	if (session.getAttribute("pec")==null && session.getAttribute("pecID")==null && session.getAttribute("pecEMAIL")==null){
			System.out.println("[FAC] Direct to FAC, Redirect to LOGIN");
			response.sendRedirect(request.getContextPath() + "/pec-login");	
	}else{
		request.getRequestDispatcher("pec-faculty?process=getAll").include(request, response);
	}
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PUP PASUC Evaluation - Faculty</title>
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
              			<a class="nav-link active"  href="pec-faculty?process=view">Faculty Members</a>
      	            </li>
      	            <li class="nav-item <%if(session.getAttribute("rights").equals("B")){%> link-hide <%}%>" id="evaltab">
                		<a class="nav-link"  href="pec-members?process=view">PEC Members</a>
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
				<!-- ADMIN - FACULTY TAB -->
				<!-- ============================================================== -->
				
       			 <div class="tab-pane fade show active">
       			
             		<div class="col-xl-12">
             		<div class="row">
             		<div class="col-xl-2"></div>
             		<div class="col-xl-8"><h2 style="text-align: center; color: #800000;">List of Faculty Members</h2></div>
             		<div class="col-xl-2"><button class="btn btn-sm btn-warning" onclick="exportTableToExcel('faculTable', 'Faculty')">Export</button></div>
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
					            
					                <table class="table table-bordered table-hover" style="width:100%" id="faculTable">
					                
					                <!-- HEADER -->
					                <thead>
					                <tr>
					                	<th>Name</th>
					                	<th>Employee ID</th>
					                	<th>Department</th>
					                	<th>Rank</th>
					                </tr>
					                </thead>
					                
					                <!-- INSERT VARIABLES -->
					                <c:forEach var="f" items="${facList}">
						                <tbody>
						                <tr>
						                	<td style="width: 30%;"><a class="card-link" href="pec-faculty?process=viewProfile&id=${f.empId}" target="_blank">${f.lastName}, ${f.firstName} ${f.middleName}</a></td>
						                	<td style="width: 15%;"><c:out value="${f.empId}" /></td>
											<td style="width: 30%;"><c:out value="${f.department}" /></td>
											<td style="width: 25%;"><c:out value="${f.rank}" /></td>
						                </tr>
						                </tbody>
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
				<!-- END OF ADMIN - FACULTY TAB -->
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
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="assets\vendor\Export-Html-Table-To-Excel-Spreadsheet-using-jQuery-table2excel/src/jquery.table2excel.js"></script>
    <script>
	    function exportTableToExcel(tableID, filename = ''){
	        var downloadLink;
	        var dataType = 'application/vnd.ms-excel';
	        var tableSelect = document.getElementById(tableID);
	        var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
	        
	        // Specify file name
	        filename = filename?filename+'.xls':'excel_data.xls';
	        
	        // Create download link element
	        downloadLink = document.createElement("a");
	        
	        document.body.appendChild(downloadLink);
	        
	        if(navigator.msSaveOrOpenBlob){
	            var blob = new Blob(['\ufeff', tableHTML], {
	                type: dataType
	            });
	            navigator.msSaveOrOpenBlob( blob, filename);
	        }else{
	            // Create a link to the file
	            downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
	        
	            // Setting the file name
	            downloadLink.download = filename;
	            
	            //triggering the function
	            downloadLink.click();
	        }
	    }
	</script>
    
    <script>
    function search() {
		var input, filter, found, table, tr, td, i, j;
		
		input = document.getElementById("input");
		filter = input.value.toUpperCase();
		table = document.getElementById("faculTable");
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
    </script>
   
</body>
</html>
	