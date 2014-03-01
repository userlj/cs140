package assignment01;
/**
 * A class to test the Employee class.
 * @author Lingjie Meng
 */
public class EmployeeTester {
	/**
	 * Tests the method of Employee class
	 * @param args not used
	 */
	public static void main(String[] args) {
		double sal = 50000;
		Address addr = new Address("304 Rano Blvd", "Apt. 4",
				 "Vestal", "NY 13850", "USA");
		Person person = new Person("Sarah", "Scott",
				addr, "012-345-6789", "1992-05-04");
		Address companyAddress = new Address("1 New Orchard Road", "",
				"Armonk", "NY 10504", "USA");
		Employee emp1  = new Employee(person, "IBM", companyAddress,
				sal, "Manager");
		System.out.println("original salary: $" + sal);
		System.out.println("raised salary: $" + emp1.getRaise(2.5));
		System.out.println("expected salary: $" + 51250.0);
		
		Address newAddress = new Address("102 main St", "Apt. 2",
				 "Binghamton", "NY 13905", "USA");
		System.out.println("\noriginal address: \n" + emp1.getPerson().getAddress());
		emp1.getPerson().changeAddress(newAddress);
		System.out.println("\nchanged address: \n" + emp1.getPerson().getAddress());
		System.out.println("\ncompany address: \n" + emp1.getCompanyAddress());
	}

}
