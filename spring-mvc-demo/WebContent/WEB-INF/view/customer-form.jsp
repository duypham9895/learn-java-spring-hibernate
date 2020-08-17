<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration Form</title>

<style type="text/css">
.error {
	color: red
}
</style>

</head>
<body>

	<form:form action="processForm" modelAttribute="customer">
	
		First Name: <form:input path="firstName" />

		<br />
	
		Last Name (*): 
		<form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />

		<br />
		
		Free Passes:
		<form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />

		<br />
		
		Postal Code:
		<form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />

		<br />
		
		Course Code:
		<form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error" />

		<br />

		<input type="submit" value="Submit" />

	</form:form>

</body>
</html>