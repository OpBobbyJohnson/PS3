package pkgLibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import pkgMain.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
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
	public double getCost() {
		return cost;
	}
	@XmlElement
	public void setCost(double cost){
		this.cost = cost;
	}
	public Book (String id) throws BookException
	{
		super();
		Book InstOfBook = GetBook(id);
		this.setId(id);
		this.setAuthor(InstOfBook.getAuthor());
		this.setTitle(InstOfBook.getTitle());
		this.setGenre(InstOfBook.getGenre());
		this.setPrice(InstOfBook.getPrice());
		this.setCost(InstOfBook.getCost());
		this.setPublish_date(InstOfBook.getPublish_date());
		this.setDescription(InstOfBook.getDescription());
	  
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
	public static Book GetBook(String bookid) throws BookException {
		try {
			Catalog Cat = ReadXMLFile();
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

	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}

	private static void WriteXMLFile(Catalog cat) {
		try {

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(cat, file);
			jaxbMarshaller.marshal(cat, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void AddBook(String id, Book book) {
		try {
			Catalog cat = ReadXMLFile();
			ArrayList<Book> alist = cat.getBooks();
			for (Book bk : cat.getBooks())
				if (bk.getId() == id)
					throw new BookException(id);
			alist.add(book);
			cat.setBooks(alist);
			WriteXMLFile(cat);
		} catch (BookException e) {
			System.out.println("Book" + id + " already exists.");
		}
	}
}
	

