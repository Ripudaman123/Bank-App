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

<jstl:if test="${requestScope.bal1==-1}">
<h2>Account Not Found</h2>
 </jstl:if>
 <jstl:if test="${requestScope.bal1>0}">
 <h2>New Balance=${requestScope.bal1}</h2>
 </jstl:if>
</body>
</html>