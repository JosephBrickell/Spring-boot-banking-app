<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Register Page </title>
</head>
<body>


   <h1> Registration Form </h1>
   
   <form action="/register" method="POST">
   	
   	
   	
    First Name : <input type="text" name="firstname" /> <br>
    Last Name : <input type="text" name="lastname" /> <br>
    Email : <input type="text" name="email" /> <br>
    DOB : <input type="text" name="dateOfBirth" /> <br>
    Password : <input type="password" name="password" /> <br>
    
    <input type="submit" value="Register"/>
   
   </form>
   
   
   
   <br/>
   <br/>
   <br/>
 	   <a href="/">BACK</a> 
	<br/>

</body>
</html>