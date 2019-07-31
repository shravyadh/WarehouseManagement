package com.Shravya.Connection;

import java.sql.*;

public class GetConnection {
private static Connection con;


public static Connection getSQLConnection() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/warehousemanagement", "root", "root");
	   System.out.println(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return con;
}
}
