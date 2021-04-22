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
		
		
		public String insertProject(String name, String details, String fund)
		{
				String output = "";
			
				try 
				{
						Connection con = connect();
						
						if (con == null) {
						return "Error while connecting to the database for inserting.";
				}
				
						// create a prepared statement
						String query = " insert into project(`projectID`,`projectName`,`projectDetails`,`projectFund`)"
										+ " values (?, ?, ?, ?)";
				
						PreparedStatement preparedStmt = con.prepareStatement(query);
				
						// binding values
						preparedStmt.setInt(1, 0);
						preparedStmt.setString(2, name);
						preparedStmt.setString(3, details);
						preparedStmt.setDouble(4, Double.parseDouble(fund));
				
						// execute the statement

						preparedStmt.execute();
						con.close();
				
						output = "Inserted successfully";
				} 
				catch (Exception e) 
				{
					output = "Error while inserting the item.";
					System.err.println(e.getMessage());
				}
				return output;
		}
 
		
		public String updateProject(String ID, String name, String details, String fund)

		{
				String output = "";
			
				try 
				{
					Connection con = connect();
					if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				
					// create a prepared statement
					String query = "UPDATE project SET projectName=?,projectDetails=?,projectFund=? WHERE projectID=?";
				
					PreparedStatement preparedStmt = con.prepareStatement(query);
				
					// binding values
					preparedStmt.setString(1, name);
					preparedStmt.setString(2, details);
					preparedStmt.setDouble(3, Double.parseDouble(fund));
					preparedStmt.setInt(4, Integer.parseInt(ID));
				
					// execute the statement
					preparedStmt.execute();
					con.close();
				
					output = "Updated successfully";
			} 
				catch (Exception e) 
				{
					output = "Error while updating the project.";
					System.err.println(e.getMessage());
				}
			
				return output;
		}
	
	        public String deleteProject(String projectID) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from project where projectID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(projectID));
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Deleted successfully";
			} catch (Exception e) {
				output = "Error while deleting the item.";
				System.err.println(e.getMessage());
			}
			return output;
		}


}
