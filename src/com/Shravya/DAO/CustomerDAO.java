package com.Shravya.DAO;
import com.Shravya.Bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.Shravya.Bean.PurchaseDetails;
import com.Shravya.Connection.GetConnection;

public class CustomerDAO {
	public PreparedStatement ps=null;
	public ResultSet rs1;
	public ResultSet rs2;
public boolean validateUser(String username,String password) {
	String sql="select * from customer where username=? and password=?";
	
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
	String query="update customer set password='"+newpassword+"' where username='"+username+"'";

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
public boolean registerUser(String customer_code,String customer_name,String address,String contactnumber,String username,String password)
{
	String query="insert into customer values (?,?,?,?,?,?)";
    try {
    	ps=GetConnection.getSQLConnection().prepareStatement(query);
    	ps.setString(1, customer_code);
    	ps.setString(2, customer_name);
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
public  ArrayList<ItemInfo> getList(String text)
{
	

	

    ArrayList<ItemInfo> item=new ArrayList<ItemInfo>();
    String query="select * from iteminfo";
    try {
    	ps=GetConnection.getSQLConnection().prepareStatement(query);
    	rs1=ps.executeQuery(query);
    	while(rs1.next())
    	{
    		ItemInfo i=new ItemInfo();
            i.setItem_code(rs1.getString(1));
    		i.setItem_name(rs1.getString(2));
    		i.setPrice(rs1.getString(3));
    		i.setStock(rs1.getString(4));
    		
    		
    		 item.add(i);   
    	}
    }catch(SQLException e)
    {
    	e.printStackTrace();
    }
 
    return item;
	

	}
public boolean updatePurchaseInfo(String customer_code,String item_code,String quantity_purchased)
{
	
	 Random r=new Random();
	  int n=r.nextInt(2000);
	  String s=String.valueOf(n);
	
	
	 
	String query="insert into purchaseinfo values (?,?,?,?,?)";
    try {
    	ps=GetConnection.getSQLConnection().prepareStatement(query);
    	ps.setString(1, s);
    	ps.setString(2, customer_code);
    	ps.setString(3, item_code);
    	ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
    	ps.setString(5, quantity_purchased);
    	
    	ps.executeUpdate();
    	return true;
    }catch(Exception e) {
      e.printStackTrace();
    }
   
	 return false;
	 
	 }
public  String getCustomerCode(String username) {
	// TODO Auto-generated method stub
	String query="select customer_code from customer where username='"+username+"'";
	String q=null;
	 try {
	    	ps=GetConnection.getSQLConnection().prepareStatement(query);
	    	rs1=ps.executeQuery(query);
	    	while(rs1.next())
	    	{
	    		q=rs1.getString(1);
	    	}
	    	return q;
	    }catch(Exception e)
	 {
		 System.out.println(e);
	 }
	 return null;
}

}

