<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must revalidate");	
//KULANG CONDITIONS PA NA KAPAG 'DI NAGREG PERO NAG DUMIRETSO DITO, PATI PAG NAKALOG IN NA
	if (session.getAttribute("faculty")!= null && session.getAttribute("empId")!=null && session.getAttribute("email")!=null){
		System.out.println("[REG] Direct to REG, Redirect to HOME");
		response.sendRedirect(request.getContextPath() + "/home");	
	}
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>PUP PASUC Evaluation | Register</title>
</head>
<body>
<h4>Verify Email Address</h4>
	<form name="verEmail" id="verEmail" action="register?verifyEmail=true" method="post">
	<div style="color: #FF0000;">${errorMessageRegister}</div>
		<input type="text" name = "code" id="code" placeholder="6-digit code" maxlength="6" required>
		<button type="submit" name="checkCodeBtn" id="checkCodeBtn" value="Change Password">Save</button>		
	</form>
</body>
</html>