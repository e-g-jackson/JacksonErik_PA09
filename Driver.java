/**
 * @description: Once running, the program will prompt the user with a menu and the ability to input an integer to select an option.
 * 			=> One option will return the entire catalog of books.
 * 			=> The second option will require the user to input a book title and search the catalog for it.
 * 			=> The second option will require the user to input an author's name and search the catalog for it.
 * 			=> The final option will exit
 * 
 * @inputs: The program requires an integer input to navigate the menu. It will also require a string input for both of the search methods
 * 
 * @outputs: The program will output a menu, a formatted list of books, or a book resulting from a search. It will also return a message
 * 			if the program is unable to find a match for the book title or author, as well as when the user selects the exit option. 
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
 * @TestCases: 
 * Case 1:  Input: Navigate to the Search Author method (input 3 in the menu) then type "George Orwell"
 * 			Output: The Program should say "Success!" and output two of the books (and their relevant information) by George Orwell. The output
 * 			should look like this:
 * 
 * 			Searching for "George Orwell"
 * 
 * 			Success!
 * 
 * 			1984
 *					by George Orwell
 *					Published in 1949
 *					This book is old!
 *					362 pages
 *					$16.99
 *
 *			Animal Farm
 *					by George Orwell
 *					Published in 1945
 *					This book is old!
 *					250 pages
 *					$19.49
 *
 * Case 2:	Input: Navigate to the Search Title method (2 in the menu) then type "Nineteen Eighty Four"
 *			Output: The program should display the following message:
 *
 *			Searching for "nineteen eighty four
 *
 *			Sorry, we were not able to find a book with that title.
 *
 * Case 3:	Input: Navigate to the Search Title method (2 in the menu) then type "kitchen confidential", all lower case.
 * 			Output: The program should display the following message:
 * 
 * 			Searching for "kitchen confidential"
 * 
 * 			Success!
 * 			
 * 			Kitchen Confidential
 * 					by Anthony Bourdain
 * 					Published in 2000
 * 					This book is fairly new!
 * 					312 Pages
 * 					$18.99
 */

import java.util.Scanner;
public class Driver {
	// User interface method, it will prompt the user for inputs to navigate the menu. It has the ability to list the entire contents of
	// the library, search the library by title, or author name, or exit the menu.
	private static void menu(Library library) {
		// Create a new scanner for user input
		Scanner input = new Scanner(System.in);
		
		// userInput initialized to 0
		int userInput = 0;
		
		// Begins while-loop for the menu
		while (userInput != 4) {
			// Prompts user with a menu
			System.out.println("Welcome to Erik Jackson's Library!");
			System.out.println("Please enter an integer to select a menu option, or 4 to leave the library.\n");
			System.out.print("\t1) View the library's collection\n"
					+ "\t2) Search for a Title\n"
					+ "\t3) Search for an Author\n"
					+ "\t4) Exit the library\n\n"
					+ "Selection:");
			
			// Collects the user input
			userInput = input.nextInt();
			// If 1 is input, the Librarian will print out the library collection.
			
			if(userInput == 1) {
				System.out.println(library.toString());
			} 
			
			// if 2 is input, the librarian will Begin a search for the title
			else if ( userInput == 2) {
				// Runs the searchAuthor() method and saves the returned value as searchResults.
				String searchResults = searchTitle(input, library);
				if (searchResults == null) {	// If there are no matching titles, the program will inform the user
					System.out.println("\nSorry, we were not able to find a book with that title.\n");
				} else { 						// If a matching author is found, it will display the book.
					System.out.println(searchResults);
				}
				
			// if 3 is input, it will begin a search for the author's name.
			}else if (userInput == 3) {
				// Runs the searchAuthor() method and saves the returned value as searchResults.
				String searchResults = searchAuthor(input, library);
				
				if (searchResults == null) {	// If there are no matching authors, the program will inform the user
					System.out.println("\nSorry, we were not able to find a book with that author.\n");
				} else { 						// If a matching author is found, it will display the book.
					System.out.println(searchResults);
				}
				
			//Exit input detected
			} else if (userInput == 4) {
				System.out.println("Thank you for visiting the library!");
				// User interface will end
			}
		}
	}
	
	private static String searchTitle(Scanner input, Library library) {

		// Prompts user input for title to search for
		System.out.print("Please enter a title to search for:  ");
		
		// match variable initialized to false, will be used later
		boolean match = false;
		
		// An empty string to store any results from the search.
		String results = "";
		
		try {	//Try block for user input
			// clear extra "/n" from buffer
			input.nextLine();
			// Take user input and save to search, casts input to string in case of numbers in the title (ie "1984" or "Fahrenheit 451")
			String search = (String)input.nextLine();
			
			System.out.println("\nSearching for \"" + search + "\"");
			
			//Compare the search term to the titles in the collection
			for(Book book : library.printCollection()) {
				if(search.toLowerCase().equals(book.getTitle().toLowerCase())) {
					//confirms a match is found
					match = true;
					// adds results to the results string, with formatting.
					results = results + "\n" + book.toString();
				}
			}
		// catches exceptions
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// If match hasn't been set to true, it will inform the user of failure to find a match.
		if (match == false) {
			return null;
		} else {
			System.out.println("\nSuccess!\n");
			return results;
		}
	}
	
	private static String searchAuthor(Scanner input, Library library) {
		// prompts user for an author name to search for
		System.out.print("Please enter an Author's name to search for:  ");
		// match variable initialized to false, will be used later
		boolean match = false;
		
		// An empty string to store any results from the search.
		String results = "";
		
		try {//Try block for user input
			// clear extra "/n" from buffer
			input.nextLine();
			// Take user input and save to search, casts input to string in case of numbers in the author name.
			String search = (String)input.nextLine();
			System.out.println("\nSearching for \"" + search + "\"");
			
			//Compare the search term to the titles in the collection
			for(Book book : library.printCollection()) {
				if(search.toLowerCase().equals(book.getAuthor().toLowerCase())) {
					// Confirms that a match was found
					match = true;
					// adds results to the results string, with formatting.
					results = results + "\n" + book.toString();
				}
			}
		// Catches exceptions
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// If match hasn't been set to true, it will inform the user of failure to find a match. Otherwise, it will display the search results.
		if (match == false) {
			return null;
		} else {
			System.out.println("\nSuccess!\n");
			return results;
		}

	}

	// main() method.
	public static void main(String[] args) {
		// Declare and Instantiate the library
		Library library = new Library();
		
		// Declare and Instantiate the books, then add them to the library.
		Book ninteenEightyFour = new Book("1984", "George Orwell", 1949, 362, 16.99);
		library.addBook(ninteenEightyFour);
		Book animalFarm = new Book("Animal Farm", "George Orwell", 1945, 250, 19.49);
		library.addBook(animalFarm);
		Book fahrenheit451 = new Book("Fahrenheit 451", "Ray Bradbury",1953, 160, 11.39);
		library.addBook(fahrenheit451);
		Book thePeripheral = new Book("The Peripheral", "William Gibson", 2014, 512, 10.29);
		library.addBook(thePeripheral);
		Book endersGame = new Book("Ender's Game", "Orson Scott Card", 1985, 256, 21.58);
		library.addBook(endersGame);
		Book fearAndLoathing = new Book("Fear and Loathing in Las Vegas", "Hunter S. Thompson", 1971, 204, 9.99);
		library.addBook(fearAndLoathing);
		Book hitchHikersGuide = new Book("The HitchHiker's Guide to the Galaxy", "Douglas Adams", 1978, 224, 13.50);
		library.addBook(hitchHikersGuide);
		Book dune = new Book("Dune", "Frank Herbert", 1965, 896, 17.80);
		library.addBook(dune);
		Book gameOfThrones = new Book("A Game of Thrones", "George R. R. Martin", 1996, 720, 16.44);
		library.addBook(gameOfThrones);
		Book kitchenConfidential = new Book("Kitchen Confidential", "Anthony Bourdain", 2000, 312, 18.99);
		library.addBook(kitchenConfidential);
		
		//userInterface.menu(scnr, library);
		menu(library);
	}

}
