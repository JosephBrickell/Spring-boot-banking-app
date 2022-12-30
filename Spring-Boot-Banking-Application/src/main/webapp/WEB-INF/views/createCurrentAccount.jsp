<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Create Current Account </title>
</head>
<body>


   <h1> Create Current Account</h1>
   
   <form action="/createCurrentAccountRequest" method="POST">
   	
   	
   	
    Account Name : <input type="text" name="accountName" /> <br>
    Overdraft Limit : <input type="text" name="overdraftLimit" /> <br>
   
    
    
    <input type="submit" value="Create"/>
   
   </form>
   
   
    <br/>
 	   <a href="/home">HOME</a> 
	<br/>

</body>
</html>