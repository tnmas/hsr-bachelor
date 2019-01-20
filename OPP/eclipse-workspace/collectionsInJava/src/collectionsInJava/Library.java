package collectionsInJava;

import java.util.HashMap;
import java.util.Map;

public class Library {
	public static Book findByISBN(String ISBN, Map<String, Book> allbooks) {
		Book book = allbooks.get(ISBN);
		return book;
	}
	public static void main(String[] args) {
		Map<String, Book> allBooks = new HashMap<>();
		Book taleOfTwoCities = new Book();
		allBooks.put("9781539687399", taleOfTwoCities);
		
		System.out.println(findByISBN("9781539687399", allBooks));

	}

}
