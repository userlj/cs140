package lab01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class lab1a {

	   public String factorize (long num) { 
		      StringBuffer buff = null; 
		      if (num >= 0) { 
		         buff = new StringBuffer(); 
		      } else { 
		         buff = new StringBuffer("-"); 
		      } 
		      long remaining = Math.abs(num); 
		      long divisor = 2; 
		      while (divisor < remaining) { 
		         while (remaining % divisor == 0) { 
		            buff.append(divisor + "x"); 
		            remaining /= divisor; 
		         } 
		         divisor++; 
		      } 
		      if(remaining > 1) { 
		         buff.append(remaining); 
		      } else { 
		         int length = buff.length(); 
		         // remove the last "x" 
		         buff.setLength(length - 1); 
		      } 
		      return buff.toString(); 
		   } 
		   /** 
		    * This is a program that reads integers (of type int). 
		    * It also reports in the text file out.txt a description 
		    * of what the user did as well as the factorization of the 
		    * integer input. 
		    * @param args not used 
		    * @throws FileNotFoundException 
		    */ 
		   public static void main(String[] args) throws FileNotFoundException { 
		      // open a file in "append mode" -- we can keep adding to it 
		      FileOutputStream outfile = new FileOutputStream("out.txt", true); 
		      // use a PrintWriter "wrapper" to make the file easier to use 
		      PrintWriter output = new PrintWriter(outfile); 
		      lab1a test = new lab1a(); 
		      Scanner keyboard = new Scanner(System.in); 
		      String invalidInput = ""; 
		      // ----- read an int 
		      int inputInt; 
		         System.out.print("Enter an int: "); 
		         if (keyboard.hasNextInt()) { 
		         inputInt = keyboard.nextInt(); 
		         System.out.println("You entered " + inputInt + "\n" 
		            + "which has the following factorization:\n" 
		            + test.factorize(inputInt)); 
		         output.println("User entered " + inputInt 
		            + "\nwhich has the following factorization:\n" 
		            + test.factorize(inputInt)); 
		         keyboard.nextLine(); 
		      } else { 
		         System.out.println("That was not a valid input"); 
		         invalidInput = keyboard.nextLine(); 
		         output.println("User input \"" + invalidInput + "\" is not an int"); 
		      } 
		      // ----- end of reading an int 
		      output.close(); 
		   } 
}
