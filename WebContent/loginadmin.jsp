<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>

<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body align="center">
<header><h1 style="text-align:center; ">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<fieldset><legend style="text-align:center; " ><h3>Admin Login</h3></legend>
<form action="Admin?operation=validation" method="post">
<table align="center"> 
         <tr><td>UserName:</td><td><input type="text" name="username"></td></tr>
         <tr><td>Password:</td><td><input type="text" name="password"></td></tr>
         <tr><td><input type="submit" value="submit"></td></tr>
         <tr><td><a href="changepassword.jsp">Forgot Password</a></td></tr>
         <tr><td><a href="admin.jsp">New User?Register Now</a></td></tr>
</table>
</form>
</fieldset>
</body>
</html>