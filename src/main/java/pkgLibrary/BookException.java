package pkgLibrary;

public class BookException extends Exception {
	private Catalog cat;
	private String bookid;
	public BookException(Catalog cat, String bookid) {
		super();
		this.cat = cat;
		this.bookid = bookid;
	}
	public BookException(String id){
		super();
		this.bookid = id;
	}
	public Catalog getCat() {
		return cat;
	}
	public String getBookid() {
		return bookid;
	}
	
}
