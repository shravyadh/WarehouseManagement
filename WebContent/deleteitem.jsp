<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Delete Items</title>
</head>
<body align="center">
<header><h1 style="text-align:center; ">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<fieldset><legend style="text-align:center;" ><h3>Delete Items</h3></legend>
<form action="Admin?operation=deleteItem" method="post">
<table align="center">
<tr><td>Item Code:<input type="text" name="item_code"></td></tr>
<tr><td><input type="submit" value="Delete"></td></tr>
</table>
</form>
</fieldset>
</body>
</html>