<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Customer Register</title>
</head>
<body align="center" >
<div class="bg-img" ></div>
<header><h1 style="text-align:center; ;">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<form action="Customer?operation=register" method="post">
<fieldset><legend style="text-align:center; " ><h3>Customer Register</h3></legend>
<table align="center">
  <tr><td> Name:</td><td><input type="text" name="customer_name" required></td></tr>
   <tr><td>UserName:</td><td><input type="text" name="username" required></td></tr>
   <tr><td>Contact Number:</td><td><input type="text" name="phoneno" required></td></tr>
   <tr><td>Address:</td><td><input type="text" name="address" required></td></tr>
   <tr><td>Password:</td><td><input type="password" name="password" required></td></tr>
</table>
 <input type="submit" value="submit"  >
</fieldset>
</form>
</body>
</html>
