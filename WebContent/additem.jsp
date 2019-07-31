<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.Shravya.Bean.ItemInfo" import="java.sql.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body align="center">
<header><h1 style="text-align:center; ">WAREHOUSE MANAGEMENT SYSTEM</h1></header>
<form action="Admin?operation=addItem" method="post">

<fieldset><legend style="text-align:center; " ><h3>Admin Register</h3></legend>



<table  >
     <tr><th> Item Code:<input type="text" name="item_code"></th></tr>
      
     <tr><th> Item Name:<input type="text" name="item_name"></th></tr>
      
     <tr><th>Price:<input type="text" name="price"></th></tr>
      
     <tr><th> Number of Items to be added:<input type="text" name="stock"></th></tr>
     
     <tr><th><input type="submit" value="submit"></th></tr>
</table>
</fieldset>
</form>
<jsp:useBean id="item" class="com.Shravya.Bean.ItemInfo" />


 
</body>
</html>