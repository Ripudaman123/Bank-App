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
<jstl:if test="${requestScope.bal2==-1}">
<h2>Account Not Found</h2>
 </jstl:if>
 <jstl:if test="${requestScope.bal2<=-1}">
<h2>Not Enough Funds</h2>
 </jstl:if>
 <jstl:if test="${requestScope.bal2>0}">
 <h2>New Balance=${requestScope.bal2}</h2>
 </jstl:if>
</body>
</html>