

$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});


// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	
	// Form validation-------------------
	var status = validateAppointmentForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	$("#formAppointment").submit();
});





// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	$("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
	$("#Ano").val($(this).closest("tr").find('td:eq(0)').text());
	$("#patientname").val($(this).closest("tr").find('td:eq(1)').text());
	$("#Specialist").val($(this).closest("tr").find('td:eq(2)').text());
	$("#Hospital").val($(this).closest("tr").find('td:eq(3)').text());
	$("#Doctor").val($(this).closest("tr").find('td:eq(4)').text());
});



// CLIENTMODEL=========================================================================
function  validateAppointmentForm()
{
	// CODE
	if ($("#Ano").val().trim() == "")
	{
		return "Insert Appointment Number.";
	}
	// NAME
	if ($("#patientname").val().trim() == "")
	{
		return "Insert Patient Name.";
	}

		// specialist-------------------------------
	if ($("#Specialist").val().trim() == "")
	{
		return "Insert Specialist.";
	}
	

		// Hospital-------------------------------
	if ($("#Hospital").val().trim() == "")
	{
		return "Insert Hospital Name.";
	}
		
	
	
	
	
	
	// Doctor------------------------
	if ($("#Doctor").val().trim() == "")
	{
		return "Insert Doctor Name.";
	}
return true;
}