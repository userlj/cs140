package lab02;
import java.util.Scanner;

/**
 * The class PrimeTester offers a method that tests whether a long is a
 * a prime number, together with a main method that allows the user to
 * enter numbers, which are tested for primality.
 * @author CS 140
 *
 */
public class PrimeTester {

	/**
	 * isPrime checks whether the input is prime.
	 * @param n the input long value
	 * @return true if n is prime, otherwise false
	 */
	public static boolean isPrime(long n) {
		boolean returnVal = n > 1;
		if(n>3 && (n%2==0 || n%3==0)/*n is greater than 3 and either n is divisible by 2 or 3*/) {
			returnVal = false;
		} else {
			long k = 1;
			// note that to test if A is smaller than the square root of B
			// we should test that A*A < B -- do not use Math.sqrt(B)
			// Decide whether to use < or <= by considering whether 25 is prime
			// while 6*k-1 is no greater than the square root of n
			while((6*k-1)*(6*k-1) <= n) {
				if(n%(6*k-1)==0 && n%(6*k+1)==0/*n is divisible by (6*k-1) or (6*k+1)*/) {
					returnVal = false;                   
				}
				k++;
			}
		}
		return returnVal;
		}
	/**
	 * The main method allows the user to enter numbers and reports
	 * whether they are prime.
	 * @param args command line arguments are ignored
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); 
		// ----- read a long 
		long inputLong = 0; 
		do {
			System.out.print("Enter a long: (enter 0 to exit)"); 
			if (keyboard.hasNextLong()) { 
				inputLong = keyboard.nextLong(); 
				keyboard.nextLine(); 
				if(inputLong < 0) {
					System.out.println("That is negative--not prime for many, "
							+ "if not most, mathematicians");
				} else if(isPrime(inputLong)) {
					System.out.println("That is a prime number");
				} else {
					System.out.println("That is not a prime number");
				}
			} else { 
				System.out.println("That was not a valid number"); 
			}  
		} while(inputLong != 0);
		keyboard.close(); 	
	}

}
