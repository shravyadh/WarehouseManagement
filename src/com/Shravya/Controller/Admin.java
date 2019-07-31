package com.Shravya.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import com.Shravya.Bean.*;
import com.Shravya.DAO.AdminDAO;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String operation=request.getParameter("operation");
		switch(operation)
		{
		
		case "validation":
		if(new AdminDAO().validateAdmin(username,password))
		{
			System.out.println("Welcome");
			request.getRequestDispatcher("adminoperation.jsp").forward(request, response);
		}
		else
		{
			
			out.println("Invalid credentials.Please try again");
			request.getRequestDispatcher("loginadmin.jsp?operation=validation").forward(request, response);
		}
		break;
		case "changepassword":
			
			String user = request.getParameter("username");
			String newpassword=request.getParameter("newpassword");
			String confirmpassword=request.getParameter("confirmpassword");
		if(new AdminDAO().changePassword(newpassword,confirmpassword,user))
		{
			request.getRequestDispatcher("loginadmin.jsp?operation=validation").forward(request, response);
		}
		else {
			out.println("Password Mismatch.Please try again!");
			request.getRequestDispatcher("adminchangepassword.jsp?operation=changepassword").forward(request,response);
		}
		break;
		case "register":
			String admin_code= AdminCode.generateAdminCode();
			String admin_name=request.getParameter("admin_name");
			String user1=request.getParameter("username");
			String contactnumber=request.getParameter("phoneno");
			String address=request.getParameter("address");
			String password1=request.getParameter("password");
			if(new AdminDAO().registerUser(admin_code,admin_name,address,contactnumber,user1,password1))
			{
				request.getRequestDispatcher("login.jsp?operation=validation").forward(request, response);
			}
		break;
		case "addItem":
			String item_code=request.getParameter("item_code");
			String item_name=request.getParameter("item_name");
			String price=request.getParameter("price");
			String stock=request.getParameter("stock");
			if(new AdminDAO().addItem(item_code,item_name,price,stock))
			{
				out.print("ITEM ADDED");
				request.getRequestDispatcher("adminoperation.jsp").forward(request, response);
			}
		break;
		case "addStock":
			String code=request.getParameter("item_code");
			String s=request.getParameter("stock");
			if(new AdminDAO().addStock(code,s))
			{
				request.getRequestDispatcher("adminoperation.jsp").forward(request, response);
			}
		break;
		case "updatePrice":
			String c=request.getParameter("item_code");
			String p=request.getParameter("price");
			if(new AdminDAO().updatePrice(c,p))
			{
				request.getRequestDispatcher("adminoperation.jsp").forward(request, response);
			}
		break;
		case "list":
			
			String date=request.getParameter("date_of_purchase");
			AdminDAO d=new AdminDAO();
			ArrayList<PurchaseDetails> list=d.getList(date);
			response.getWriter().println("<table border=1>");
		     response.getWriter().println("<th>Transaction ID </th><th>Customer Code</th><th>Item Code</th><th>Date of Purchase</th><th>Quantity Purchased</th>");
			for(PurchaseDetails pd:list)
			{
				
		     
			 response.getWriter().println("<tr><td>"+pd.getTransaction_id()+"</td>");
			 response.getWriter().println("<td>"+pd.getCustomer_code()+"</td>");
			 response.getWriter().println("<td>"+pd.getItem_code()+"</td>");
			 response.getWriter().println("<td>"+pd.getDate_of_purchase()+"</td>");
			 response.getWriter().println("<td>"+pd.getQuantity_purchased()+"</td>");
			}
			//HttpSession session=request.getSession();
			//session.setAttribute("purchase",list);
		    //request.getRequestDispatcher("listcustomer.jsp").forward(request, response);
		break;
		case "deleteItem":
			String i=request.getParameter("item_code");
			if(new AdminDAO().deleteItem(i))
			{
				request.getRequestDispatcher("adminoperation.jsp").forward(request, response);
			}
			break;
		}
		
		doGet(request, response);
	}

}
