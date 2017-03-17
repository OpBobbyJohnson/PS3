package pkgLibrary;

import java.util.Date;
import pkgMain.XMLReader;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Book {

	private String id;
	private String author;
	private String title;
	private String genre;
	private double price;
	private Date publish_date;
	private String description;
	private double cost;

	public Book() {

	}

	public Book(String id, String author, String title, String genre, double price, Date publish_date,
			String description, double cost) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.publish_date = publish_date;
		this.description = description;
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}


	public Book (Catalog cat, String strPassedBookID)
	{
	    for (Book b: cat.getBooks())
	      {
	         if (b.getId() == strPassedBookID) {
	            this.id = b.id;
	            this.author= b.author;
	            this.title = b.title;
	            this.genre = b.genre;
	            this.price = b.price;
	            this.publish_date = b.publish_date;
	            this.description = b.description;
	            this.cost = b.cost;
	         }
	      }
	  
	}
	
	public String getGenre() {
		return genre;
	}

	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	@XmlElement
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public static Book GetBook(Catalog Cat ,String bookid) throws BookException {
		try {
			for (Book b : Cat.getBooks()) {
				if (b.getId() == bookid) {
					return b;
				}
			}
			System.out.println("cat ID " + Cat.getId());
			System.out.println("Book count: " + Cat.getBooks().size());
			throw new BookException(Cat, bookid);

		} catch (BookException bE) {
			throw bE;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
