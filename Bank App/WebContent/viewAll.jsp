<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Saving Accounts</h2>
<table border="1">

				<tr>
					<th>Account Number</th>
					<th>Account Holder Name</th>
					<th>Customer ID</th>
					<th>Account Balance</th>
					<th>Account Salaried </th>
				</tr>
				<jstl:forEach var="viewsa" items="${requestScope.viewsa}">
					<tr>
						<td>${viewsa.accountNumber}</td>
						<td>${viewsa.accountHolder.customerName}</td>
						<td>${viewsa.accountHolder.customerId}</td>
						<td>${viewsa.accountBalance}</td>
						<td>${viewsa.salary}</td>
						
					</tr>
				</jstl:forEach>
</table>

<h2>Current Accounts</h2>
<table border="1">

				<tr>
					<th>Account Number</th>
					<th>Account Holder Name</th>
					<th>Customer ID</th>
					<th>Account Balance</th>
					<th>Account Overdraft Limit</th>
				</tr>
				<jstl:forEach var="viewcu" items="${requestScope.viewcu}">
					<tr>
						<td>${viewcu.accountNumber}</td>
						<td>${viewcu.accountHolder.customerName}</td>
						<td>${viewcu.accountHolder.customerId}</td>
						<td>${viewcu.accountBalance}</td>
						<td>${viewcu.odLimit}</td>
						
					</tr>
				</jstl:forEach>
</table>
</body>
</html>