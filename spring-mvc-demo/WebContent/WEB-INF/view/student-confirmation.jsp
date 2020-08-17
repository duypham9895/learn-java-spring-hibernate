<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Student confirmation</title>
</head>

<body>
	The student is confirmed: ${student.firstName} ${student.lastName}.

	<br /> Country: ${student.country}.

	<br /> Favorite Language: ${student.favoriteLanguage}.

	<br /> Operating Systems:

	<ul>

		<c:forEach var="temp" items="${student.operatingSystems}">

			<li>${temp}</li>

		</c:forEach>

	</ul>

</body>

</html>