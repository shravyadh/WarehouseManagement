<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Update Price</title>
</head>
<body>
<header><h1 style="text-align:center;">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<fieldset><legend style="text-align:center; " ><h3>Update Price</h3></legend>
<form action="Admin?operation=updatePrice" method="post">
<table align="center"> 
<tr><th>Item Code:</th><td><input type="text" name="item_code"></td></tr>
<tr><th>Updated Price:</th><td><input type="text" name="price"></td></tr>
<tr><td><input type="submit" value="submit"></td></tr>
</table>
</form>
</fieldset>
</body>
</html>