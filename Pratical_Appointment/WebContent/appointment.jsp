
 <%@ page import = "com.Appointment" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
  


   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Management</title>


<link rel="stylesheet" href="View/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<div class="row">
		
			<div class="col-8">
			
				<h1>Appointments </h1>
		
		
		
				<form id="formAppointment" name="formAppointment" method="post" action="appointment.jsp">
					Appointment Number:
					<input id="Ano" name="Ano" type="text"
								class="form-control form-control-sm">
					<br> Patient Name:
					<input id="patientname" name="patientname" type="text"
								class="form-control form-control-sm">
					<br> Specialist:
					<input id="Specialist" name="Specialist" type="text"
								class="form-control form-control-sm">
					<br> Hospital Name:
					<input id="Hospital" name="Hospital" type="text"
									class="form-control form-control-sm">
					<br> Doctor Name:
					<input id="Doctor" name="Doctor" type="text"
									class="form-control form-control-sm">
					<br>
					<input id="btnSave" name="btnSave" type="button" value="Save"
										class="btn btn-primary">
					<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
				
		
					</form>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
			
				<%
						Appointment appObj = new Appointment();
						out.print(appObj.readPatients());
				%>
				
			</div>

		</div>
	</div>
	<script src="Component/jquery-3.3.1.min.js"></script>
	<script src="Component/appointment.js"></script>
</body>
</html>	
			
			
		
	


	

