/**
 * @description: This is a library class, it primarily contains a list of Book class objects, but also tracks the number of books in the library.
 * 			This class contains methods for adding and removing books, which will adjust the numBooks variable accordingly. It also contains a
 * 			customized toString() method for displaying the contents of the library, as well as information about each title.
 * 
 * @inputs: This class can take new books as an input, and add them to the catalog.
 * 
 * @outputs: This class can output the number of books, an unformatted array of the catalog of books, and a formatted catalog of books.
 * 
 * @author Erik Jackson
 * 
 * @contact erik.jackson@my.century.edu
 * 
 * @since 11/16/2024
 * 
 * Institution: Century College
 * 
 * Instructor: Mathew Nyamagwa
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Library {
	// Define collection
	private List<Book> collection;
	private int numBooks;
	
	public Library() {
		// Assign an array list to collection
		collection = new ArrayList<>();
		// Initialize numBooks at 0
		numBooks = 0;
	}
	
	// Add a book to the collection
	public void addBook(Book book) {
		collection.add(book);
		numBooks++;
	}
	
	// Remove a book from the collection
	public void removeBook(Book book) {
		collection.remove(book);
		numBooks--;
	}
	
	// returns the number of books in the collection
	public int numBooks() {
		return numBooks;
	}
	
	// printCollection() returns a list of books (collection)
	public List<Book> printCollection() {
		return collection;
	}
	
	//@override toString method
	public String toString() {
		String returnList = "We have " + numBooks + " books in the library.\n\n";
		// listNumber will number the books as they are displayed
		int listNumber = 0;
		
		//For loop to iterate through collection
		for(Book thisBook : collection) {
			// Increment listNumber
			listNumber++;
			// Add formatted book information to the returnList.
			returnList = returnList + listNumber + ") " + thisBook + "\n";
		}
		return returnList;
	}
	 
}

