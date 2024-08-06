package com.ayushi.EMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class conn {
	
	Connection connection;
	Statement statement;
	
	//5steps
	public conn()
	{
		try {
			
			//1. Register the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Creating the connection String
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","Welcome@2021");
			
			//3. Creating statement
			statement=connection.createStatement();
			
			//4.executing mysql queries
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
