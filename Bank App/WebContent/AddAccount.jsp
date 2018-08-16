<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="Left">
		<form action="AddAccount.app" method="get">
		
		<table>
        <tr>
        <td>Account Holder Name: </td>
        <td> <input type="text" name="txtName" required="required"/></td>
		</tr>
		<tr> 
		<td>Mobile Number:</td>
		<td> <input type="number" name="contactNumber" required="required"/>
		 </td>
		 </tr>
	     <tr><td>
		Email:</td> 
		<td><input type="email" name="emailId" required="required"/> 
		</td></tr>
		<tr><td>		
		Date of Birth:</td> 
		<td><input type="date" name="dob" required="required" min="01/01/2000"/> 
         </td></tr>
		<tr>
		<td>Account Type: </td>
		<td><select name="accountType">
		<option value="savings">Savings Account</option>
		<option value="current">Current Account</option>
		</select>		
		</td>
		</tr>
		<tr>
		<td><h3>For Savings Account Only:</h3></td>
		</tr>
		<tr>
		<td>If Savings: </td>
		<td><input type="radio" name="ifsav" value="true">Salaried
		<input type="radio" name="ifsav" value="false">Non Salaried
		</td></tr>
		<tr>
		<tr>
		<td>Enter the amount(if salaried): </td>
		<td><input type="number" name="samount" min=0></td>
		</tr>		
		<tr>
		<td>Enter the amount(if non-salaried): </td>
		<td><input type="number" name="samount" min=1000></td>
		</tr>	
		<tr>	
		<td colspan="3"><h3>For Current Account Only:</h3></td>		
		</tr>	
		<tr>
		<td>Enter the overdraft limit(min 10000): </td>
		<td><input type="number" name="limit" min=10000></td>
		</tr>		
		<tr>
		<td>Enter the amount(min 10000): </td>
		<td><input type="number" name="camount" min=10000></td>
		</tr>
		<tr>
		<td><input type="submit" value="Save"> <td/>
		<td><input type="reset" value="Clear"></td>
		</tr>
		</table>
		</form>
	</div>

</body>
</html>