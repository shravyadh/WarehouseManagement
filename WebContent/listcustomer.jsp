<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.Shravya.Bean.*" import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>List of Customers</title>
</head>
<body align="center">
<header><h1 style="text-align:center;">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<fieldset><legend style="text-align:center; " ><h3>List of Customers</h3></legend>
<form action="Admin?operation=list" method="post">
<table align="center"> 
<tr><th>Enter date:<input type="text" name="date_of_purchase"></th></tr>
<tr><th><input type="submit" value="submit"></th></tr>
</table>
</form>
</fieldset>
</body>
</html>