<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Add Stock</title>
</head>
<body align="center">
<header><h1 style="text-align:center;">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<form action="Admin?operation=addStock" method="post">  
<fieldset><legend style="text-align:center;" ><h3>Add Stock</h3></legend>
<table align="center">
<tr><td>Item Code:</td><td><input type="text" name="item_code"></td></tr>
<tr><td>Number to be added:</td><td><input type="text" name="stock"></td></tr>
<tr><td><input type="submit" value="submit"></td></tr>
</table>
</fieldset>
</form>
</body>
</html>