/**
 * @description: This is a book class. It contains variables related to attributes of books, as well as methods relating to the book. It has 
 * 			getters and setters for every attribute as well as the ability to open and close a book. It also has a method for formatting the
 * 			contents of this instance of the book class with the toString() method. The book class is also capable of checking if it shares
 * 			an author with another book.
 * 
 * @inputs: When a new book is created, it can instantiate a new book if given the following information:
 * 			=> Title
 * 			=> Author
 * 			=> Year Published
 * 			=> Number of Pages
 * 			=> Cost of the Book
 * 
 * @outputs: Once the book is created it can return a formatted string of all of its contents, it can also assess the age of the book (whether 
 * 			it is old or new). The book can also be "opened" or "closed", but it will not open if it is already open or close if it is already
 * 			closed.
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

public class Book {
	// Declare variables for the Book class
	private String title;
	private String author;
	private int publishedYear;
	private int pages;
	private double cost;
	private boolean isOpen;
	
	//Constructors
	// the first constructor has no parameters
	public Book() {
		title = "Unknown";
		author = "Anonymous";
		publishedYear = 1900;
		pages = 0;
		cost = 0.00;
		isOpen = false;
	}
	
	// the second constructor has almost all of the parameters included, isOpen is set to false by default.
	public Book(String newTitle, String newAuthor, int newPublishedYear, int newPages, double newCost) {
		title = newTitle;
		author = newAuthor;
		publishedYear = newPublishedYear;
		pages = newPages;
		cost = newCost;
		isOpen = false;
	}
	
	// SETTERS
	// setTitle() allows the title to be changed
	public void setTitle(String newTitle) {
		title = newTitle;
	}

	// setAuthor() allows the author to be changed
	public void setAuthor(String newAuthor) {
		author = newAuthor;
	}

	// setPublishedYear() allows the published year to be changed
	public void setPublishedYear(int newYear) {
		publishedYear = newYear;
	}

	// setPages() allows the number of pages to be changed
	public void setPages(int newPages) {
		pages = newPages;
	}

	// setCost() allows the cost to be changed
	public void setCost(double newCost) {
		cost = newCost;
	}

	// setOpened() allows isOpen to be changed
	public void setOpened(boolean newIsOpen) {
		isOpen = newIsOpen;
	}
	
	// GETTERS
	// getTitle() returns the title as a string
	public String getTitle() {
		return title;
	}

	// getAuthor() returns the author name as a string
	public String getAuthor() {
		return author;
	}

	// getPublishedYear() returns the year it was published as an integer
	public int getPublishedYear() {
		return publishedYear;
	}

	// getPages() returns the number of pages as an integer
	public int getPages() {
		return pages;
	}

	// getCost() returns the cost as a double
	public double getCost() {
		return cost;
	}

	// getOpenStatus() returns the value of isOpen as a boolean
	public boolean getOpenStatus() {
		return isOpen;
	}
	
	//Other functions
	// authorEquals() compares the author of this book to the author in the parameter, 
	// it returns true if they are the same and false if they are not.
	public Boolean authorEquals(String otherAuthor) {
		if (this.author.equals(otherAuthor)){
			return true;
		} else {
			return false;
		}
	}
	
	// toString() converts all of the data elements to a string and returns it formatted.
	public String toString() {
		return (title + "\n\tby " + author + "\n\tPublished in " + publishedYear  + "\n\t" + isOld() + "\n\t" + pages + " pages\n\t$" + cost + "\n");
	}
	
	// isOld() decides how old a book is based on it's published year and returns a comment in the form of a string.
	public String isOld() {
		if(publishedYear >= 2000) {
			return ("This book is fairly new!");
		} else if (publishedYear >= 1950) {
			return ("This book is a little older.");
		} else {
			return("This book is old!");
		}
	}
	
	// the openBook() method will open the book, but only if it is already closed.
	public String openBook() {
		if(!isOpen) {
			isOpen = true;
			return ("The book is now opened!");
		} else {
			return ("The book was already opened!");
		}
	}
	
	// The closeBook() method will close the book, but only if it is already open.
	public String closeBook() {
		if(isOpen) {
			isOpen = false;
			return ("The book is now closed!");
		} else {
			return ("The book was already closed!");
		}
	}
	
	
}
