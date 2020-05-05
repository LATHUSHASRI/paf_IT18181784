
 <%@ page import = "com.Appointment" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
  
    
 <%   
 //Save---------------------------------
if (request.getParameter("Ano") != null)
{
	Appointment appObj = new Appointment();
	String stsMsg = "";
	//Insert--------------------------
	if (request.getParameter("hidItemIDSave") == "")
	{
		stsMsg = appObj.insertpatientapp(request.getParameter("Ano"),
			request.getParameter("patientname"),
			request.getParameter("Specialist"),
			request.getParameter("Hospital"),
			request.getParameter("Doctor"));
	}
else//Update----------------------
	{
		stsMsg = appObj.updateappointment(request.getParameter("hidItemIDSave"),
			request.getParameter("Ano"),
			request.getParameter("patientname"),
			request.getParameter("Specialist"),
			request.getParameter("Hospital"),
			request.getParameter("Doctor"));
	}
	session.setAttribute("statusMsg", stsMsg);
}
 
 
 
//Delete-----------------------------
if (request.getParameter("hidItemIDDelete") != null)
{
	Appointment appObj = new Appointment();
	String stsMsg = appObj.deleteAppointment(request.getParameter("hidItemIDDelete"));
	session.setAttribute("statusMsg", stsMsg);
}

%>

   
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
				<div id="alertSuccess" class="alert alert-success">
					<%
						out.print(session.getAttribute("statusMgs"));
					%>
				
				</div>
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
			
			
		
	


	

