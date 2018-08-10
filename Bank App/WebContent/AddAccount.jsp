<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="align: center;">
		<form action=".app" method="get">
		<br><input type="text" name="txtName" required="required"
				value="${requestScope.customer.customerName}" /><br /> 
		<br><input type="number" name="contactnumber" required="required"
				value="${requestScope.customer.contactNumber}" /><br /> 
		<br><input type="email" name="emaiId" required="required"
				value="${requestScope.customer.emailId}" /><br /> 		
		<br><input type="date" name="txtName" required="required"
				value="${requestScope.customer.dateOfBirth}" /><br /> 

				<input type="submit" value="Save" />
			
			
			
			
			<jstl:if test="${requestScope. != null }">
				<input type="number" name="txtId" required="required"
					readonly="readonly" value="${requestScope.employee.empId}" />
				<br />
			</jstl:if>
			<jstl:if test="${requestScope.employee == null }">
				<input type="number" name="txtId" required="required" />
				<br />
			</jstl:if>

			
		</form>
	</div>

</body>
</html>