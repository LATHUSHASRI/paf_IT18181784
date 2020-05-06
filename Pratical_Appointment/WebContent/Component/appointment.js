

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
	
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
			{
			url : "AppointmentsAPI",
			type : type,
			data : $("#formAppointment").serialize(),
			dataType : "text",
			complete : function(response, status)
			{
			onItemSaveComplete(response.responseText, status);
			}
			});
	
	
});


function onItemSaveComplete(response, status)
{
	if (status == "success")
	{
			var resultSet = JSON.parse(response);
			if (resultSet.status.trim() == "success")
			{
				$("#alertSuccess").text("Successfully saved.");
				$("#alertSuccess").show();
				$("#divItemsGrid").html(resultSet.data);
			} else if (resultSet.status.trim() == "error")
			{
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
			}
	} else if (status == "error")
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
		$("#hidItemIDSave").val("");
		$("#formItem")[0].reset();
}




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



//romove

$(document).on("click", ".btnRemove", function(event)
{
		$.ajax(
		{
			url : "AppointmentsAPI",
			type : "DELETE",
			data : "AppointmentID=" + $(this).data("appointmentID"),
			dataType : "text",
			complete : function(response, status)
		{
				onItemDeleteComplete(response.responseText, status);
		}
		});
});


function onItemDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
	} else if (resultSet.status.trim() == "error")
	{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
	}
	} else if (status == "error")
	{
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}



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




