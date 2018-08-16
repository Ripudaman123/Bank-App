<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="withdraw.app" method="get">
<h3>Enter Account Number: </h3><input type="number" name="accountNumber" required="required"/>
<h3>Enter Amount: </h3><input type="number" name="amount" required="required"/>
<br><input type="submit" value="Withdraw">
</form>
</body>
</html>