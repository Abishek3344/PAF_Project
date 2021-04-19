package model;

import java.sql.*; 

public class Project {
	
	// DB connection
		private Connection connect()
		{
				Connection con = null;
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");

					//Provide the correct details: DBServer/DBName, username, password
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_gb", "root", "");
				}
				catch (Exception e)
				{e.printStackTrace();}
	
				return con;
		}
		
		public String readProjects()
		 {
				String output = "";
				
				try
				{
					Connection con = connect();
		 
					if (con == null)
					{return "Error while connecting to the database for reading."; }
					// Prepare the html table to be displayed
					output = "<table border='1'><tr><th>Project Code</th><th>Project Name</th>" +
							"<th>Project Details</th>" +
							"<th>ProjectFund</th>" +
							"<th>Update</th><th>Remove</th></tr>";

					String query = "select * from project";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
		 
					// iterate through the rows in the result set
					while (rs.next())
					{
						String projectID = Integer.toString(rs.getInt("projectID"));
						String projectName = rs.getString("projectName");
						String projectDetails = rs.getString("projectDetails");
						String projectFund = Double.toString(rs.getDouble("projectFund"));
		 
						// Add into the html table
						output += "<tr><td>" + projectID + "</td>";
						output	+= "<td>" + projectName + "</td>";
						output += "<td>" + projectDetails + "</td>";
						output += "<td>" + projectFund + "</td>";
		 
						// buttons
						output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
								+ "<td><form method='post' action='items.jsp'>"
								+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
								+ "<input name='itemID' type='hidden' value='" + projectID
								+ "'>" + "</form></td></tr>";
					}
		 
					con.close();
					
					// Complete the html table
					output += "</table>";
				}
				catch (Exception e)
				{
					output = "Error while reading the items.";
					System.err.println(e.getMessage());
				}
		 
				return output;
		 } 


}
