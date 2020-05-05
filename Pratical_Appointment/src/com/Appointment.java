package com;


	
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class Appointment {
	
		//A common method to connect to the DB
		private Connection connect()
		{
		Connection con = null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Provide the correct details: DBServer/DBName, username, password
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project", "root", "");
		}
		catch (Exception e)
		{e.printStackTrace();}
		return con;
		}
		
		
		
		public String insertpatientapp(String Ano,String patientname,  String Specialist,String Hospital,String Doctor) //,Date  Adate,Time time

		{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for inserting.";
			}
		// create a prepared statement
			 String query = " insert into appointment (`AppointmentID`,`Ano`,`patientname`,`Specialist`,`Hospital`,`Doctor`)"      
					  + " values (?, ?, ?, ?, ?,?)"; 
		 
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, Ano);
		preparedStmt.setString(3, patientname);
		preparedStmt.setString(4, Specialist);
		preparedStmt.setString(5, Hospital);
		preparedStmt.setString(6, Doctor);
		
		// execute the statement
		preparedStmt.execute();
		
		con.close();
		
		output = "Inserted successfully";
		}
		
		
		catch (Exception e)
		{
			output = "Error while inserting the apointments.";
			System.err.println(e.getMessage());
		}
			return output;
		}
		
		
		public String readPatients()
		{   
			String output = ""; 
		 
		  try   
		  {    
			  Connection con = connect(); 
		 
		   if (con == null)
		   {return "Error while connecting to the database for reading."; } 
		 
		   // Prepare the html table to be displayed   
		   output = "<table border=\"1\"><tr><th>Appointment Number</th><th>Patient Name</th><th>Specialist</th><th>Hospital Name</th><th>Doctor Name </th><th>Update</th><th>Remove</th></tr>"; 
		 
		   String query = "select * from appointment";
		   Statement stmt = con.createStatement();
		   ResultSet rs = stmt.executeQuery(query); 
		 
		   // iterate through the rows in the result set    
		   while (rs.next())    
		   {      
			   String AppointmentID= Integer.toString(rs.getInt("AppointmentID"));
			   String Ano= rs.getString("Ano");
		   	   String patientname= rs.getString("patientname"); 
			   String Specialist=rs.getString("Specialist");
			   String Hospital  = rs.getString("Hospital");
			   String Doctor = rs.getString("Doctor"); 
		   
		 
		    	// Add into the html table     
		   		
			   output += "<tr><td><input id=\"hidItemIDUpdate\" name=\"hidItemIDUpdate\" type=\"hidden\" value=\"" +AppointmentID + "\">" 
					   + Ano + "</td>";
		   		output += "<td>" + patientname  + "</td>";
		   		output += "<td>" + Specialist  + "</td>";
		   		output += "<td>" + Hospital + "</td>";
		   		output += "<td>" + Doctor + "</td>"; 
		   		
		   	// buttons     
		   		output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btnUpdate btn-secondary\"></td>"
		   				+ "<td><form method=\"post\" action=\"appointment.jsp\">"
		   				+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
		   				+ "<input name=\"hidItemIDDelete\" type=\"hidden\" value=\"" + AppointmentID
		   				+ "\">" + "</form></td></tr>";
		   		
		   } 
		 
		   con.close(); 
		 
		   // Complete the html table
		   output += "</table>";  
		   }  
			catch (Exception e)   
			{    
				output = "Error while reading the Appointment.";
				System.err.println(e.getMessage());  
			} 
		 
		  return output;  
		  }
		
		//public List<Patient.java>
		
		
		
		public String updateappointment(String AppointmentID,String Ano, String patientname, String Specialist, String Hospital, String Doctor)
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for updating."; }
		// create a prepared statement
		String query = "UPDATE appointment SET Ano=?,patientname=?,Specialist=?,Hospital=?, Doctor=? WHERE AppointmentID=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setString(1, Ano);
		preparedStmt.setString(2, patientname);
		preparedStmt.setString(3, Specialist);
		preparedStmt.setString(4, Hospital);
		preparedStmt.setString(5, Doctor);
		preparedStmt.setInt(6, Integer.parseInt(AppointmentID));
		// execute the statement
		preparedStmt.execute();
		con.close();
		output = "Updated successfully";
		}
		catch (Exception e)
		{
		output = "Error while updating the item.";
		System.err.println(e.getMessage());
		}
		return output;
		}
		public String deleteAppointment(String AppointmentID)
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for deleting."; }
		// create a prepared statement
		String query = "delete from appointment where AppointmentID=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setInt(1, Integer.parseInt(AppointmentID));
		// execute the statement
		preparedStmt.execute();
		con.close();
		output = "Deleted successfully";
		}
		catch (Exception e)
		{
		output = "Error while deleting the item.";
		System.err.println(e.getMessage());
		}
		return output;
		}
		
		
		



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
