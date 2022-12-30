<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Create Savings Account </title>
</head>
<body>


   <h1> Create Savings Account</h1>
   
   <form action="/createSavingsAccountRequest" method="POST">
   	
   	
   	
    Account Name : <input type="text" name="accountName" /> <br>
   
    
    
    <input type="submit" value="Create"/>
   
   </form>
   
    <br/>
 	   <a href="/home">HOME</a> 
	<br/>

</body>
</html>