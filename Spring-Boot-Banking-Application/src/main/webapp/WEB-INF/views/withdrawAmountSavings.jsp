<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Withdraw From Current Account </title>
</head>
<body>


   <h1> Withdraw </h1>
   
   <form action="/withdrawFromSavingsAccount" method="POST">
   	
   	
   	
    Amount : <input type="text" name="amount" /> <br>
   
    
    
    <input type="submit" value="submit"/>
   
   </form>
   
    <br/>
 	   <a href="/home">HOME</a> 
	<br/>

</body>
</html>