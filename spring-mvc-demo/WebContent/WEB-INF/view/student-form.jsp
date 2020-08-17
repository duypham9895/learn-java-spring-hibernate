<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student Registration Form - Spring MVC</title>
	</head>
	
	<body>
	
		<form:form action="processForm" modelAttribute="student">
		
			First Name: <form:input path="firstName"/>
			
			<br />
			
			Last Name: <form:input path="lastName"/>
			
			<br />
			
			Country: 
			<form:select path="country">
			
				<form:options items="${countryOptions}" />
				
			</form:select>
			
			<br/>
			
			Favorite Programming Language:
			
			<br />
			
			<form:radiobuttons path="favoriteLanguage" items="${languages}" />  
		
			<br />
			
			Operating Systems:
			
			Linux <form:checkbox path="operatingSystems" value="Linux" />
			MacOS <form:checkbox path="operatingSystems" value="MacOS" />
			MSWindows <form:checkbox path="operatingSystems" value="MSWindows" />
			
			<br />
			
			<input type="submit" value="Submit" />
			
		</form:form>
		
	</body>
</html>