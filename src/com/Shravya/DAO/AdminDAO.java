package com.Shravya.DAO;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.time.LocalDate;

import com.Shravya.Connection.GetConnection;
import com.Shravya.Bean.*;
public class AdminDAO {
	public PreparedStatement ps=null;
	public ResultSet rs1,rs2;
public boolean validateAdmin(String username,String password) {
	String sql="select * from admin where username=? and password=?";
	
	try {
		Connection con=GetConnection.getSQLConnection();
		ps=con.prepareStatement(sql);
// TODO Auto-generated catch block
	    ps.setString(1, username);
	// TODO Auto-generated catch block
	    ps.setString(2, password);
	
		rs1=ps.executeQuery();
	
	
		return rs1.next();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
}
public boolean changePassword(String newpassword,String confirmpassword,String username)
{
	if(newpassword.contentEquals(confirmpassword))
	{
		System.out.println(" "+newpassword+" "+confirmpassword+" "+username);
	String query="update admin set password='"+newpassword+"' where username='"+username+"'";
	
	try {
		ps=GetConnection.getSQLConnection().prepareStatement(query);
		ps.executeUpdate();
		return true;
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
	}
	else {
		System.out.println("Passwords do not match");
	}
	return false;
}
public boolean registerUser(String admin_code,String admin_name,String address,String contactnumber,String username,String password)
{
	String query="insert into admin values (?,?,?,?,?,?)";
    try {
    	ps=GetConnection.getSQLConnection().prepareStatement(query);
    	ps.setString(1, admin_code);
    	ps.setString(2, admin_name);
    	ps.setString(3, address);
    	ps.setString(4, contactnumber);
    	ps.setString(5, username);
    	ps.setString(6, password);
    	ps.executeUpdate();
    	return true;
    }catch(Exception e) {
      e.printStackTrace();
    }
    return false;
}
public boolean addItem(String item_code,String item_name,String price, String stock)
{ 
	
	String query="insert into iteminfo values (?,?,?,?)";
    try {
    	ps=GetConnection.getSQLConnection().prepareStatement(query);
    	ps.setString(1, item_code);
    	ps.setString(2, item_name);
    	ps.setString(3, price);
    	ps.setString(4,stock);
    	ps.executeUpdate();
    	return true;
    }catch(Exception e) {
      e.printStackTrace();
    }
    return false;
}
public boolean addStock(String item_code, String stock)
{ 
	String q="select stock from iteminfo where item_code="+item_code;
	try {
		int total=0,t;
		ps=GetConnection.getSQLConnection().prepareStatement(q);
		rs1=ps.executeQuery(q);
	if(rs1.next())
	{
		t=rs1.getInt(1);
		total=Integer.parseInt(stock)+t;
	}
	String query="update iteminfo set stock='"+total+"' where item_code="+item_code;
  
    	ps=GetConnection.getSQLConnection().prepareStatement(query);
    	
    	ps.executeUpdate();
    	return true;
    }catch(Exception e) {
      e.printStackTrace();
    }
    return false;
}
public boolean updatePrice(String item_code, String price)
{ 
	try {
		

	String query="update iteminfo set price='"+price+"' where item_code="+item_code;
  
    	ps=GetConnection.getSQLConnection().prepareStatement(query);
    	
    	ps.executeUpdate();
    	return true;
    }catch(Exception e) {
      e.printStackTrace();
    }
    return false;
}
public  ArrayList<PurchaseDetails> getList(String date)
{
	
	Date d=java.sql.Date.valueOf(date);

    ArrayList<PurchaseDetails> purchase=new ArrayList<PurchaseDetails>();
    String query="select * from purchaseinfo where date_of_purchase='"+d+"'";
    try {
    	ps=GetConnection.getSQLConnection().prepareStatement(query);
    	rs1=ps.executeQuery(query);
    	while(rs1.next())
    	{
    		PurchaseDetails p=new PurchaseDetails();
    		p.setTransaction_id(rs1.getString(1));
    		p.setCustomer_code(rs1.getString(2));
    		p.setItem_code(rs1.getString(3));
    		p.setDate_of_purchase(rs1.getString(4));
    		p.setQuantity_purchased(rs1.getString(5));
    		 purchase.add(p);
            
    	}
    }catch(SQLException e)
    {
    	e.printStackTrace();
    }
   
    return purchase;
	
}
public boolean deleteItem(String item_code)
{ 
	try {
		

	String query="delete from iteminfo where item_code="+item_code;
  
    	ps=GetConnection.getSQLConnection().prepareStatement(query);
    	
    	ps.executeUpdate();
    	return true;
    }catch(Exception e) {
      e.printStackTrace();
    }
    return false;
}
}
