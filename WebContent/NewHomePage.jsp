<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
<%!//CSS Styles%> 


body {
	background-color: powderblue;
	font-family: "Lato", sans-serif;
}

.sidenav {
	width: 100px;
	position: fixed;
	z-index: 1;
	top: 20px;
	left: 10px;
	background: #eee;
	overflow-x: hidden;
	padding: 10px 0;
	font-size: 14px;
	border-style: groove;
}

.main {
	margin-left: 40px;
	font-size: 28px;
	padding: 0px 10px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Admin Console Page</title>
</head>


<body>
	<h1 style="text-align: center">Admin Page</h1>

	<div class="main" style="text-align: center">
		<%!//Search for book function%>
		<form class="form-inline" method="get"
			action="BookServlet?action=searchBook">
			<%!//Will get the action of the book%>
			<input type="text" placeholder="Search.." name="search"> <input
				type="hidden" name="action" value="searchBook" />
			<button type="submit">Search</button>
		</form>
	</div>





	<%!//Sidenav%>
	<div class="sidenav" style="text-align: center">
		<h4>
			<%!//Functions to request and view book%>
			<a href="${pageContext.request.contextPath}/BookServlet?action=list">View
				All Books</a>
		</h4>


		<h4>
			<%!//Function that redirects to Add New Book%>
			<a href="${pageContext.request.contextPath}/BookServlet?action=new">Add
				New Book</a>
		</h4>
		

	</div>






</body>
</html>