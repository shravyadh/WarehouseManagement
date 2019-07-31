<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.Shravya.Bean.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Welcome Customer!</title>
</head>
<body align="center">
<header><h1 style="text-align:center;">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<fieldset><legend style="text-align:center; " ><h3>Welcome Customer!</h3></legend>
<form action="Customer?operation=list" method="post">
<table align="center">
<tr><th>List of Products(yes/no?):</th></tr>
<tr><td>Yes:</td><td><input type="radio" name="List_of_items" value="yes"></td></tr>
<tr><td>No:</td><td><input type="radio" name="List_of_items" value="no"></td></tr>
<tr><td><input type="submit" value="submit"></td></tr>
</table>
</form>
</fieldset>
</body>
</html>