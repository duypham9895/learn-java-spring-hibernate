<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation</title>
</head>
<body>
	The customer is confirmed: ${customer.firstName } ${customer.lastName }.
	<br /> Free passes: ${customer.freePasses }.
	<br /> Postal Code: ${customer.postalCode }.
	<br /> Course Code: ${customer.courseCode }.

</body>
</html>