<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body align="center">
<header><h1 style="text-align:center; ">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<form action="Customer?operation=validation" method="post">  
<fieldset><legend style="text-align:center; " ><h3>Customer Login</h3></legend>
<table align="center">
           <tr><td>UserName : </td><td><input type="text" name="username"></td></tr>  

           <tr><td>Password  : </td><td><input type="password" name="password"></td></tr>
           <tr><td><input type="submit" value="Login"></td></tr>  
           <tr><td><a href="changepassword.jsp"> Forgot Password</a></td></tr>
           <tr><td><a href="user.jsp">New User? Register Now</a></td></tr>
</table>
</fieldset></form>
</body>
</html>