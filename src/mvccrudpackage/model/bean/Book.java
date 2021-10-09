package mvccrudpackage.model.bean;


//declaration of the things needed in order to have books
public class Book {
	protected int bid;
	protected String booktitle;
	protected String description;
	protected String author;
	protected String publisheddate;
	protected String isbn;
	protected String price;
	protected int noofpages;
	protected String categorytitle;
	protected int cid;

	public Book() {
	}

	//constructor


	public Book(String booktitle, String description, String author, String publisheddate, String isbn, String price,
			int noofpages, String categorytitle, int cid) {
		this.booktitle = booktitle;
		this.description = description;
		this.author = author;
		this.publisheddate = publisheddate;
		this.isbn = isbn;
		this.price = price;
		this.noofpages = noofpages;
		this.categorytitle = categorytitle;

		this.cid = cid;

	}
	
	//constructor

	public Book(int bid, String booktitle, String description, String author, String publisheddate, String isbn,
			String price, int noofpages, String categorytitle, int cid) {

		this.bid = bid;
		this.booktitle = booktitle;
		this.description = description;
		this.author = author;
		this.publisheddate = publisheddate;
		this.isbn = isbn;
		this.price = price;
		this.noofpages = noofpages;
		this.categorytitle = categorytitle;
		this.cid = cid;

	}

	//getters and setters 
	
	public int getbid() {
		return bid;
	}

	public void setbid(int bid) {
		this.bid = bid;
	}

////////////////////////////////

////////////////////////////////
	public String getbooktitle() {
		return booktitle;
	}

	public void setbooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

////////////////////////////////
	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

////////////////////////////////
	public String getauthor() {
		return author;
	}

	public void setauthor(String author) {
		this.author = author;
	}

//////////////////////////////////////
	public String getpublisheddate() {
		return publisheddate;
	}

	public void setgetpublisheddate(String publisheddate) {
		this.publisheddate = publisheddate;
	}

	////////////////////////////////////////
	public String getisbn() {
		return isbn;
	}

	public void setisbn(String isbn) {
		this.isbn = isbn;
	}

///////////////////////////////////
	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		this.price = price;
	}

////////////////////////////////
	public int getnoofpages() {
		return noofpages;
	}

	public void setnoofpages(int noofpages) {
		this.noofpages = noofpages;
	}

	
	//////////////////////////////////////
	public String getcategorytitle() {
		return categorytitle;
	}

	public void setcategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}

	
	
////////////////////////////////////
	public int getcid() {
		return cid;
	}

	public void setcid(int cid) {
		this.cid = cid;
	}
}

////////////////////////////////
