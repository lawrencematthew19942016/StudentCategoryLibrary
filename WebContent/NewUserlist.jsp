<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%!//User specific page%> 

<html>
<style>
body {
	background-color: powderblue;
	font-family: sans-serif;
}

table, th, td {
	border: 1px solid black;
	padding: 15px;
	text-align: left;
	border-bottom: 1px solid #000000;
}

tr:hover {
	background-color: #3fd2d6;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form class="form-inline" method="get"
			action="BookServlet?action=searchBook">
			<input type="text" placeholder="Search.." name="search"> <input
				type="hidden" name="action" value="searchBook" />
			<button type="submit">Search</button>
		</form>
		<tr align=center>
				<th>ID</th>
				<th>Book Title</th>
				<th>Description</th>
				<th>Author</th>
				<th>Published Date</th>
				<th>ISBN</th>
				<th>Price</th>
				<th>NOOF</th>
				<th>CI</th>
				<c:forEach var="emp" items="${listBook}">
				<tr align=center>
				
				<%!//Cannot edit or delete books%> 
				
				
					<td><c:out value="${emp.getbid()}" /></td>
					<td><c:out value="${emp.getbooktitle()}" /></td>
					<td><c:out value="${emp.getdescription()}" /></td>
					<td><c:out value="${emp.getauthor()}" /></td>
					<td><c:out value="${emp.getpublisheddate()}" /></td>
					<td><c:out value="${emp.getisbn()}" /></td>
					<td><c:out value="${emp.getprice()}" /></td>
					<td><c:out value="${emp.getnoofpages()}" /></td>
					<td><c:out value="${emp.getcid()}" /></td>
				</tr>
			</c:forEach>



</body>
</html>