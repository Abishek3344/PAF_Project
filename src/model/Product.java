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

}
