<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="fundTransfer.app" method="get">
<h3>Enter Sender's Account Number: <input type="number" name="accountNumber1" required="required"/> </h3>
<h3>Enter Receiver's's Account Number: <input type="number" name="accountNumber2" required="required"/></h3>
<h3>Enter Amount: <input type="number" name="amount" required="required"/> </h3>
<br><input type="submit" value="Transfer">
</form>
</body>
</html>