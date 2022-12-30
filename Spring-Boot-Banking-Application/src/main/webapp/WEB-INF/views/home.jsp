<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ab.entities.Customer"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<h1 align = "center"> BRICKELL BANK  </h1>


	   <div>
	   <b> Welcome <c:forEach var="s" items="${session_customer}">	
	   
	   <c:out value="${s.firstname}"/> 
	   
	   </c:forEach>	</b> 
	   
	   
	   </div>
	   
	   
	   
	   
	   <br/>
 	   <a href="/createCurrentAccount">CREATE CURRENT ACCOUNT </a> 
	   <br/>
	   <a href="/createSavingsAccount">CREATE SAVINGS ACCOUNT </a> 
	   <br/>
 	   <a href="/seeCurrentAccount">VIEW CURRENT ACCOUNT </a> 
	   <br/>
 	   <a href="/seeSavings">VIEW SAVINGS ACCOUNT </a> 
	 
	
		
</body>
</html>