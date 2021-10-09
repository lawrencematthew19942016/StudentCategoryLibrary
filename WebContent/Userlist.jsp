<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Book Management Application</title>
</head>
<body style="font-family: arial, serif;">
	<div align="center" cellpadding=10>


		<a href="Userpage.jsp">Back to Home Page</a>

		<Table>
			<h2>List of Book</h2>


			<tr align=center>
				<th>ID</th>
				<th>Book Title</th>
				<th>Description</th>
				<th>Author</th>
				<th>Published Date</th>
				<th>ISBN</th>
				<th>Cost</th>
				<th>Number of Pages</th>
				<th>Genre</th>
				



			</tr>
			<c:forEach var="emp" items="${userBook}">
				<tr align=center>
					<td><c:out value="${emp.getbid()}" /></td>
					<td><c:out value="${emp.getbooktitle()}" /></td>
					<td><c:out value="${emp.getdescription()}" /></td>
					<td><c:out value="${emp.getauthor()}" /></td>
					<td><c:out value="${emp.getpublisheddate()}" /></td>
					<td><c:out value="${emp.getisbn()}" /></td>
					<td>$<c:out value="${emp.getprice()}" /></td>
					<td><c:out value="${emp.getnoofpages()}" /> Pages</td>
					<td><c:out value="${emp.getcategorytitle()}" /></td>
					

				</tr>
			</c:forEach>
		</table>
	</div>
</body>