<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body align="center">
<header><h1 style="text-align:center;" >WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<fieldset><legend style="text-align:center;"  ><h3>Add to cart</h3></legend>
<form action="Customer?operation=ordernow" method="post">
<table align="center">
<%String id=(String)request.getParameter("id"); %>
<tr><td>Enter item code:</td><td><input type="text" name="item_code" value=<%=id %> readonly></td></tr>
<tr><td>Quantity required:</td><td><input type="text" name="quantity_purchased"></td></tr>
<tr><td><input type="submit" value="submit"></td></tr>
</table>
</form>
</fieldset>
</body>
</html>