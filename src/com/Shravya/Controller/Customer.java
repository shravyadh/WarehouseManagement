package com.Shravya.Controller;
import com.Shravya.Bean.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Shravya.Bean.CustomerCode;
import com.Shravya.Bean.PurchaseDetails;
import com.Shravya.Connection.GetConnection;
import com.Shravya.DAO.AdminDAO;
import com.Shravya.DAO.CustomerDAO;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/Customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * Default constructor. 
     */
    public Customer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String operation=request.getParameter("operation");
		switch(operation)
		{
		
		case "validation":
		if(new CustomerDAO().validateUser(username,password))
		{
			String customer_code= new CustomerDAO().getCustomerCode(username);
			session.setAttribute("customercode", customer_code);
			request.getRequestDispatcher("customeroperation.jsp").forward(request, response);
		}
		else
		{
			
			out.println("Invalid credentials.Please try again");
			request.getRequestDispatcher("login.jsp?operation=validation").forward(request, response);
		}
		break;
		case "changepassword":
			
			String user = request.getParameter("username");
			String newpassword=request.getParameter("newpassword");
			String confirmpassword=request.getParameter("confirmpassword");
		if(new CustomerDAO().changePassword(newpassword,confirmpassword,user))
		{
			request.getRequestDispatcher("login.jsp?operation=validation").forward(request, response);
		}
		else {
			out.println("Password Mismatch.Please try again!");
			request.getRequestDispatcher("changepassword.jsp?operation=changepassword").forward(request,response);
		}
		break;
		case "register":
			String customer_code= CustomerCode.generateCustomerCode();
			//session.setAttribute("customercode", customer_code);
			String customer_name=request.getParameter("customer_name");
			String user1=request.getParameter("username");
			String contactnumber=request.getParameter("phoneno");
			String address=request.getParameter("address");
			String password1=request.getParameter("password");
			if(new CustomerDAO().registerUser(customer_code,customer_name,address,contactnumber,user1,password1))
			{
				request.getRequestDispatcher("login.jsp?operation=validation").forward(request, response);
			}
			else {
				response.setContentType("text/html");
				response.getWriter().println("<html>\r\n" + 
						"<head>\r\n"  + 
						"<meta charset=\"ISO-8859-1\">\r\n" + 
						"<title>Invalid User</title>\r\n" + 
						"</head>\r\n" + 
						"<body align=\"center\">\r\n" + 
						"<header><h1 style=\"text-align:center; color:white;\">WAREHOUSE MANAGEMENT SYSTEM</h1></header>\r\n" + 
						"<fieldset><legend style=\"text-align:center; color:white;\" ><h3>Invalid User</h3></legend>\r\n" );
				response.getWriter().println("These credentials already exist.Please try again!");
				response.getWriter().println("<br><input type=\"button\" value=\"BACK\" onclick=\"window.location.href='user.jsp'\"></fieldset>\r\n" + 
						"</body>\r\n" + 
						"</html>");
			
			}
		break;
		case "list":
		{
			String text=request.getParameter("List_of_items");
			if(text.equals("yes"))
			{
			CustomerDAO d=new CustomerDAO();
			ArrayList<ItemInfo> list=d.getList(text);
			response.getWriter().println("<html>\r\n" + 
					"<head>\r\n"  + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Product List</title>\r\n" + 
					"</head>\r\n" + 
					"<body align=\"center\">\r\n" + 
					"<header><h1 style=\"text-align:center; color:white;\">WAREHOUSE MANAGEMENT SYSTEM</h1></header>\r\n" + 
					"<fieldset><legend style=\"text-align:center; color:white;\" ><h3>List of Products</h3></legend>\r\n" + 
					"<table align=\"center\" border=\"1\"> ");
			
			 response.getWriter().println("<th>Item Code </th><th>Item Name</th><th>Price</th><th>Stock</th>");
			for(int i=0;i<list.size();i++)
			{
			 ItemInfo f=list.get(i);
			 
			 response.getWriter().println("<tr><td>"+f.getItem_code()+"</td>");
			 response.getWriter().println("<td>"+f.getItem_name()+"</td>");
			 response.getWriter().println("<td>"+f.getPrice()+"</td>");
			 response.getWriter().println("<td>"+f.getStock()+"</td>");
			 response.getWriter().println("<td><a href=cart.jsp?id="+f.getItem_code()+">Order Now</a></td></tr>");
			}
			response.getWriter().println("</table>\r\n" +
					"			</fieldset>\r\n" + 
					"			</body>\r\n" + 
					"			</html>");
		}
		else {
			request.getRequestDispatcher("login.jsp?operation=validation").forward(request, response);
		}
		break;}
		case "ordernow":
			double sum=0;
			String quantity=request.getParameter("quantity_purchased");
		    int stock;
			String code=request.getParameter("item_code");
		String query="select price from iteminfo where item_code="+code;
		String query1="select stock from iteminfo where item_code="+code;
		String query2=null;
			PreparedStatement ps,ps1,ps2;
			try {
				ps = (PreparedStatement) GetConnection.getSQLConnection().prepareStatement(query);
		        
				ResultSet rs=ps.executeQuery(query);
		        while(rs.next())
		        {
		        	if(rs.getInt("price")<10)
		        	{
		        		sum=rs.getInt("price")-(sum+rs.getInt("price"));
		        	}
		        	else if(rs.getInt("price")>=10&&rs.getInt("price")<=100)
		        	{
		        	sum=rs.getInt("price")*Integer.parseInt(quantity)-(sum+rs.getInt("price")*Integer.parseInt(quantity))*(0.1);
		        	}
		        	else {
		        		sum=rs.getInt("price")*Integer.parseInt(quantity)-(sum+rs.getInt("price")*Integer.parseInt(quantity))*(0.2);
		        	}
		        	
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps1= (PreparedStatement) GetConnection.getSQLConnection().prepareStatement(query1);
				ResultSet rs=ps1.executeQuery(query1);
		        while(rs.next())
		        {
		        stock=rs.getInt("stock")-Integer.parseInt(quantity);
		         query2="update iteminfo set stock="+stock+" where item_code="+code;
		         System.out.println(query2);
		        }
		        ps2= (PreparedStatement) GetConnection.getSQLConnection().prepareStatement(query2);
				ps2.executeUpdate(query2) ;
			}catch(Exception e)
			{
				System.out.println(e);
			}
		
			String customercode=(String)session.getAttribute("customercode");
			if(new CustomerDAO().updatePurchaseInfo(customercode,code,quantity))
			{
				response.getWriter().println("<html>\r\n" + 
						"<head>\r\n" + 
						
						"<meta charset=\"ISO-8859-1\">\r\n" + 
						"<title>Thank you!</title>\r\n" + 
						"</head>\r\n" + 
						"<body align=\"center\">\r\n" + 
						"<header><h1 style=\"text-align:center; color:white;\">WAREHOUSE MANAGEMENT SYSTEM</h1></header>\r\n" + 
						"<fieldset><legend style=\"text-align:center; color:white;\" ><h3>Thank you!</h3></legend>\r\n" );
				response.getWriter().println("Thank you for shopping with us");
		        response.getWriter().println("Your total amount is "+sum);
				response.getWriter().println("</fieldset>\r\n" + "</body>\r\n" + "</html>");
			}
		}
	
			
	doGet(request,response);
		}

}
