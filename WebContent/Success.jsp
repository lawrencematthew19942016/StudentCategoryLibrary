
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
<%! //CSS Styles %>
body {
	background-color: powderblue;
	font-family: sans-serif;
}

.main {
	background-color: #FFFFFF;
	width: 400px;
	height: 400px;
	margin: 7em auto;
	border-radius: 1.5em;
	box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Login Successful</title>
</head>
<body>
<div class ="main" align= "center">
	<h1>Success Page</h1>
	<h2>
		Welcome
		<%! //Display username of the Admin %>
		<c:out value="${username}" />
	</h2>
	<h3>Admin Login Successful</h3>
	<br> Continue to
	<%! //redirects to Home Page %>
	<a href="NewHomePage.jsp">Admin Page</a>
	</div>
</body>
</html>