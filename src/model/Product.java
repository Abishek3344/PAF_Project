package model;

import java.sql.*; 

public class Product {
	
	// DB connection
	private Connection connect()
	{
			Connection con = null;
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");

				//DBServer/DBName, username, password
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_product_db", "root", "");
			}
			catch (Exception e)
			{e.printStackTrace();}

			return con;
	}
	
	public String getProducts()
	 {
			String output = "";
			
			try
			{
				Connection con = connect();
	 
				if (con == null)
				{return "Error while connecting to database for reading...."; }
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Project Code</th><th>Product Name</th>" +
						"<th>Description</th>" +
						"<th>Product Type</th>" +
						"<th>Amount</th>" +
						"<th>Update</th><th>Remove</th></tr>";

				String query = "select * from product";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
	 
				// iterate through the rows in the result set
				while (rs.next())
				{
					String id = Integer.toString(rs.getInt("ID"));
					String name = rs.getString("Name");
					String des = rs.getString("Description");
					String type = rs.getString("Type");
					String amount = Double.toString(rs.getDouble("Amount"));
	 
					// Add into the html table
					output += "<tr><td>" + id + "</td>";
					output	+= "<td>" + name + "</td>";
					output += "<td>" + des + "</td>";
					output += "<td>" + type + "</td>";
					output += "<td>" + amount + "</td>";
	 
					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
							+ "<td><form method='post' action='items.jsp'>"
							+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
							+ "<input name='itemID' type='hidden' value='" + id
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
	
	public String addProduct(String name, String type, String des , String amount)
	{
			String output = "";
		
			try 
			{
					Connection con = connect();
					
					if (con == null) {
					return "Error while connecting to the database for inserting...";
			}
			
					// create a prepared statement
					String query = " insert into product(`Name`,`Description`,`Type`,`Amount`)"
									+ " values (?, ?, ?, ?)";
			
					PreparedStatement preparedStmt = con.prepareStatement(query);
			
					// binding values
					preparedStmt.setString(1, name);
					preparedStmt.setString(2, des);
					preparedStmt.setString(3, type);
					preparedStmt.setDouble(4, Double.parseDouble(amount));
			
					// execute the statement

					preparedStmt.execute();
					con.close();
			
					output = "Product inserted successfully!";
			} 
			catch (Exception e) 
			{
				output = "Error while inserting new product...";
				System.err.println(e.getMessage());
			}
			return output;
	}

}
