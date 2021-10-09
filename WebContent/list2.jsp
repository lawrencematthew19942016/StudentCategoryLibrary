<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<style>
body {
	background-color: powderblue;
	font-family: sans-serif;
	
}

</style>
<head>
<title>Book Management Application</title>
</head>
<body style="font-family: arial, serif;">
	<div align="center" cellpadding=10>

		<form class="form-inline" method="get"
			action="BookServlet?action=searchBook">
			<input type="text" placeholder="Search.." name="search"> <input
				type="hidden" name="action" value="searchBook" />
			<button type="submit">Search</button>
		</form>

		<a href="NewHomePage.jsp">Back to Home Page</a>

		<Table Border="5" Width="50%" Cellpadding="4" Cellspacing="4">
			<h2>List of Book</h2>
			<center>
				<h4>
					<a href="${pageContext.request.contextPath}/BookServlet?action=new">Add
						New Book</a>
				</h4>
			</center>



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
				<th>Edit/Delete</th>


			</tr>
			<c:forEach var="emp" items="${listBook}">
				<tr align=center>
					<td><c:out value="${emp.getbid()}" /></td>
					<td><c:out value="${emp.getbooktitle()}" /></td>
					<td><c:out value="${emp.getdescription()}" /></td>
					<td><c:out value="${emp.getauthor()}" /></td>
					<td><c:out value="${emp.getpublisheddate()}" /></td>
					<td><c:out value="${emp.getisbn()}" /></td>
					<td><c:out value="${emp.getprice()}" /></td>
					<td><c:out value="${emp.getnoofpages()}" /></td>
					<td><c:out value="${emp.getcid()}" /></td>
					<td>|<a
						href="${pageContext.request.contextPath}/BookServlet?action=edit&id=<c:out value='${emp.getbid()}' />">Edit</a>|
						|<a
						href="${pageContext.request.contextPath}/BookServlet?action=delete&id=<c:out value='${emp.getbid()}' />">Delete</a>|
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>