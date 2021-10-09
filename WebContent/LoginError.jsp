<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


<%! //CSS Styles %>
<style>
body {
	background-color: powderblue;
	font-family: sans-serif;
}

form.form1 {
	padding-top: 60px;
}

.main {
	background-color: #FFFFFF;
	width: 400px;
	height: 400px;
	margin: 7em auto;
	border-radius: 1.5em;
	box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}

.pass1 {
	width: 76%;
	color: rgb(38, 50, 56);
	font-weight: 700;
	font-size: 14px;
	letter-spacing: 1px;
	background: rgba(136, 126, 126, 0.04);
	padding: 10px 20px;
	border: none;
	border-radius: 20px;
	outline: none;
	box-sizing: border-box;
	border: 2px solid rgba(0, 0, 0, 0.02);
	margin-bottom: 50px;
	margin-left: 46px;
	text-align: center;
	margin-bottom: 27px;
	font-family: 'Ubuntu', sans-serif;
}
</style>


<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<div class="main" align="center">
	<%! //Display of Error %>
		<h1>Error page</h1>
		<p style="text-align: center">Sorry, you have entered in the wrong
			password or username!</p>
		<br>
		<p>Please try again or contact the admin</p>
		<%! //Redirection %>
		<br> <a href="Login.jsp">Go Back</a>
	</div>
</body>
</html>


















