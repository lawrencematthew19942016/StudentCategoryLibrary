package mvccrudpackage.controller;

import mvccrudpackage.model.bean.Book;
import mvccrudpackage.model.dao.BookDAO;

import java.sql.SQLException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
	}

	public void init() {
		bookDAO = new BookDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
// TODO Auto-generated method stub
		// String action = request.getServletPath();
		String action = request.getParameter("action");
		System.out.println(action);
		if (action == null) {
			action = "No action";
		}
		RequestDispatcher dispatcher;
		try {
			switch (action) {
			case "new":
				showNewBook(request, response);
				break;
			case "insert":
				insertBook(request, response);
				break;
			case "delete":
				deleteBook(request, response);
				break;

			case "edit":
				showEditBook(request, response);
				break;
			case "update":
				updateBook(request, response);
				break;
			case "searchBook":
				searchBook(request, response);
				break;
			case "userBook":
				userBook(request, response);
			default:
				listBook(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}// DoPost Method End

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Book> listBook = bookDAO.selectAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void userBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Book> userBook = bookDAO.selectUserBooks();
		request.setAttribute("userBook", userBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Userlist.jsp");
		dispatcher.forward(request, response);
	}

	

	private void showNewBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Bookform.jsp");
		dispatcher.forward(request, response);
	}

	//Insertion of the Book into the program
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		String booktitle = request.getParameter("booktitle");
		String description = request.getParameter("description");
		String author = request.getParameter("author");
		String publisheddate = request.getParameter("publisheddate");
		String isbn = request.getParameter("isbn");
		String price = request.getParameter("price");
		int noofpages = Integer.parseInt(request.getParameter("noofpages"));
		String categorytitle = request.getParameter("categorytitle");
		int cid = Integer.parseInt(request.getParameter("cid"));

		Book e = new Book(booktitle, description, author, publisheddate, isbn, price, noofpages, categorytitle  ,cid);
		bookDAO.insertBook(e);
		//Insertion of book is then redirected to the location that is desired 
		response.sendRedirect(request.getContextPath() + "/BookServlet?action=list");
	}

	private void showEditBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book existingBook = bookDAO.selectBook(id);
		//dispatcher requestion to the Servlet that the user program
		RequestDispatcher dispatcher = request.getRequestDispatcher("Bookform.jsp");
		request.setAttribute("Book", existingBook);
		dispatcher.forward(request, response);
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String booktitle = request.getParameter("booktitle");
		String description = request.getParameter("description");
		String author = request.getParameter("author");
		String publisheddate = request.getParameter("publisheddate");
		String isbn = request.getParameter("isbn");
		String price = request.getParameter("price");
		int noofpages = Integer.parseInt(request.getParameter("noofpages"));
		String categorytitle = request.getParameter("categorytitle");
		int cid = Integer.parseInt(request.getParameter("cid"));

		
		Book e = new Book(booktitle, description, author, publisheddate, isbn, price, noofpages, categorytitle, cid);
		bookDAO.updateBook(e);
		response.sendRedirect(request.getContextPath() + "/BookServlet?action=list");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		bookDAO.deleteBook(id);
		response.sendRedirect(request.getContextPath() + "/BookServlet?action=list");

	}
	


	private void searchBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String search = request.getParameter("search");
		System.out.println("searchBook");
		List<Book> listBook = bookDAO.searchBook(search);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		request.setAttribute("listBook", listBook);
		dispatcher.forward(request, response);
	}

}
