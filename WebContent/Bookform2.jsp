<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<style>
<%! //CSS Styles %>





body {
	background-color: powderblue;
	font-family: sans-serif;
}
</style>
<head>
<title>Add New Book</title>
</head>
<body>
	<center>
		<h4>
		<%! //Redirects to Book List %>
			<a href="${pageContext.request.contextPath}/BookServlet?action=list">List
				All Book</a>
		</h4>
	</center>
	<div align="center">
		<c:if test="${Book != null}">
			<form action="${pageContext.request.contextPath}/BookServlet"
				method="post">
				<input type="hidden" name="action" value="update">
		</c:if>
		<c:if test="${Book == null}">
			<form
				action="${pageContext.request.contextPath}/BookServlet?action=insert"
				method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${Book != null}">
               Edit Book
              </c:if>
					<c:if test="${Book == null}">
               Add New Book
              </c:if>
				</h2>
			</caption>
			<c:if test="${Book != null}">
				<input type="hidden" name="bid"
					value="<c:out value='${Book.getbid()}' />" />
			</c:if>

			<tr>
				<th>Book Name:</th>
				<td><input type="text" name="booktitle" size="45" required
					value="<c:out value='${Book.getbooktitle()}' />" /></td>
			</tr>
			<tr>
			<tr>
				<th>Description:</th>
				<td><input type="text" name="description" size="45" required
					value="<c:out value='${Book.getdescription()}' />" /></td>
			</tr>
			<tr>
				<th>Author:</th>
				<td><input type="text" name="author" size="45" required
					value="<c:out value='${Book.getauthor()}' />" /></td>
			</tr>
			<tr>
				<th>Published Date:</th>
				<td><input type="text" name="publisheddate" size="45" required
					value="<c:out value='${Book.getpublisheddate()}' />" /></td>
			</tr>
			<tr>
				<th>ISBN:</th>
				<td><input type="text" name="isbn" size="45" required
					value="<c:out value='${Book.getisbn()}' />" /></td>
			</tr>
			<tr>
				<th>Price:</th>
				<td><input type="text" name="price" size="45" required
					value="<c:out value='${Book.getprice()}' />" /></td>
			</tr>
			<tr>
				<th>Number of Pages:</th>
				<td><input type="number" name="noofpages" min="10" required
					value="<c:out value='${Book.getnoofpages()}' />" /></td>
			</tr>
			<tr>
				<th>CI:</th>
				<td><input type="number" name="cid" min="1" max="8" required
					value="<c:out value='${Book.getcid()}' />" /></td>
			</tr>
			<tr>
			<th>CI:</th>
			<td><select name="cars" id="cars">
				<option value="Fantasy">Fantasy</option>
				<option value="Adventure">Adventure</option>
				<option value="Romance">Romance</option>
				<option value="Academic">Academic</option>
				<option value="Dystopian">Dystopian</option>
				<option value="Mystery">Mystery</option>
				<option value="Horror">Horror</option>
			</select></td>
</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
