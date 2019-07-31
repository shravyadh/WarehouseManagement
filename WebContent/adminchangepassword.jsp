<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body align="center">
<header><h1 style="text-align:center; ">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<form name="adminchangepassword" action="Admin?operation=changepassword" method="post">
<fieldset><legend style="text-align:center; " ><h3>Change Password</h3></legend>
<table align="center">
         <tr><td>UserName:</td><td><input type="text" name="username"></td></tr>
         <tr><td>New Password:</td><td><input type="password" name="newpassword"></td></tr>
         <tr><td>Confirm Password:</td><td><input type="password" name="confirmpassword"></td></tr>
         <tr><td><input type="submit" value="submit"></td></tr>
      </table>
      </fieldset>
</form>
</body>
</html>