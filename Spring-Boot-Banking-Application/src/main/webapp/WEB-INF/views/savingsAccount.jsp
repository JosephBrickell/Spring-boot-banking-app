<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ab.entities.CurrentAccount"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Savings Account</title>
</head>
<body>
<table border = "1">
	<thread>
		<tr>
			<td>Account Number </td>
			<td>Account Name </td>
			<td>Balance </td>
			
		</tr>
	</thread>

<c:forEach var="c" items="${savings_account}">
	<tr>
	
	
	   <td> <c:out value="${c.accountNumber}"/> </td> 
	   <td> <c:out value="${c.accountName}"/> </td>
	   <td> £<c:out value="${c.balance}"/> </td>
	
	</tr>  
	   </c:forEach>
	   
	
</table>	   
	   <br/>
	   <br/>
	   <br/>
 	   <a href="/depositAmountSavings">DEPOSIT MONEY </a>
 	   <br/>
 	   <br/>
 	   <br/>
	   <a href="/withdrawAmountSavings">WITHDRAW MONEY </a>

<br/>
<br/>


 <br/>
 	   <a href="/home">HOME</a> 
	<br/>

<table border = "1">
	<thread>
		<tr>
			<td>Transaction ID</td>
			<td>Amount</td>
			<td>Transaction Type </td>
			
		</tr>
	</thread>

<c:forEach var="t" items="${transactions_List}">
	<tr>
	   <td><c:out value="${t.transactionId}"/> </td> 
	   <td>£<c:out value="${t.amount}"/> </td> 
	   <td><c:out value="${t.transactionType}"/> </td> 
	</tr>   
	   </c:forEach>
</table>

</body>
</html>