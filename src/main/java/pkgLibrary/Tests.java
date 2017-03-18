package pkgLibrary;

import static org.junit.Assert.*;
import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;
import org.junit.Test;

public class Tests {

	@Test
	public static void GetBook1() throws BookException {
		Book bkTest1 = new Book("bk101");
		assertTrue(bkTest1.GetBook("bk101").equals(bkTest1));
	}


}
