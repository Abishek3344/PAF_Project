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


}
