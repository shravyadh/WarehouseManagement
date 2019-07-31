<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Change password</title>
</head>
<body align="center">
<header><h1 style="text-align:center; ">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<fieldset><legend style="text-align:center; " ><h3>Change password</h3></legend>
<form name="changepassword" action="Customer?operation=changepassword" method="post">
<table align="center">
      <tr><td>UserName:</td><td><input type="text" name="username"></td></tr>
         <tr><td>New Password:</td><td><input type="password" name="newpassword"></td></tr>
         <tr><td>Confirm Password:</td><td><input type="password" name="confirmpassword"></td></tr>
         <tr><td><input type="submit" value="submit"></td></tr>
      </table>
</form>
</fieldset>
</body>
</html>