package ch03.section_4;
/**
   A class to test the BankAccount class.
 */
public class BankAccountTester
{
	/**
      Tests the methods of the BankAccount class.
      @param args not used
	 */
	public static void main(String[] args)
	{
		Address address = new Address("100 Main St", "", 
				"Binghamton", "NY 13905", "USA");
		BankAccount harrysChecking = 
				new BankAccount("Jane Doe", address, 10001);
		harrysChecking.deposit(2000);
		harrysChecking.withdraw(500);
		System.out.println(harrysChecking.getBalance());
		System.out.println("Expected: 1500");      
	}
}
