package assignment02;
/**
 * A class to test the Person class.
 * @author Lingjie Meng
 */
public class PersonTester {
	/**
	 * Tests the methods of the Person class.
	 * @param args not used
	 */
	public static void main(String[] args) {
		Address addr = new Address("304 Rano Blvd", "Apt. 4",
				 "Vestal", "NY 13850", "USA");
		Person pers = new Person("Sarah", "Scott",
				addr, "987-654-320", "192-05-04");	//wrong format of ssn and dob
		
		/*
		System.out.println(addr.getStreet1());
		System.out.println(addr.getStreet2());
		System.out.println(addr.getCity() + ", " + addr.getZip());
		System.out.println(pers.getFirstNames());
		System.out.println(pers.getLastNames());
		System.out.println(pers.getSsn());
		System.out.println(pers.getDob());
		System.out.println(pers.getAddress());
		*/
		//System.out.println(addr);	
		System.out.println(pers);
	}

}
