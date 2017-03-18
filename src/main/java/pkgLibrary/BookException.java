package pkgLibrary;

public class BookException extends Exception {
	private Catalog cat;
	private String bookid;
	private Book b;
	public BookException(Catalog cat, String bookid) {
		super();
		this.cat = cat;
		this.bookid = bookid;
	}
	public BookException(Book b){
		super();
		this.b = b;
	}
	public Catalog getCat() {
		return cat;
	}
	public String getBookid() {
		return b.getId();
	}
	/*private Book b;
	
	public BookException(){
		super();
	}
	
	public BookException(Book b){
		super("Not good.");
		this.b = b;
	}
	
	public Book B(){
		return b;
	}*/
}
