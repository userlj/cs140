package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingTracker {
	public ArrayList<Book2> bookFileReader() 
			throws FileNotFoundException {
		File file = new File("books.txt");

		//make an array for all the books
		ArrayList<Book2> books = new ArrayList<Book2>();

		// reopen file
		Scanner input = new Scanner(file);
		while(input.hasNextLine()) {
			String line = input.nextLine();
			String[] parts = line.split("\t");
			String title = parts[0];
			int numPgs = Integer.parseInt(parts[1]);
			boolean req = Boolean.parseBoolean(parts[2]);
			int amountRead = Integer.parseInt(parts[3]);
			books.add(new Book2(title,numPgs,req,amountRead));
		}		
		input.close();
		return books;
	}

	public void writeBookFile(ArrayList<Book2> books) throws FileNotFoundException { 
		File outfile = new File("books.txt"); 
		PrintWriter output = new PrintWriter(outfile);
		for(Book2 book : books) {
			output.println(book.outputLine());
		}
		output.close();
        Book2GUIUpdater.logObj.info("Wrote out to " + outfile.getName() + "\n");		//
	}

	public void checkCurrentPage(Book2 book) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("For the book " + book.getTitle());
		boolean inputOK = false;
		while(!inputOK) {
			System.out.println("What page have you reached?");
			String line = keyboard.nextLine();
			Scanner lineAnalyzer = new Scanner(line);
			if(lineAnalyzer.hasNextInt()) {
				int newPage = lineAnalyzer.nextInt();
				if(newPage < 1 || newPage > book.getPageCount()) {
					System.out.println("There is no such page, " +
							"please look at the book");
				} else {
					if(newPage < book.getBookmark()) {
						System.out.println("It seems you have gone " +
								"back to a previous page");
					}
					inputOK = true;
					book.setBookmark(newPage);
				}
			} else {
				System.out.println("You did not enter a number");
			}
			lineAnalyzer.close();
		}	
		keyboard.close();
	}

	public void updateReadings() throws FileNotFoundException {
		ArrayList<Book2> books = bookFileReader();
		for(Book2 book : books) {
			checkCurrentPage(book);
		}
		writeBookFile(books);
	}

	public static void main(String[] args) throws FileNotFoundException {
		ReadingTracker test = new ReadingTracker();
		ArrayList<Book2> books = test.bookFileReader();
		for(Book2 book : books) {
			System.out.println(book);
		}
	}
}
