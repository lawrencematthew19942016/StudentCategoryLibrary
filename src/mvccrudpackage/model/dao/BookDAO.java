package mvccrudpackage.model.dao;

import java.sql.*;
import java.util.*;

import mvccrudpackage.model.bean.Book;

public class BookDAO {
	// Defines instance variables and able to connect and implement specific actions
	// using Java and mySQL
	private String DBURL = "jdbc:mysql://localhost:3306/newbookstore";
	private String DBUsername = "root";
	private String DBPassword = "mysql";
	private String INSERTEMPSQL = "INSERT INTO books (booktitle, description, author, publisheddate, isbn, price, noofpages, cid) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	private String SELECTEMPID = "select bid, booktitle, description, author, publisheddate, isbn, price, noofpages, cid from books left join book_category using (cid) where bid =?";
	private String SELECTALLEMPS = "select * from books left join book_category using (cid) order by bid;\r\n" + "";
	private String DELETECATSQL = "delete from categorytitle where cid = ?;";
	private String SEARCHBOOKCAT = "SELECT * FROM books left join book_category using (cid) where categorytitle LIKE ?;";
	private String SEARCHCAT = "SELECT * FROM books left join book_category using (cid) where categorytitle LIKE ?;";
	private String DELETEEMPSQL = "delete from books where bid = ?;";
	private String UPDATEEMPSQL = "update books SET booktitle = ?, description= ?, author = ?, publisheddate= ?, isbn = ?, price = ?, noofpages = ?, cid = ? where bid = ?;";

	// constructor for the Book
	public BookDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DBURL, DBUsername, DBPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

//Function to be able to insert book into database 
	public void insertBook(Book emp) throws SQLException {
		System.out.println(INSERTEMPSQL);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// try-with-resource statement will auto close the connection.
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(INSERTEMPSQL);

			preparedStatement.setString(1, emp.getbooktitle());
			preparedStatement.setString(2, emp.getdescription());
			preparedStatement.setString(3, emp.getauthor());
			preparedStatement.setString(4, emp.getpublisheddate());
			preparedStatement.setString(5, emp.getisbn());
			preparedStatement.setString(6, emp.getprice());
			preparedStatement.setInt(7, emp.getnoofpages());
			preparedStatement.setInt(8, emp.getcid());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			finallySQLException(connection, preparedStatement, null);
		}
	}

	public Book selectBook(int bid) {
		Book emp = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		// Connection of the code where it is established
		try {
			connection = getConnection();
			// Creation of the object connection
			preparedStatement = connection.prepareStatement(SELECTEMPID);
			preparedStatement.setInt(1, bid);
			System.out.println(preparedStatement);

			rs = preparedStatement.executeQuery();
			// Query is executed here
			// Give us the Results of the specific function
			while (rs.next()) {

				String booktitle = rs.getString("booktitle");
				String description = rs.getString("description");
				String author = rs.getString("author");
				String publisheddate = rs.getString("publisheddate");
				String isbn = rs.getString("isbn");
				String price = rs.getString("price");
				int noofpages = rs.getInt("noofpages");
				String categorytitle = rs.getString("categorytitle");
				int cid = rs.getInt("cid");
				emp = new Book(bid, booktitle, description, author, publisheddate, isbn, price, noofpages,
						categorytitle, cid);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			finallySQLException(connection, preparedStatement, rs);
		}
		return emp;
	}

	//// "select * from EmployeeTBL";

	public List<Book> selectAllBooks() {
		// Employee emp = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Book> emps = new ArrayList<>();
		// Establishing the Connection
		try {
			connection = getConnection();
			// Object Creation
			preparedStatement = connection.prepareStatement(SELECTALLEMPS);
			System.out.println(preparedStatement);
			// Execution the query
			rs = preparedStatement.executeQuery();

			// Processing the ResultSet object.
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String booktitle = rs.getString("booktitle");
				String description = rs.getString("description");
				String author = rs.getString("author");
				String publisheddate = rs.getString("publisheddate");
				String isbn = rs.getString("isbn");
				String price = rs.getString("price");
				int noofpages = rs.getInt("noofpages");
				String categorytitle = rs.getString("categorytitle");
				int cid = rs.getInt("cid");

				emps.add(new Book(bid, booktitle, description, author, publisheddate, isbn, price, noofpages,
						categorytitle, cid));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			finallySQLException(connection, preparedStatement, rs);
		}
		return emps;
	}

	public List<Book> selectUserBooks() {
		// Employee emp = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Book> emps = new ArrayList<>();
		// Establishing the Connection
		try {
			connection = getConnection();
			// Object Creation
			preparedStatement = connection.prepareStatement(SELECTALLEMPS);
			System.out.println(preparedStatement);
			// Execution the query
			rs = preparedStatement.executeQuery();

			// Processing the ResultSet object.
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String booktitle = rs.getString("booktitle");
				String description = rs.getString("description");
				String author = rs.getString("author");
				String publisheddate = rs.getString("publisheddate");
				String isbn = rs.getString("isbn");
				String price = rs.getString("price");
				int noofpages = rs.getInt("noofpages");
				String categorytitle = rs.getString("categorytitle");
				int cid = rs.getInt("cid");

				emps.add(new Book(bid, booktitle, description, author, publisheddate, isbn, price, noofpages,
						categorytitle, cid));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			finallySQLException(connection, preparedStatement, rs);
		}
		return emps;
	}

	// Function to delete book
	public boolean deleteBook(int bid) throws SQLException {
		boolean empDeleted = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(DELETEEMPSQL);
			preparedStatement.setInt(1, bid);
			empDeleted = preparedStatement.executeUpdate() > 0 ? true : false;
		} finally {
			finallySQLException(connection, preparedStatement, null);
		}
		return empDeleted;
	}
	
	// Function to delete category
	public boolean deleteCategory(int cid) throws SQLException {
		boolean empDeleted = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SEARCHCAT);
			preparedStatement.setInt(1, cid);
			empDeleted = preparedStatement.executeUpdate() > 0 ? true : false;
		} finally {
			finallySQLException(connection, preparedStatement, null);
		}
		return empDeleted;
	}

//Function to update book
	public boolean updateBook(Book emp) throws SQLException {
		boolean empUpdated = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(UPDATEEMPSQL);
			preparedStatement.setInt(1, emp.getbid());
			preparedStatement.setString(2, emp.getbooktitle());
			preparedStatement.setString(3, emp.getdescription());
			preparedStatement.setString(4, emp.getauthor());
			preparedStatement.setString(5, emp.getpublisheddate());
			preparedStatement.setString(6, emp.getisbn());
			preparedStatement.setString(7, emp.getprice());
			preparedStatement.setInt(8, emp.getnoofpages());
			preparedStatement.setInt(9, emp.getcid());

			empUpdated = preparedStatement.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			finallySQLException(connection, preparedStatement, null);
		}
		return empUpdated;
	}

	// Function to list book
	public List<Book> searchBook(String search) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Book> emps = new ArrayList<>();
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SEARCHBOOKCAT);
			preparedStatement.setString(1, "%" + search + "%");
			System.out.println(preparedStatement);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String booktitle = rs.getString("booktitle");
				String description = rs.getString("description");
				String author = rs.getString("author");
				String publisheddate = rs.getString("publisheddate");
				String isbn = rs.getString("isbn");
				String price = rs.getString("price");
				int noofpages = rs.getInt("noofpages");
				String categorytitle = rs.getString("categorytitle");
				int cid = rs.getInt("cid");
				emps.add(new Book(booktitle, description, author, publisheddate, isbn, price, noofpages, categorytitle, cid));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			finallySQLException(connection, preparedStatement, rs);
		}
		return emps;
	}

//Will print what the error that is found within the program. 
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

//Exception for mySQL with the try-catch exception
	private void finallySQLException(Connection c, PreparedStatement p, ResultSet r) {
		if (r != null) {
			try {
				r.close();
			} catch (Exception e) {
			}
			r = null;
		}

		if (p != null) {
			try {
				p.close();
			} catch (Exception e) {
			}
			p = null;
		}

		if (c != null) {
			try {
				c.close();
			} catch (Exception e) {
				c = null;
			}

		}
	}
}
